<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<title>Mon profil</title>
</head>
<body>

<!-- Barre navigation haut page Accueil -->
  
   <%@ include file="navBarUtilisateurConnecte.jsp" %>
	
<!-- Informations du profil -->

<div class="card text-center">
  <div class="card-header">
  	<strong>Mon profil</strong>
  </div>
  <div class="card-body">
		Pseudo : ${u.getPseudo()} <br>
		
		Nom :  ${u.getNom()} <br>
		
		Prénom :  ${u.getPrenom()} <br>
		
		Email :  ${u.email} <br>
		
		Telephone :  ${ u.getTelephone()} <br>
		
		Rue :  ${ u.getRue() } <br>
		
		Code Postal : ${ u.getCodePostal() } <br>
		
		Ville :  ${ u.getVille() } <br>
	</div>
	<div class="card-footer">
		<a href="<%=request.getContextPath()%>/ServletModificationProfil">	
			<button type="button">Modifier</button>
		</a>
	</div>
</div>
</body>
</html>

