package com.portifolio.magnum.eventregisterapi.controller;

import com.portifolio.magnum.eventregisterapi.domain.wrapper.EventWrapper;
import com.portifolio.magnum.eventregisterapi.domain.wrapper.ResponseWrapper;
import com.portifolio.magnum.eventregisterapi.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/events")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping(value = "/collect")
    public ResponseEntity<ResponseWrapper> collectEvents() {
        ResponseWrapper response = eventService.collectEvents();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/autocomplete/{input}")
    public ResponseEntity<List<EventWrapper>> getEventAutoComplete(@PathVariable("input") String input) {
        List<EventWrapper> events = eventService.getEventsAutoComplete(input);
        if(events.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(events);
    }
}
