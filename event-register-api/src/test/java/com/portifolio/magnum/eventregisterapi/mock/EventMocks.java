package com.portifolio.magnum.eventregisterapi.mock;

import com.portifolio.magnum.eventregisterapi.domain.TypeEventEnum;
import com.portifolio.magnum.eventregisterapi.domain.wrapper.CustomDataWrapper;
import com.portifolio.magnum.eventregisterapi.domain.wrapper.EventWrapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventMocks {

    public static List<CustomDataWrapper> camisaAzul() {
        List<CustomDataWrapper> customData = new ArrayList<>();
        CustomDataWrapper customDataWrapper1 = new CustomDataWrapper();
        customDataWrapper1.setKey("product_name");
        customDataWrapper1.setValue("Camisa Azul");
        CustomDataWrapper customDataWrapper2 = new CustomDataWrapper();
        customDataWrapper2.setKey("transaction_id");
        customDataWrapper2.setValue("3029384");
        CustomDataWrapper customDataWrapper3 = new CustomDataWrapper();
        customDataWrapper3.setKey("product_price");
        customDataWrapper3.setValue("100");
        customData.add(customDataWrapper1);
        customData.add(customDataWrapper2);
        customData.add(customDataWrapper3);
        return customData;
    }

    public static EventWrapper eventoComprouProdutoCamisaAzul() {
        EventWrapper event = new EventWrapper();
        event.setTimestamp(new Date());
        event.setEvent(TypeEventEnum.COMPROU_PRODUTO);
        event.setCustomData(camisaAzul());
        return event;
    }

    public static List<CustomDataWrapper> patioSavassi() {
        List<CustomDataWrapper> customData = new ArrayList<>();
        CustomDataWrapper customDataWrapper1 = new CustomDataWrapper();
        customDataWrapper1.setKey("store_name");
        customDataWrapper1.setValue("Patio Savassi");
        CustomDataWrapper customDataWrapper2 = new CustomDataWrapper();
        customDataWrapper2.setKey("transaction_id");
        customDataWrapper2.setValue("3029384");
        customData.add(customDataWrapper1);
        customData.add(customDataWrapper2);
        return customData;
    }

    public static EventWrapper eventoComprouPatioSavassi() {
        EventWrapper event2 = new EventWrapper();
        event2.setTimestamp(new Date());
        event2.setRevenue(250.0);
        event2.setEvent(TypeEventEnum.COMPROU);
        event2.setCustomData(patioSavassi());
        return event2;
    }

    public static List<CustomDataWrapper> calcaRosa() {
        List<CustomDataWrapper> customData = new ArrayList<>();
        CustomDataWrapper customDataWrapper1 = new CustomDataWrapper();
        customDataWrapper1.setKey("product_price");
        customDataWrapper1.setValue("150");
        CustomDataWrapper customDataWrapper2 = new CustomDataWrapper();
        customDataWrapper2.setKey("transaction_id");
        customDataWrapper2.setValue("3029384");
        CustomDataWrapper customDataWrapper3 = new CustomDataWrapper();
        customDataWrapper3.setKey("product_name");
        customDataWrapper3.setValue("Calça Rosa");
        customData.add(customDataWrapper1);
        customData.add(customDataWrapper2);
        customData.add(customDataWrapper3);
        return customData;
    }

    public static EventWrapper eventoComprouProdutoCalcaRosa() {
        EventWrapper event3 = new EventWrapper();
        event3.setTimestamp(new Date());
        event3.setEvent(TypeEventEnum.COMPROU_PRODUTO);
        event3.setCustomData(calcaRosa());
        return event3;
    }

    public static List<CustomDataWrapper> tenisPreto() {
        List<CustomDataWrapper> customData = new ArrayList<>();
        CustomDataWrapper customDataWrapper1 = new CustomDataWrapper();
        customDataWrapper1.setKey("transaction_id");
        customDataWrapper1.setValue("3409340");
        CustomDataWrapper customDataWrapper2 = new CustomDataWrapper();
        customDataWrapper2.setKey("product_name");
        customDataWrapper2.setValue("Tênis preto");
        CustomDataWrapper customDataWrapper3 = new CustomDataWrapper();
        customDataWrapper3.setKey("product_price");
        customDataWrapper3.setValue("120");
        customData.add(customDataWrapper1);
        customData.add(customDataWrapper2);
        customData.add(customDataWrapper3);
        return customData;
    }

    public static EventWrapper eventoComprouProdutoTenisPreto() {
        EventWrapper event4 = new EventWrapper();
        event4.setTimestamp(new Date());
        event4.setEvent(TypeEventEnum.COMPROU_PRODUTO);
        event4.setCustomData(tenisPreto());
        return event4;
    }

    public static List<CustomDataWrapper> bhShopping() {
        List<CustomDataWrapper> customData = new ArrayList<>();
        CustomDataWrapper customDataWrapper1 = new CustomDataWrapper();
        customDataWrapper1.setKey("transaction_id");
        customDataWrapper1.setValue("3409340");
        CustomDataWrapper customDataWrapper2 = new CustomDataWrapper();
        customDataWrapper2.setKey("store_name");
        customDataWrapper2.setValue("BH Shopping");
        customData.add(customDataWrapper1);
        customData.add(customDataWrapper2);
        return customData;
    }

    public static EventWrapper eventoComproBHShopping() {
        EventWrapper event5 = new EventWrapper();
        event5.setTimestamp(new Date());
        event5.setRevenue(120.0);
        event5.setEvent(TypeEventEnum.COMPROU);
        event5.setCustomData(bhShopping());
        return event5;
    }


}
