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
public class ExtraWage implements Serializable {

    long HRId;

    BigDecimal bonus;

    BigDecimal fine;

    Date time;

}
