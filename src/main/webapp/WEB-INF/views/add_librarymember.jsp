<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 12/14/2023
  Time: 6:41 PM
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

<form:form modelAttribute="librarymember_key" action="/membercontroller/submit_add_library_member_form">

    enter the member national  code here: <form:input path="systemMember.national_code"/>

    <input type="submit" name="add_memebet_to library"  />
</form:form>




</body>
</html>
