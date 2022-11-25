package com.hr.controller;

import com.hr.pojo.Department;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController("/department")
public class DepartmentController {
    @GetMapping("/getDepartment")
    public Department getDepartment(long id){//根据ID获取部门

        return new Department();
    }

    @GetMapping("/getAllLevel1Department")
    public List<Department> getAllLevel1Department(){//获取一级部门
        return new ArrayList<>();
    }

    @GetMapping("/getAllLevel2Department")
    public List<Department> getAllLevel2Department(long parentId){//获取二级部门
        return new ArrayList<>();
    }

    @GetMapping("/getAllLevel3Department")
    public List<Department> getAllLevel3Department(long parentId){//获取三级部门
        return new ArrayList<>();
    }


}
