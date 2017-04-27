package com.dalgim.example.sb.eventlog.logic.service.event;

import com.dalgim.example.sb.eventlog.logic.service.event.EventService;
import com.dalgim.example.sb.eventlog.model.event.Event;
import org.springframework.stereotype.Service;

/**
 * @author Mateusz Dalgiewicz on 27.04.17.
 */
@Service
public class EventServiceImpl implements EventService {

    @Override
    public void save(Event event) {
        System.out.println(event.getEventType() + ", " + event.getEventDirection() + ", EXTRA: " + event.getExtraData());
    }
}
