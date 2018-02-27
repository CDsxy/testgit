package com.myweb.smis.dao;

import com.myweb.smis.domain.Student;
import org.junit.Test;

import java.util.List;

public interface IStudentDao {
    /**
     * 保存新的学生信息
     * @param newstu 学生信息
     */
    void save(Student newstu);

    /**
     * 修改学生信息
     * @param id 被修改学生ID
     * @param stu 新的学生信息
     */
    void update(Long id, Student stu);

    /**
     * 删除学生信息
     * @param id 被删除学生ID
     */
    void delete(Long id);

    /**
     * 查询学生信息
     * @param id 被查询学生具体ID
     * @return 被查询学生信息
     */
    Student get(Long id);

    /**
     * 查询所有学生信息
     * @return 所有学生信息
     */
    List<Student> listAll();
}
