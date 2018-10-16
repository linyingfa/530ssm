package com.soecode.lyf.service.inter.imethod;

import com.soecode.lyf.entity.User;
import com.soecode.lyf.utils.Result;

/**
 * Created by xiaolin on 2018/10/15.
 */
public interface InterUserService {

    void registAccount(User user, String verifyCode, Result rs);
}
