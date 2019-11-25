package com.portifolio.magnum.eventregisterapi.model;

import com.portifolio.magnum.eventregisterapi.domain.TypeEventEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
@Document(collection = "event")
@NoArgsConstructor
@AllArgsConstructor
public class Event extends ArrayList<Event> implements Serializable {

    @Id
    private String id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp;
    @Enumerated(EnumType.STRING)
    private TypeEventEnum event;
    private Double revenue;
    private Map<String, String> customData = new HashMap<>();


}
