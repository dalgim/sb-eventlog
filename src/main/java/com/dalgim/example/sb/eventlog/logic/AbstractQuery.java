package com.dalgim.example.sb.eventlog.logic;

import com.dalgim.example.sb.eventlog.logic.service.event.EventExtraDataStrategy;
import com.dalgim.example.sb.eventlog.logic.service.event.EventLogger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Mateusz Dalgiewicz on 27.04.17.
 */
public abstract class AbstractQuery<O> {

    private EventLogger eventLogger;
    private EventExtraDataStrategy<O> extraDataStrategyOutput;

    @Autowired(required = false)
    public void setExtraDataStrategyOutput(EventExtraDataStrategy<O> extraDataStrategyOutput) {
        this.extraDataStrategyOutput = extraDataStrategyOutput;
    }

    @Autowired
    public void setEventLogger(EventLogger eventLogger) {
        this.eventLogger = eventLogger;
    }

    protected abstract O logic();

    public O execute() {
        try {
            eventLogger.beforeLogicEvent(getClass());
            O output = logic();
            eventLogger.afterLogicEvent(getClass(), output, extraDataStrategyOutput);
            return output;
        } catch (Exception e) {
            eventLogger.exceptionEvent();
            throw e;
        }
    }
}
