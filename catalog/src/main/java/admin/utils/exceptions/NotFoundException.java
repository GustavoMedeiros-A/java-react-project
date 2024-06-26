package admin.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends APIException {
    public NotFoundException(String message, Object payload) {
        super(message, "@medeiros/notfound", HttpStatus.NOT_FOUND, payload);
    }
}
