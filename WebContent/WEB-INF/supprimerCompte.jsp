<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ include file="navBarUtilisateurConnecte.jsp" %>

<div style="text-align:center">
	<p> Êtes-vous sur de vouloir nous quitter ? </p>
	
	<form method="post">
		<button type="submit">Oui !</button>
	</form>
	
	<a href="<%=request.getContextPath()%>/ServletCompteUtilisateur">
		<button type="button">Non !</button>
	</a>
</div>

</body>
</html>