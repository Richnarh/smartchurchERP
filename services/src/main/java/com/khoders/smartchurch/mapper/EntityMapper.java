package com.khoders.smartchurch.mapper;

import com.khoders.smartchurch.dto.MembershipDto;
import com.khoders.smartchurch.dto.PositionDto;
import com.khoders.smartchurch.entities.Membership;
import com.khoders.smartchurch.entities.Position;
import com.khoders.smartchurch.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EntityMapper {

    @Autowired private PositionService positionService;

    public Membership toEntity(MembershipDto dto){

        Membership membership = new Membership();

        membership.setFirstname(dto.getFirstname());
        membership.setSurname(dto.getSurname());
        membership.setLastname(dto.getLastname());
        membership.setAddressLocation(dto.getAddressLocation());
        membership.setBirthDate(dto.getBirthDate());
        membership.setDescription(dto.getDescription());
        membership.setEmergencyNumber(dto.getEmergencyNumber());
        membership.setPhoneNumber(dto.getPhoneNumber());
        membership.setOccupation(dto.getOccupation());
        membership.setTitle(dto.getTitle());

        if(dto.getPositionId() == null)
        {
            new Throwable("Please position value cannot be null");
        }

        try {
            Optional<Position> position = positionService.findEntityById(dto.getPositionId());
            position.ifPresent(membership::setPosition);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return membership;
    }

    public MembershipDto toDto(Membership membership) {
        MembershipDto dto = new MembershipDto();

        if(membership == null)
        {
            return null;
        }

        dto.setId(membership.getId());
        dto.setAddressLocation(membership.getAddressLocation());
        dto.setBirthDate(membership.getBirthDate());
        dto.setDescription(membership.getDescription());
        dto.setFirstname(membership.getFirstname());
        dto.setLastname(membership.getLastname());
        dto.setSurname(membership.getSurname());
        dto.setPhoneNumber(membership.getPhoneNumber());
        dto.setEmergencyNumber(membership.getEmergencyNumber());
        dto.setOccupation(membership.getOccupation());
        dto.setTitle(membership.getTitle());

        if(membership.getPosition() != null)
        {
            dto.setPositionId(membership.getPosition().getId());
            dto.setPositionName(membership.getPosition().getPositionName());
        }
        return dto;
    }

    public PositionDto toDto(Position position)
    {
        PositionDto dto = new PositionDto();
        if (position == null){
            return null;
        }
        dto.setId(position.getId());
        dto.setPositionName(position.getPositionName());
        return dto;
    }

    public Position toEntity(PositionDto dto){
        Position position = new Position();
        position.setPositionName(dto.getPositionName());

        return position;
    }
}
