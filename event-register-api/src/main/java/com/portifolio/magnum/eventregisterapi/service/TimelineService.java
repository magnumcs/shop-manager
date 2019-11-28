package com.portifolio.magnum.eventregisterapi.service;

import com.portifolio.magnum.eventregisterapi.domain.wrapper.EventWrapper;
import com.portifolio.magnum.eventregisterapi.domain.wrapper.TimelineResponseWrapper;
import com.portifolio.magnum.eventregisterapi.model.Event;
import com.portifolio.magnum.eventregisterapi.model.TimeLine;

import java.util.List;

public interface TimelineService {

    TimelineResponseWrapper manipulateEvents(List<EventWrapper> eventsRequest);

}
