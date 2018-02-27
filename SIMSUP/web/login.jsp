<%--
  Created by IntelliJ IDEA.
  User: Thinkad
  Date: 2018/2/24
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登陆</title>
    <script type="text/javascript">
      function change() {
        //重新设置<img>元素的src属性
          document.getElementById("randomCodeImg").src="/randomCode?"+new Date().getTime();
      }
    </script>
  </head>
    <body>
      <%
        session.invalidate();
      %>
      <h1>登陆界面</h1>
      <span style="color: red;">${errorMessage}</span>
      <span style="color: red">${wrongPassword}</span>
      <span style="color: red">${randomCodeError}</span>
      <span style="color: green">${rightMessage}</span>
      <form action="/login?log=loginIn" method="post">
        用户名:<input type="text" name="username" required/><br/>
        密&emsp;码:<input type="password" name="password" required/><br/>
        验证码:<input type="text" name="randomCode" size="5" maxlength="5" required/>
              <img src="/randomCode" id="randomCodeImg" style="cursor: pointer" onclick="change();" title="看不清，换一张"/><br/>
            <input type="submit" value="登陆"/>
            <input type="reset" value="重置"/>
      </form>
      <a href="/login?log=edit">注册</a>
    </body>
</html>
