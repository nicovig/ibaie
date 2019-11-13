<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier mon profil</title>
</head>
<body>

<!-- Barre navigation haut page Accueil -->
  
<%@ include file="navBarUtilisateurConnecte.jsp" %>

<!-- Modification des informations utilisateur -->

	
	<div class="card text-center">
	  <div class="card-header">
	  	<strong>Mon profil</strong>
	  	<br>
	  </div>
	  <div class="card-body">	
		<form method="post">
				<br>
				<p>Pseudo :  <input type="text" name="ID" pattern="[a-zA-Z0-9]{1,}" value="${ u.getPseudo() }" required>
				Nom :  <input type="text" name="nom" value="${ u.getNom()}" required></p>
				<br>
				<p>Prénom :  <input type="text" name="prenom" value="${ u.getPrenom() }" required>
				Email : <input type="email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" value="${ u.getEmail() }" required></p>
				<br>
				<p>Telephone :  <input type="text" name="telephone" value="${ u.getTelephone() }" required>
				Rue : <input type="text" name="rue" value="${ u.getRue() }" required></p>
				<br>
				<p>Code Postal :  <input type="text" name="CP" value="${ u.getCodePostal() }" required>
				Ville : <input type="text" name="ville" value="${ u.getVille() }" required></p>
				<br>
				<p>Mot de passe actuel : <input type="password" name="MDPActuel" value="${ u.getMotDePasse() }" required></p>			
				<br>
				<p>Nouveau mot de passe :  <input type="password" name="MDPNouveau">
				Confimation : <input type="password" name="MDPverif"></p>
				<br>
				<p>Crédit : ${ u.getCredit() }</p>
			
				<button type="submit">Modifier</button>
				
				<br>
				<br>
				<a href="<%=request.getContextPath()%>/ServletCompteUtilisateur"> 
					<button type="button">Retour à l'accueil</button>
				</a>
				<a href="<%=request.getContextPath()%>/ServletSuppressionCompte"> 
					<button type="button">Supprimer mon compte</button>
				</a>		
		</form>
	  </div>
	</div>
</body>
</html>

