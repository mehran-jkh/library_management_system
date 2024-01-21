<%--
  Created by IntelliJ IDEA.
  User: mehra
  Date: 1/10/2024
  Time: 5:48 PM
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
<h1>this page is for displaying error messages </h1>

<h3>
    <div style="color:crimson ; align: center" >
    <c:forEach items="${errors}" var="error">
        ${error.objectName}:
        <c:out value="${error.defaultMessage}"  />
    </c:forEach>
    </div>
</h3>

</body>
</html>
