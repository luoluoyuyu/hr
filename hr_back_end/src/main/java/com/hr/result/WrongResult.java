package com.hr.result;

import com.hr.exception.Wrong;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("返回结果")
public class WrongResult implements Serializable {
    @ApiModelProperty("响应码都为500")
    private int code;
    @ApiModelProperty("错误描述，如果是bug的话会显示是后台错误，如果是参数信息等错误会显示其他")
    private String message;

    public WrongResult(Wrong wrong){
        this.code=500;
        this.message = wrong.getException();

    }

    public WrongResult(Exception e){
        this.code=500;
        this.message="后台出现错误";
    }
}
