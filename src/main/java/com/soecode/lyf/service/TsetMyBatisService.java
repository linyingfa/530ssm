package com.soecode.lyf.service;

import com.soecode.lyf.entity.Userr;

import java.util.List;

/**
 * Created by xiaolin on 2018/10/16.
 */
public interface TsetMyBatisService {


    Userr testFindUserById(int id);

    List<Userr> testFindUserByName(String name);

    void testInsertUser(Userr userr);

    void testDeleteUser(int id);

    void testUpdateUser(Userr userr);
}
