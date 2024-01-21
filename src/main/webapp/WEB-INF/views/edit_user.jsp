
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>edit user page</title>
</head>
<body>
<h1>edit role page</h1>
<form:form method="POST" action="/usercontroller/submit_edit_user" modelAttribute="user_key" >

                    <form:hidden path="user_id"></form:hidden>

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
