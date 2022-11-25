package com.hr.controller;

import com.hr.result.Result;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    public Result login(String user,String password){
        return new Result();
    }

    public Result logout(){
        return new Result();
    }
}
