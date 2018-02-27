package com.myweb.smis.dao;

import com.myweb.smis.domain.User;

public interface IUserDao {
    /**
     * 根据账号查询用户信息对象
     * @param username 用户名(唯一)
     * @return 登陆用户对象
     */
    User getUserByUsername(String username);

    /**
     * 用户注册
     * @param u 用户信息
     */
    void register(User u);
}
