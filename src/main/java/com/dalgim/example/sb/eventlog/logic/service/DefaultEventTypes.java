package com.dalgim.example.sb.eventlog.logic.service;

import com.dalgim.example.sb.eventlog.logic.impl.DeleteUserCommand;
import com.dalgim.example.sb.eventlog.logic.impl.EditUserFilteredQuery;
import com.dalgim.example.sb.eventlog.logic.impl.OvervievUserQuery;
import com.dalgim.example.sb.eventlog.model.event.EventType;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mateusz Dalgiewicz on 27.04.17.
 */
public class DefaultEventTypes {

    private static Map<Class, EventType> eventTypes = new HashMap<>();

    static {
        eventTypes.put(DeleteUserCommand.class, EventType.DELETE_ACCOUNT);
        eventTypes.put(OvervievUserQuery.class, EventType.OVERVIEW_ACCOUNT);
        eventTypes.put(EditUserFilteredQuery.class, EventType.EDIT_ACCOUNT);
    }

    public static EventType getEventByClass(Class clazz) {
        return eventTypes.get(clazz);
    }
}
