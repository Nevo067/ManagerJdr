<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="form.css" >
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${ut.login }
${ut.password}
<h1>Inscription</h1>
<p>Page vous permettant de s'inscrire sur le site</p>
<form action="inscription" method = "POST">
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
<p>

${ resultat }

${ login }

${ password }
</p>
</body>
</html>