package com.jdd.service;

import com.jdd.pojo.Users;
import com.jdd.pojo.bo.UserBo;

public interface UserService {

    /**
     * 判断用户名是否存在
     */
    boolean queryUsernameIsExist(String username);

    /**
     * 创建用户
     * @param userBo
     * @return
     */
    Users createUser(UserBo userBo) throws Exception;
}