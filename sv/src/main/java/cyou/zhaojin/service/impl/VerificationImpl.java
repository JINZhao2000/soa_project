package cyou.zhaojin.service.impl;

import cyou.zhaojin.bean.Client;
import cyou.zhaojin.bean.Credit;
import cyou.zhaojin.dao.CreditDao;
import cyou.zhaojin.dao.impl.CreditDaoImpl;
import cyou.zhaojin.service.Verification;
import jakarta.jws.WebService;
import lombok.extern.log4j.Log4j2;

import java.util.List;

/**
 * @author Zhao JIN
 */

@WebService(endpointInterface = "cyou.zhaojin.service.Verification")
@Log4j2
public class VerificationImpl implements Verification {
    private final static CreditDao creditDao = new CreditDaoImpl();
    private final static double RATE = 0.05;
    private final static int YEAR_MAX = 10;

    private final static int AMOUNT_MAX = 150_000;
    private final static double PROP_TIME = 0.4;
    private final static double SCORE_GAP = 0.5;
    private final static double REST_GAP = 0.1;
    @Override
    public boolean doVerify(Client client) {
        if (score(client.getDuration(), client.getAmount()) <= SCORE_GAP) {
            return false;
        }

        double clientIn = client.getIncome() - client.getSpent();
        double clientOut = due(client.getDuration(), client.getAmount());
        if (clientIn <= clientOut) {
            return false;
        }
        List<Credit> credits = creditDao.findAll(client.getEmail());
        if (credits.isEmpty()) {
            return (clientIn - clientOut) / clientIn >= REST_GAP;
        }
        double all = credits.stream().map(c -> due(c.getC_time_rest(), c.getC_amount_rest())).mapToDouble(Double::doubleValue).sum();
        return (clientIn - clientOut - all) / clientIn >= REST_GAP;
    }

    private double score(int time, int amount) {
        if (time > YEAR_MAX) return 0;
        if (amount > AMOUNT_MAX) return 0;
        return (1 - time / (double) YEAR_MAX) * 100 * PROP_TIME + (1 - amount / (double) AMOUNT_MAX) * 100 * (1-PROP_TIME);
    }

    private double due(int time, int amount) {
        if (time == 0) {
            return Integer.MAX_VALUE;
        }
        return amount * Math.pow(1.0+RATE,time) / (double) time / 12.0;
    }
}
