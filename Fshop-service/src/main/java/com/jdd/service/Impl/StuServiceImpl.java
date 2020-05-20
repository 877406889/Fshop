package com.jdd.service.Impl;

import com.jdd.mapper.StuMapper;
import com.jdd.pojo.Stu;
import com.jdd.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StuServiceImpl implements StuService {

    @Autowired
    private StuMapper stuMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Stu getStuInfo(Integer id) {
        return stuMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveStu() {
        Stu stu = new Stu();
        stu.setAge(20);
        stu.setId(1);
        stu.setName("L_earn");
        stuMapper.insert(stu);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateStu(int id) {
        Stu stu = new Stu();
        stu.setId(id);
        stu.setAge(19);
        stu.setName("lucy");
        stuMapper.updateByPrimaryKey(stu);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteStu(int id) {

    }
}
