package com.hr.pojo;


import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WageStandardAudit implements Serializable {

    long id;

    WageStandard wageStandard;

    Date time;

    int agree;

    String reviewed;

    Date reviewedTime;


}
