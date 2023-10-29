package cyou.zhaojin;

import cyou.zhaojin.service.impl.VerificationImpl;
import jakarta.xml.ws.Endpoint;

/**
 * @author Zhao JIN
 */
public class SVPublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9001/SV", new VerificationImpl());
    }
}
