<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action ="UtilisateurPageServlet" method="post">
	<p><label>Login</label>
		${ sessionScope.login }
		<label>login</label>
		<input name="login" type="text">
	</p>
	<p>
		<label>Mot de passe</label>
		<input name="mdp" type="text">
	</p>
	<input type ="submit" name="reset"value="Changer vos identifiant">
	
</form>
<c:if test="${ isChanged }">
<p>
Vos identifiants sont changes
</p>
	
</c:if>
</body>
</html>