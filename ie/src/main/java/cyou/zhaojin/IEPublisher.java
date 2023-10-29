package cyou.zhaojin;

import cyou.zhaojin.service.impl.InformationExtractionImpl;
import jakarta.xml.ws.Endpoint;

/**
 * @author Zhao JIN
 */
public class IEPublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9000/IE", new InformationExtractionImpl());
    }
}
