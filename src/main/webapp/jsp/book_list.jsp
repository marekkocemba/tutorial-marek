<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="pl.unity.tutorial.marek.book.model.enums.BookCategoryEnum" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
		    	<style>
            		.error {
            		color: #ff0000;
            		font-style: italic;
            		font-weight: bold;
            		}
            	</style>
	</head>
	<body>
		<a href="/index.html"> Powrót do index-u </a> <br>
		Wyszukiwarka:
		<form:form method="GET" action="/books" modelAttribute="book">
			Tytuł: <form:input path="title"/>
			<br>
			Autor: <form:input path="author"/>
			<br>
			Rok od: <form:input path="yearFrom"/>
			<form:errors path="yearFrom" class='error'/>
        	<br>
        	Rok do: <form:input path="yearTo"/>
        	<br>
        	Kategoria:
            <form:select  path="bookCategoryList">
            	<c:forEach items="<%=BookCategoryEnum.values()%>" var="bookCategoryItem">
            		<option value="${bookCategoryItem}">${bookCategoryItem.minuscule}</option>
            	</c:forEach>
            </form:select>
            <br>
			Dostepne:  <form:checkbox path="available"/>
        	<br>
        	<input type= "submit" value= "filtruj" >
		</form:form>
		<h3>Lista książek</h3>
		<c:choose>
			 <c:when test = "${not empty bookList}">
			 	<c:forEach items="${bookList}" var="book">
                	<a href="/books/${book.id}"> ${book.title} || ${book.author} || ${book.bookCategory.minuscule} ||  ${book.year} </a> <br>
             	</c:forEach>
			 </c:when>
			 <c:otherwise>
             Brak książek w bazie
             </c:otherwise>
         </c:choose>
         <form method="GET" action="/books/form">
         	<input type="submit" value="dodaj książkę" >
         </form>
    </body>
</html>