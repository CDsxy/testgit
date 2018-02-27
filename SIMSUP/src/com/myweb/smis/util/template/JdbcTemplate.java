package com.myweb.smis.util.template;

import com.myweb.smis.util.JdbcUtils;
import com.myweb.smis.util.template.handler.IStudentResultSetHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcTemplate{
    private JdbcTemplate(){};
    public static int update(String SQL, Object...param){
        Connection conn = null;
        PreparedStatement pre = null;
        try{
            conn = JdbcUtils.getConn();
            pre = conn.prepareStatement(SQL);
            for(int i = 0; i < param.length; i++){
                pre.setObject(i + 1, param[i]);
            }
            return pre.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn, pre, null);
        }
        return 0;
    }

    public static <T>T query(String SQL, IStudentResultSetHandler<T> handler, Object...param){
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        try{
            conn = JdbcUtils.getConn();
            pre = conn.prepareStatement(SQL);
            for(int i = 0; i < param.length; i++){
                pre.setObject(i + 1,param[i]);
            }
            res = pre.executeQuery();
            return handler.handle(res);
        }catch(Exception e){
            e.printStackTrace();
        }
        finally {
            JdbcUtils.close(conn, pre, res);
        }
        return null;
    }
}

