<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
	</head>
    <body>
    	<a href="/index.html"> Powrót do index-u </a> <br>
        <h3>Książka dodana/zmodyfikowana</h3>
        <form method="GET" action="/books/form">
                <input type="submit" value="dodaj ksiązkę" >
        </form>
        <form method="GET" action="/books">
                <input type="submit" value="pokaż listę książek" >
        </form>
    </body>
</html>