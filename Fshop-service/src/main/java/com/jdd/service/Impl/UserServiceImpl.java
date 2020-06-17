package com.jdd.service.Impl;

import com.jdd.Utils.DateUtils;
import com.jdd.Utils.ImageUtils;
import com.jdd.Utils.MD5Utils;
import com.jdd.enums.SexEnum;
import com.jdd.mapper.UsersMapper;
import com.jdd.pojo.Users;
import com.jdd.pojo.bo.UserBo;
import com.jdd.service.UserService;
import org.apache.catalina.User;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

/**
 * @Author: L_earn
 * @Date: 2020/5/24 23:09
 *
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    Sid sid;
    /**
     * 查询用户名是否已经存在
     * @param username
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryUsernameIsExist(String username) {
        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andEqualTo("username",username);
        return usersMapper.selectOneByExample(userExample) == null ? true : false;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Users createUser(UserBo userBo) throws Exception {

        String userId = sid.nextShort();

        Users user = new Users();
        user.setId(userId) ;
        user.setUsername(userBo.getUsername());
        user.setPassword(MD5Utils.getMD5Str(userBo.getPassword()));
        //设置用户默认用户名
        user.setNickname(userBo.getUsername());
        //设置用户默认头像
        user.setFace(ImageUtils.getImage("defaultFace.png"));
        //设置默认的生日
        user.setBirthday(DateUtils.stringToDate("1900-01-01"));
        //设置默认的性别
        user.setSex(SexEnum.secret.type);
        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());

        usersMapper.insert(user);

        return user;
    }

    @Override
    public Users queryUserForLogin(String username, String password) {

        return null;
    }


}
