package com.myweb.smis.test;

import com.myweb.smis.dao.IStudentDao;
import com.myweb.smis.dao.impl.StudentDaoImpl;
import com.myweb.smis.domain.Student;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class IStudentDaoTest {
    private IStudentDao dao = new StudentDaoImpl();
    @Test
    public void save() throws Exception {
        Student stu = new Student();
        stu.setName("阿飞");
        stu.setGender("男");
        stu.setAge(17);
        stu.setScore(92);
        stu.setSchool("YY大学");
        dao.save(stu);
    }

    @Test
    public void update() throws Exception {
        Student stu = dao.get(6L);
        stu.setAge(13);
        stu.setName("花花");
        dao.update(8L, stu);
    }

    @Test
    public void delete() throws Exception {
        dao.delete(1l);
    }

    @Test
    public void get() throws Exception {
        System.out.println(dao.get(9L));
    }

    @Test
    public void listAll() throws Exception {
        List<Student> list = dao.listAll();
        for(Student stu : list){
            System.out.println(stu);
        }
    }

}