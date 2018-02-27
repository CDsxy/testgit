package com.myweb.smis.test;

import com.myweb.smis.dao.IUserDao;
import com.myweb.smis.dao.impl.UserDaoImpl;
import com.myweb.smis.domain.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class IUserDaoTest {
    private IUserDao dao = new UserDaoImpl();
    @Test
    public void getUserByUsername() throws Exception {
        User user = dao.getUserByUsername("admi");
        System.out.println(user);
    }

    @Test
    public void testRegister() throws Exception{
        User user = new User();
        user.setUsername("adm");
        user.setPassword("123456");
        dao.register(user);
    }

}