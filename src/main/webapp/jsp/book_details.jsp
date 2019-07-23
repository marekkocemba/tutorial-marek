<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
	</head>
	<body>
		<a href="/index.html"> Powrót do index-u </a> <br>
  		<h3>Informacje szczegółowe</h3>
        	<table>
                <tr>
                    <td>Tytuł:</td>
                    <td>${book.title}</td>
                </tr>
                <tr>
                	<td>Autor:</td>
                	<td>${book.author}</td>
                </tr>
                <tr>
                	<td>Kategoria:</td>
                	<td>${book.bookCategory}</td>
                </tr>
                <tr>
                	<td>Rok:</td>
                	<td>${book.year}</td>
                </tr>
            </table>
            <form method="GET" action="/books/form">
            <input type="hidden" name="id" value="${book.id}">
            	<input type="submit" value="edytuj książkę" >
            </form>
            <form method="GET" action="/books/delete/${book.id}">
            	<input type="submit" value="usuń ksiązkę" >
            </form>
            <c:choose>
            	<c:when test = "${book.available == true}">//do przemyslenia request param
            		<form method="POST" action="/reservations/user/random">
            			<input type="hidden" name="bookId" value="${book.id}">
                    	<input type="submit" value="wypożycz ksiązkę" >
                    </form>
            	</c:when>
                <c:otherwise>
                	<form method="POST" action="/reservations/return">
                	    <input type="hidden" name="bookId" value="${book.id}">
                        <input type="submit" value="oddaj ksiązkę" >
                    </form>
                </c:otherwise>
            </c:choose>
    </body>
</html>