<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 11/2/2023
  Time: 1:28 PM
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
<h1>for viewing all books-information!!!</h1>   <br>
<h4><form:errors path="*" cssStyle="color: crimson" />  </h4>


<a href="/bookinfocontroller/addbookinfo">ADD PAGE</a>



<hr>
<form:form modelAttribute="fileterdto_key" action="/bookinfocontroller/viewfilteredbooksinfo">


    Search Field :
    <form:select path="search_field_code" >
        <c:forEach items="${searchfields_key.searchFields}" var="searchfield">
            <form:option value="${searchfield.key}" label="${searchfield.value}"></form:option>
        </c:forEach>
    </form:select>

    &nbsp; &nbsp; &nbsp;

    Search Type :
    <form:select path="search_type_code" >
        <c:forEach items="${searchtypes_key.searchTypes}" var="search_type">
            <form:option value="${search_type.key}" label="${search_type.value}"></form:option>
        </c:forEach>
    </form:select>

    &nbsp; &nbsp; &nbsp;

    your search value: <form:input path="value" ></form:input> &nbsp;

    <form:button>Apply the Filter</form:button>

</form:form>

<hr>

<br>

<table border="2" width="70%" cellpadding="2">

    <tr>
        <th>title</th>  <th>author</th>  <th>isbn</th>    <th>is_creation_allowed</th>  <th>CREATE A COPY</th> <th>...</th>
    </tr>

    <c:forEach items="${bookinfo_list_key}" var="bookinfo">


        <tr>
            <td>${bookinfo.title}</td>
            <td>${bookinfo.author}</td>
            <td>${bookinfo.isbn}</td>
            <td>${bookinfo.is_creation_allowed}</td>

            <td>   <a href="/bookcontroller/addbook/${bookinfo.id}">CREATE A COPY </a>  </td>
            <td>   <a href="/bookinfocontroller/viewlibrariesbybookinfo/${bookinfo.id}"> view libraries which have this book </a>  </td>
        </tr>

    </c:forEach>


</table>

</body>
</html>
