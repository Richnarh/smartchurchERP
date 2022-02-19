package com.khoders.smartchurch.controller;

import com.khoders.smartchurch.dto.PositionDto;
import com.khoders.smartchurch.entities.Position;
import com.khoders.smartchurch.impl.PositionServiceImpl;
import com.khoders.smartchurch.mapper.EntityMapper;
import com.khoders.smartchurch.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/position")
public class PositionController {
    @Autowired private EntityMapper entityMapper;
    @Autowired private PositionServiceImpl service;

    @PostMapping(value = "/add-position")
    public ResponseEntity<?> savePosition(@RequestBody PositionDto dto)
    {
        try
        {
            Position entity = entityMapper.toEntity(dto);
            Position position = service.save(entity);

            if(position == null)
            {
                return ApiResponse.error("Unknown Error", null);
            }
            return ApiResponse.created("Member saved successfully", entityMapper.toDto(position));
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
            List<Position> positionList = service.findAll();
            List<PositionDto> dtoList = new LinkedList<>();
            positionList.forEach(position -> {
                dtoList.add(entityMapper.toDto(position));
            });
            return ApiResponse.ok("success", dtoList);
        }catch (Exception e)
        {
            e.printStackTrace();
            return ApiResponse.error(e.getMessage(), null);
        }
    }

    @PutMapping(value = "/update-position")
    public ResponseEntity<Object> updatePosition(@RequestBody PositionDto dto)
    {
        Position entity = entityMapper.toEntity(dto);
        Position position = service.save(entity);

        if(position == null)
        {
            return ApiResponse.error("Unknown Error", null);
        }
        return ApiResponse.ok("Member updated successfully", entityMapper.toDto(position));
    }

    @DeleteMapping(value = "/delete-position/{positionId}")
    public ResponseEntity<Object> deletePosition(@PathVariable("positionId") String positionId)
    {
        Optional<Position> position = service.findEntityById(positionId);
        if(!position.isPresent()){
            return ApiResponse.notFound("Position not found", null);
        }

        Position foundPosition = position.get();

        return ApiResponse.ok("Position deleted successfully", foundPosition);
    }
}
