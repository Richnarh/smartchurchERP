package com.khoders.smartchurch.controller;

import com.khoders.smartchurch.dto.BranchDto;
import com.khoders.smartchurch.dto.PositionDto;
import com.khoders.smartchurch.entities.Branch;
import com.khoders.smartchurch.mapper.BranchMapper;
import com.khoders.smartchurch.services.BranchService;
import com.khoders.smartchurch.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("api/v1/branch")
public class BranchController {
    private final BranchMapper mapper;
    private final BranchService branchService;

    private BranchController(BranchService branchService, BranchMapper mapper){
        this.branchService=branchService;
        this.mapper=mapper;
    }
    @PostMapping(value = "/add")
    public ResponseEntity<?> saveBranch(@RequestBody BranchDto dto)
    {
        System.out.println(dto);
        try
        {
            Branch entity = mapper.toEntity(dto);
            Branch branch = branchService.save(entity);

            if(branch == null)
            {
                return ApiResponse.error("Unknown Error", null);
            }
            return ApiResponse.created("Branch created successfully", mapper.toDto(branch));
        }catch (Exception e)
        {
            return ApiResponse.error(e.getMessage(), null);
        }
    }

    @GetMapping(value = "/list")
    public ResponseEntity<Object> getPosition()
    {
        try
        {
            List<Branch> branchList = branchService.findAll();
            List<BranchDto> dtoList = new LinkedList<>();
            branchList.forEach(branch -> {
                dtoList.add(mapper.toDto(branch));
            });
            return ApiResponse.ok("success", dtoList);
        }catch (Exception e)
        {
            e.printStackTrace();
            return ApiResponse.error(e.getMessage(), null);
        }
    }

}
