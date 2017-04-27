package com.dalgim.example.sb.eventlog.logic.service;

import com.dalgim.example.sb.eventlog.model.event.Event;

/**
 * @author Mateusz Dalgiewicz on 27.04.17.
 */
public interface EventService {

    void save(Event event);
}
