package com.hr.controller;

import com.hr.pojo.UpdateHRFile;
import com.hr.pojo.WageStandard;
import com.hr.result.PageResult;
import com.hr.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller("/wageStandard")
public class WageStandardController {
    @GetMapping("/getWageStandard")
    public  Result<WageStandard> getWageStandard(long id){
        return new Result<>();
    }

    @GetMapping("getWageStandardBy")
   public PageResult<WageStandard> getWageStandardBy(String name, Date fileTime, Date endTime){
       return new PageResult<>();
   }


   @PostMapping("/updateWageStandard")
   public Result updateWageStandard(UpdateHRFile updateHRFile){
       return new Result();
   }

    @PostMapping("/addWageStandard")
   public Result addWageStandard(WageStandard wageStandard){
        return new Result();
   }
}
