package com.portifolio.magnum.eventregisterapi.service.Imp;

import com.portifolio.magnum.eventregisterapi.client.EventsClient;
import com.portifolio.magnum.eventregisterapi.domain.wrapper.EventRequestWrapper;
import com.portifolio.magnum.eventregisterapi.domain.wrapper.EventWrapper;
import com.portifolio.magnum.eventregisterapi.domain.wrapper.TimelineResponseWrapper;
import com.portifolio.magnum.eventregisterapi.exception.BadGatewayException;
import com.portifolio.magnum.eventregisterapi.model.Event;
import com.portifolio.magnum.eventregisterapi.model.Product;
import com.portifolio.magnum.eventregisterapi.model.TimeLine;
import com.portifolio.magnum.eventregisterapi.service.TimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TimelineServiceImp implements TimelineService {

    private static String PRODUCT_NAME = "product_name";
    private static String PRODUCT_PRICE = "product_price";
    private static String TRANSACTION_ID = "transaction_id";
    private static String STORE_NAME = "store_name";

    private final EventsClient eventsClient;

    @Autowired
    public TimelineServiceImp(EventsClient eventsClient) {
        this.eventsClient = eventsClient;
    }


    private EventRequestWrapper getEvents() {
        ResponseEntity<EventRequestWrapper> eventRequest = eventsClient.get();
        if(HttpStatus.OK.equals(eventRequest.getStatusCode()) &&
                !Objects.requireNonNull(eventRequest.getBody()).getEvents().isEmpty()) {
            return eventRequest.getBody();
        }
        throw new BadGatewayException("Erro ao tentar realizar operação!");
    }

    @Override
    public TimelineResponseWrapper manipulateEvents() {
        EventRequestWrapper eventRequest = getEvents();

        List<Event> events = new ArrayList<>();

        eventRequest.getEvents().forEach(e -> events.add(buildEventRequest(e)));

        Map<String,List<Event>> eventsByTransaction =  events.stream()
                .collect(Collectors.groupingBy(e -> e.getCustomData().get(TRANSACTION_ID)));

        List<TimeLine> timeline = buildTimelineDetails(eventsByTransaction);

        return new TimelineResponseWrapper(timeline);
    }

    private Event buildEventRequest(EventWrapper eventWrapper) {
        Map<String, String> dados = new HashMap<>();
        eventWrapper.getCustomData().forEach(cd -> dados.put(cd.getKey(), cd.getValue()));
        return Event.builder()
                .event(eventWrapper.getEvent())
                .timestamp(eventWrapper.getTimestamp())
                .revenue(eventWrapper.getRevenue())
                .customData(dados).build();
    }

    private List<TimeLine> buildTimelineDetails(Map<String,List<Event>> eventsByTransaction) {
        List<TimeLine> timeLineList = new ArrayList<>();
        eventsByTransaction.entrySet().stream().forEach(map -> {
            TimeLine timeLine = new TimeLine();
            map.getValue().stream().forEach(list -> {
                timeLine.setTimeStamp(list.getTimestamp());
                timeLine.setTransactionId(list.getCustomData().get(TRANSACTION_ID));
                if(list.getRevenue() != null)
                    timeLine.setRevenue(list.getRevenue());
                if(list.getCustomData().get(STORE_NAME) != null)
                    timeLine.setStoreName(list.getCustomData().get(STORE_NAME));
                Product p = new Product();
                list.getCustomData().entrySet().stream().forEach(product -> {
                    if(PRODUCT_PRICE.equals(product.getKey()) || PRODUCT_NAME.equals(product.getKey())) {
                        if(PRODUCT_NAME.equals(product.getKey()))
                            p.setName(product.getValue());
                        if(PRODUCT_PRICE.equals(product.getKey()))
                            p.setPrice(Double.valueOf(product.getValue()));
                    }
                });
                if(p.getName() != null && p.getPrice() != null)
                    timeLine.getProducts().add(p);
            });
            timeLineList.add(timeLine);
        });
        return timeLineList;
    }
}
