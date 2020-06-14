package com.jdd.Utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Author: L_earn
 * @Description：自定义响应格式主要包括Status、msg、data三个部分
 * @ckassName：JDDJSONResult
 * @Date: 2020/6/14 11:23
 */
public class JDDJSONResult {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    @JsonIgnore
    private String ok;	// 不使用

    public static JDDJSONResult build(Integer status, String msg, Object data) {
        return new JDDJSONResult(status, msg, data);
    }

    public static JDDJSONResult build(Integer status, String msg, Object data, String ok) {
        return new JDDJSONResult(status, msg, data, ok);
    }

    public static JDDJSONResult ok(Object data) {
        return new JDDJSONResult(data);
    }

    public static JDDJSONResult ok() {
        return new JDDJSONResult(null);
    }

    public static JDDJSONResult errorMsg(String msg) {
        return new JDDJSONResult(500, msg, null);
    }

    public static JDDJSONResult errorMap(Object data) {
        return new JDDJSONResult(501, "error", data);
    }

    public static JDDJSONResult errorTokenMsg(String msg) {
        return new JDDJSONResult(502, msg, null);
    }

    public static JDDJSONResult errorException(String msg) {
        return new JDDJSONResult(555, msg, null);
    }

    public static JDDJSONResult errorUserQQ(String msg) {
        return new JDDJSONResult(556, msg, null);
    }

    public JDDJSONResult() {

    }

    public JDDJSONResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public JDDJSONResult(Integer status, String msg, Object data, String ok) {
        this.status = status;
        this.msg = msg;
        this.data = data;
        this.ok = ok;
    }

    public JDDJSONResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public Boolean isOK() {
        return this.status == 200;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

}
