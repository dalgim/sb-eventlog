package com.dalgim.example.sb.eventlog.logic;

/**
 * @author Mateusz Dalgiewicz on 27.04.17.
 */
public interface Query<O> {

    O execute();
}
