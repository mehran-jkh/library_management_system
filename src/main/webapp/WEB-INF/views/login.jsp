<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 9/21/2023
  Time: 1:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> login page</h1>  <br>

<form:form method="POST" action="/logincontroller/sbmit_login_form" modelAttribute="loginDTO_key" >
    <table >

        <tr>
            <td>UserName : </td>
            <td><form:input path="username"  /></td>
        </tr>

        <tr>
            <td>PassWord :</td>
            <td><form:input path="password" /></td>
        </tr>

        <tr>
            <td>Login:</td>
            <td> <input type="submit" value="Login..."/> </td>
        </tr>

    </table>
</form:form>




</body>
</html>
