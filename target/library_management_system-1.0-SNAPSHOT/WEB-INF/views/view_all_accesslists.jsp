<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 9/17/2023
  Time: 5:18 PM
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
<form:form modelAttribute="accesslist_key" action="/accesslistcontroller/submit_add_accesslist_form" >
<%--    ///////////////////////////////////////////////////////   role selecting     --%>
    <form:select path="role_id" onchange="change_role(this.value)">
        <c:forEach items="${role_list_key}" var="role">
           <form:option value="${role.id}" label="${role.name}"></form:option>
        </c:forEach>
    </form:select>
<%--    ///////////////////////////////////////////////////////   page selecting     --%> <br>

    <c:forEach items="${page_list_key}" var="page">
        <form:checkbox path="pages_id" value="${page.id}" label="${page.name}"  />  <br>
    </c:forEach>


    <form:button >Click To Add</form:button>


</form:form>

<div id="div_id">

</div>


<%--<c:forEach items="${role_list_key}" var="role">--%>
<%--    ${role.name} <br>--%>
<%--</c:forEach>--%>



</body>
<script>

    function change_role( role_id)
    {
        window.location.href="/accesslistcontroller/viewallaccesslists?role_id="+role_id
    }

</script>
</html>
