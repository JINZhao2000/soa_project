package cyou.zhaojin.bean;

/**
 * @author Zhao JIN
 */
public class Credit {
    private int credit_id;
    private String email;
    private int c_amount;
    private int c_duration;
    private int c_time_rest;
    private int c_amount_rest;

    public Credit() {}

    public Credit(int credit_id, String email, int c_amount, int c_duration, int c_time_rest, int c_amount_rest) {
        this.credit_id = credit_id;
        this.email = email;
        this.c_amount = c_amount;
        this.c_duration = c_duration;
        this.c_time_rest = c_time_rest;
        this.c_amount_rest = c_amount_rest;
    }

    public int getCredit_id() {
        return credit_id;
    }

    public String getEmail() {
        return email;
    }

    public int getC_amount() {
        return c_amount;
    }

    public int getC_duration() {
        return c_duration;
    }

    public int getC_time_rest() {
        return c_time_rest;
    }

    public int getC_amount_rest() {
        return c_amount_rest;
    }
}
