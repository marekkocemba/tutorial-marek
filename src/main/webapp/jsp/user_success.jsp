<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
	</head>
    <body>
    	<a href="/index.html"> Powrót do index-u </a> <br>
        <h3>Użytkownik dodany/zmodyfikowany</h3>
        <form method="GET" action="/users/form">
                <input type="submit" value="dodaj użytkownika" >
        </form>
        <form method="GET" action="/users">
                <input type="submit" value="pokaż listę użytkowników" >
        </form>
    </body>
</html>