package icu.yuyurbq.go.base.exception;

public enum ErrorCodeEnum {

    UNKNOWN_EXCEPTION(10000,"未知错误"),
    VALID_EXCEPTION(10001,"参数格式错误");

    private final int code;
    private final String message;

    ErrorCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
