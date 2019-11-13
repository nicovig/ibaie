<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<title>Ré-initialiser le mot de passe</title>
</head>
<body>

<%@ include file="navbarVisiteurs.jsp" %>

	<div class="card text-center">
  		<div class="card-header">
  			<strong>Mot de passe oublié ?</strong>	
  		</div>
  		<div class="card-body">
			<form method="post">
				<p>Pour récupérer votre mot de passe, veuillez saisir l'adresse mail associée à votre compte. </p>
				
				<br>
				E-mail : <input type="email" name="email" required>
				<br>
			</form>
		</div>
		<div class="card-footer">	
				<br>
			<a href="<%=request.getContextPath()%>/ServletMdpOublie">		
				<button type="submit">Envoyer</button>
			</a>
		</div>
	</div>

</body>
</html>