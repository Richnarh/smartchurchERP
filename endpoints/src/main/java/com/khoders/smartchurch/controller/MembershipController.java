package com.khoders.smartchurch.controller;

import com.khoders.smartchurch.dto.MembershipDto;
import com.khoders.smartchurch.entities.Membership;
import com.khoders.smartchurch.impl.MembershipServiceImpl;
import com.khoders.smartchurch.mapper.EntityMapper;
import com.khoders.smartchurch.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/repository")
public class MembershipController {
    @Autowired private MembershipServiceImpl service;
    @Autowired private EntityMapper entityMapper;

    @PostMapping(value = "/add-member")
    public ResponseEntity<?> saveMember(@RequestHeader("churchId") String churchId, @RequestBody MembershipDto dto)
    {
        Membership membershipEntity = entityMapper.toEntity(dto);
        Membership membership = service.save(membershipEntity);

        if(membership == null)
        {
            return ApiResponse.error("Unknown Error", null);
        }
        return ApiResponse.created("Member saved successfully", entityMapper.toDto(membership));
    }

    @GetMapping(value = "/list")
    public ResponseEntity<Object> getMembership(@RequestHeader("churchId") String churchId){
       try
       {
           List<Membership> membershipList = service.findAll();
           List<MembershipDto> dtoList = new LinkedList<>();

           membershipList.forEach(member ->{
               dtoList.add(entityMapper.toDto(member));
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
        Membership entity = entityMapper.toEntity(dto);
        Membership membership = service.save(entity);

        dto.setId(membership.getId());
        dto.setSurname(membership.getSurname());

        return ApiResponse.ok("Member updated successfully", dto);
    }

    @DeleteMapping(value = "/delete-member/{memberId}")
    public ResponseEntity<Object> deleteMember(@RequestHeader("churchId") String churchId, @PathVariable("memberId") String memberId)
    {
        service.delete(memberId);
        MembershipDto dto = new MembershipDto();
        dto.setId(memberId);

        return ApiResponse.ok("Member deleted successfully", dto);
    }
}
