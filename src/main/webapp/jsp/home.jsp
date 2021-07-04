<%--
  Created by IntelliJ IDEA.
  User: weter
  Date: 04.07.2021
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--Цвет текста берем из значения куки color --%>
    <span style="color:${cookie.color.value}">Hello!</span>
    <form method="post" action="/home">
        <label for="color">
            <select name="color" id="color">
                <option value="red">Красный</option>
                <option value="blue">Синий</option>
                <option value="black">Черный</option>
            </select>
        </label>
        <input type="submit" value="Color send">
    </form>

</body>
</html>
