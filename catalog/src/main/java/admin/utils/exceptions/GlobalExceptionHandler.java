package admin.utils.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(APIException.class)
    public final ResponseEntity<Object> handleAPIException(APIException apiException, WebRequest webRequest) {
        logger.error("APIException caught: ", apiException);

        var response = new ExceptionResponse(
                apiException.getMessage(),
                apiException.getCode(),
                apiException.getPayload(),
                apiException.getStatus());

        return new ResponseEntity<>(response, apiException.getStatus());
    }

    public static class ExceptionResponse {
        private final String message;
        private final String code;
        private final Object payload;
        private final HttpStatus status;

        public ExceptionResponse(
                String message,
                String code,
                Object payload,
                HttpStatus status) {
            this.message = message;
            this.code = code;
            this.payload = payload;
            this.status = status;
        }

        public String getMessage() {
            return message;
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
}
