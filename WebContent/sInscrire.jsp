<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Créer un compte</title>

</head>
<body>

  <!-- Barre navigation haut page Accueil -->
  
	<%@include file="navbarVisiteurs.jsp" %>
	

	<div class="card text-center">
  		<div class="card-header">
			<strong>Créer un compte</strong>
		</div>
		<div class="card-body">
		
		<c:if test = "${ userM.verifPseudo(request) }">
			<p><c:out value="Le pseudo est déjà utilisé, merci d'en choisir un autre." /></p>
		</c:if>
		
		<c:if test = "${ userM.verifEmail(request) }">
			<p><c:out value="L'adresse mail existe déjà dans notre liste d'inscrits." /></p>
		</c:if>
	
			<form method="post" id="form_user">
				<div class="row">
				Pseudo :  <input type="text" name="ID" required pattern="[a-zA-Z0-9]{1,}">

				Nom :  <input type="text" name="nom" required>
				<br>
				Prénom :  <input type="text" name="prenom" required>
				Email : <input type="email" name="email" required>
				<br>
				Telephone :  <input type="text" name="telephone" required>
				Rue : <input type="text" name="rue" required>
				<br>
				Code Postal :  <input type="text" name="CP" required>
				Ville : <input type="text" name="ville" required>
				<br>
				Mot de passe :  <input type="password" name="MDP" required>
				Confimation : <input type="password" name="MDPverif" required>
				<br>
			
		</div>	
		<div class="card-footer">	
				
				<button type="submit" form="form_user">Valider</button>
				
				
				<br>
				
				<a href="<%=request.getContextPath()%>/Accueil"> 
					<button type="button">Annuler</button>
				</a>
		</div>
		</form>			
		</div>
	</div>
</body>
</html>