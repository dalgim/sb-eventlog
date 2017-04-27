package com.dalgim.example.sb.eventlog.logic.service.event;

import com.dalgim.example.sb.eventlog.logic.usecase.DeleteUserCommand;
import com.dalgim.example.sb.eventlog.logic.usecase.EditUserParamQuery;
import com.dalgim.example.sb.eventlog.logic.usecase.OvervievActiveUserQuery;
import com.dalgim.example.sb.eventlog.model.event.EventType;
import com.google.common.collect.Maps;
import java.util.Map;

/**
 * @author Mateusz Dalgiewicz on 27.04.17.
 */
public class DefaultEventTypes {

    private static Map<Class, EventType> eventTypes = Maps.newHashMap();

    static {
        eventTypes.put(DeleteUserCommand.class, EventType.DELETE_ACCOUNT);
        eventTypes.put(OvervievActiveUserQuery.class, EventType.OVERVIEW_ACCOUNT);
        eventTypes.put(EditUserParamQuery.class, EventType.EDIT_ACCOUNT);
    }

    public static EventType getEventByClass(Class clazz) {
        EventType eventType = eventTypes.get(clazz);
        if (eventType != null) {
            return eventType;
        } else {
            return EventType.NOT_SPECIFIED;
        }
    }
}
