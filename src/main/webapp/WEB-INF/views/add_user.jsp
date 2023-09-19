<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 9/19/2023
  Time: 2:41 PM
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


<h1> add user page!!!</h1>
<br>
<form:form action="/usercontroller/submit_adduser_form" modelAttribute="user_key">

    UserName : <form:input path="username"></form:input>  <br> <br>

    email : <form:input  path="email"></form:input>  <br> <br>

    phone_number : <form:input  path="mobile_number"></form:input>  <br> <br>

    System_Role :
    <form:select path="aarole.code" >

       <c:forEach items="${ roles_list_key}" var="role">
           <form:option value="${role.code}" label="${role.name}"></form:option>
       </c:forEach>

    </form:select> <br> <br>

    <form:button value="click-to-add">Click_to_add</form:button>

</form:form>





</body>
</html>
