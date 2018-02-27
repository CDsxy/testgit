package com.myweb.smis.dao.impl;

import com.myweb.smis.dao.IStudentDao;
import com.myweb.smis.domain.Student;
import com.myweb.smis.util.template.handler.BeanHandler;
import com.myweb.smis.util.template.handler.BeanListHandler;
import com.myweb.smis.util.template.JdbcTemplate;

import java.util.List;

public class StudentDaoImpl implements IStudentDao{
    public void save(Student newstu) {
        String SQL = "insert into student (name, gender,score, school, age) values (?, ?, ?, ?, ?)";
        Object[] param = {newstu.getName(), newstu.getGender(), newstu.getScore(),
                          newstu.getSchool(), newstu.getAge()};
        JdbcTemplate.update(SQL, param);

    }

    public void update(Long id, Student newstu) {
        String SQL = "update student set name = ?, gender = ?, score = ?, school = ?, age = ? where id = ?";
        Object[] param = {newstu.getName(), newstu.getGender(), newstu.getScore(), newstu.getSchool(), newstu.getAge(), id};
        JdbcTemplate.update(SQL, param);

    }

    public void delete(Long id) {
        String SQL = "delete from student where id = ?";
        JdbcTemplate.update(SQL, id);

    }

    public Student get(Long id) {
        String SQL = "select * from student where id = ?";
        return JdbcTemplate.query(SQL, new BeanHandler<>(Student.class), id);
    }

    public List<Student> listAll() {
        String SQL = "select * from student";
        return JdbcTemplate.query(SQL, new BeanListHandler<>(Student.class));
    }
}
