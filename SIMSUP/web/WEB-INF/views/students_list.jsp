<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
    <title>学生信息列表</title>
</head>
        <h1>学生信息列表</h1>
        <div align="center">
            欢迎你！${USER_IN_SESSION.username}
            <a href="/login.jsp">注销</a>
        </div>
        <a href="/student?cmd=edit">添加学生</a>
        <table border="1" width="70%" cellspacing="0" cellpadding="0">
            <tr style="background: #ddffd7">
                <th>ID</th>
                <th>姓名</th>
                <th>年龄</th>
                <th>性别</th>
                <th>分数</th>
                <th>学校</th>
                <th colspan="2">操作</th>
            </tr>
            <c:forEach items="${students}" var="li" varStatus="st">
            <tr style="background: ${st.count%2==0?"#D3A4FF":"#D0D0D0"}">
                <td>${li.id}</td>
                <td>${li.name}</td>
                <td>${li.age}</td>
                <td>${li.gender}</td>
                <td>${li.score}</td>
                <td>${li.school}</td>
                <td><a href="/student?cmd=edit&id=${li.id}">编辑</a></td>
                <td><a href="/student?cmd=delete&id=${li.id}">删除</a></td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>