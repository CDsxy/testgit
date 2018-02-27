package com.myweb.smis.web.servlet;

import com.myweb.smis.dao.IStudentDao;
import com.myweb.smis.dao.impl.StudentDaoImpl;
import com.myweb.smis.domain.Student;
import com.myweb.smis.domain.User;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/student")
public class EditServlet extends HttpServlet{
    private IStudentDao studentDao;

    public void init() throws ServletException {
        studentDao = new StudentDaoImpl();
    }

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Object user = req.getSession().getAttribute("USER_IN_SESSION");
        if(user == null){
            resp.sendRedirect("/login.jsp");
            return;
        }
        String cmd = req.getParameter("cmd");
        if("save".equals(cmd)){
            this.saveOrUpdate(req, resp);
        }else if("edit".equals(cmd)){
            this.edit(req, resp);
        }else if("delete".equals(cmd)){
            this.delete(req, resp);
        }else{
            this.list(req, resp);
        }
    }
    protected void saveOrUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id =req.getParameter("id");
            String name =req.getParameter("name");
            String gender = req.getParameter("gender");
            String school = req.getParameter("school");
            Integer age = Integer.valueOf(req.getParameter("age"));
            Integer score = Integer.valueOf(req.getParameter("score"));
            Student student = new Student();
            student.setName(name);
            student.setAge(age);
            student.setSchool(school);
            student.setScore(score);
            student.setGender(gender);
        if(hasLength(id)) {
            studentDao.update(Long.valueOf(id), student);
        }else{
            studentDao.save(student);
        }
        resp.sendRedirect("/student");
    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        studentDao.delete(Long.valueOf(req.getParameter("id")));
        resp.sendRedirect("/student");
    }
    protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if(hasLength(id)) {
            Student stu = studentDao.get(Long.valueOf(id));
            req.setAttribute("student", stu);
        }
        req.getRequestDispatcher("/WEB-INF/views/edit.jsp").forward(req, resp);
    }
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> list = studentDao.listAll();
        req.setAttribute("students", list);
        req.getRequestDispatcher("/WEB-INF/views/students_list.jsp").forward(req, resp);
    }

    private boolean hasLength(String str){
        return str!=null&&!"".equals(str.trim());
    }
}
