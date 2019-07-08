<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <h3>Dodaj/Edytuj użytkownika</h3>
        	<form:form method="POST" action="/users" modelAttribute="user">
             <table>
                <tr>
                    <td><form:label path="name">Imie</form:label></td>
                    <td><form:input path="name"/></td>
                    <td class='error'><form:errors path="name"/></td>
                </tr>
                <tr>
                    <td><form:label path="surname">Nazwisko</form:label></td>
                    <td><form:input path="surname"/></td>
                    <td class='error'><form:errors path="surname"/></td>
                </tr>
                <tr>
                    <td><form:label path="email">Email</form:label></td>
                    <td><form:input path="email"/></td>
                    <td class='error'><form:errors path="email"/></td>
                </tr>
                <tr>
                	<td><form:label path="telephone">Telefon</form:label></td>
                    <td><form:input path="telephone"/></td>
                </tr>
                <tr>
                	<td><form:hidden path="id" /></td>
                    <td><input type="submit" value="OK"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>