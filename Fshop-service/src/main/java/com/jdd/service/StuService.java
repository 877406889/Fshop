package com.jdd.service;

import com.jdd.pojo.Stu;

public interface StuService {

    Stu getStuInfo(Integer id);

    void saveStu();

    void updateStu(int id);

    void deleteStu(int id);
}
