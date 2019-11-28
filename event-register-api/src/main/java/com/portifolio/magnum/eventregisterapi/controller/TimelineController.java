package com.portifolio.magnum.eventregisterapi.controller;

import com.portifolio.magnum.eventregisterapi.client.EventsClient;
import com.portifolio.magnum.eventregisterapi.domain.wrapper.EventRequestWrapper;
import com.portifolio.magnum.eventregisterapi.domain.wrapper.TimelineResponseWrapper;
import com.portifolio.magnum.eventregisterapi.service.TimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/timeline")
public class TimelineController {

    private final TimelineService timelineService;

    private final EventsClient eventsClient;

    @Autowired
    public TimelineController(TimelineService timelineService, EventsClient eventsClient) {
        this.timelineService = timelineService;
        this.eventsClient = eventsClient;
    }

    @PostMapping
    public ResponseEntity<?> registerEvents(@RequestBody EventRequestWrapper eventRequestWrapper) {
        return eventsClient.get();
//        TimelineResponseWrapper timeline = timelineService.collectEvents(eventRequestWrapper.getEvents());
//        return ResponseEntity.ok().body(timeline);
    }



}
