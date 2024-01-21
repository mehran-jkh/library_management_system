<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 11/9/2023
  Time: 3:28 PM
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
<h1>Add Member </h1>

<form:form method="POST" modelAttribute="Member_key" action="/membercontroller/submit_add_member_form">
    <table >

       <tr> ----------------------------------------------- user related fields </tr>

        <tr>
            <td>email :</td>
            <td><form:input path="email" />     <form:errors path="email"   cssStyle="color: crimson"/></td>
        </tr>

        <tr>
            <td>mobile :</td>
            <td><form:input path="phone" /> <form:errors path="phone" cssStyle="color: crimson"  />  </td>
        </tr>

        <tr>
            <td>username :</td>
            <td><form:input path="username" /> <form:errors path="username" cssStyle="color: crimson"  />  </td>
        </tr>

        <tr>
            <td>password :</td>
            <td><form:input path="password" /> <form:errors path="password" cssStyle="color: crimson"  />  </td>
        </tr>

        <tr>  <td>   -------------------------------------- member related fields </td> </tr>
        <tr>
            <td>name :</td>
            <td><form:input path="name" /></td>
            <td bgcolor="#dc143c"> <form:errors path="name"  /> </td>
        </tr>

        <tr>
            <td>national_code :</td>
            <td><form:input path="national_code" /></td>
            <td bgcolor="#dc143c"> <form:errors path="national_code"  /> </td>
        </tr>

        <tr>
            <td>address :</td>
            <td><form:input path="address" /></td>
        </tr>

        <tr>
         <td> Member_Type : </td>

            <td>
            <form:select path="memberTypeDTO.id" >
                <c:forEach items="${ membertypes_list_key}" var="membertype">
                        <form:option value="${membertype.id}" label="${membertype.membertype_name}"></form:option>
                </c:forEach>
            </form:select>
            </td>
                <br>
        </tr>

        <tr>
            <td> </td>
            <td><input type="submit" value="Edit Save" /> </td>
        </tr>



    </table>

</form:form>




</body>
</html>
