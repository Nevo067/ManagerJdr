<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="formCharacter.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="FormCharacter" method="post">
  <h1>Personnage</h1>
  <h2>Caracteristique</h2>
    <label>Nom:</label>   <input name="CharaPri" type="text">
  Mana:  <input name="CharaPri" type="text">
  <label>Stress:<input name="CharaPri" type="text"></p>
  <table>
    <tr>
      <th>Force</th>
      <th>Constitution</th>
      <th>Dexterite</th>
      <th>Perception</th>
      <th>Courage</th>
    </tr>
    <tr>
      <td><input name="chara" type="number"></td>
      <td><input name="chara" type="number"></td>
      <td><input name="chara" type="number"></td>
      <td><input name="chara" type="number"></td>
      <td><input name="chara" type="number"></td>
    </tr>
  </table>
  <h2>Competence</h2>
  <div class=competence>
  <p>Nom <input type="text"></p>
  <p>De <input type="text"></p>
  <p>Description</p>
    <textarea cols=150 row=150></textarea>
  </div>
  <input type="submit" value ="Envoyer"></submit>
  </form>
</body>
</html>