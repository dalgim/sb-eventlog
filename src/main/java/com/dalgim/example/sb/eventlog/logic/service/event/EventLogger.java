package com.dalgim.example.sb.eventlog.logic.service.event;

import com.dalgim.example.sb.eventlog.model.event.Event;
import com.dalgim.example.sb.eventlog.model.event.EventStep;
import com.dalgim.example.sb.eventlog.model.event.EventType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.dalgim.example.sb.eventlog.model.event.EventStep.INCOMING;
import static com.dalgim.example.sb.eventlog.model.event.EventStep.OUTGOING;
import static com.dalgim.example.sb.eventlog.model.event.EventStep.PROGRESS;

/**
 * @author Mateusz Dalgiewicz on 27.04.17.
 */
@Service
@RequiredArgsConstructor
public class EventLogger {

    private final EventService eventService;

    public <I> void beforeLogicEvent(Class clazz, I input, EventExtraDataStrategy<I> extraDatatrategy) {
        Event event = defaultEventLog(clazz, INCOMING);
        event.setExtraData(extraDatatrategy.createExtraData(input));
        eventService.save(event);
    }

    public <O> void afterLogicEvent(Class clazz, O output, EventExtraDataStrategy<O> extraDataStrategy) {
        Event event = defaultEventLog(clazz, OUTGOING);
        event.setExtraData(extraDataStrategy.createExtraData(output));
        eventService.save(event);
    }

    public void beforeLogicEvent(Class clazz) {
        Event event = defaultEventLog(clazz, INCOMING);
        eventService.save(event);
    }

    public void afterLogicEvent(Class clazz) {
        Event event = defaultEventLog(clazz, OUTGOING);
        eventService.save(event);
    }

    public void exceptionEvent() {
        Event exceptionEvent = Event.newExceptionEvent();
        exceptionEvent.setEventStep(PROGRESS);
        eventService.save(exceptionEvent);
    }

    public Event defaultEventLog(Class clazz, EventStep eventStep) {
        EventType eventType = DefaultEventTypes.getEventByClass(clazz);
        Event event = Event.newEvent(eventType);
        event.setEventStep(eventStep);
        return event;
    }
}
