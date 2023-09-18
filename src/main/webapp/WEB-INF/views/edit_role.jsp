<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 9/8/2023
  Time: 1:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>edit role page</h1>
<form:form method="POST" action="/rolecontroller/submit_edit_role" modelAttribute="role_key" >
    <table >
        <tr>
            <td></td>
            <td><form:hidden  path="code" /></td>
        </tr>
        <tr>
            <td>Name : </td>
            <td><form:input path="name"  /></td>
        </tr>
        <tr>
            <td>discriotion :</td>
            <td><form:input path="description" /></td>
        </tr>
        <tr>
            <td>Maxusers :</td>
            <td><form:input path="maxuser" /></td>
        </tr>

        <tr>
            <td> </td>
            <td><input type="submit" value="Edit Save" /> </td>
        </tr>
    </table>
</form:form>




</body>
</html>
