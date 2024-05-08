package web3;

import java.math.BigInteger;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.tx.gas.StaticEIP1559GasProvider;

import reflection.trading.Rusd;

//static String admin1 = "0xb8C30268E0c4A1AaE6aB3c22A9d4043148216614";
//static String refWallet = "0xF6e9Bff937ac8DF6220688DEa63A1c92b6339510";

public class test {
	static String rusdAddr = "0x455759a3f9124bf2576da81fb9ae8e76b27ff2d6";
	static String publicKey = "0x2ab0e9e4ee70fff1fb9d67031e44f6410170d00e";
	static String privateKey = "9d136e05de9a38ab85ac6c471578bd4e101402df3373c006b7e07e69ab2073cb";

	static long chainId = 137;
	static Web3j web3j = Web3j.build(new HttpService("https://evocative-fabled-fire.matic.quiknode.pro/32cf5be29cb98c393bd95643b7ac25e016d6e8b1/"));

	public static void main( String[] args) throws Exception {
		try {
			RawTransactionManager txManager = new RawTransactionManager(
					web3j,
					Credentials.create(privateKey),
					chainId);
	
                        System.out.println(fetchCurrentBaseFee());
			StaticEIP1559GasProvider gp = new StaticEIP1559GasProvider( // fails with this
					chainId,
					fetchCurrentBaseFee().add(BigInteger.valueOf(100000000000L)),
					BigInteger.valueOf(50000000000L),
					BigInteger.valueOf(300000) );
	
			DefaultGasProvider gp2 = new DefaultGasProvider();  // fails with this
	
			Rusd c = reflection.trading.Rusd.load(
					rusdAddr,
					web3j, 
					txManager,
					gp);
			
			BigInteger i = c.decimals().send();
			System.out.println( "decimals = " + i);  // this works!

			TransactionReceipt transactionReceipt = c.transfer(publicKey, BigInteger.valueOf( 1) ).send();
			System.out.println(transactionReceipt.getTransactionHash());
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
	}

	private static BigInteger fetchCurrentBaseFee() throws Exception {
		return web3j.ethGetBlockByNumber(org.web3j.protocol.core.DefaultBlockParameterName.LATEST, false)
				.send()
				.getBlock()
				.getBaseFeePerGas();
	}
}
