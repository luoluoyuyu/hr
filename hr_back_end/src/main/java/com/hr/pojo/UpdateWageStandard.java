package com.hr.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateWageStandard implements Serializable {
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
}
