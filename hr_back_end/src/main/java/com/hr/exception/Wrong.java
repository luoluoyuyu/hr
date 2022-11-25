package com.hr.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Wrong extends RuntimeException{

    private String exception;


    public Wrong(WrongReason wrongReason){
        exception= wrongReason.getReason();
    }
}
