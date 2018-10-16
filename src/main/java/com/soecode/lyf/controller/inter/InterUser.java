package com.soecode.lyf.controller.inter;

import com.soecode.lyf.entity.User;
import com.soecode.lyf.service.inter.imethod.InterUserService;
import com.soecode.lyf.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiaolin on 2018/10/15.
 */
@RestController
@RequestMapping("/user/")
public class InterUser {

    @Autowired
    private InterUserService service;

    /**
     * 用户注册
     * /user/common/registAccount.do
     */
    @RequestMapping(value = "common/registAccount.do", method = {RequestMethod.POST, RequestMethod.GET})
    public Result registAccount(User user, String verifyCode) {
        Result rs = new Result();
        try {
            service.registAccount(user, verifyCode, rs);
        } catch (Exception e) {
            e.printStackTrace();
            rs.setMsg("服务器异常");
        }
        return rs;
    }
}
