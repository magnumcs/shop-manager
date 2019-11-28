package com.portifolio.magnum.eventregisterapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.portifolio.magnum.eventregisterapi.domain.TypeEventEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event implements Serializable {

    @Id
    private String id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @Enumerated(EnumType.STRING)
    private TypeEventEnum event;
    private Double revenue;
    @JsonProperty("custom_data")
    private Map<String, String> customData = new HashMap<>();




}
