package com.soecode.lyf.dao;


import com.soecode.lyf.entity.UserQueryVo;
import com.soecode.lyf.entity.Userr;

import java.util.List;

/**
 * 用户mapper
 *
 * @author lx
 */
public interface UserrMapper {

    // 根据用户id查询用户信息
    Userr findUserById(int id) throws Exception;

    // 根据用户姓名查询用户信息
    List<Userr> findUserByName(String username) throws Exception;

    // 自定义查询条件查询用户信息
    List<Userr> findUserList(UserQueryVo userQueryVo) throws Exception;

    // 查询用户，使用resultMap进行映射
    List<Userr> findUserListResultMap(UserQueryVo userQueryVo) throws Exception;

    // 查询用户返回记录个数
    int findUserCount(UserQueryVo userQueryVo) throws Exception;

    // 插入用户
    void insertUser(Userr user) throws Exception;

    // 删除用户
    void deleteUser(int id) throws Exception;

    // 修改用户
    void updateUser(Userr user) throws Exception;
}
