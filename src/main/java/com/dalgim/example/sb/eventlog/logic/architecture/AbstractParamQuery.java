package com.dalgim.example.sb.eventlog.logic.architecture;

import com.dalgim.example.sb.eventlog.logic.service.event.EventExtraDataStrategy;
import com.dalgim.example.sb.eventlog.logic.service.event.EventLogger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Mateusz Dalgiewicz on 27.04.17.
 */
public abstract class AbstractParamQuery<O, I> {

    private EventLogger eventLogger;
    private EventExtraDataStrategy<I> extraDataStrategyInput;
    private EventExtraDataStrategy<O> extraDataStrategyOutput;

    protected abstract O logic(I input);

    public O execute(I input) {
        try {
            eventLogger.beforeLogicEvent(getClass(), input, extraDataStrategyInput);
            O output = logic(input);
            eventLogger.afterLogicEvent(getClass(), output, extraDataStrategyOutput);
            return output;
        } catch (Exception e) {
            eventLogger.exceptionEvent();
            throw e;
        }

    }

    @Autowired
    public void setEventLogger(EventLogger eventLogger) {
        this.eventLogger = eventLogger;
    }

    @Autowired(required = false)
    public void setExtraDataStrategyInput(EventExtraDataStrategy<I> extraDataStrategyInput) {
        this.extraDataStrategyInput = extraDataStrategyInput;
    }

    @Autowired(required = false)
    public void setExtraDataStrategyOutput(EventExtraDataStrategy<O> extraDataStrategyOutput) {
        this.extraDataStrategyOutput = extraDataStrategyOutput;
    }
}
