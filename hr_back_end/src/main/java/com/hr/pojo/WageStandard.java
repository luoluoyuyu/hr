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
public class WageStandard implements Serializable {

    long id;

    BigDecimal base_pay;

    BigDecimal transportationSubsidy;

    BigDecimal lunchAllowance;

    BigDecimal communicationSubsidy;

    BigDecimal pensionSubsidy;

    BigDecimal unemploymentInsurance;

    BigDecimal medicalInsurance;

    BigDecimal housingProvidentFund;

    String name;

    Date time;

    BigDecimal total;

}
