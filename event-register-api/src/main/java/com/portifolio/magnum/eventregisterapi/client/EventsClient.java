package com.portifolio.magnum.eventregisterapi.client;

import com.portifolio.magnum.eventregisterapi.domain.wrapper.EventRequestWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "events-service", url = "https://storage.googleapis.com/dito-questions", decode404 = true)
public interface EventsClient {

    @GetMapping("/events.json")
    ResponseEntity<EventRequestWrapper> get();
}
