package com.soecode.lyf.service;

import com.soecode.lyf.dao.UserrMapper;
import com.soecode.lyf.entity.Userr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiaolin on 2018/10/16.
 */
@Service
public class TsetMyBatisServiceImpl implements TsetMyBatisService {

    @Autowired
    UserrMapper userrMapper;

    @Override
    public Userr testFindUserById(int id) {
        Userr userr = null;
        try {
            userr = userrMapper.findUserById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userr;
    }

    @Override
    public List<Userr> testFindUserByName(String name) {
        List<Userr> userrList = null;

        try {
//            userrList = userrMapper.findUserByName("%" + name + "%");
            userrList = userrMapper.findUserByName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userrList;
    }

    @Override
    public void testInsertUser(Userr userr) {
        try {
            userrMapper.insertUser(userr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void testDeleteUser(int id) {
        try {
            userrMapper.deleteUser(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void testUpdateUser(Userr userr) {
        try {
            userrMapper.updateUser(userr);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
