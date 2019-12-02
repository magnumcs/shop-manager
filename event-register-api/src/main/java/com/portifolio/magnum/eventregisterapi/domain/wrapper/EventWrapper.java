package com.portifolio.magnum.eventregisterapi.domain.wrapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.portifolio.magnum.eventregisterapi.domain.TypeEventEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Data
@Document(collection = "event")
@AllArgsConstructor
@NoArgsConstructor
public class EventWrapper implements Serializable {

    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @Enumerated(EnumType.STRING)
    private TypeEventEnum event;
    private Double revenue;
    @JsonProperty("custom_data")
    private List<CustomDataWrapper> customData = new ArrayList<>();

}
