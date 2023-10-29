package cyou.zhaojin.service.impl;

import cyou.zhaojin.bean.Client;
import cyou.zhaojin.constants.Result;
import cyou.zhaojin.dao.ClientDao;
import cyou.zhaojin.dao.impl.ClientDaoImpl;
import cyou.zhaojin.service.ApprovalDecision;
import cyou.zhaojin.service.InformationExtraction;
import cyou.zhaojin.service.PropertyEvaluation;
import cyou.zhaojin.service.Verification;
import cyou.zhaojin.utility.IEUtils;
import cyou.zhaojin.utility.Pair;
import jakarta.jws.WebService;
import jakarta.xml.ws.Service;
import lombok.extern.log4j.Log4j2;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Zhao JIN
 */
@WebService(endpointInterface = "cyou.zhaojin.service.InformationExtraction")
@Log4j2
public class InformationExtractionImpl implements InformationExtraction {
    private static final ClientDao clientDao = new ClientDaoImpl();

    @Override
    public Result doExtract(String data) {
        String newData = IEUtils.pretreat(data);
        Pair<Result, Client> result = IEUtils.extract(newData);
        if (result.first().getCode() != Result.SUCCESS_CODE) {
            return result.first();
        }
        Client client = result.second();
        clientDao.saveClient(client);

        QName svName = new QName("http://impl.service.zhaojin.cyou/","VerificationImplService");
        QName peName = new QName("http://impl.service.zhaojin.cyou/","PropertyEvaluationImplService");
        QName adName = new QName("http://impl.service.zhaojin.cyou/","ApprovalDecisionImplService");
        try {
            Verification sv = Service.create(new URL("http://localhost:9001/SV?wsdl"), svName).getPort(Verification.class);
            boolean svResult = sv.doVerify(client);
            PropertyEvaluation pe = Service.create(new URL("http://localhost:9002/PE?wsdl"), peName).getPort(PropertyEvaluation.class);
            boolean peResult = pe.doEvaluate(client);
            ApprovalDecision ad = Service.create(new URL("http://localhost:9003/AD?wsdl"), adName).getPort(ApprovalDecision.class);
            return ad.decision(client, svResult, peResult);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.SERVICE_NOT_AVAILABLE;
        }
    }
}
