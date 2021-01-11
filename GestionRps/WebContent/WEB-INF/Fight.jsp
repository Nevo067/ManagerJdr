<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="FightServlet" method="POST">
	    <div>
	        <select name="chara1">
		        <c:forEach  var="i" begin="0" end="${ nbList }" varStatus="status">
		            <option value="${listChara[i].idCharacterc}">${listChara[i].nom}</option>
		        </c:forEach>
	        </select>
	        <select name="chara2">
	            <c:forEach  var="i" begin="0" end="${ nbList }" varStatus="status">
	            	<option value="${listChara[i].idCharacterc}">${listChara[i].nom}</option>
	        	</c:forEach>
	        </select>
	        <input type="button" name ="Load"/>
	    </div>
	    <div name="Result">
	        <c:forEach  var="i" begin="0" end="${ nbDice }" varStatus="status">
	        	<p>${ listVal[i] }</p>
	        </c:forEach>
	    </div>
	    <div name="option">
	        <input type="submit" name="dice" value="Lancer un dao" />
	    </div>
    </form>
</body>
</html>