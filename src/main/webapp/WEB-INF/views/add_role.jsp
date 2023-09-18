<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 8/24/2023
  Time: 2:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> add role page!!!</h1>
<br>
<form:form action="/rolecontroller/submit_addrole_form" modelAttribute="role_key">

 Name : <form:input path="name"></form:input>  <br> <br>
 description : <form:input path="description"></form:input>  <br> <br>
 maxusers : <form:input  path="maxuser"></form:input>  <br> <br>
    <form:button value="click-to-add">Click_to_add</form:button>

</form:form>


</body>
</html>
