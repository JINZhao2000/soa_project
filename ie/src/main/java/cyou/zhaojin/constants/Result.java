package cyou.zhaojin.constants;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@XmlRootElement
public class Result implements Serializable {
    private int code;
    private String message;

    private Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result() {}

    public final static int SUCCESS_CODE = 0;
    public final static int INVALID_DATA_CODE = -1;
    public final static int INVALID_EMAIL_CODE = -2;
    public final static int NEGATIVE_VALUE_CODE = -3;
    public final static int UNKNOWN_DATA_CODE = -4;
    public final static int SAVE_ERROR_CODE = -5;
    public final static int SERVICE_NOT_AVAILABLE_CODE = -6;

    public final static int CREDIT_NOT_ALLOWED_CODE = -7;
    public final static int PROPERTY_NOT_VALID_CODE = -8;
    public final static int FINAL_DECISION_NOT_PASSED_CODE = -9;

    final static String SUCCESS_MESSAGE = "success";
    final static String INVALID_DATA_MESSAGE = "invalid_data";
    final static String INVALID_EMAIL_MESSAGE = "invalid_email";
    final static String UNKNOWN_DATA_MESSAGE = "unknown_data";
    final static String NEGATIVE_VALUE_MESSAGE = "negative_value";
    final static String SAVE_ERROR_MESSAGE = "save_error";
    final static String SERVICE_NOT_AVAILABLE_MESSAGE = "service_not_available";
    final static String CREDIT_NOT_ALLOWED_MESSAGE = "credit_not_allowed";
    final static String PROPERTY_NOT_VALID_MESSAGE = "property_not_valid";
    final static String FINAL_DECISION_NOT_PASSED_MESSAGE = "problem_of_risk_or_politics_not_passed";

    public final static Result SUCCESS = new Result(SUCCESS_CODE, SUCCESS_MESSAGE);
    public final static Result INVALID_DATA = new Result(INVALID_DATA_CODE, INVALID_DATA_MESSAGE);
    public final static Result INVALID_EMAIL = new Result(INVALID_EMAIL_CODE, INVALID_EMAIL_MESSAGE);
    public final static Result NEGATIVE_VALUE = new Result(NEGATIVE_VALUE_CODE, NEGATIVE_VALUE_MESSAGE);
    public final static Result UNKNOWN_DATA = new Result(UNKNOWN_DATA_CODE, UNKNOWN_DATA_MESSAGE);
    public final static Result SAVE_ERROR = new Result(SAVE_ERROR_CODE, SAVE_ERROR_MESSAGE);
    public final static Result SERVICE_NOT_AVAILABLE = new Result(SERVICE_NOT_AVAILABLE_CODE, SERVICE_NOT_AVAILABLE_MESSAGE);
    public final static Result CREDIT_NOT_ALLOWED = new Result(CREDIT_NOT_ALLOWED_CODE, CREDIT_NOT_ALLOWED_MESSAGE);
    public final static Result PROPERTY_NOT_VALID = new Result(PROPERTY_NOT_VALID_CODE, PROPERTY_NOT_VALID_MESSAGE);
    public final static Result FINAL_DECISION_NOT_PASSED = new Result(FINAL_DECISION_NOT_PASSED_CODE, FINAL_DECISION_NOT_PASSED_MESSAGE);

    public String toString() {
        return this.code + ":" + this.message;
    }

    @XmlElement
    public int getCode() {
        return code;
    }

    @XmlElement
    public String getMessage() {
        return message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
