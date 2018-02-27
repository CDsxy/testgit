<%--
  Created by IntelliJ IDEA.
  User: Thinkad
  Date: 2018/2/25
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
    <body>
        <h1>注册页面</h1>
        <span style="color: red">${errorMessage}</span>
        <span style="color: red">${exist}</span>
        <form action="/login?log=register" method="post">
            用户名:<input type="text" name="username" required/><br/>
            密码:<input type="password" name="password" required/><br/>
            确认密码:<input type="password" name="rpassword" required/><br/>
                <input type="submit" value="注册"/>
                <input type="reset" value="重置"/>
        </form>
    </body>
</html>
