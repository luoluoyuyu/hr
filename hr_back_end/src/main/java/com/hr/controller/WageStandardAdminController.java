package com.hr.controller;

import com.hr.pojo.WageStandardAudit;
import com.hr.result.PageResult;
import com.hr.result.Result;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/wageStandard")
public class WageStandardAdminController {

    @PostMapping("/deleteWageStandard")
    public Result deleteWageStandard(long id){
        return new Result();
    }
    @PostMapping("/wageStandardAudit")
    public Result wageStandardAudit(long id){
        return new Result();
    }
    @GetMapping("/getAllNeedAuditStandard")
    public PageResult<WageStandardAudit> getAllNeedAuditStandard(int size,int num){
        return new PageResult();
    }
    @PostMapping("/updateDepartmentPositionWageStand")
    public Result updateDepartmentPositionWageStand(long departmentId,long positionId,long wageStandId){
        return new Result();
    }

}
