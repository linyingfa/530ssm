package com.soecode.lyf.service.inter.impl;

import com.soecode.lyf.dao.ConstructTeamMapper;
import com.soecode.lyf.dao.UserMapper;
import com.soecode.lyf.entity.ConstructTeam;
import com.soecode.lyf.entity.User;
import com.soecode.lyf.service.inter.imethod.InterUserService;
import com.soecode.lyf.utils.Constant;
import com.soecode.lyf.utils.DataUtils;
import com.soecode.lyf.utils.Result;
import com.soecode.lyf.utils.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by xiaolin on 2018/10/15.
 */
@Service
public class InterUserServiceImpl implements InterUserService {

    @Autowired
    private UserMapper userMapper;//用户

    @Autowired
    private ConstructTeamMapper constructTeamMapper;//施工队

    /**
     * 用户注册
     */
    @Override
    public void registAccount(User user, String verifyCode, Result rs) {
        /*if (!ValidateUtils.isMobilePhone(user.getUserName())) {
            rs.setMsg("请输入正确的手机号");
            return;
        }*/
        if (ValidateUtils.isBlank(user.getUserName(), user.getPassword(), verifyCode)) {
            rs.setMsg("参数有误");
            return;
        }
        User curruser = new User();
        curruser.setUserName(user.getUserName());
        //List<User> list = userMapper.findAll(curruser);
        //if (!ValidateUtils.isEmptyForCollection(list)) {
        //rs.setMsg("账号已存在");
        //return;
        // }
        //验证码
        /*String code = (String) RedisUtils.get(user.getUserName());
        if (ValidateUtils.isBlank(code)) {
            rs.setMsg("验证码已过期");
            return;
        }
        if (!verifyCode.equals(code.trim())) {
            rs.setMsg("验证码错误");
            return;
        }*/
        if (user.getPassword().length() < 6 || user.getPassword().length() > 16) {
            rs.setMsg("请输入6至16位的密码");
            return;
        }
        //String password = MD5.getMD5(user.getPassword());
        user.setPassword(user.getPassword());
        user.setCreateTime(new Date());
        user.setState(1);//状态 1:有效 0:无效
        user.setSource(Constant.USER_SOURCE_REGIST);//来源 1:用户注册 2:系统创建 3:广告商创建
        user.setNickName("手机用户" + DataUtils.getRadom(6));
        user.setContactPhone(user.getUserName());
        userMapper.insert(user);
        User currUser = userMapper.selectByPrimaryKey(user.getId());
        currUser.setPassword("");
        ConstructTeam constructTeam = constructTeamMapper.selectByPrimaryKey(currUser.getConstructTeamId());
        if (constructTeam != null) {
            currUser.setTeamName(constructTeam.getName());
        }
        rs.put("info", currUser);
    }
}
