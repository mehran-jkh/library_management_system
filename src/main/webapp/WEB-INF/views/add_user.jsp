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
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<h1> add user page!!!</h1>

<br>

<br>

<form:form action="/usercontroller/submit_adduser_form" modelAttribute="user_key">
<%--    <c:if test="${not empty bindingResult.globalErrors}">--%>
<%--        <ul>--%>
<%--            <c:forEach items="${bindingResult.globalErrors}" var="error">--%>
<%--                <li>${error.defaultMessage}</li>--%>
<%--            </c:forEach>--%>
<%--        </ul>--%>
<%--    </c:if>--%>
    <form:errors path = "*"    cssStyle="color: crimson"/>
    UserName : <form:input path="username"></form:input>  <form:errors path="username" /> <br> <br>


    PassWord : <form:input path="password"></form:input> <form:errors path="password" /> <br> <br>


    email : <form:input  path="email"></form:input>  <form:errors path="email"></form:errors>  <br> <br>

    phone_number : <form:input  path="phone"></form:input>  <form:errors path="phone"></form:errors><br> <br>


    System_Role :
    <form:select path="roleinfodto.id" >

       <c:forEach items="${ roles_list_key}" var="role">
           <form:option value="${role.id}" label="${role.name}"></form:option>
       </c:forEach>

    </form:select> <br> <br>

    <form:button value="click-to-add">Click_to_add</form:button>

</form:form>





</body>
</html>
