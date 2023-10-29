package cyou.zhaojin.service;


import cyou.zhaojin.bean.Client;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

import static jakarta.jws.soap.SOAPBinding.Style;

/**
 * @author Zhao JIN
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface PropertyEvaluation {
    @WebMethod
    boolean doEvaluate(Client client);
}
