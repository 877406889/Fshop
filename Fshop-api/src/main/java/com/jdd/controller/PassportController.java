package com.jdd.controller;

import com.jdd.Utils.JDDJSONResult;
import com.jdd.pojo.bo.UserBo;
import com.jdd.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: L_earn
 * @Date: 2020/5/24 23:21
 */
@RestController
@RequestMapping("/passport")
public class PassportController {

    @Autowired
    private UserService userService;

    @GetMapping("/usernameIsExist")
    public JDDJSONResult usernameIsExist(@RequestParam String username){
        //用户名不能为空
        if (StringUtils.isBlank(username)){
            return JDDJSONResult.errorMap("用户名不能为空");
        }
        //用户名不存在
        if (userService.queryUsernameIsExist(username)){
            return JDDJSONResult.ok();
        }else {
            //用户名已经存在
            return JDDJSONResult.errorMap("用户名已经存在");
        }
    }

    @PostMapping("/regist")
    public JDDJSONResult regist(@RequestBody UserBo userBo){
        String username = userBo.getUsername();
        String password = userBo.getPassword();
        String confirmPwd = userBo.getConfirmPassword();
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password) || StringUtils.isBlank(confirmPwd)){
            return JDDJSONResult.errorMsg("参数不能为空");
        }
        boolean isExit = userService.queryUsernameIsExist(username);
        if (!isExit){
            return JDDJSONResult.errorMsg("用户名已存在");
        }
        if (password.length() < 6){
            return JDDJSONResult.errorMsg("密码长度必须大于6位");
        }
        if (!password.equals(confirmPwd)){
            return  JDDJSONResult.errorMsg("两次密码不一致");
        }
        return JDDJSONResult.ok();
    }
}