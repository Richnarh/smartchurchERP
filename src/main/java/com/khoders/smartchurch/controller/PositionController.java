package com.khoders.smartchurch.controller;

import com.khoders.smartchurch.dto.PositionDto;
import com.khoders.smartchurch.entities.Position;
import com.khoders.smartchurch.mapper.PositionMapper;
import com.khoders.smartchurch.services.PositionService;
import com.khoders.smartchurch.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("api/v1/position")
public class PositionController {
    private final PositionMapper mapper;
    private final PositionService positionService;

    private PositionController(PositionService positionService, PositionMapper mapper){
        this.positionService=positionService;
        this.mapper=mapper;
    }
    @PostMapping(value = "/add")
    public ResponseEntity<?> savePosition(@RequestBody PositionDto dto)
    {
        System.out.println(dto);
        try
        {
            Position entity = mapper.toEntity(dto);
            Position position = positionService.save(entity);

            if(position == null)
            {
                return ApiResponse.error("Unknown Error", null);
            }
            return ApiResponse.created("Member saved successfully", mapper.toDto(position));
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
            List<Position> positionList = positionService.findAll();
            List<PositionDto> dtoList = new LinkedList<>();
            positionList.forEach(position -> {
                dtoList.add(mapper.toDto(position));
            });
            return ApiResponse.ok("success", dtoList);
        }catch (Exception e)
        {
            e.printStackTrace();
            return ApiResponse.error(e.getMessage(), null);
        }
    }

}
