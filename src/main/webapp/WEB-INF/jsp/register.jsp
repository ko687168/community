<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" buffer="none" %>
<html>
<head>
    <title>用户注册</title>
    <meta http-equiv="Expires" content="0">
    <meta http-equiv="Cache-Control", content="no-cache">
    <meta http-equiv="Progma" content="no-cache">
</head>
<body>
    <form   action="/register" method="post">
               用户名：<input type="text" name="username">
               密码：<input type="password" name="password">
                <input type="submit" value="注册">
    </form>

</body>
</html>