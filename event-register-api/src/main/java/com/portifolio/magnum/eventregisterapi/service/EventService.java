package com.portifolio.magnum.eventregisterapi.service;

import com.portifolio.magnum.eventregisterapi.domain.wrapper.EventWrapper;
import com.portifolio.magnum.eventregisterapi.domain.wrapper.ResponseWrapper;

import java.util.List;

public interface EventService {

    ResponseWrapper collectEvents();

    List<EventWrapper> getEventsAutoComplete(String input);

}
