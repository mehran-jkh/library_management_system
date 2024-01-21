
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>add role page</title>
</head>
<body>
<h1> add role page</h1>
<br>
<form:form action="/rolecontroller/submit_addrole_form" modelAttribute="role_key">

 Name : <form:input path="name"></form:input>  <form:errors path="name"></form:errors> <br> <br>
 description : <form:input path="description"></form:input>  <form:errors path="description"></form:errors> <br> <br>
 maxusers : <form:input  path="maxuser"></form:input> <form:errors path="maxuser"></form:errors> <br> <br>
    <form:button value="click-to-add">Click_to_add</form:button>

</form:form>


</body>
</html>
