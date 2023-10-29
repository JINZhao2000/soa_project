package cyou.zhaojin.service.impl;

import cyou.zhaojin.bean.Client;
import cyou.zhaojin.constants.Result;
import cyou.zhaojin.service.ApprovalDecision;
import jakarta.jws.WebService;
import lombok.extern.log4j.Log4j2;

/**
 * @author Zhao JIN
 */
@WebService(endpointInterface = "cyou.zhaojin.service.ApprovalDecision")
@Log4j2
public class ApprovalDecisionImpl implements ApprovalDecision {
    @Override
    public Result decision(Client client, boolean credit, boolean prop) {
        if (!credit) {
            return Result.CREDIT_NOT_ALLOWED;
        }
        if (!prop) {
            return Result.PROPERTY_NOT_VALID;
        }
        if (!decision(client)) {
            return Result.FINAL_DECISION_NOT_PASSED;
        }
        return Result.SUCCESS;
    }

    private boolean risk(Client client) {
        log.info("This part will be replaced by a real risk analysis system");
        return true;
    }

    private boolean politic(Client client) {
        log.info("This part will be replaced by a real politic analysis system");
        return true;
    }

    private boolean predict(Client client) {
        log.info("This part will be replaced by a trained prediction model");
        return true;
    }

    private boolean decision(Client client) {
        return risk(client) && politic(client) && predict(client);
    }
}
