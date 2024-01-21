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

<a href="/pagecontroller/viewallpages"> view_all_page</a> <br>

<a href="/accesslistcontroller/viewallaccesslists">view_all_accesslists</a> <br>

<a href="/usercontroller/viewallusers">view_all_users</a> <br>



<a href="/bookinfocontroller/addbookinfo">add_bookinfo_page</a> <br>

<a href="/bookinfocontroller/viewfilteredbooksinfo">view_all_bookinfo</a> <br>

<a href="/bookcontroller/viewfilterebooks">view_all_books</a> <br>




<a href="/membercontroller/addmember"> add_system_member </a> <br>
<a href="/membercontroller/addlibrarymember"> add_library_member_to_your_library </a> <br>



<a href="/resourcecontroller/viewalllibraries"> view_all_libraries </a> <br>





<a href="/logincontroller/login"> Login </a> <br>
<a href="/logincontroller/logout"> Logout </a>


</body>
</html>