package com.portifolio.magnum.eventregisterapi.model;

import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.*;

@Data
public class TimeLine implements Serializable {

    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp;
    private Double revenue;
    private String transactionId;
    private String storeName;
    private List<Product> products = new ArrayList<>();

}
