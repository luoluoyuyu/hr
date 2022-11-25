package com.hr.controller;

import com.hr.pojo.SalaryPayRe;
import com.hr.result.PageResult;
import com.hr.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/wage")
public class WageController {

    @GetMapping("/getSalaryPay")
    public Result<SalaryPayRe> getSalaryPay(long id){//获取对应发放工资记录
        return new Result<>();
    }
    @GetMapping("/getSalaryPayByHR")
    public PageResult<SalaryPayRe> getSalaryPayByHR(long HRFileId,int num,int size){//获取HR对应发放工资记录
        return new PageResult<>();
    }
    @GetMapping("/getSalaryPayByDepartment")
    public PageResult<SalaryPayRe> getSalaryPayByDepartment(long department,int num,int size){//获取部门对应发放工资记录
        return new PageResult<>();
    }
    @GetMapping("/getSalaryAudit")
    public PageResult<SalaryPayRe> getSalaryAudit(long HRFileId,int num,int size){//获取HR对应未发放工资记录
        return new PageResult<>();
    }
    @GetMapping("/getSalaryAuditByDepartment")
    public PageResult<SalaryPayRe> getSalaryAuditByDepartment(long department,int num,int size){//获取部门对应未发放工资记录
        return new PageResult<>();
    }
    @PostMapping("/agreeAudit")
    public Result agreeAudit(long id){//该未发放工资的登记为已发放
       return new Result();
    }
    @PostMapping("/agreeAudits")
    public Result agreeAudits(List<Long> idList ){//将List中的Id的未发放记录改为以发放
        return new Result();
    }
}
