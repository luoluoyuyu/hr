package com.hr.controller;

import com.hr.pojo.HRAudit;
import com.hr.result.PageResult;
import com.hr.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("hrController")
public class HRAdminController {
    @PostMapping("/deleteHRFile")
    public Result deleteHRFile(long id){
        return new Result();
    }

    @PostMapping("/HRFileAudit")
    public Result HRFileAudit(long id){
        return new Result();
    }

    @GetMapping("/getAllNeedAuditFile")
    public PageResult<HRAudit> getAllNeedAuditFile(int size,int num){
        return new PageResult<>();
    }

    @GetMapping("/getNeedAuditFileByDepartment")

    public PageResult<HRAudit> getNeedAuditFileByDepartment(int size,int num){
        return new PageResult<>();
    }


    @GetMapping("/getNeedAuditFile")
    public Result<HRAudit> getNeedAuditFile(long id){
        return new Result<>();
    }

}
