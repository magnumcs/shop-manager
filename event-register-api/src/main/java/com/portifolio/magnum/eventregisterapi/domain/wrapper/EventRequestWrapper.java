package com.portifolio.magnum.eventregisterapi.domain.wrapper;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class EventRequestWrapper implements Serializable {

    private List<EventWrapper> events = new ArrayList<>();

}
