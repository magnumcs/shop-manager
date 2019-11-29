package com.portifolio.magnum.eventregisterapi.domain.wrapper;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseWrapper implements Serializable {

    private Integer httpStatus;
    private String message;

    public ResponseWrapper(Integer httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
