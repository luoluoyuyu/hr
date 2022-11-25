package com.hr.pojo;


import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HRFile implements Serializable {

    private long id;

    private String name;

    private String sex;

    private Department department;

    private String nation;

    private String email;

    private String telephone;

    private Date birthday;

    private String faith;

    private Date time;

    private String bank;

    private String bankAccount;

    private String registrant;

    private String resume;

    private String remarks;

    private String education;

    private long wageStandardId;

    private Position position;

    private int stale;
}
