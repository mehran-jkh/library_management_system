<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 11/11/2023
  Time: 5:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="POST" modelAttribute="librarian_key" action="/resourcecontroller/submit_add_librarian">
    <table >

        <tr> ------------------------------------------------------------------ user related fields </tr>

        <tr>
            <td>UserName : </td>
            <td><form:input path="username"  /></td>
        </tr>

        <tr>
            <td>email :</td>
            <td><form:input path="email" /></td>
        </tr>

        <tr>
            <td>mobile :</td>
            <td><form:input path="mobile" /></td>
        </tr>

        <tr>
            <td>name :</td>
            <td><form:input path="name" /></td>
        </tr>

        <tr>  <td>   ------------------------------------------------------------------ member related fields </td> </tr>


        <tr>
            <td>personnel_code :</td>
            <td><form:input path="personnel_code" /></td>
        </tr>

        <tr>
            <td> </td>
            <td><input type="submit" value="Edit Save" /> </td>
        </tr>



    </table>

</form:form>
</body>
</html>
