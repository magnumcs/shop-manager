package com.portifolio.magnum.eventregisterapi.service.Imp;

import com.portifolio.magnum.eventregisterapi.client.EventsClient;
import com.portifolio.magnum.eventregisterapi.domain.wrapper.EventRequestWrapper;
import com.portifolio.magnum.eventregisterapi.repository.EventRepository;
import com.portifolio.magnum.eventregisterapi.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

public class EventServiceImp implements EventService {

    private final EventsClient eventsClient;
    private final EventRepository eventRepository;

    @Autowired
    public EventServiceImp(EventsClient eventsClient, EventRepository eventRepository) {
        this.eventsClient = eventsClient;
        this.eventRepository = eventRepository;
    }

    @Override
    public void collectEvents() {
        ResponseEntity<EventRequestWrapper> eventRequest = eventsClient.get();

        if(HttpStatus.OK.equals(eventRequest.getStatusCode()) &&
                !Objects.requireNonNull(eventRequest.getBody()).getEvents().isEmpty()){
            eventRequest.getBody().getEvents().forEach(eventRepository::save);
        }
    }
}
