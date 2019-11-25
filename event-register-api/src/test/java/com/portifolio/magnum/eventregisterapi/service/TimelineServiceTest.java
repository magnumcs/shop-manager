package com.portifolio.magnum.eventregisterapi.service;

import com.portifolio.magnum.eventregisterapi.model.Event;
import com.portifolio.magnum.eventregisterapi.model.TimeLine;
import com.portifolio.magnum.eventregisterapi.repository.TimelineRepository;
import com.portifolio.magnum.eventregisterapi.service.Imp.TimelineServiceImp;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

import static com.portifolio.magnum.eventregisterapi.mock.EventMocks.*;

@RunWith(MockitoJUnitRunner.Silent.class)
public class TimelineServiceTest {

    @InjectMocks
    private TimelineServiceImp timelineService;

    @Mock
    private TimelineRepository timelineRepository;

    @Test
    public void deveSalvarOsEventosNoBancoEListarDadosOrdenados() {

        List<Event> events = new ArrayList<>();

        Event event = eventoComprouProdutoCamisaAzul();
        events.add(event);

        Event event2 = eventoComprouPatioSavassi();
        events.add(event2);

        Event event3 = eventoComprouProdutoCalcaRosa();
        events.add(event3);

        Event event4 = eventoComprouProdutoTenisPreto();
        events.add(event4);

        Event event5 = eventoComproBHShopping();
        events.add(event5);

        //List<TimeLine> timeLine = timelineService.collectEvents(events);

        //Assert.assertArrayEquals();

    }



}
