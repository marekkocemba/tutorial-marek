<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
	</head>
    <body>
    	<c:choose>
        	<c:when test = "${not empty reservation}">
        		<h3>Książka wypożyczona użytkownikowi: "${reservation.user.name} ${reservation.user.surname}"</h3>
        	</c:when>
        	<c:otherwise>
        		<h3>Książka oddana</h3>
        	</c:otherwise>
        </c:choose>
        <form method="GET" action="/books">
                <input type="submit" value="pokaż listę książek" >
        </form>
    </body>
</html>