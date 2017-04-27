package com.dalgim.example.sb.eventlog.logic.service.event.extra;

import com.dalgim.example.sb.eventlog.dto.UserDTO;
import com.dalgim.example.sb.eventlog.logic.service.event.EventExtraDataStrategy;
import com.dalgim.example.sb.eventlog.model.event.EventExtraData;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;
import java.util.Map;

/**
 * @author Mateusz Dalgiewicz on 27.04.17.
 */
@Component
public class EditUserInputExtraData implements EventExtraDataStrategy<UserDTO> {

    @Override
    public Map<EventExtraData, String> createExtraData(UserDTO input) {
        Preconditions.checkNotNull(input, "UserDTO cannot be null.");

        Map<EventExtraData, String> extraDataStringMap = Maps.newHashMap();
        extraDataStringMap.put(EventExtraData.NAME, input.getFirstName());
        return extraDataStringMap;
    }
}
