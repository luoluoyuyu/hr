package com.hr.controller;

import com.hr.pojo.Position;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController("/position")
public class PositionController {

    @GetMapping("/getPosition")
    public Position getPosition(long id){
        return new Position();
    }


    @GetMapping("/getDepartmentPosition")
    public List<Position> getDepartmentPosition(long departmentId){
        return new ArrayList<>();
    }

}
