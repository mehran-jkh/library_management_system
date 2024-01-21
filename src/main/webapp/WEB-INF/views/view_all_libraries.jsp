<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 11/11/2023
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>for viewing all the libraries</h1> <br>


<table border="2" width="70%" cellpadding="2">

    <tr>
        <th>lib_name</th>  <th>phone</th>  <th>postal_address</th>    <th>postal_address</th>  <th>ADD_LIBRARIAN</th>
    </tr>

    <c:forEach var="lib" items="${library_list_key}">
        <tr>
                <%--    <td>${role.code}</td>--%>
            <td>${lib.library_name}</td>
            <td>${lib.phone}</td>
            <td>${lib.postal_address}</td>
            <td>${lib.city}</td>
<%--            <td> <a href="/resourcecontroller/addlibrarian/${lib.id}" >ADD_LIBRARIAN </a>  </td>--%>


        </tr>
    </c:forEach>


</table>
</body>
</html>
