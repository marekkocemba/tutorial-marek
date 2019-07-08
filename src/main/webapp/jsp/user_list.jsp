<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
	</head>
	<body>
		<a href="/index.html"> Powrót do index-u </a> <br>
		<h3>Lista użytkowników</h3>
		<c:choose>
			 <c:when test = "${not empty userList}">
			 	<c:forEach items="${userList}" var="user">
                	<a href="/users/${user.id}"> ${user.name} || ${user.surname} || ${user.email} ||  ${user.telephone} </a> <br>
             	</c:forEach>
			 </c:when>
			 <c:otherwise>
             Brak użytkowników w bazie
             </c:otherwise>
         </c:choose>
         <form method="GET" action="/users/form">
         	<input type="submit" value="dodaj użytkownika" >
         </form>
    </body>
</html>