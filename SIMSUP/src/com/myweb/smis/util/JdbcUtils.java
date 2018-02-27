package com.myweb.smis.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.sun.org.apache.xalan.internal.utils.XMLSecurityPropertyManager;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils{
    private static DataSource ds = null;

    static{
            try {
                Properties p = new Properties();
                p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
                ds = DruidDataSourceFactory.createDataSource(p);
            }catch (Exception e) {
                e.printStackTrace();
            }
    }

    public static Connection getConn(){
        try {
            return ds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(Connection conn, Statement sta, ResultSet res){
        try{
            if (res != null) {
                res.close();
            }
        }catch(Exception e){
        }finally {
            try{
                if(sta!= null){
                    sta.close();
                }
            }catch(Exception e){
            }finally {
                try{
                    if(conn!=null) {
                        conn.close();
                    }
                }catch(Exception e){
                }
            }
        }
    }
}
