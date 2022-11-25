package com.hr.controller;

import com.hr.pojo.HRFile;
import com.hr.pojo.UpdateHRFile;
import com.hr.result.PageResult;
import com.hr.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;


@Controller("/HR")
public class HRController {

    @GetMapping("/getHRFile")
    public HRFile getHRFile(long id){

        return new HRFile();
    }

    @GetMapping("/getHRFileBy")
    public PageResult<HRFile> getHRFileBy(int department, String name,
                                          int positionId, Date firstTime, Date endTime){
        return new PageResult<>();
    }

    @PostMapping("/updateHRFile")
    public Result updateHRFile(UpdateHRFile updateHRFile){
        return new Result<>();
    }


    @PostMapping("/addHRFile")
    public Result addHRFile(HRFile hrFile){
        return new Result();
    }

}
