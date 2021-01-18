<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="Navbar.jsp" %>
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
	        <input type="submit" name ="Load"/>
	    </div>
	    <div name="Result">
	        <c:forEach  var="i" begin="0" end="${ nbDice }" varStatus="status">
	        <p> ${ charaFight[i%2].nom } : ${ listVal[i] } </p>
	        	<c:if test="${ ((i%2) == 1 && listVal[i] != null)}">
		        		<c:choose>
		        		
		        		<c:when test="${ (listVal[i] > listVal[(i-1)]) }">
		        			<p>${ listChara[(i-1)%1].nom } gagne</p>
		        		</c:when>
		        		<c:when test="${ (listVal[i] < listVal[(i-1)]) }">
		        				<p>${ listChara[i%2].nom } gagne</p>
		        		</c:when>
		        		<c:when test="${ (listVal[i] == listVal[(i-1)]) }">
		        			<p>Egalite</p>
		        		</c:when>
		        		<c:otherwise>
				            No comment sir...
				         </c:otherwise>
		        	</c:choose>	
	        	</c:if>
	        </c:forEach>
	    </div>
	    <div name="option">
	        <input type="submit" name="dice" value="Lancer un dao" />
	    </div>
    </form>
</body>
</html>