package com.dalgim.example.sb.eventlog.logic.service.event.extra;

import com.dalgim.example.sb.eventlog.dto.DeleteUserDTO;
import com.dalgim.example.sb.eventlog.logic.service.event.EventExtraDataStrategy;
import com.dalgim.example.sb.eventlog.model.event.EventExtraData;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;
import java.util.Map;

/**
 * Created by Mateusz Dalgiewicz on 27.04.2017.
 */
@Component
public class DeleteUserExtraData implements EventExtraDataStrategy<DeleteUserDTO> {

    @Override
    public Map<EventExtraData, String> createExtraData(DeleteUserDTO input) {
        Preconditions.checkNotNull(input, "DeleteUserDTO cannot be null!");

        Map<EventExtraData, String> extraDataStringMap = Maps.newHashMap();
        extraDataStringMap.put(EventExtraData.USER_ID, String.valueOf(input.getId()));
        return extraDataStringMap;
    }
}
