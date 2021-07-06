<%--
  Created by IntelliJ IDEA.
  User: weter
  Date: 05.07.2021
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%--
    страница авторизации пользователя

--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Please, sign up!
    </div>
    <form method="post" action="/login">
        <label for="name">User name
            <input class="input-field" type="text" id="name" name="name">
        </label>
        <label for="password">Password
            <input class="input-field" type="password" id="password" name="password">
        </label>

        <input class="input-field" type="submit" value="Sign up">
    </form>
</div>

</body>
</html>
