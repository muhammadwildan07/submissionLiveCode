package com.enigma.wms_api.entity;

public enum TransactionType {
    EAT_IN(1),
    ONLINE(2),
    TAKE_AWAY(3);


    private final int value;

    TransactionType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;

    }
}
