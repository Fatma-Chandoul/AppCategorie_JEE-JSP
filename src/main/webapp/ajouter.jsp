<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Ajouter un produit</h1>
<form action="Save" method="get">
<p>Titre: <input type="text" name="titre"></p>
<p>Prix: <input type="text" name="prix"></p>
<p>Categorie: <select  name="cat">
<c:forEach items="${cats }" var="c">
<option value="${c.id }">${c.titre }</option>
</c:forEach>
</select>
</p>
<p><input type="submit"></p>
</form>
</body>
</html>