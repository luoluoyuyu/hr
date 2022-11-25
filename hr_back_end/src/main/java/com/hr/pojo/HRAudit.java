package com.hr.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HRAudit implements Serializable {

    long id;

    HRFile hrFile;

    int agree;

    String reviewed;

    Date reviewedTime;

    int review_comments;

}
