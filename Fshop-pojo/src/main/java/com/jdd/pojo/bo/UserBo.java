package com.jdd.pojo.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: L_earn
 * @Description：todo
 * @ckassName：UserBo
 * @Date: 2020/6/14 13:34
 */

@ApiModel(value = "用户对象BO" , description = "从客户端，由用户传入的封装数据在此entity中")
public class UserBo {
    @ApiModelProperty(value = "用户名",name = "username",example = "jdd",required = true)
    private String username;
    @ApiModelProperty(value = "用户密码",name = "password",example = "123456",required = true )
    private String password;
    @ApiModelProperty(value = "校验密码",name = "confirmPassword",example = "123456",required = true)
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
