package com.hr.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUser implements Serializable {
    private long userId;

    private String userName;

    private Date loginTime;

    private Date endTime;

    private String token;



}