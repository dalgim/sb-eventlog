package com.dalgim.example.sb.eventlog.logic.service.event;

import com.dalgim.example.sb.eventlog.model.event.Event;
import com.dalgim.example.sb.eventlog.model.event.EventSource;
import com.dalgim.example.sb.eventlog.model.event.EventType;

import java.time.LocalDateTime;

/**
 * @author Mateusz Dalgiewicz on 27.04.17.
 */
public class DefaultEventFactory {

    public static Event createEvent(EventType eventType) {
        Event event = new Event();
        event.setEventDateTime(LocalDateTime.now());
        event.setEventSource(EventSource.APP_LOGIC);
        event.setIntegrityCheckSum("chevksum");
        event.setEventType(eventType);
        return event;
    }
}
