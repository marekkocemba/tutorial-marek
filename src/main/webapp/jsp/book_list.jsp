<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
	</head>
	<body>
		<h3>Lista książek</h3>
		<c:choose>
			 <c:when test = "${not empty bookList}">
			 	<c:forEach items="${bookList}" var="book">
                	<a href="/books/${book.id}"> ${book.title} || ${book.author} || ${book.bookCategory.small} ||  ${book.year} </a> <br>
             	</c:forEach>
			 </c:when>
			 <c:otherwise>
             Brak książek w bazie
             </c:otherwise>
         </c:choose>
    </body>
</html>