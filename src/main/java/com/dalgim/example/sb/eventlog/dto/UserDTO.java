package com.dalgim.example.sb.eventlog.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Mateusz Dalgiewicz on 27.04.17.
 */
@Getter
@Setter
public class UserDTO {

    private Long id;
    private String login;
    private String firstname;
}
