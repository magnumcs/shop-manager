package com.portifolio.magnum.eventregisterapi.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.portifolio.magnum.eventregisterapi.domain.wrapper.EventRequestWrapper;
import com.portifolio.magnum.eventregisterapi.model.Event;
import com.portifolio.magnum.eventregisterapi.model.TimeLine;
import com.portifolio.magnum.eventregisterapi.service.TimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/timeline")
public class TimelineController {

    private final TimelineService timelineService;

    @Autowired
    public TimelineController(TimelineService timelineService) {
        this.timelineService = timelineService;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> registerEvents(@RequestBody EventRequestWrapper eventRequestWrapper) {
        List<TimeLine> timeLine = timelineService.collectEvents(eventRequestWrapper.getEvents());
        return ResponseEntity.ok().body(null);
    }

}
