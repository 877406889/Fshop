package com.jdd.enums;

/**
 * @Author: L_earn
 * @Description：todo
 * @ckassName：SexEnum
 * @Date: 2020/6/14 16:03
 */
public enum SexEnum {
    woman(0,"女"),
    man(1,"男"),
    secret(2,"保密");

    public final Integer type;
    public final String value;

    SexEnum(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
