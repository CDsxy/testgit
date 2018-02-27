package com.myweb.smis.dao.impl;

import com.myweb.smis.dao.IUserDao;
import com.myweb.smis.domain.User;
import com.myweb.smis.util.template.JdbcTemplate;
import com.myweb.smis.util.template.handler.IStudentResultSetHandler;

import java.sql.ResultSet;

public class UserDaoImpl implements IUserDao{
    public User getUserByUsername(String username) {
        String SQL = "select * from t_user where username = ?";

        return JdbcTemplate.query(SQL, new IStudentResultSetHandler<User>(){
            public User handle(ResultSet res) throws Exception {
                if(res.next()){
                    User user = new User();
                    user.setId(res.getLong("id"));
                    user.setUsername(res.getString("username"));
                    user.setPassword(res.getString("password"));
                    return user;
                }
                return null;
            }
        }, username);
    }

    public void register(User u) {
        String SQL = "insert into t_user (username, password) values (?, ?)";
        JdbcTemplate.update(SQL, u.getUsername(), u.getPassword());
    }
}
