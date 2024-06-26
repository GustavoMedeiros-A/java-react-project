package admin.catalog.utils.exceptions;

import org.springframework.http.HttpStatus;

public class APIException extends RuntimeException {
    private final String code;
    private final HttpStatus status;
    private final Object payload;

    public APIException(String message, String code, HttpStatus status, Object payload) {
        super(message);
        this.code = code;
        this.status = status;
        this.payload = payload;
    }

    public String getCode() {
        return code;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public Object getPayload() {
        return payload;
    }

}
