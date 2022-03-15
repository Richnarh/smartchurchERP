package com.khoders.smartchurch.mapper;

import com.khoders.smartchurch.dto.MembershipDto;
import com.khoders.smartchurch.entities.Membership;
import com.khoders.smartchurch.entities.Position;
import com.khoders.smartchurch.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class MembershipMapper {
    @Autowired
    private PositionService positionService;

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
            throw new RuntimeException("Please position value cannot be null");
        }

        try {
            Position position = positionService.findEntityById(UUID.fromString(dto.getPositionId()));
            membership.setPosition(position);

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

        dto.setId(membership.getId().toString());
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
            dto.setPositionId(membership.getPosition().getId().toString());
            dto.setPositionName(membership.getPosition().getPositionName());
        }
        return dto;
    }
}
