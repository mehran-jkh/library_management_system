<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 11/2/2023
  Time: 5:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="POST" modelAttribute="book_key" action="/bookcontroller/submit_add_book_form">
    <table>


        <tr>
            <td>Title : </td>
            <td> ${book_key.book_info.title} </td>
<%--            <td><form:label  path="bookinfoDTO.title"  /></td>--%>
        </tr>


        <tr>
            <td>author :</td>
            <td> ${book_key.book_info.author} </td>
        <%--            <td><form:input readonly="true" path="bookinfoDTO.author"  /></td>--%>
        </tr>


        <tr>
            <td>isbn :</td>
            <td> ${book_key.book_info.isbn} </td>
<%--            <td><form:input path="bookinfoDTO.isbn" /></td>--%>
        </tr>





        <tr>
            <td>is_active</td>
            <td><form:checkbox path="is_active" /></td>
        </tr>


        <tr>
            <td>is_refrence</td>
            <td><form:checkbox path="is_reference" /></td>
        </tr>


        <tr>
            <td> </td>
            <td><input type="submit" value="Edit Save" /> </td>
        </tr>


    </table>
</form:form>
</body>
</html>
