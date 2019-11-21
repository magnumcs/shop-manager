package com.portifolio.magnum.eventregisterapi.model;

import com.portifolio.magnum.eventregisterapi.domain.TypeEventEnum;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;

@Data
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp;
    @Enumerated(EnumType.STRING)
    private TypeEventEnum typeEvent;
    @ElementCollection
    @CollectionTable(name="customData")
    @MapKeyColumn(name="customData_id")
    private HashMap<String, String> customData;


}
