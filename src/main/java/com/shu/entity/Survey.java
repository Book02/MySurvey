package com.shu.entity;

import com.shu.utils.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Survey extends Entity {

    public static final String state_create="创建";
    public static final String state_exec="执行中";
    public static final String state_over="结束";
    /**
     * 0匿名；1不匿名
     */
    private Integer anon;
    /**
     *
     */
    private String bgimg;
    /**
     * 0:不限制;1:限制
     */
    private Integer bounds;
    /**
     *
     */
    private Date createTime;
    /**
     *
     */
    private Integer creator;
    /**
     *
     */
    private Date endTime;
    /**
     *
     */
    private Integer id;
    /**
     *
     */
    private String logo;
    /**
     *
     */
    private String password;
    /**
     *
     */
    private String remark;
    /**
     * 0公开;1密码
     */
    private Integer rules;
    /**
     *
     */
    private Date startTime;
    /**
     * 创建、执行中、结束
     */
    private String state;
    /**
     *
     */
    private String title;
    /**
     *
     */
    private String url;

    //创建者信息
    private Admin admin;


//    private List<Question> questions;
}
