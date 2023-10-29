package cyou.zhaojin;

import cyou.zhaojin.service.impl.PropertyEvaluationImpl;
import jakarta.xml.ws.Endpoint;

/**
 * @author Zhao JIN
 */
public class PEPublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9002/PE", new PropertyEvaluationImpl());
    }
}
