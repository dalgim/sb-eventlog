package com.dalgim.example.sb.eventlog.logic.service.event;

import com.dalgim.example.sb.eventlog.model.event.Event;
import com.dalgim.example.sb.eventlog.model.event.EventDirection;
import com.dalgim.example.sb.eventlog.model.event.EventType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Mateusz Dalgiewicz on 27.04.17.
 */
@Service
@RequiredArgsConstructor
public class EventLogger {

    private final EventService eventService;

    public <I> void beforeLogicEvent(Class clazz, I input, EventExtraDataStrategy<I> extraDatatrategy) {
        Event event = defaultEventLog(clazz, EventDirection.IN);
        event.setExtraData(extraDatatrategy.createExtraData(input));
        eventService.save(event);
    }

    public <O> void afterLogicEvent(Class clazz, O output, EventExtraDataStrategy<O> extraDataStrategy) {
        Event event = defaultEventLog(clazz, EventDirection.OUT);
        event.setExtraData(extraDataStrategy.createExtraData(output));
        eventService.save(event);
    }

    public void beforeLogicEvent(Class clazz) {
        Event event = defaultEventLog(clazz, EventDirection.IN);
        eventService.save(event);
    }

    public void afterLogicEvent(Class clazz) {
        Event event = defaultEventLog(clazz, EventDirection.OUT);
        eventService.save(event);
    }

    public Event defaultEventLog(Class clazz, EventDirection eventDirection) {
        EventType eventType = DefaultEventTypes.getEventByClass(clazz);
        Event event = DefaultEventFactory.createEvent(eventType);
        event.setEventDirection(eventDirection);
        return event;
    }

    public void exceptionEvent() {
        System.out.println("Exception event");
    }
}
