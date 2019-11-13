<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<title>Connexion</title>
</head>
<body>

<%@ include file="navbarVisiteurs.jsp" %>

	<div class="card text-center">
  		<div class="card-header">
  			<strong>Connexion</strong>	
  		</div>
  		<div class="card-body">
			<form method="post">
				<br>
				<label for ="identifiant">Identifiant : </label>
				  <input type="text" name="ID" required>
				<br>
				<br>
				<label for ="MDP">Mot de passe : </label>
					<input type="password" name="MDP" required>
				<br>
				
			
				<div>
					<br>
					<button type="submit">Se connecter</button>
					<br>
					<br>
					<input type="checkbox" id="connexion" name="connexion"><label for="connexion">Se souvenir de moi</label>
					<br>
					<a href="/ibaie/ServletMdpOublie">Mot de passe oublié</a>
					<br>
					<br>
				</div>
			</form>
		</div>
		
		<div class="card-footer">
					<a href="<%=request.getContextPath()%>/sInscrire.jsp">
						<button type="button">Créer un compte</button>
					</a>
		</div>		
	</div>
	
</body>
</html>