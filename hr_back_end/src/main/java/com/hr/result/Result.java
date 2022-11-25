package com.hr.result;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
@ApiModel("返回结果")
public class Result <T>implements Serializable {

    @ApiModelProperty("响应码都为200")
    private int code;
    @ApiModelProperty("响应描述")
    private String message;

    @ApiModelProperty("响应内容")
    private T data;

    public Result(){
        this.code=200;
        message="操作成功";
    }

    public Result(String message){
        this.code=200;
        this.message=message;
    }

    public Result(T data){
        this.code=200;
        this.data=data;
    }

    public Result(String message,T data){
        this.code=200;
        this.message=message;
        this.data=data;
    }
}
