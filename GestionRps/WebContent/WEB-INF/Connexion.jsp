<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Connexion</h1>
<p>Page Vous permettant de vous connecter</p>
<form action="Connexion" method = "POST">
<fieldset>
	<legend>Formulaire</legend>
	<label for="login">Login</label>
	<br>
	<input type="text" id="login" name="login" size=20>
	<br>
	
	<label for="password">Password</label>
	<br>
	<input type="text" id="password" name="password" size=20>
	<br>
	<input type="submit">
</fieldset>
</form>
<c:if test="${sessionScope.isConnected}">
<p>Vous etes connectez</p>
</c:if>
<p>${erreur}</p>

</body>
</html>