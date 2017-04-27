package com.dalgim.example.sb.eventlog.model.event;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import static com.dalgim.example.sb.eventlog.model.event.EventType.EXCEPTION;

/**
 * @author Mateusz Dalgiewicz on 27.04.17.
 */
@Getter
@Setter
public class Event {

    private String uuid;
    private EventType eventType;
    private EventStep eventStep;
    private Map<EventExtraData, String> extraData;
    private LocalDateTime eventDateTime;

    private Event() {
        this.uuid = UUID.randomUUID().toString();
        extraData = Maps.newHashMap();
        eventDateTime = LocalDateTime.now();
    }

    public static Event newEvent(EventType eventType) {
        Preconditions.checkNotNull(eventType, "EventType cannot be null!");

        Event event = new Event();
        event.setEventType(eventType);
        return event;
    }

    public static Event newExceptionEvent() {
        return newEvent(EXCEPTION);
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventType=" + eventType +
                ", extraData=" + extraData +
                '}';
    }
}
