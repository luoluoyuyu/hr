package com.hr.pojo;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SalaryPayRe implements Serializable {

    long id;

    long HRId;

    String name;

    Department department;

    BigDecimal base_pay;

    BigDecimal transportationSubsidy;

    BigDecimal lunchAllowance;

    BigDecimal communicationSubsidy;

    BigDecimal pensionSubsidy;

    BigDecimal unemploymentInsurance;

    BigDecimal medicalInsurance;

    BigDecimal housingProvidentFund;

    BigDecimal bonus;

    BigDecimal fine;

    Date time;

    int state;
}
