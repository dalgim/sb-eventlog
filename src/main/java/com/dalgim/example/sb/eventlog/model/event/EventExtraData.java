package com.dalgim.example.sb.eventlog.model.event;

/**
 * @author Mateusz Dalgiewicz on 27.04.17.
 */
public enum EventExtraData {

    UUID("uuid"),
    NAME("name");

    private String key;

    EventExtraData(String key) {
        this.key = key;
    }

    public String key() {
        return this.key;
    }

}
