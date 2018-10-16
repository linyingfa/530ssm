package com.soecode.lyf.controller;


import com.soecode.lyf.entity.Userr;
import com.soecode.lyf.service.TsetMyBatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by xiaolin on 2018/10/16.
 * https://blog.csdn.net/vikisss/article/details/73335400
 */
@Controller
@RequestMapping("/test/")
public class TsetMyBatisController {


    @Autowired
    private TsetMyBatisService tsetMyBatisService;

    /**
     * /test/findUserById/lyf.do
     * // 测试根据id查询用户(得到单条记录)
     */
    @RequestMapping(value = "findUserById/lyf.do", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public Userr testFindUserById(int id) {
        Userr rs = new Userr();
        try {
            rs = tsetMyBatisService.testFindUserById(id);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return rs;
    }

    /**
     * /test/testFindUserByName/lyf.do
     * // 测试根据名称模糊查询用户(可能得到多条记录)
     * //注意参数，http请求对应的参数， key-values对应，否则传不过来
     */
    @RequestMapping(value = "findUserByName/lyf.do", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public List<Userr> testFindUserByName(String username) {
        List<Userr> list = null;
        try {
            list = tsetMyBatisService.testFindUserByName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


    // 测试插入用户
    @RequestMapping(value = "insertUser/lyf.do", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public void testInsertUser(String username, String sex, String birthday, String address) {
        // 用户姓名
        // 性别
        // 生日
        // 地址
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(birthday.trim());
            Userr userr = new Userr();
            userr.setAddress(address);
            userr.setUsername(username);
            userr.setSex(sex);
            userr.setBirthday(date);
            tsetMyBatisService.testInsertUser(userr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    // 测试删除用户
    @RequestMapping(value = "deleteUser/lyf.do", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public void testDeleteUser(int id) {
        tsetMyBatisService.testDeleteUser(id);
    }


    // 测试根据id更新用户(得到单条记录)
    @RequestMapping(value = "updateUser/lyf.do", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public void testUpdateUser(int id, String username, String sex, String birthday, String address) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(birthday.trim());
            Userr userr = new Userr();
            userr.setAddress(address);
            userr.setUsername(username);
            userr.setId(id);
            userr.setSex(sex);
            userr.setBirthday(date);
            tsetMyBatisService.testUpdateUser(userr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
