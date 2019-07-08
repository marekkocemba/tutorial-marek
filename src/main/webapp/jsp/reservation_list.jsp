<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
	</head>
	<body>
		<a href="/index.html"> Powrót do index-u </a> <br>
		<h3>Lista wypozyczeń</h3>
		<c:choose>
			 <c:when test = "${not empty reservationList}">
			 	<c:forEach items="${reservationList}" var="reservation">
             ${reservation.book.title} ${reservation.book.author} wypozyczony przez  ${reservation.user.name} ${reservation.user.surname}
             	</c:forEach>
			 </c:when>
			 <c:otherwise>
             Brak wypozyczen
             </c:otherwise>
         </c:choose>
    </body>
</html>