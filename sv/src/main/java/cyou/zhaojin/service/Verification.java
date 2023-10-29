package cyou.zhaojin.service;

import cyou.zhaojin.bean.Client;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface Verification {
    @WebMethod
    boolean doVerify(Client client);
}
