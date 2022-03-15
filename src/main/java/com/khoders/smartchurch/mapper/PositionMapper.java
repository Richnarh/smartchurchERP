package com.khoders.smartchurch.mapper;

import com.khoders.smartchurch.dto.PositionDto;
import com.khoders.smartchurch.entities.Position;
import org.springframework.stereotype.Component;

@Component
public class PositionMapper {
    public PositionDto toDto(Position position)
    {
        PositionDto dto = new PositionDto();
        if (position == null){
            return null;
        }
        dto.setId(position.getId().toString());
        dto.setPositionName(position.getPositionName());
        return dto;
    }

    public Position toEntity(PositionDto dto){
        Position position = new Position();
        position.setPositionName(dto.getPositionName());

        return position;
    }
}
