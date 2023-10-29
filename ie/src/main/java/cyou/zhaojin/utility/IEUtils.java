package cyou.zhaojin.utility;

import cyou.zhaojin.bean.Client;
import cyou.zhaojin.constants.Result;

import java.util.Locale;
import java.util.regex.Pattern;

/**
 * @author Zhao JIN
 */
public class IEUtils {
    private static final Pattern pattern = Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");

    public static String pretreat(String data) {
        return data.toLowerCase(Locale.FRANCE);
    }

    public static Pair<Result, Client> extract(String data) {
        String[] lines = data.split("\n");
        Client client = new Client();
        for (String line : lines) {
            Result result = inject(client, line);
            if (result.getCode() != Result.SUCCESS_CODE)
                return new Pair<>(result, null);
        }
        return new Pair<>(Result.SUCCESS, client);
    }

    private static Result inject(Client c, String pair) {
        int ind = pair.indexOf(':');
        if (ind == -1) return Result.INVALID_DATA;
        String key = pair.substring(0, ind);
        String value = pair.substring(ind+1, pair.length()-1);
        switch (key) {
            case "email":
                String email = value.trim();
                if (pattern.matcher(email).find()) {
                    c.setEmail(email);
                    return Result.SUCCESS;
                }
                return Result.INVALID_EMAIL;
            case "nom du client":
                c.setName(value.trim());
                return Result.SUCCESS;
            case "adresse":
                c.setAddress(value.trim());
                return Result.SUCCESS;
            case "numéro de téléphone":
                String number = value.trim().replaceAll( " ", "").replace("+", "00");
                c.setTel(number);
                return Result.SUCCESS;
            case "montant du prêt demandé":
                int amount = parseInt(value);
                if (amount < 0) {
                    return Result.NEGATIVE_VALUE;
                }
                c.setAmount(amount);
                return Result.SUCCESS;
            case "durée du prêt":
                int duration = parseInt(value);
                if (duration < 0) {
                    return Result.NEGATIVE_VALUE;
                }
                c.setDuration(duration);
                return Result.SUCCESS;
            case "description de la propriété":
                if (value.length() > 200) {
                    value = value.substring(0, 200);
                }
                c.setDescription(value);
                return Result.SUCCESS;
            case "revenu mensuel":
                double incomev = parseDouble(value);
                if (incomev < 0) {
                    return Result.NEGATIVE_VALUE;
                }
                c.setIncome(incomev);
                return Result.SUCCESS;
            case "dépenses mensuelles":
                double spentv = parseDouble(value);
                if (spentv < 0) {
                    return Result.NEGATIVE_VALUE;
                }
                c.setSpent(spentv);
                return Result.SUCCESS;
            default:
                return Result.UNKNOWN_DATA;
        }
    }

    private static int parseInt(String str) {
        String s = str.replaceAll("[^0-9]", "");
        if (s.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(s);
    }

    private static double parseDouble(String str) {
        String s = str.replace(",", ".").replaceAll("[^0-9.]", "");
        if (s.isEmpty()) {
            return 0.0;
        }
        return Double.parseDouble(s);
    }
}
