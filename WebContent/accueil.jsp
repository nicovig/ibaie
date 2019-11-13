<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/MiseEnPage.css">
<title>Bienvenue sur Ibaie</title>
</head>
<body>
  
  <!-- Barre navigation haut page Accueil -->
  
   <%@ include file="navbarVisiteurs.jsp" %>
  

  
  <!-- Contenu page web -->
  
  <h3 style="text-align:center">Liste des enchères</h3>
  
  <!-- Zone de recherches par filtres -->
	 <div class="container">
		  <h4>Filtrer la recherche : </h4>
		 <div class="input-group col-4">
		  	<input type="text" id="SearchBar" placeholder="Nom de l'article">
		 </div>
		  <br>
		 <div>
		  <select name="categorie">
		  <option selected> Toutes les catégories
		  <option> Informatique
		  <option> Ameublement
		  <option> Vêtements
		  <option> Sport & Loisirs
		  </select>
		 </div>
		  <br>
		 <div>
		  <button>Rechercher</button>
		 </div>
	</div>	
  <br>
  
  <!-- Listing des enchères -->

<div class="container">
  <div class="row">
    <div class="col-lg-6  col-xs-12">
    	<div class="card" style="width: 18 rem frame: 2px;" >
		  	<img class="card-img-top" src="css/img/logo.png" alt="Card img cap">
		  	<div class="card-body">
		  	<h5 class="card-title" a href="lienVersLAnnonce">Titre de l'article</h5>
		  	<p>Prix : + parametre prixVente</p>
		  	<p>Fin de l'enchère : + parametre dateFinEncheres</p>
		  	<p>Vendeur : + parametre pseudo</p>
		 	</div>
		  </div>
    </div>
    <div class="col-lg-6 col-xs-12">
    	<div class="card" style="width: 18 rem frame: 2px;" >
		  	<img class="card-img-top" src="css/img/logo.png" alt="Card img cap">
		  	<div class="card-body">
		  	<h5 class="card-title" a href="lienVersLAnnonce">Titre de l'article</h5>
		  	<p>Prix : + parametre prixVente</p>
		  	<p>Fin de l'enchère : + parametre dateFinEncheres</p>
		  	<p>Vendeur : + parametre pseudo</p>
		 	</div>
		  </div>
    </div>
    <div class="col-lg-6 col-xs-12">
    	<div class="card" style="width: 18 rem frame: 2px;" >
		  	<img class="card-img-top" src="css/img/logo.png" alt="Card img cap">
		  	<div class="card-body">
		  	<h5 class="card-title" a href="lienVersLAnnonce">Titre de l'article</h5>
		  	<p>Prix : + parametre prixVente</p>
		  	<p>Fin de l'enchère : + parametre dateFinEncheres</p>
		  	<p>Vendeur : + parametre pseudo</p>
		 	</div>
		  </div>
    </div>
    <div class="col-lg-6 col-xs-12">
    	<div class="card" style="width: 18 rem frame: 2px;" >
		  	<img class="card-img-top" src="css/img/logo.png" alt="Card img cap">
		  	<div class="card-body">
		  	<h5 class="card-title" a href="lienVersLAnnonce">Titre de l'article</h5>
		  	<p>Prix : + parametre prixVente</p>
		  	<p>Fin de l'enchère : + parametre dateFinEncheres</p>
		  	<p>Vendeur : + parametre pseudo</p>
		 	</div>
		  </div>
    </div>
    <div class="col-lg-6 col-xs-12">
    	<div class="card" style="width: 18 rem frame: 2px;" >
		  	<img class="card-img-top" src="css/img/logo.png" alt="Card img cap">
		  	<div class="card-body">
		  	<h5 class="card-title" a href="lienVersLAnnonce">Titre de l'article</h5>
		  	<p>Prix : + parametre prixVente</p>
		  	<p>Fin de l'enchère : + parametre dateFinEncheres</p>
		  	<p>Vendeur : + parametre pseudo</p>
		 	</div>
		  </div>
    </div>
    <div class="col-lg-6 col-xs-12">
    	<div class="card" style="width: 18 rem frame: 2px;" >
		  	<img class="card-img-top" src="css/img/logo.png" alt="Card img cap">
		  	<div class="card-body">
		  	<h5 class="card-title" a href="lienVersLAnnonce">Titre de l'article</h5>
		  	<p>Prix : + parametre prixVente</p>
		  	<p>Fin de l'enchère : + parametre dateFinEncheres</p>
		  	<p>Vendeur : + parametre pseudo</p>
		 	</div>
		  </div>
    </div>
 </div>

<nav aria-label="Page navigation" style="text-align:center">
  <ul class="pagination">
    <li>
      <a href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li>
      <a href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>

</body>
</html>