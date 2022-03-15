package com.khoders.smartchurch.controller;

import com.khoders.smartchurch.dto.MembershipDto;
import com.khoders.smartchurch.entities.Membership;
import com.khoders.smartchurch.mapper.MembershipMapper;
import com.khoders.smartchurch.services.MembershipService;
import com.khoders.smartchurch.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/membership")
public class MembershipController {
    private final MembershipMapper mapper;
    private final MembershipService membershipService;

    private MembershipController(MembershipService membershipService, MembershipMapper mapper){
        this.membershipService = membershipService;
        this.mapper = mapper;
    }

    @PostMapping(value = "/add-member")
    public ResponseEntity<?> saveMember(@RequestHeader("churchId") String churchId, @RequestBody MembershipDto dto)
    {
        Membership membershipEntity = mapper.toEntity(dto);
        Membership membership = membershipService.save(membershipEntity);

        if(membership == null)
        {
            return ApiResponse.error("Unknown Error", null);
        }
        return ApiResponse.created("Member saved successfully", mapper.toDto(membership));
    }

    @GetMapping(value = "/list")
    public ResponseEntity<Object> getMembership(@RequestHeader("churchId") String churchId){
        try
        {
            List<Membership> membershipList = membershipService.findAll();
            List<MembershipDto> dtoList = new LinkedList<>();

            membershipList.forEach(member ->{
                dtoList.add(mapper.toDto(member));
            });

            return ApiResponse.ok("success data", dtoList);
        }catch (Exception e)
        {
            e.printStackTrace();
            return ApiResponse.error(e.getMessage(), null);
        }
    }

    @PutMapping(value = "/update-member")
    public ResponseEntity<Object> updateMember(@RequestHeader("churchId") String churchId, @RequestBody MembershipDto dto)
    {
        Membership entity = mapper.toEntity(dto);
        Membership membership = membershipService.save(entity);

        dto.setId(membership.getId().toString());
        dto.setSurname(membership.getSurname());

        return ApiResponse.ok("Member updated successfully", dto);
    }

    @DeleteMapping(value = "/delete-member/{memberId}")
    public ResponseEntity<Object> deleteMember(@RequestHeader("churchId") String churchId, @PathVariable("memberId") String memberId)
    {
        membershipService.delete(UUID.fromString(memberId));
        MembershipDto dto = new MembershipDto();
        dto.setId(memberId);

        return ApiResponse.ok("Member deleted successfully", dto);
    }
}
