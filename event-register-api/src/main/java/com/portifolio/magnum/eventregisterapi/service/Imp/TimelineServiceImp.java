package com.portifolio.magnum.eventregisterapi.service.Imp;

import com.portifolio.magnum.eventregisterapi.model.Event;
import com.portifolio.magnum.eventregisterapi.model.Product;
import com.portifolio.magnum.eventregisterapi.model.TimeLine;
import com.portifolio.magnum.eventregisterapi.repository.TimelineRepository;
import com.portifolio.magnum.eventregisterapi.service.TimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class TimelineServiceImp implements TimelineService {

    private static String PRODUCT_NAME = "product_name";
    private static String PRODUCT_PRICE = "product_price";
    private static String TRANSACTION_ID = "transaction_id";
    private static String STORE_NAME = "store_name";

    private final TimelineRepository timelineRepository;

    @Autowired
    public TimelineServiceImp(TimelineRepository timelineRepository) {
        this.timelineRepository = timelineRepository;
    }

    @Override
    public List<TimeLine> collectEvents(List<Event> events) {
        Map<String,List<Event>> eventsByTransaction =  events.stream()
                .collect(Collectors.groupingBy(e -> e.getCustomData().get(TRANSACTION_ID)));

        List<TimeLine> timeLine = buildTimelineDetails(eventsByTransaction);

        timeLine.forEach(timelineRepository::save);

        return timeLine;
    }

    private List<TimeLine> buildTimelineDetails(Map<String,List<Event>> eventsByTransaction) {
        List<TimeLine> timeLineList = new ArrayList<>();
        eventsByTransaction.entrySet().stream().forEach(map -> {
            TimeLine timeLine = new TimeLine();
            map.getValue().stream().forEach(list -> {
                timeLine.setTimeStamp(list.getTimeStamp());
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
