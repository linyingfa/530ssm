package com.soecode.lyf.dao;

import com.soecode.lyf.entity.User;

public interface UserMapper extends BaseMapper<User, Long> {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}