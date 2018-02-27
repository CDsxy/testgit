package com.myweb.smis.web.servlet;

import com.myweb.smis.dao.IUserDao;
import com.myweb.smis.dao.impl.UserDaoImpl;
import com.myweb.smis.domain.User;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
    private IUserDao userDao = null;

    public void init() throws ServletException {
        userDao = new UserDaoImpl();
    }

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String log = req.getParameter("log");
        if("loginIn".equals(log)){
            this.loginIn(req, resp);
        }else if("register".equals(log)){
            this.register(req, resp);
        }else if("edit".equals(log)){
            this.edit(req, resp);
        }else{
            resp.sendRedirect("/login.jsp");
        }


    }

    protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
    }

    protected void loginIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String randomCode = req.getParameter("randomCode");
        String randomCodeInSession = (String)req.getSession().getAttribute("RANDOMCODE_IN_SESSION");
        User user = userDao.getUserByUsername(username);
        if(user == null){
            req.setAttribute("errorMessage", "账号不存在");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }
        if(!password.equals(user.getPassword())){
            req.setAttribute("wrongPassword", "密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }
        if(!randomCode.equalsIgnoreCase(randomCodeInSession)){
            req.setAttribute("randomCodeError", "验证码错误");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }
        req.getSession().removeAttribute("RANDOMCODE_IN_SESSION");
        req.getSession().setAttribute("USER_IN_SESSION", user);
        resp.sendRedirect("/student");
    }

    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String rpassword = req.getParameter("rpassword");
        User us = userDao.getUserByUsername(username);
        if(us != null){
            req.setAttribute("exist", "账户已存在");
            req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req ,resp);
            return;
        }
        if(!password.equals(rpassword)){
            req.setAttribute("errorMessage", "两次密码不一致");
            req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req ,resp);
            return;
        }
        User u = new User();
        u.setUsername(username);
        u.setPassword(password);
        userDao.register(u);
        req.setAttribute("rightMessage", "注册成功");
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }
}
