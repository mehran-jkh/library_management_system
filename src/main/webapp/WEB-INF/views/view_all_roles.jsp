<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 9/5/2023
  Time: 9:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>view-all-roles</title>
</head>
<body>
<h1>for viewing all the roles</h1> <br>

<a href="/rolecontroller/addrole">ADD ROLE FORM</a>


<table border="2" width="70%" cellpadding="2">

<tr>
    <th>name</th>  <th>description</th>  <th>max-users</th>    <th>DELETE</th>  <th>EDIT</th>
</tr>

<c:forEach var="role" items="${roles_list_key}">
<tr>
<%--    <td>${role.code}</td>--%>
    <td>${role.name}</td>
    <td>${role.description}</td>
    <td>${role.maxuser}</td>
    <td> <a href="/rolecontroller/deleterole/${role.id}" >DELETE </a>  </td>
    <td> <a href="/rolecontroller/editrole/${role.id}" >EDIT </a>  </td>

</tr>
</c:forEach>


</table>
</body>
</html>
