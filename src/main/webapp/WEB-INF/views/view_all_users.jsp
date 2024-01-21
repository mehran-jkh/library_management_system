<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 9/19/2023
  Time: 2:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>for viewing all the users</h1> <br>

<a href="/usercontroller/adduser">ADD USER FORM</a>


<table border="2" width="70%" cellpadding="2">

    <tr>
        <th>username</th>  <th>password</th>  <th>email</th>  <th>phone_number</th> <th>system_roel</th>  <th>EDIT</th>
    </tr>

    <c:forEach var="user" items="${useers_list_key}">
        <tr>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.email}</td>
            <td>${user.phone}</td>
            <td>${user.roleinfodto.name}</td>
            <td> <a href="/usercontroller/edituser/${user.user_id}" > EDIT </a>  </td>
        </tr>
    </c:forEach>


</table>
</body>
</html>
