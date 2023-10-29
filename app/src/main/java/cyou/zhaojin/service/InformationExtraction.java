package cyou.zhaojin.service;


import cyou.zhaojin.constants.Result;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface InformationExtraction {
    @WebMethod
    Result doExtract(String data);
}
