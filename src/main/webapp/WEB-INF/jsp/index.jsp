<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="fr.eni.ENIEnchere.bo.Utilisateur"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="index.css">
<link rel="stylesheet" href="nav1.css">
<title>Enchere et en os !</title>

</head>

<body>

<%@ include file = "navbar.jsp" %>

  <div id="cont1" class="cont1 container-fluid">
	<a href="Index"><img src="img/LOGO_sans_titre.png"alt="logo"></a>
	<h1>ENCHERE ET EN OS</h1>
  </div>


	<c:if test="${!empty listeCodesErreur}">
		<div class="alert alert-danger" role="alert">
			<strong>Erreur!</strong>
			<ul>
				<c:forEach var="code" items="${listeCodesErreur}">
					<li>${LecteurMessage.getMessageErreur(code)}</li>
				</c:forEach>
			</ul>
		</div>
	</c:if>

<div id="cont2" class="cont2 container">

	<c:choose>
		<c:when test="${empty sessionScope.user}">
			<h2 class="titre">Liste des enchères :</h2>
			<form action="Index" method="post">
				<div>
					<div>
						<div class="filtre_cat">
							<div class="filtre">
								<input class="searchTxt" type="text" name="nomArticle"
									placeholder="Le nom de l'article contient"> <img
									src="img/loupe.png" width="50" height="50" alt="Loupe">
							</div>
							<div class="desc">Catégorie :</div>
							<div class="cat">
								<select class="selectcat" name="categorie" id="categorie">
									<option value="toutes">Toutes</option>
									<option value="1">Informatique</option>
									<option value="2">Ameublement</option>
									<option value="3">Vêtement</option>
									<option value="4">Sport&Loisirs</option>
								</select>
							</div>
							<div class="search1">
								<input type="submit" name="rechercher" value="Rechercher">
							</div>
						</div>
					</div>
				</div>
			</form>
		</c:when>

		<c:otherwise>
			<h2 class="titre">Liste des enchères :</h2>
			<form action="Index" method="post">
				<div>
					<div>
						<div class="filtre_cat">
							<div class="filtre">
								<input class="searchTxt" type="text" name="nomArticle"
									placeholder="Le nom de l'article contient"> <img
									src="img/loupe.png" width="50" height="50" alt="Loupe">
							</div>
							<div class="desc">Catégorie :</div>
							<div class="cat">
								<select class="selectcat" name="categorie" id="categorie">
									<option value="toutes">Toutes</option>
									<option value="1">Informatique</option>
									<option value="2">Ameublement</option>
									<option value="3">Vêtement</option>
									<option value="4">Sport&Loisirs</option>
								</select>
							</div>
						</div>
					</div>
				</div>
				<div class="listFilter">
					<div class="achats">
						<input type="radio" name="choixFiltre" id="achats" value="achats"
							checked> <label for="achats">Achats</label>
						<div class="chekbox_cont">
							<div class="box">
								<input type="checkbox" name="encheresOuvertes"
									id="encheresOuvertes"> <label for="encheresOuvertes">Enchères
									ouvertes</label>
							</div>
							<div class="box">
								<input type="checkbox" name="encheresEnCours"
									id="encheresEnCours"> <label for="encheresEnCours">Mes
									enchères en cours</label>
							</div>
							<div class="box">
								<input type="checkbox" name="encheresRemporte"
									id="encheresRemporte"> <label for="encheresRemporte">Mes
									enchères remportées</label>
							</div>
						</div>
					</div>

					<div class="ventes">
						<input type="radio" name="choixFiltre" id="ventes" value="ventes">
						<label for="ventes">Mes ventes</label>
						<div class="chekbox_cont">
							<div class="box">
								<input type="checkbox" name="venteEnCours" id="venteEnCours">
								<label for="venteEnCours">Mes ventes en cours</label>
							</div>
							<div class="box">
								<input type="checkbox" name="venteNonDebute" id="venteNonDebute">
								<label for="venteNonDebute">Mes ventes non débutées</label>
							</div>
							<div class="box">
								<input type="checkbox" name="venteTerminer" id="venteTerminer">
								<label for="venteTerminer">Mes ventes terminées</label>
							</div>
						</div>
					</div>
				</div>
				<div class="search2">
					<input type="submit" name="rechercher" value="Rechercher">
				</div>
			</form>
		</c:otherwise>
	</c:choose>
</div>

<div id="cont3" class="cont3 container-fluid">

	<div class="row row-cols-2 row-cols-md-2 g-4">
	  <div class="col">
	    <div class="card">
	      <img src="img/Informatique.jpg" class="card-img-top" alt="...">
	      <div class="card-body">
	        <h5 class="card-title">Informatique</h5>
	        <p class="card-text">PC Gamer
PC monté par un professionnel il y a 2 ans, très bon état, remis à neuf avec alimentation neuve.
On peut fournir les boîtes de la plupart des composants, (alimentation, qui est sous-garantie</p>
	        <p class="card-prix">Prix : 590jetons</p>
			<p class="card-enchère">Fin de l'enchère: 14/12/2022</p>     
	   	    <p class="card-vendeur">Vendeur: Tartine67</p>    
	      </div>
	    </div>
	  </div>
	  <div class="col">
	    <div class="card">
	      <img src="img/Ameublement.jpg" class="card-img-top" alt="...">
	      <div class="card-body">
	        <h5 class="card-title">Ameublement</h5>
	        <p class="card-text">table à manger style industriel plateau bois foncé et pieds métal - Longueur en 160 - rallonge de 50 intégrée -
Etat neuf achetée en juillet 2021</p>
	        <p class="card-prix">Prix : 390jetons</p>
			<p class="card-enchère">Fin de l'enchère: 04/01/2022</p>     
	   	    <p class="card-vendeur">Vendeur: Juliette25</p>   
	      </div>
	    </div>
	  </div>
	  <div class="col">
	    <div class="card">
	      <img src="img/Vêtement.png" class="card-img-top" alt="...">
	      <div class="card-body">
	        <h5 class="card-title">Vêtement</h5>
	        <p class="card-text">JACK AND JONES Sweats à Capuche Miller Homme Bordeaux
Couleur:Bordeaux / Bleu Marine / Blanc
Précisions sur le produit:Logo imprimé.
60% coton 40% polyester.
Capuche doublée avec cordon.
Poignets et ourlet à côtes.</p>
	        <p class="card-prix">Prix : 90jetons</p>
			<p class="card-enchère">Fin de l'enchère: 24/12/2022</p>     
	   	    <p class="card-vendeur">Vendeur: BOBmoulin</p>   
	      </div>
	    </div>
	  </div>
	  <div class="col">
	    <div class="card">
	      <img src="img/Sport&Loisirs.jpg" class="card-img-top" alt="...">
	      <div class="card-body">
	        <h5 class="card-title">Sport&Loisirs</h5>
	        <p class="card-text">Ballon de collection (football) - ancien Cuir vintage années 50-60.</p>
	        <p class="card-prix">Prix : 1420jetons</p>
			<p class="card-enchère">Fin de l'enchère: 08/12/2022</p>     
	   	    <p class="card-vendeur">Vendeur: Dams</p>   
	      </div>
	    </div>
	  </div>
	</div>
	
</div>

</body>

</html>