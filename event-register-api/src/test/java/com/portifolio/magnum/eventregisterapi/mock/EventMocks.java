package com.portifolio.magnum.eventregisterapi.mock;

import com.portifolio.magnum.eventregisterapi.domain.TypeEventEnum;
import com.portifolio.magnum.eventregisterapi.model.Event;

import java.util.Date;
import java.util.HashMap;

public class EventMocks {

    public static Event eventoComprouProdutoCamisaAzul() {
        HashMap<String, String> customData = new HashMap<>();
        customData.put("product_name", "Camisa Azul");
        customData.put("transaction_id", "3029384");
        customData.put("product_price", "100");

        Event event = new Event();
        event.setTimeStamp(new Date());
        event.setEvent(TypeEventEnum.COMPROU_PRODUTO);
        event.setCustomData(customData);
        return event;
    }

    public static Event eventoComprouPatioSavassi() {
        HashMap<String, String> customData2 = new HashMap<>();
        customData2.put("store_name", "Patio Savassi");
        customData2.put("transaction_id", "3029384");

        Event event2 = new Event();
        event2.setTimeStamp(new Date());
        event2.setRevenue(250.0);
        event2.setEvent(TypeEventEnum.COMPROU);
        event2.setCustomData(customData2);
        return event2;
    }

    public static Event eventoComprouProdutoCalcaRosa() {
        HashMap<String, String> customData3 = new HashMap<>();
        customData3.put("product_name", "Calça Rosa");
        customData3.put("transaction_id", "3029384");
        customData3.put("product_price", "150");

        Event event3 = new Event();
        event3.setTimeStamp(new Date());
        event3.setEvent(TypeEventEnum.COMPROU_PRODUTO);
        event3.setCustomData(customData3);
        return event3;
    }

    public static Event eventoComprouProdutoTenisPreto() {
        HashMap<String, String> customData4 = new HashMap<>();
        customData4.put("product_name", "Tênis preto");
        customData4.put("transaction_id", "3409340");
        customData4.put("product_price", "120");

        Event event4 = new Event();
        event4.setTimeStamp(new Date());
        event4.setEvent(TypeEventEnum.COMPROU_PRODUTO);
        event4.setCustomData(customData4);
        return event4;
    }

    public static Event eventoComproBHShopping() {
        HashMap<String, String> customData5 = new HashMap<>();
        customData5.put("store_name", "BH Shopping");
        customData5.put("transaction_id", "3409340");

        Event event5 = new Event();
        event5.setTimeStamp(new Date());
        event5.setRevenue(120.0);
        event5.setEvent(TypeEventEnum.COMPROU);
        event5.setCustomData(customData5);
        return event5;
    }


}
