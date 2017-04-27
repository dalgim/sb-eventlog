package com.dalgim.example.sb.eventlog.logic;

import com.dalgim.example.sb.eventlog.logic.service.DefaultEventFactory;
import com.dalgim.example.sb.eventlog.logic.service.DefaultEventTypes;
import com.dalgim.example.sb.eventlog.logic.service.EventService;
import com.dalgim.example.sb.eventlog.model.event.Event;
import com.dalgim.example.sb.eventlog.model.event.EventDirection;
import com.dalgim.example.sb.eventlog.model.event.EventType;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Mateusz Dalgiewicz on 27.04.17.
 */
public abstract class AbstractFilteredQuery<O, I> {

    private EventService eventService;

    @Autowired
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    protected abstract O logic(I input);

    public O execute(I input) {
        try {
            beforeLogicEvent();
            O output = logic(input);
            afterLogicEvent();
            return output;
        } catch (Exception e) {
            exceptionEvent();
            throw e;
        }

    }

    private void beforeLogicEvent() {
        if (true) {
            defaultEventLog(EventDirection.IN);
        } else {
            System.out.println("Impl before vent");
        }
    }

    private void defaultEventLog(EventDirection eventDirection) {
        EventType eventType = DefaultEventTypes.getEventByClass(getClass());
        Event event = DefaultEventFactory.createEvent(eventType);
        event.setEventDirection(eventDirection);
        eventService.save(event);
    }

    private void afterLogicEvent() {
        if (true) {
            defaultEventLog(EventDirection.OUT);
        } else {
            System.out.println("Impl after event");
        }
    }

    private void exceptionEvent() {
        System.out.println("Exception event");
    }
}
