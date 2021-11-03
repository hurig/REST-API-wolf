package hu.forestwolf.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class MethodNotAllowedException extends RuntimeException{

    private String message;

    public MethodNotAllowedException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
