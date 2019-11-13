<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/MiseEnPage.css">
<meta charset="UTF-8">
<title>Bienvenue sur iBaie</title>
</head>
<body>

	<!-- Barre navigation haut page Accueil -->
  
   <%@ include file="navBarUtilisateurConnecte.jsp" %>
    
   
  	<!-- Zone de recherches par filtres -->
 
 	<div class="container">

		  <h4>Filtrer la recherche : </h4>
		<div class="input-group col-4">
		  	<input type="text" id="SearchBar" placeholder="Nom de l'article">
		
		<form action="method">
	  		<input type="radio" name="AchatouVente" value="achat"> Achat<br>
	  			<ul>
	  				<li><input type="checkbox" name="encheresOuvertes" value="encheresOuvertes"> Enchères ouvertes</li>
	  				<li><input type="checkbox" name="encheresEnCours" value="encheresEnCours"> Mes enchères en cours</li>
	  				<li><input type="checkbox" name="encheresRemportees" value="encheresRemportees"> Mes enchères remportées</li>
	  			</ul>
	  		<input type="radio" name="AchatouVente" value="vente"> Mes ventes<br>
	  			<ul>
	  				<li><input type="checkbox" name="ventesEnCours" value="ventesEnCours"> Mes ventes en cours</li>
	  				<li><input type="checkbox" name="ventesNonDebutees" value="ventesNonDebutees"> Mes ventes non-débutées</li>
	  				<li><input type="checkbox" name="ventesTerminees" value="ventesTerminees"> Mes ventes terminées</li>
	  			</ul>
	  	</form>
		</div>
			  <br>
			  <select name="categorie">
			  <option selected> Toutes les catégories
			  <option> Informatique
			  <option> Ameublement
			  <option> Vêtements
			  <option> Sport et Loisirs
			  </select>
			  <br>
			  <br>
			  <button>Rechercher</button>
		
		
	</div>	
 
  <br>
  
  <!-- Listing des enchères -->
 
  
  <h3 style="text-align:center">Liste des enchères</h3>

		<div class="container">
		  <div class="row">
		    <div class="col-lg-4 col-sm-6 col-xs-12">
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
		
		    <div class="col-lg-4 col-sm-6 col-xs-12">
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
		    <div class="col-lg-4 col-sm-6 col-xs-12">
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
		    <div class="col-lg-4 col-sm-6 col-xs-12">
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
		    <div class="col-lg-4 col-sm-6 col-xs-12">
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
		    <div class="col-lg-4 col-sm-6 col-xs-12">
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