package com.portifolio.magnum.eventregisterapi.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.*;

@Data
@Document(collection = "timeline")
public class TimeLine implements Serializable {

    @Id
    private String id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp;
    private Double revenue;
    private String transactionId;
    private String storeName;
    private List<Product> products = new ArrayList<>();

}
