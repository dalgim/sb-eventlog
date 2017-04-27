package com.dalgim.example.sb.eventlog.model.event;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

/**
 * @author Mateusz Dalgiewicz on 27.04.17.
 */
@Getter
@Setter
@ToString
public class Event {

    private String uuid;
    private EventType eventType;
    private EventSource eventSource;
    private EventDirection eventDirection;
    private Map<EventExtraData, String> extraData;
    private String integrityCheckSum;
    private LocalDateTime eventDateTime;

    public Event() {
        this.uuid = UUID.randomUUID().toString();
    }
}
