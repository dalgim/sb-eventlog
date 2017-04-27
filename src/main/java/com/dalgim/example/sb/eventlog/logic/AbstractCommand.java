package com.dalgim.example.sb.eventlog.logic;

import com.dalgim.example.sb.eventlog.logic.service.event.EventExtraDataStrategy;
import com.dalgim.example.sb.eventlog.logic.service.event.EventLogger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Mateusz Dalgiewicz on 27.04.17.
 */
public abstract class AbstractCommand<I> {

    private EventLogger eventLogger;
    private EventExtraDataStrategy<I> extraDataStrategyInput;

    @Autowired(required = false)
    public void setExtraDataStrategyInput(EventExtraDataStrategy<I> extraDataStrategyInput) {
        this.extraDataStrategyInput = extraDataStrategyInput;
    }

    protected abstract void logic(I input);

    public void execute(I input) {
        try {
            eventLogger.beforeLogicEvent(getClass(), input, extraDataStrategyInput);
            logic(input);
            eventLogger.afterLogicEvent(getClass());
        } catch (Exception e) {
            eventLogger.exceptionEvent();
            throw e;
        }

    }

}
