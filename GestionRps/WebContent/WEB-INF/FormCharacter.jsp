<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="formCharacter.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="Navbar.jsp" %>
<form action="FormCharacter" method="post">
<div>
	<input type="submit" name="formAdd" value="Ajouter">
	<input type="submit" name="formEdit" value="Edit">
	<input type="submit" name="formDelete" value="Delete">
</div>
	${ nbList }
	<select name="idChara">
		<c:forEach  var="i" begin="0" end="${ nbList }" varStatus="status">
			<option value="${ list[i].idCharacterc }">
				<c:out value="${ list[i].nom }"></c:out>
			</option>
		</c:forEach>
	</select>
	
  <h1>Personnage</h1>
  <h2>Caracteristique</h2>
    <label>Nom:</label>   <input name="CharaPri" type="text" value="${ charaEdit.nom }">
  Mana:  <input name="CharaPri" type="text" value="${ charaEdit.mana }">
  <label>Stress:<input name="CharaPri" type="text" value="${ charaEdit.stress }"></p>
  <table>
    <tr>
      <th>Force</th>
      <th>Constitution</th>
      <th>Dexterite</th>
      <th>Perception</th>
      <th>Courage</th>
    </tr>
    <tr>
      <td><input name="chara" type="number" value="${ charaEdit.forTce }"></td>
      <td><input name="chara" type="number" value="${ charaEdit.constitution }"></td>
      <td><input name="chara" type="number" value="${ charaEdit.dexterite }"></td>
      <td><input name="chara" type="number" value="${ charaEdit.perception }"></td>
      <td><input name="chara" type="number" value="${ charaEdit.courage }"></td>
    </tr>
  </table>
  <h2>Competence</h2>
  <div class=competence>
  <p>Nom <input type="text"></p>
  <p>De <input type="text"></p>
  <p>Description</p>
    <textarea cols=150 row=150></textarea>
  </div>
  ${ sessionScope.formEdit } ttt
  <c:if test="${sessionScope.formEdit != null && sessionScope.formEdit == 0 }">
  <input type="submit" name="envoie" value ="Envoyer">
  </c:if>
  
  <c:if test="${sessionScope.formEdit == 1 }">
  <input type="submit" name="edit" value ="Edit">
  </c:if>
  
  <c:if test="${sessionScope.formEdit == 2 }">
  <input type="submit" name="delete" value ="Delete">
  </c:if>
  
  </form>
</body>
</html>