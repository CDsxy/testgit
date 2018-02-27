<%--
  Created by IntelliJ IDEA.
  User: Thinkad
  Date: 2018/2/24
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑</title>
</head>
    <body>
    <div align="center">
        欢迎你！${USER_IN_SESSION.username}
    </div>
        <form action="/student?cmd=save" method="post">
                <input type="hidden" name="id" value="${student.id}"/>
            姓名:<input type="text" name="name" value="${student.name}"/><br/>
            年龄:<input type="number" name="age" value="${student.age}"/><br/>
            性别:<input type="radio" name="gender" value="男" ${student.gender=='男'?"checked":""}/>男
                <input type="radio" name="gender" value="女" ${student.gender=='女'?"checked":""}/>女<br/>
            分数:<input type="number" name="score" value="${student.score}"/><br/>
            学校:<input type="text" name="school" value="${student.school}"/><br/>
                <input type="submit" value="提交"/>
                <input type="reset" value="重置"/>
        </form>
    </body>
</html>
