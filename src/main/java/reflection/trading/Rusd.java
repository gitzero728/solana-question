package reflection.trading;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.5.3.
 */
@SuppressWarnings("rawtypes")
public class Rusd extends Contract {
    public static final String BINARY = "0x60806040523480156200001157600080fd5b5060405162001eb438038062001eb483398101604081905262000034916200028b565b6040518060400160405280601981526020017f5265666c656374696f6e2055534420537461626c65636f696e000000000000008152506040518060400160405280600481526020017f52555344000000000000000000000000000000000000000000000000000000008152508160039081620000b191906200039a565b506004620000c082826200039a565b505050620000ef620000e062000218640100000000026401000000009004565b6401000000006200021c810204565b6001600655600160a060020a0382166200016a576040517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601060248201527f5a65726f2052656620416464726573730000000000000000000000000000000060448201526064015b60405180910390fd5b600160a060020a038116620001dc576040517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601260248201527f5a65726f2041646d696e20416464726573730000000000000000000000000000604482015260640162000161565b60088054600160a060020a031916600160a060020a03938416179055166000908152600760205260409020805460ff191660011790556200046d565b3390565b60058054600160a060020a03838116600160a060020a0319831681179093556040519116919082907f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e090600090a35050565b8051600160a060020a03811681146200028657600080fd5b919050565b600080604083850312156200029f57600080fd5b620002aa836200026e565b9150620002ba602084016200026e565b90509250929050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b6002810460018216806200030757607f821691505b60208210810362000341577f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b50919050565b601f82111562000395576000818152602081206020601f86010481016020861015620003705750805b6020601f860104820191505b8181101562000391578281556001016200037c565b5050505b505050565b815167ffffffffffffffff811115620003b757620003b7620002c3565b620003cf81620003c88454620002f2565b8462000347565b602080601f8311600181146200040b5760008415620003ee5750858301515b60028086026008870290910a600019041982161786555062000391565b600085815260208120601f198616915b828110156200043c578886015182559484019460019091019084016200041b565b50858210156200045d57878501516008601f88160260020a60001904191681555b5050505050600202600101905550565b611a37806200047d6000396000f3fe608060405234801561001057600080fd5b506004361061016a576000357c01000000000000000000000000000000000000000000000000000000009004806362835413116100e057806395d89b411161009957806395d89b41146102f7578063a457c2d7146102ff578063a9059cbb14610312578063bae3909e14610325578063dd62ed3e14610338578063f2fde38b1461034b57600080fd5b8063628354131461026857806370a082311461027b578063715018a6146102a457806389fa2c03146102ac5780638a854e17146102bf5780638da5cb5b146102d257600080fd5b8063395093511161013257806339509351146101e45780633a68a420146101f7578063429b62e51461020c5780635690cc4f1461022f57806358e78a85146102425780635948f1f01461025557600080fd5b806306fdde031461016f578063095ea7b31461018d57806318160ddd146101b057806323b872dd146101c2578063313ce567146101d5575b600080fd5b61017761035e565b60405161018491906116ea565b60405180910390f35b6101a061019b366004611739565b6103f0565b6040519015158152602001610184565b6002545b604051908152602001610184565b6101a06101d0366004611763565b61040a565b60405160068152602001610184565b6101a06101f2366004611739565b61042e565b61020a61020536600461179f565b610450565b005b6101a061021a36600461179f565b60076020526000908152604090205460ff1681565b61020a61023d3660046117c1565b610517565b61020a610250366004611803565b6105d2565b61020a610263366004611803565b610712565b61020a610276366004611803565b610838565b6101b461028936600461179f565b600160a060020a031660009081526020819052604090205490565b61020a61099f565b61020a6102ba366004611866565b6109b3565b61020a6102cd3660046117c1565b610a77565b600554600160a060020a03165b604051600160a060020a039091168152602001610184565b610177610b1f565b6101a061030d366004611739565b610b2e565b6101a0610320366004611739565b610bc4565b6008546102df90600160a060020a031681565b6101b461034636600461189d565b610bd2565b61020a61035936600461179f565b610bfd565b60606003805461036d906118d0565b80601f0160208091040260200160405190810160405280929190818152602001828054610399906118d0565b80156103e65780601f106103bb576101008083540402835291602001916103e6565b820191906000526020600020905b8154815290600101906020018083116103c957829003601f168201915b5050505050905090565b6000336103fe818585610c90565b60019150505b92915050565b600033610418858285610def565b610423858585610e66565b506001949350505050565b6000336103fe8185856104418383610bd2565b61044b9190611923565b610c90565b61045861105c565b600160a060020a0381166104b65760405160e560020a62461bcd02815260206004820152601060248201527f5a65726f2052656620416464726573730000000000000000000000000000000060448201526064015b60405180910390fd5b6008805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a0383169081179091556040519081527fee8d9fc2dcbce36aaaa124e0fadf074941fe4caa3e111168bf077f5d9962cec49060200160405180910390a150565b61051f6110b9565b3360009081526007602052604090205460ff166105515760405160e560020a62461bcd0281526004016104ad9061195d565b61055b8482611115565b60085461057690600160a060020a0385811691168685611281565b60408051600160a060020a038087168252851660208201529081018390527fbada3c4baa6b99d20a41f68a4851033785aba2f98674fa6ccb22325e0342577a906060015b60405180910390a16105cc6001600655565b50505050565b6105da6110b9565b3360009081526007602052604090205460ff1661060c5760405160e560020a62461bcd0281526004016104ad9061195d565b30600160a060020a0385160361062b576106268583611115565b610647565b60085461064790600160a060020a038681169188911685611281565b6040517f40c10f19000000000000000000000000000000000000000000000000000000008152600160a060020a038681166004830152602482018390528416906340c10f1990604401600060405180830381600087803b1580156106aa57600080fd5b505af11580156106be573d6000803e3d6000fd5b505050507ff4e116c5af669bd0b672b4498a0a9b172a0029e608d2ab109e51480f6abc841485858585856040516106f9959493929190611994565b60405180910390a161070b6001600655565b5050505050565b61071a6110b9565b3360009081526007602052604090205460ff1661074c5760405160e560020a62461bcd0281526004016104ad9061195d565b30600160a060020a0385160361076b576107668583611309565b610786565b60085461078690600160a060020a0386811691168785611281565b6040517f9dc29fac000000000000000000000000000000000000000000000000000000008152600160a060020a03868116600483015260248201839052841690639dc29fac90604401600060405180830381600087803b1580156107e957600080fd5b505af11580156107fd573d6000803e3d6000fd5b505050507fe0af7bd1c7af549f1358ffb9853efb55d890ff7d77578bb809df4c6687632ba085858585856040516106f9959493929190611994565b6108406110b9565b3360009081526007602052604090205460ff166108725760405160e560020a62461bcd0281526004016104ad9061195d565b6040517f9dc29fac000000000000000000000000000000000000000000000000000000008152600160a060020a03868116600483015260248201849052851690639dc29fac90604401600060405180830381600087803b1580156108d557600080fd5b505af11580156108e9573d6000803e3d6000fd5b50506040517f40c10f19000000000000000000000000000000000000000000000000000000008152600160a060020a03888116600483015260248201859052861692506340c10f199150604401600060405180830381600087803b15801561095057600080fd5b505af1158015610964573d6000803e3d6000fd5b505050507f9b70cf807609e020a161917ee2eb8b7ed70d5127c0c61a35e46b5e30c4c06e9585858585856040516106f9959493929190611994565b6109a761105c565b6109b160006113cb565b565b6109bb61105c565b600160a060020a038216610a145760405160e560020a62461bcd02815260206004820152601260248201527f5a65726f2061646d696e2041646472657373000000000000000000000000000060448201526064016104ad565b600160a060020a038216600081815260076020908152604091829020805460ff19168515159081179091558251938452908301527f4526a942aaed9ea92b149506bb00ccf0f9267091de10444718cf9b09e05dc680910160405180910390a15050565b610a7f6110b9565b3360009081526007602052604090205460ff16610ab15760405160e560020a62461bcd0281526004016104ad9061195d565b600854610acd90600160a060020a038581169187911685611281565b610ad78482611309565b60408051600160a060020a038087168252851660208201529081018390527fb87623f177ec93e7f7a02bf29165ba072767176685f9e8a359a9fac60ffe5ec7906060016105ba565b60606004805461036d906118d0565b60003381610b3c8286610bd2565b905083811015610bb75760405160e560020a62461bcd02815260206004820152602560248201527f45524332303a2064656372656173656420616c6c6f77616e63652062656c6f7760448201527f207a65726f00000000000000000000000000000000000000000000000000000060648201526084016104ad565b6104238286868403610c90565b6000336103fe818585610e66565b600160a060020a03918216600090815260016020908152604080832093909416825291909152205490565b610c0561105c565b600160a060020a038116610c845760405160e560020a62461bcd02815260206004820152602660248201527f4f776e61626c653a206e6577206f776e657220697320746865207a65726f206160448201527f646472657373000000000000000000000000000000000000000000000000000060648201526084016104ad565b610c8d816113cb565b50565b600160a060020a038316610d0e5760405160e560020a62461bcd028152602060048201526024808201527f45524332303a20617070726f76652066726f6d20746865207a65726f2061646460448201527f726573730000000000000000000000000000000000000000000000000000000060648201526084016104ad565b600160a060020a038216610d8d5760405160e560020a62461bcd02815260206004820152602260248201527f45524332303a20617070726f766520746f20746865207a65726f20616464726560448201527f737300000000000000000000000000000000000000000000000000000000000060648201526084016104ad565b600160a060020a0383811660008181526001602090815260408083209487168084529482529182902085905590518481527f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b92591015b60405180910390a3505050565b6000610dfb8484610bd2565b905060001981146105cc5781811015610e595760405160e560020a62461bcd02815260206004820152601d60248201527f45524332303a20696e73756666696369656e7420616c6c6f77616e636500000060448201526064016104ad565b6105cc8484848403610c90565b600160a060020a038316610ee55760405160e560020a62461bcd02815260206004820152602560248201527f45524332303a207472616e736665722066726f6d20746865207a65726f20616460448201527f647265737300000000000000000000000000000000000000000000000000000060648201526084016104ad565b600160a060020a038216610f645760405160e560020a62461bcd02815260206004820152602360248201527f45524332303a207472616e7366657220746f20746865207a65726f206164647260448201527f657373000000000000000000000000000000000000000000000000000000000060648201526084016104ad565b600160a060020a03831660009081526020819052604090205481811015610ff65760405160e560020a62461bcd02815260206004820152602660248201527f45524332303a207472616e7366657220616d6f756e742065786365656473206260448201527f616c616e6365000000000000000000000000000000000000000000000000000060648201526084016104ad565b600160a060020a03848116600081815260208181526040808320878703905593871680835291849020805487019055925185815290927fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef910160405180910390a36105cc565b600554600160a060020a031633146109b15760405160e560020a62461bcd02815260206004820181905260248201527f4f776e61626c653a2063616c6c6572206973206e6f7420746865206f776e657260448201526064016104ad565b60026006540361110e5760405160e560020a62461bcd02815260206004820152601f60248201527f5265656e7472616e637947756172643a207265656e7472616e742063616c6c0060448201526064016104ad565b6002600655565b600160a060020a0382166111945760405160e560020a62461bcd02815260206004820152602160248201527f45524332303a206275726e2066726f6d20746865207a65726f2061646472657360448201527f730000000000000000000000000000000000000000000000000000000000000060648201526084016104ad565b600160a060020a038216600090815260208190526040902054818110156112265760405160e560020a62461bcd02815260206004820152602260248201527f45524332303a206275726e20616d6f756e7420657863656564732062616c616e60448201527f636500000000000000000000000000000000000000000000000000000000000060648201526084016104ad565b600160a060020a0383166000818152602081815260408083208686039055600280548790039055518581529192917fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef9101610de2565b505050565b60408051600160a060020a0385811660248301528416604482015260648082018490528251808303909101815260849091019091526020810180517bffffffffffffffffffffffffffffffffffffffffffffffffffffffff167f23b872dd000000000000000000000000000000000000000000000000000000001790526105cc90859061142a565b600160a060020a0382166113625760405160e560020a62461bcd02815260206004820152601f60248201527f45524332303a206d696e7420746f20746865207a65726f20616464726573730060448201526064016104ad565b80600260008282546113749190611923565b9091555050600160a060020a038216600081815260208181526040808320805486019055518481527fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef910160405180910390a35050565b60058054600160a060020a0383811673ffffffffffffffffffffffffffffffffffffffff19831681179093556040519116919082907f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e090600090a35050565b600061147f826040518060400160405280602081526020017f5361666545524332303a206c6f772d6c6576656c2063616c6c206661696c656481525085600160a060020a03166115159092919063ffffffff16565b90508051600014806114a05750808060200190518101906114a091906119c8565b61127c5760405160e560020a62461bcd02815260206004820152602a60248201527f5361666545524332303a204552433230206f7065726174696f6e20646964206e60448201527f6f7420737563636565640000000000000000000000000000000000000000000060648201526084016104ad565b6060611524848460008561152c565b949350505050565b606030318311156115a85760405160e560020a62461bcd02815260206004820152602660248201527f416464726573733a20696e73756666696369656e742062616c616e636520666f60448201527f722063616c6c000000000000000000000000000000000000000000000000000060648201526084016104ad565b60008086600160a060020a031685876040516115c491906119e5565b60006040518083038185875af1925050503d8060008114611601576040519150601f19603f3d011682016040523d82523d6000602084013e611606565b606091505b509150915061161787838387611622565b979650505050505050565b6060831561169457825160000361168d57600160a060020a0385163b61168d5760405160e560020a62461bcd02815260206004820152601d60248201527f416464726573733a2063616c6c20746f206e6f6e2d636f6e747261637400000060448201526064016104ad565b5081611524565b61152483838151156116a95781518083602001fd5b8060405160e560020a62461bcd0281526004016104ad91906116ea565b60005b838110156116e15781810151838201526020016116c9565b50506000910152565b60208152600082518060208401526117098160408501602087016116c6565b601f01601f19169190910160400192915050565b8035600160a060020a038116811461173457600080fd5b919050565b6000806040838503121561174c57600080fd5b6117558361171d565b946020939093013593505050565b60008060006060848603121561177857600080fd5b6117818461171d565b925061178f6020850161171d565b9150604084013590509250925092565b6000602082840312156117b157600080fd5b6117ba8261171d565b9392505050565b600080600080608085870312156117d757600080fd5b6117e08561171d565b93506117ee6020860161171d565b93969395505050506040820135916060013590565b600080600080600060a0868803121561181b57600080fd5b6118248661171d565b94506118326020870161171d565b93506118406040870161171d565b94979396509394606081013594506080013592915050565b8015158114610c8d57600080fd5b6000806040838503121561187957600080fd5b6118828361171d565b9150602083013561189281611858565b809150509250929050565b600080604083850312156118b057600080fd5b6118b98361171d565b91506118c76020840161171d565b90509250929050565b6002810460018216806118e457607f821691505b60208210810361191d577f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b50919050565b80820180821115610404577f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b6020808252600a908201527f4f6e6c792041646d696e00000000000000000000000000000000000000000000604082015260600190565b600160a060020a03958616815293851660208501529190931660408301526060820192909252608081019190915260a00190565b6000602082840312156119da57600080fd5b81516117ba81611858565b600082516119f78184602087016116c6565b919091019291505056fea2646970667358221220d7e75adfd213baecb9f9833301080585fabc177c240908bdf571eab4bf1de51f64736f6c63430008110033";

