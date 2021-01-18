<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="navbar.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<ul>
	<li><a href="<c:url value="inscription"/>">Inscription</a></li>
	<li><a href="<c:url value="Connexion"/>">Connexion</a></li>
	
	<c:if test="${sessionScope.isConnected}">
		<li><a href="<c:url value="/FormCharacter"/>">Creation de personnage</a></li>
		<li><a href="<c:url value="/ListCharacterServlet"/>">Liste de personnage</a></li>
		<li><a href="<c:url value="/UtilisateurPageServlet"/>">Page d'utilisateur</a></li>
		<li><a href="<c:url value="/FightServlet"/>">Play</a></li>
	</c:if>
</ul>
</body>
</html>