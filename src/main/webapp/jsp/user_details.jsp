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
                    <td>Imie:</td>
                    <td>${user.name}</td>
                </tr>
                <tr>
                	<td>Nazwisko:</td>
                	<td>${user.surname}</td>
                </tr>
                <tr>
                	<td>Email:</td>
                	<td>${user.email}</td>
                </tr>
                <tr>
                	<td>Telefon:</td>
                	<td>${user.telephone}</td>
                </tr>
            </table>
            <form method="GET" action="/users/form">
            	<input type="hidden" name="id" value="${user.id}">
            	<input type="submit" value="edytuj użytkownika" >
            </form>
            <form method="GET" action="/users/delete/${user.id}">
            	<input type="submit" value="usuń użytkownika" >
            </form>
    </body>
</html>