    private static String librariesLinkedBinary;

    public static final String FUNC_ADMINS = "admins";

    public static final String FUNC_ALLOWANCE = "allowance";

    public static final String FUNC_APPROVE = "approve";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_DECREASEALLOWANCE = "decreaseAllowance";

    public static final String FUNC_INCREASEALLOWANCE = "increaseAllowance";

    public static final String FUNC_NAME = "name";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_REFWALLETADDRESS = "refWalletAddress";

    public static final String FUNC_RENOUNCEOWNERSHIP = "renounceOwnership";

    public static final String FUNC_SYMBOL = "symbol";

    public static final String FUNC_TOTALSUPPLY = "totalSupply";

    public static final String FUNC_TRANSFER = "transfer";

    public static final String FUNC_TRANSFERFROM = "transferFrom";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_ADDORREMOVEADMIN = "addOrRemoveAdmin";

    public static final String FUNC_SETREFWALLETADDRESS = "setRefWalletAddress";

    public static final String FUNC_BUYSTOCK = "buyStock";

    public static final String FUNC_SELLSTOCK = "sellStock";

    public static final String FUNC_SWAPSTOCK = "swapStock";

    public static final String FUNC_BUYRUSD = "buyRusd";

    public static final String FUNC_SELLRUSD = "sellRusd";

