package com.portifolio.magnum.eventregisterapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_GATEWAY)
public class BadGatewayException extends RuntimeException {
    public BadGatewayException() {
        super();
    }
    public BadGatewayException(String message, Throwable cause) {
        super(message, cause);
    }
    public BadGatewayException(String message) {
        super(message);
    }
    public BadGatewayException(Throwable cause) {
        super(cause);
    }
}
