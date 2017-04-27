package com.dalgim.example.sb.eventlog.logic.exception;

/**
 * @author Mateusz Dalgiewicz on 27.04.17.
 */
public class EntityNotFoundRuntimeException extends RuntimeException {

    public EntityNotFoundRuntimeException() {
        super();
    }

    public EntityNotFoundRuntimeException(String s) {
        super(s);
    }
}
