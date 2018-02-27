package com.myweb.smis.util.template.handler;

import java.sql.ResultSet;

public interface IStudentResultSetHandler<T> {
    /**
     * 处理结果集
     * @return 处理完成的对象
     */
    T handle(ResultSet res) throws Exception;
}
