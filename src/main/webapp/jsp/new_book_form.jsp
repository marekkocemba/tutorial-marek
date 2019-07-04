<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <h3>Dodaj książke</h3>
        <form:form method="POST" action="/books" modelAttribute="book">
             <table>
                <tr>
                    <td><form:label path="title">Tytuł</form:label></td>
                    <td><form:input path="title"/></td>
                    <td class='error'><form:errors path="title"/></td>
                </tr>
                <tr>
                    <td><form:label path="author">Autor</form:label></td>
                    <td><form:input path="author"/></td>
                    <td class='error'><form:errors path="author"/></td>
                </tr>
                <tr>
                    <td><form:label path="bookCategory">Kategoria</form:label></td>
                    <td>
                    	<form:select path="bookCategory">
                    	   <option value="SAMPLE_CAT" selected>(sample cat)</option>
                           <option value="SAMPLE_CAT">sample</option>
                    	</form:select>
                    </td>
                    <td class='error'><form:errors path="bookCategory"/></td>
                </tr>
                <tr>
                	<td><form:label path="year">Rok wydania</form:label></td>
                	<td><form:input path="year"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>