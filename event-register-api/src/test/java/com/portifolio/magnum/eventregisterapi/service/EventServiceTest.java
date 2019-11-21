package com.portifolio.magnum.eventregisterapi.service;

import com.portifolio.magnum.eventregisterapi.model.Event;
import com.portifolio.magnum.eventregisterapi.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EventServiceTest {

    private final EventRepository eventRepository;

    @Autowired
    public EventServiceTest(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void deveSalvarOsEventosNoBancoEVerificarSeSalvouCorretamente() {
        Event event = new Event();
        event.set

    }
}
