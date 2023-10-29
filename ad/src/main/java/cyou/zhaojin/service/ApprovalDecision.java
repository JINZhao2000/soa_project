package cyou.zhaojin.service;

import cyou.zhaojin.bean.Client;
import cyou.zhaojin.constants.Result;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.Style;

/**
 * @author Zhao JIN
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface ApprovalDecision {
    @WebMethod
    Result decision(Client client, boolean credit, boolean prop);
}
