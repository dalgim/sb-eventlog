package com.dalgim.example.sb.eventlog.logic.service.event;

import com.dalgim.example.sb.eventlog.model.event.EventExtraData;

import java.util.Map;

/**
 * @author Mateusz Dalgiewicz on 27.04.17.
 */
public interface EventExtraDataStrategy<I> {

    Map<EventExtraData, String> createExtraData(I input);
}
