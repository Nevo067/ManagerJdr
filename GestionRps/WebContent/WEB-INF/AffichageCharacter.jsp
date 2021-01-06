<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Character</h1>
createListCharacter(request, ses);

<c:forEach var="i" begin="0" end="${ numberOfList }">
<p>
	${ chara[i].nom }
	${ chara[i].idCharacterc }
	btn${ chara[i].idCharacterc } 
</p>
<table>
	<tr>
		<th>Force</th>
      <th>Constitution</th>
      <th>Dexterite</th>
      <th>Perception</th>
      <th>Courage</th>
	</tr>
	<tr>
		<td>${ chara[i].forTce }</td>
		<td>${ chara[i].constitution }</td>
		<td>${ chara[i].dexterite }</td>
		<td>${ chara[i].perception }</td>
		<td>${ chara[i].courage }</td>  
	</tr>
</table>
<form action=<c:url value="/FormCharacter"/> method="Post">

<input name="btn${ chara[i].idCharacterc }" type="submit" value="Edit">
</form>
</c:forEach>
</body>
</html>