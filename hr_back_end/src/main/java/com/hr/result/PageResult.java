package com.hr.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("分页的返回结果")
public class PageResult <T>implements Serializable {
    @ApiModelProperty("响应码都为200")
    private int code;

    @ApiModelProperty("信息描述，一般没有")
    private String message;

    @ApiModelProperty("总数据条数")
    int totalCount;// 总数据条数

    @ApiModelProperty("总页码数")
    int pageCount;// 总页码数

    @ApiModelProperty("当前页码数")
    int pageNum ;// 当前页码数

    @ApiModelProperty("每页的数据条数")
    int pageSize ;// 每页的数据条数

    @ApiModelProperty("响应的信息用Java的List<?>")
    private List<T> data;

    public PageResult(org.springframework.data.domain.Page<T> page,int size,int num){
        this.code=200;
        this.totalCount= (int) page.getTotalElements();
        this.pageCount=page.getTotalPages();
        this.pageNum=num;
        this.pageSize=size;
        data=page.getContent();
    }
}
