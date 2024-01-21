<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 11/3/2023
  Time: 6:24 PM
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
<hr>

<form:form modelAttribute="fileterdto_key" action="/bookcontroller/viewfilterebooks">


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

    your search value: <form:input path="value" ></form:input> &nbsp;



    library_name and city:
    <select id="library_code" name="library_code">
        <option value="-1">all the libraries</option>

        <c:forEach items="${libraries_key}" var="library">
            <option value="${library.id}">${library.library_name}-${library.city} </option>
        </c:forEach>
    </select>

    <br>


    <form:button>Apply the Filter</form:button>

</form:form>

<hr>

<table border="2" width="70%" cellpadding="2">

    <tr>
        <th>title</th>  <th>author</th>  <th>isbn</th>    <th>is_reference</th>  <th>is_active</th>  <th>library_and_city</th> <th>edit</th>
    </tr>

    <c:forEach items="${books_list_key}" var="book">

        <tr>
            <td>${book.book_info.title}</td>
            <td>${book.book_info.author}</td>
            <td>${book.book_info.isbn}</td>
            <td>${book.is_reference}</td>
            <td>${book.is_active}</td>
            <td>${book.library.library_name} </td>
            <td> <a href=""> change-state </a>  </td>
        </tr>

    </c:forEach>


</table>
</body>
</html>
