<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 11/2/2023
  Time: 1:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Add BookInfo Page</h1>
<form:form method="POST" modelAttribute="bookinfo_key" action="/bookinfocontroller/submit_add_bookinfo_form">
    <table>

        <tr>
            <td>Title : </td>
            <td><form:input path="title"  /> <form:errors path="title"></form:errors></td>
        </tr>

        <tr>
            <td>author :</td>
            <td><form:input path="author" /> <form:errors path="author"></form:errors></td>
        </tr>

        <tr>
            <td>isbn :</td>
            <td><form:input path="isbn" /> <form:errors path="isbn"></form:errors></td>
        </tr>

        <tr>
            <td>is_creation_allowed :</td>
            <td><form:checkbox path="is_creation_allowed" /></td>
        </tr>

        <tr>
            <td> </td>
            <td><input type="submit" value="Edit Save" /> </td>
        </tr>

    </table>
</form:form>
</body>
</html>
