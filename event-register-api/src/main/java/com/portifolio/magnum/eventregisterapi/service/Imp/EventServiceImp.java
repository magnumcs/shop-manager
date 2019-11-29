package com.portifolio.magnum.eventregisterapi.service.Imp;

import com.portifolio.magnum.eventregisterapi.client.EventsClient;
import com.portifolio.magnum.eventregisterapi.domain.wrapper.EventRequestWrapper;
import com.portifolio.magnum.eventregisterapi.domain.wrapper.EventWrapper;
import com.portifolio.magnum.eventregisterapi.domain.wrapper.ResponseWrapper;
import com.portifolio.magnum.eventregisterapi.exception.BadGatewayException;
import com.portifolio.magnum.eventregisterapi.model.Event;
import com.portifolio.magnum.eventregisterapi.repository.EventRepository;
import com.portifolio.magnum.eventregisterapi.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class EventServiceImp implements EventService {

    private final EventsClient eventsClient;
    private final EventRepository eventRepository;

    @Autowired
    public EventServiceImp(EventsClient eventsClient, EventRepository eventRepository) {
        this.eventsClient = eventsClient;
        this.eventRepository = eventRepository;
    }

    @Override
    public ResponseWrapper collectEvents() {
        ResponseEntity<EventRequestWrapper> eventRequest = eventsClient.get();

        if(HttpStatus.OK.equals(eventRequest.getStatusCode()) &&
                !Objects.requireNonNull(eventRequest.getBody()).getEvents().isEmpty()) {
            eventRequest.getBody().getEvents().forEach(eventRepository::save);
            return new ResponseWrapper(HttpStatus.OK.value(), "Eventos coletados com sucesso!");
        }
        throw new BadGatewayException("Erro ao tentar realizar operação");
    }

    @Override
    public List<EventWrapper> getEventsAutoComplete(String input) {
        if(input.length() < 2) {
            return Collections.emptyList();
        }
        return eventRepository.findEventByEventLike(input.toUpperCase());
    }
}
