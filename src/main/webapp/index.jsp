<%@ taglib prefix="a" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a> <br>

<a href="/rolecontroller/viewallroles"> view_all_roles page</a> <br>

<a href="/pagecontroller/viewallroles"> view_all_page</a> <br>

<a href="/accesslistcontroller/viewallaccesslists">view_all_accesslists</a> <br>

<a href="/usercontroller/viewallusers">view_all_users</a> <br>

<a href="/logincontroller/login"> Login </a>


</body>
</html>