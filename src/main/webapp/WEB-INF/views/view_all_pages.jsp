<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 9/16/2023
  Time: 1:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>view all pages</title>
</head>
<body>
<h1>for viewing all pages</h1>   <br>
<a href="/pagecontroller/addpage">ADD PAGE</a>
<table border="2" width="70%" cellpadding="2">

    <tr>
        <th>name</th>  <th>description</th>  <th>url</th>    <th>DELETE</th>  <th>EDIT</th>
    </tr>

    <c:forEach items="${page_list_key}" var="page">
        <tr>
        <td>${page.name}</td>
        <td>${page.description}</td>
        <td>${page.url}</td>
        <td>   <a href="/pagecontroller/deletepage/${page.id}">DELTE </a>  </td>
        <td>   <a href="/pagecontroller/editpage/${page.id}">EDIT </a>  </td>
        </tr>
    </c:forEach>


</table>




</body>
</html>
