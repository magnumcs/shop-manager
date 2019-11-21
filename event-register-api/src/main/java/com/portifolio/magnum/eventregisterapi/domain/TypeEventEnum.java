package com.portifolio.magnum.eventregisterapi.domain;

public enum TypeEventEnum {

    COMPROU(0, "Comprou"),
    COMPROU_PRODUTO(1, "Comprou produto");

    private Integer id;
    private String value;

    TypeEventEnum(Integer id, String value) {
        this.id = id;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
