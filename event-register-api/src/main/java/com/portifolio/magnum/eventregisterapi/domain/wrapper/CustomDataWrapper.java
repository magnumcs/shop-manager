package com.portifolio.magnum.eventregisterapi.domain.wrapper;

import lombok.Data;

import java.io.Serializable;

@Data
public class CustomDataWrapper implements Serializable {

    private String key;
    private String value;

}
