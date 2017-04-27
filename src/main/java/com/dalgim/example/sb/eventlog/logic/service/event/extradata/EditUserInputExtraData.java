package com.dalgim.example.sb.eventlog.logic.service.event.extradata;

import com.dalgim.example.sb.eventlog.dto.UserDTO;
import com.dalgim.example.sb.eventlog.logic.service.event.EventExtraDataStrategy;
import com.dalgim.example.sb.eventlog.model.event.EventExtraData;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mateusz Dalgiewicz on 27.04.17.
 */
@Component
public class EditUserInputExtraData implements EventExtraDataStrategy<UserDTO> {

    @Override
    public Map<EventExtraData, String> createExtraData(UserDTO input) {
        Map<EventExtraData, String> extraDataStringMap = new HashMap<>();
        extraDataStringMap.put(EventExtraData.NAME, input.getFirstname());
        return extraDataStringMap;
    }
}
