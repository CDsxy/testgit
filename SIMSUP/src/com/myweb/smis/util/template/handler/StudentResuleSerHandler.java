package com.myweb.smis.util.template.handler;

import com.myweb.smis.domain.Student;
import com.myweb.smis.util.template.handler.IStudentResultSetHandler;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentResuleSerHandler implements IStudentResultSetHandler<List<Student>> {
    public List<Student> handle(ResultSet res) throws Exception{
        List<Student> list = new ArrayList<>();
        while(res.next()){
            Student stu =new Student();
            list.add(stu);
            stu.setName(res.getString("name"));
            stu.setGender(res.getString("gender"));
            stu.setId(res.getLong("id"));
            stu.setSchool(res.getString("school"));
            stu.setScore(res.getInt("score"));
        }
        return list;
    }
}
