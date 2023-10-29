package cyou.zhaojin;

import cyou.zhaojin.service.impl.ApprovalDecisionImpl;
import jakarta.xml.ws.Endpoint;

/**
 * @author Zhao JIN
 */
public class ADPublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9003/AD", new ApprovalDecisionImpl());
    }
}
