package com.khoders.smartchurch.mapper;

import com.khoders.smartchurch.dto.BranchDto;
import com.khoders.smartchurch.entities.Branch;
import com.khoders.smartchurch.entities.Membership;
import com.khoders.smartchurch.services.MembershipService;
import com.khoders.smartchurch.utils.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BranchMapper {
    @Autowired
    private MembershipService membershipService;

    public Branch toEntity(BranchDto dto) {
        Branch branch = new Branch();
        branch.setBranchName(dto.getBranchName());
        branch.setEmail(dto.getEmail());

        Membership headPastor = membershipService.findEntityById(SpringUtils.stringToUUID(dto.getHeadPastorId()));
        if(headPastor == null)
        {
            throw new RuntimeException("Head Pastor Name does not exist!");
        }
        branch.setHeadPastorName(headPastor);

        return branch;
    }

    public BranchDto toDto(Branch branch) {
        BranchDto dto = new BranchDto();
        if(branch == null)
        {
            return null;
        }

        dto.setBranchName(branch.getBranchName());
        dto.setEmail(branch.getEmail());
        dto.setHeadPastorName(branch.getHeadPastorName().getFullname());

        return dto;
    }
}
