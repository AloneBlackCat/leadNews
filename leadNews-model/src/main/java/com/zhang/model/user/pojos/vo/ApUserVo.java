package com.zhang.model.user.pojos.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter @Getter
public class ApUserVo {
    /*用户id*/
    private Integer id;
    /*用户名称*/
    private String name;
    /*用户手机号*/
    private String phone;
    /*用户头像*/
    private String image;
    /*性别*/
    private Boolean sex;
    /*资质*/
    private Boolean certification;
    /*身份认证*/
    private Boolean identityAuthentication;
    /*状态*/
    private Boolean status;
    /*标识*/
    private Short flag;
    /*注册时间*/
    private Date createdTime;
}
