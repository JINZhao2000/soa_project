package cyou.zhaojin.controller;

import cyou.zhaojin.constants.Result;
import cyou.zhaojin.service.InformationExtraction;
import jakarta.xml.ws.Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.xml.namespace.QName;
import java.net.URL;

/**
 * @author Zhao JIN
 */
@Controller
public class BaseController {
    private static final QName name = new QName("http://impl.service.zhaojin.cyou/","InformationExtractionImplService");

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @PostMapping("/analyze")
    public String analyze(String demand, Model model){
        try {
            InformationExtraction ie = Service.create(new URL("http://localhost:9000/IE?wsdl"), name).getPort(InformationExtraction.class);
            Result result = ie.doExtract(demand);
            model.addAttribute("code", result.getCode());
            model.addAttribute("message", result.getMessage().replace('_', ' '));
            return "result";
        } catch (Exception e) {
            System.err.println(Result.SERVICE_NOT_AVAILABLE.getMessage().replace('_', ' '));
            model.addAttribute("message", Result.SERVICE_NOT_AVAILABLE.getMessage().replace('_', ' '));
            return "result";
        }
    }
}
