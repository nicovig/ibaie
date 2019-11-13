<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Déconnexion</title>
</head>
<body>

<%@ include file="navBarUtilisateurConnecte.jsp" %>

<div style="text-align:center">
	<p> Souhaitez-vous vraiment vous déconnecter ?</p>
	
	<form method="post">
		<button type="submit">Déconnexion</button>
	</form>
	
	<a href="<%=request.getContextPath()%>/ServletCompteUtilisateur">
		<button type="button">Annuler</button>
	</a>
</div>
</body>
</html>