<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.myapp.models.User" %>
<%--
  Created by IntelliJ IDEA.
  User: weter
  Date: 01.07.2021
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--
    используется Java код, внутри HTML страницы заключается в тэги <%></%>
    request.getAttribute("usersFromServer") - передача на страницу JSP данных, созданных на стороне сервера
--%>
    <%
        ArrayList<User> users = (ArrayList) request.getAttribute("usersFromServer");
    %>
    <table>
        <tr>
            <th>User Name</th>
            <th>Birth Date</th>
        </tr>
            <%for(User user : users) {%>
        <tr>
            <td><%=user.getName()%></td>
            <td><%=user.getBirthDate()%></td>
        </tr>
        <%}%>
    </table>

</body>
</html>
