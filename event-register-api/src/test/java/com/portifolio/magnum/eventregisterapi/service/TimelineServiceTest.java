package com.portifolio.magnum.eventregisterapi.service;

import com.portifolio.magnum.eventregisterapi.domain.wrapper.EventWrapper;
import com.portifolio.magnum.eventregisterapi.domain.wrapper.TimelineResponseWrapper;
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
    public void deveManipularOsDadosDosEventosERetornorATimelineOrdenada() {

        List<EventWrapper> events = new ArrayList<>();

        EventWrapper event = eventoComprouProdutoCamisaAzul();
        events.add(event);

        EventWrapper event2 = eventoComprouPatioSavassi();
        events.add(event2);

        EventWrapper event3 = eventoComprouProdutoCalcaRosa();
        events.add(event3);

        EventWrapper event4 = eventoComprouProdutoTenisPreto();
        events.add(event4);

        EventWrapper event5 = eventoComproBHShopping();
        events.add(event5);

        TimelineResponseWrapper timeline = timelineService.manipulateEvents(events);

        Assert.assertEquals(2, timeline.getTimeline().size());

    }

}
