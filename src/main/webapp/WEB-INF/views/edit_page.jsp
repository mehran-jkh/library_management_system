<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 9/16/2023
  Time: 6:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="POST" modelAttribute="page_key" action="/pagecontroller/submit_edit_page">
    <table >

        <tr>

            <form:hidden path="id"/>

        </tr>

        <tr>
            <td>Name : </td>
            <td><form:input path="name"  /></td>
        </tr>

        <tr>
            <td>description :</td>
            <td><form:input path="description" /></td>
        </tr>

        <tr>
            <td>url :</td>
            <td><form:input path="url" /></td>
        </tr>

        <tr>
            <td> </td>
            <td><input type="submit" value="Edit Save" /> </td>
        </tr>
    </table>
</form:form>
</body>
</html>