    public static final String FUNC_DECIMALS = "decimals";

    public static final Event ADMINCHANGED_EVENT = new Event("AdminChanged", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Bool>() {}));
    ;

    public static final Event APPROVAL_EVENT = new Event("Approval", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event BUYRUSD_EVENT = new Event("BuyRusd", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event BUYSTOCK_EVENT = new Event("BuyStock", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event OWNERSHIPTRANSFERRED_EVENT = new Event("OwnershipTransferred", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event SELLRUSD_EVENT = new Event("SellRusd", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event SELLSTOCK_EVENT = new Event("SellStock", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event SETREFWALLETADDRESS_EVENT = new Event("SetRefWalletAddress", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final Event SWAPSTOCK_EVENT = new Event("SwapStock", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event TRANSFER_EVENT = new Event("Transfer", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected Rusd(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Rusd(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Rusd(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Rusd(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<AdminChangedEventResponse> getAdminChangedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(ADMINCHANGED_EVENT, transactionReceipt);
        ArrayList<AdminChangedEventResponse> responses = new ArrayList<AdminChangedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AdminChangedEventResponse typedResponse = new AdminChangedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.AdminAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.IsAdmin = (Boolean) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static AdminChangedEventResponse getAdminChangedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(ADMINCHANGED_EVENT, log);
        AdminChangedEventResponse typedResponse = new AdminChangedEventResponse();
        typedResponse.log = log;
        typedResponse.AdminAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.IsAdmin = (Boolean) eventValues.getNonIndexedValues().get(1).getValue();
        return typedResponse;
    }

    public Flowable<AdminChangedEventResponse> adminChangedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getAdminChangedEventFromLog(log));
    }

    public Flowable<AdminChangedEventResponse> adminChangedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ADMINCHANGED_EVENT));
        return adminChangedEventFlowable(filter);
    }

    public static List<ApprovalEventResponse> getApprovalEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(APPROVAL_EVENT, transactionReceipt);
        ArrayList<ApprovalEventResponse> responses = new ArrayList<ApprovalEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ApprovalEventResponse typedResponse = new ApprovalEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.spender = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static ApprovalEventResponse getApprovalEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(APPROVAL_EVENT, log);
        ApprovalEventResponse typedResponse = new ApprovalEventResponse();
        typedResponse.log = log;
        typedResponse.owner = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.spender = (String) eventValues.getIndexedValues().get(1).getValue();
        typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<ApprovalEventResponse> approvalEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getApprovalEventFromLog(log));
    }

    public Flowable<ApprovalEventResponse> approvalEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(APPROVAL_EVENT));
        return approvalEventFlowable(filter);
    }

    public static List<BuyRusdEventResponse> getBuyRusdEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(BUYRUSD_EVENT, transactionReceipt);
        ArrayList<BuyRusdEventResponse> responses = new ArrayList<BuyRusdEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            BuyRusdEventResponse typedResponse = new BuyRusdEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.UserAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.StableCoinAddress = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.Amount = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static BuyRusdEventResponse getBuyRusdEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(BUYRUSD_EVENT, log);
        BuyRusdEventResponse typedResponse = new BuyRusdEventResponse();
        typedResponse.log = log;
        typedResponse.UserAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.StableCoinAddress = (String) eventValues.getNonIndexedValues().get(1).getValue();
        typedResponse.Amount = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
        return typedResponse;
    }

    public Flowable<BuyRusdEventResponse> buyRusdEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getBuyRusdEventFromLog(log));
    }

    public Flowable<BuyRusdEventResponse> buyRusdEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(BUYRUSD_EVENT));
        return buyRusdEventFlowable(filter);
    }

    public static List<BuyStockEventResponse> getBuyStockEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(BUYSTOCK_EVENT, transactionReceipt);
        ArrayList<BuyStockEventResponse> responses = new ArrayList<BuyStockEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            BuyStockEventResponse typedResponse = new BuyStockEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.UserAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.StableCoinAddress = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.StockTokenAddress = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.StableCoinAmount = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.StockTokenAmount = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static BuyStockEventResponse getBuyStockEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(BUYSTOCK_EVENT, log);
        BuyStockEventResponse typedResponse = new BuyStockEventResponse();
        typedResponse.log = log;
        typedResponse.UserAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.StableCoinAddress = (String) eventValues.getNonIndexedValues().get(1).getValue();
        typedResponse.StockTokenAddress = (String) eventValues.getNonIndexedValues().get(2).getValue();
        typedResponse.StableCoinAmount = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
        typedResponse.StockTokenAmount = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
        return typedResponse;
    }

    public Flowable<BuyStockEventResponse> buyStockEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getBuyStockEventFromLog(log));
    }

    public Flowable<BuyStockEventResponse> buyStockEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(BUYSTOCK_EVENT));
        return buyStockEventFlowable(filter);
    }

    public static List<OwnershipTransferredEventResponse> getOwnershipTransferredEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, transactionReceipt);
        ArrayList<OwnershipTransferredEventResponse> responses = new ArrayList<OwnershipTransferredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static OwnershipTransferredEventResponse getOwnershipTransferredEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, log);
        OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
        typedResponse.log = log;
        typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
        return typedResponse;
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getOwnershipTransferredEventFromLog(log));
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERSHIPTRANSFERRED_EVENT));
        return ownershipTransferredEventFlowable(filter);
    }

    public static List<SellRusdEventResponse> getSellRusdEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(SELLRUSD_EVENT, transactionReceipt);
        ArrayList<SellRusdEventResponse> responses = new ArrayList<SellRusdEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SellRusdEventResponse typedResponse = new SellRusdEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.UserAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.StableCoinAddress = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.Amount = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static SellRusdEventResponse getSellRusdEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(SELLRUSD_EVENT, log);
        SellRusdEventResponse typedResponse = new SellRusdEventResponse();
        typedResponse.log = log;
        typedResponse.UserAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.StableCoinAddress = (String) eventValues.getNonIndexedValues().get(1).getValue();
        typedResponse.Amount = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
        return typedResponse;
    }

    public Flowable<SellRusdEventResponse> sellRusdEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getSellRusdEventFromLog(log));
    }

    public Flowable<SellRusdEventResponse> sellRusdEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SELLRUSD_EVENT));
        return sellRusdEventFlowable(filter);
    }

    public static List<SellStockEventResponse> getSellStockEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(SELLSTOCK_EVENT, transactionReceipt);
        ArrayList<SellStockEventResponse> responses = new ArrayList<SellStockEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SellStockEventResponse typedResponse = new SellStockEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.UserAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.StableCoinAddress = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.StockTokenAddress = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.StableCoinAmount = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.StockTokenAmount = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static SellStockEventResponse getSellStockEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(SELLSTOCK_EVENT, log);
        SellStockEventResponse typedResponse = new SellStockEventResponse();
        typedResponse.log = log;
        typedResponse.UserAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.StableCoinAddress = (String) eventValues.getNonIndexedValues().get(1).getValue();
        typedResponse.StockTokenAddress = (String) eventValues.getNonIndexedValues().get(2).getValue();
        typedResponse.StableCoinAmount = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
        typedResponse.StockTokenAmount = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
        return typedResponse;
    }

    public Flowable<SellStockEventResponse> sellStockEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getSellStockEventFromLog(log));
    }

    public Flowable<SellStockEventResponse> sellStockEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SELLSTOCK_EVENT));
        return sellStockEventFlowable(filter);
    }

    public static List<SetRefWalletAddressEventResponse> getSetRefWalletAddressEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(SETREFWALLETADDRESS_EVENT, transactionReceipt);
        ArrayList<SetRefWalletAddressEventResponse> responses = new ArrayList<SetRefWalletAddressEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SetRefWalletAddressEventResponse typedResponse = new SetRefWalletAddressEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.RefWalletAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static SetRefWalletAddressEventResponse getSetRefWalletAddressEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(SETREFWALLETADDRESS_EVENT, log);
        SetRefWalletAddressEventResponse typedResponse = new SetRefWalletAddressEventResponse();
        typedResponse.log = log;
        typedResponse.RefWalletAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<SetRefWalletAddressEventResponse> setRefWalletAddressEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getSetRefWalletAddressEventFromLog(log));
    }

    public Flowable<SetRefWalletAddressEventResponse> setRefWalletAddressEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SETREFWALLETADDRESS_EVENT));
        return setRefWalletAddressEventFlowable(filter);
    }

    public static List<SwapStockEventResponse> getSwapStockEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(SWAPSTOCK_EVENT, transactionReceipt);
        ArrayList<SwapStockEventResponse> responses = new ArrayList<SwapStockEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SwapStockEventResponse typedResponse = new SwapStockEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._userAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._stockTokenToBurn = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse._stockTokenToMint = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse._stockTokenToBurnAmt = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse._stockTokenToMintAmt = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static SwapStockEventResponse getSwapStockEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(SWAPSTOCK_EVENT, log);
        SwapStockEventResponse typedResponse = new SwapStockEventResponse();
        typedResponse.log = log;
        typedResponse._userAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse._stockTokenToBurn = (String) eventValues.getNonIndexedValues().get(1).getValue();
        typedResponse._stockTokenToMint = (String) eventValues.getNonIndexedValues().get(2).getValue();
        typedResponse._stockTokenToBurnAmt = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
        typedResponse._stockTokenToMintAmt = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
        return typedResponse;
    }

    public Flowable<SwapStockEventResponse> swapStockEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getSwapStockEventFromLog(log));
    }

    public Flowable<SwapStockEventResponse> swapStockEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(SWAPSTOCK_EVENT));
        return swapStockEventFlowable(filter);
    }

    public static List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(TRANSFER_EVENT, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static TransferEventResponse getTransferEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(TRANSFER_EVENT, log);
        TransferEventResponse typedResponse = new TransferEventResponse();
        typedResponse.log = log;
        typedResponse.from = (String) eventValues.getIndexedValues().get(0).getValue();
        typedResponse.to = (String) eventValues.getIndexedValues().get(1).getValue();
        typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<TransferEventResponse> transferEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getTransferEventFromLog(log));
    }

    public Flowable<TransferEventResponse> transferEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRANSFER_EVENT));
        return transferEventFlowable(filter);
    }

    public RemoteFunctionCall<Boolean> admins(String param0) {
        final Function function = new Function(FUNC_ADMINS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> allowance(String owner, String spender) {
        final Function function = new Function(FUNC_ALLOWANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, owner), 
                new org.web3j.abi.datatypes.Address(160, spender)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> approve(String spender, BigInteger amount) {
        final Function function = new Function(
                FUNC_APPROVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, spender), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> balanceOf(String account) {
        final Function function = new Function(FUNC_BALANCEOF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, account)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> decreaseAllowance(String spender, BigInteger subtractedValue) {
        final Function function = new Function(
                FUNC_DECREASEALLOWANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, spender), 
                new org.web3j.abi.datatypes.generated.Uint256(subtractedValue)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> increaseAllowance(String spender, BigInteger addedValue) {
        final Function function = new Function(
                FUNC_INCREASEALLOWANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, spender), 
                new org.web3j.abi.datatypes.generated.Uint256(addedValue)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> name() {
        final Function function = new Function(FUNC_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> refWalletAddress() {
        final Function function = new Function(FUNC_REFWALLETADDRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> renounceOwnership() {
        final Function function = new Function(
                FUNC_RENOUNCEOWNERSHIP, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> symbol() {
        final Function function = new Function(FUNC_SYMBOL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> totalSupply() {
        final Function function = new Function(FUNC_TOTALSUPPLY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> transfer(String to, BigInteger amount) {
        final Function function = new Function(
                FUNC_TRANSFER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, to), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferFrom(String from, String to, BigInteger amount) {
        final Function function = new Function(
                FUNC_TRANSFERFROM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, from), 
                new org.web3j.abi.datatypes.Address(160, to), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferOwnership(String newOwner) {
        final Function function = new Function(
                FUNC_TRANSFEROWNERSHIP, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> addOrRemoveAdmin(String adminAddress, Boolean isAdmin) {
        final Function function = new Function(
                FUNC_ADDORREMOVEADMIN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, adminAddress), 
                new org.web3j.abi.datatypes.Bool(isAdmin)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setRefWalletAddress(String _refWalletAddress) {
        final Function function = new Function(
                FUNC_SETREFWALLETADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _refWalletAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> buyStock(String _userAddress, String _stableCoinAddress, String _stockTokenAddress, BigInteger _stableCoinAmount, BigInteger _stockTokenAmount) {
        final Function function = new Function(
                FUNC_BUYSTOCK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _userAddress), 
                new org.web3j.abi.datatypes.Address(160, _stableCoinAddress), 
                new org.web3j.abi.datatypes.Address(160, _stockTokenAddress), 
                new org.web3j.abi.datatypes.generated.Uint256(_stableCoinAmount), 
                new org.web3j.abi.datatypes.generated.Uint256(_stockTokenAmount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> sellStock(String _userAddress, String _stableCoinAddress, String _stockTokenAddress, BigInteger _stableCoinAmount, BigInteger _stockTokenAmount) {
        final Function function = new Function(
                FUNC_SELLSTOCK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _userAddress), 
                new org.web3j.abi.datatypes.Address(160, _stableCoinAddress), 
                new org.web3j.abi.datatypes.Address(160, _stockTokenAddress), 
                new org.web3j.abi.datatypes.generated.Uint256(_stableCoinAmount), 
                new org.web3j.abi.datatypes.generated.Uint256(_stockTokenAmount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> swapStock(String _userAddress, String _stockTokenToBurn, String _stockTokenToMint, BigInteger _stockTokenToBurnAmt, BigInteger _stockTokenToMintAmt) {
        final Function function = new Function(
                FUNC_SWAPSTOCK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _userAddress), 
                new org.web3j.abi.datatypes.Address(160, _stockTokenToBurn), 
                new org.web3j.abi.datatypes.Address(160, _stockTokenToMint), 
                new org.web3j.abi.datatypes.generated.Uint256(_stockTokenToBurnAmt), 
                new org.web3j.abi.datatypes.generated.Uint256(_stockTokenToMintAmt)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> buyRusd(String _userAddress, String _stableCoinAddress, BigInteger _stableCoinAmount, BigInteger _amount) {
        final Function function = new Function(
                FUNC_BUYRUSD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _userAddress), 
                new org.web3j.abi.datatypes.Address(160, _stableCoinAddress), 
                new org.web3j.abi.datatypes.generated.Uint256(_stableCoinAmount), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> sellRusd(String _userAddress, String _stableCoinAddress, BigInteger _stableCoinAmount, BigInteger _amount) {
        final Function function = new Function(
                FUNC_SELLRUSD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _userAddress), 
                new org.web3j.abi.datatypes.Address(160, _stableCoinAddress), 
                new org.web3j.abi.datatypes.generated.Uint256(_stableCoinAmount), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> decimals() {
        final Function function = new Function(FUNC_DECIMALS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static Rusd load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Rusd(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Rusd load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Rusd(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Rusd load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Rusd(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Rusd load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Rusd(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Rusd> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _refWalletAddress, String admin) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _refWalletAddress), 
                new org.web3j.abi.datatypes.Address(160, admin)));
        return deployRemoteCall(Rusd.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), encodedConstructor);
    }

    public static RemoteCall<Rusd> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _refWalletAddress, String admin) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _refWalletAddress), 
                new org.web3j.abi.datatypes.Address(160, admin)));
        return deployRemoteCall(Rusd.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Rusd> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _refWalletAddress, String admin) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _refWalletAddress), 
                new org.web3j.abi.datatypes.Address(160, admin)));
        return deployRemoteCall(Rusd.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Rusd> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _refWalletAddress, String admin) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _refWalletAddress), 
                new org.web3j.abi.datatypes.Address(160, admin)));
        return deployRemoteCall(Rusd.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), encodedConstructor);
    }

//    public static void linkLibraries(List<Contract.LinkReference> references) {
//        librariesLinkedBinary = linkBinaryWithReferences(BINARY, references);
//    }

    public static String getDeploymentBinary() {
        if (librariesLinkedBinary != null) {
            return librariesLinkedBinary;
        } else {
            return BINARY;
        }
    }

    public static class AdminChangedEventResponse extends BaseEventResponse {
        public String AdminAddress;

        public Boolean IsAdmin;
    }

    public static class ApprovalEventResponse extends BaseEventResponse {
        public String owner;

        public String spender;

        public BigInteger value;
    }

    public static class BuyRusdEventResponse extends BaseEventResponse {
        public String UserAddress;

        public String StableCoinAddress;

        public BigInteger Amount;
    }

    public static class BuyStockEventResponse extends BaseEventResponse {
        public String UserAddress;

        public String StableCoinAddress;

        public String StockTokenAddress;

        public BigInteger StableCoinAmount;

        public BigInteger StockTokenAmount;
    }

    public static class OwnershipTransferredEventResponse extends BaseEventResponse {
        public String previousOwner;

        public String newOwner;
    }

    public static class SellRusdEventResponse extends BaseEventResponse {
        public String UserAddress;

        public String StableCoinAddress;

        public BigInteger Amount;
    }

    public static class SellStockEventResponse extends BaseEventResponse {
        public String UserAddress;

        public String StableCoinAddress;

        public String StockTokenAddress;

        public BigInteger StableCoinAmount;

        public BigInteger StockTokenAmount;
    }

    public static class SetRefWalletAddressEventResponse extends BaseEventResponse {
        public String RefWalletAddress;
    }

    public static class SwapStockEventResponse extends BaseEventResponse {
        public String _userAddress;

        public String _stockTokenToBurn;

        public String _stockTokenToMint;

        public BigInteger _stockTokenToBurnAmt;

        public BigInteger _stockTokenToMintAmt;
    }

    public static class TransferEventResponse extends BaseEventResponse {
        public String from;

        public String to;

        public BigInteger value;
    }
}
