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
<title>Enchere et en os !</title>

</head>

<body>

<%@ include file = "navbar.jsp" %>

  <div id="cont1" class="cont1 container-fluid">
	<img src="img/LOGO_sans_titre.png"alt="logo">
	<h1>ENCHERE ET EN OS</h1>
  </div>

	<c:if test="${ !empty sessionScope.user}">
		<p>Vous êtes connecté en temps que : ${sessionScope.user.pseudo}!</p>
	</c:if>

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

<div id="cont2" class="cont2 container-fluid">

	<c:choose>
		<c:when test="${empty sessionScope.user}">
			<h2 class="titre">Liste des enchères</h2>
			<form action="Index" method="post">
				<div class="cont_rech">
					<div class="left_cont_rech">
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
			<h2 class="titre">Liste des enchères</h2>
			<form action="Index" method="post">
				<div class="cont_rech">
					<div class="left_cont_rech">
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

	<section class="article d-inline-flex">
		<div class="card mb-3" style="max-width: 540px;">
			<div class="row g-0">
				<div class="col-md-4">
					<img src="..." class="img-fluid rounded-start" alt="...">
				</div>
				<div class="col-md-8">
					<div class="card-body">
						<h5 class="card-title">Card title</h5>
						<p class="card-text">This is a wider card with supporting text
							below as a natural lead-in to additional content. This content is
							a little bit longer.</p>
						<p class="card-text">
							<small class="text-muted">Last updated 3 mins ago</small>
						</p>
					</div>
				</div>
			</div>
		</div>
		<div class="card mb-3" style="max-width: 540px;">
			<div class="row g-0">
				<div class="col-md-4">
					<img src="..." class="img-fluid rounded-start" alt="...">
				</div>
				<div class="col-md-8">
					<div class="card-body">
						<h5 class="card-title">Card title</h5>
						<p class="card-text">This is a wider card with supporting text
							below as a natural lead-in to additional content. This content is
							a little bit longer.</p>
						<p class="card-text">
							<small class="text-muted">Last updated 3 mins ago</small>
						</p>
					</div>
				</div>
			</div>
		</div>
		<div class="card mb-3" style="max-width: 540px;">
			<div class="row g-0">
				<div class="col-md-4">
					<img src="..." class="img-fluid rounded-start" alt="...">
				</div>
				<div class="col-md-8">
					<div class="card-body">
						<h5 class="card-title">Card title</h5>
						<p class="card-text">This is a wider card with supporting text
							below as a natural lead-in to additional content. This content is
							a little bit longer.</p>
						<p class="card-text">
							<small class="text-muted">Last updated 3 mins ago</small>
						</p>
					</div>
				</div>
			</div>
		</div>
		<div class="card mb-3" style="max-width: 540px;">
			<div class="row g-0">
				<div class="col-md-4">
					<img src="..." class="img-fluid rounded-start" alt="...">
				</div>
				<div class="col-md-8">
					<div class="card-body">
						<h5 class="card-title">Card title</h5>
						<p class="card-text">This is a wider card with supporting text
							below as a natural lead-in to additional content. This content is
							a little bit longer.</p>
						<p class="card-text">
							<small class="text-muted">Last updated 3 mins ago</small>
						</p>
					</div>
				</div>
			</div>
		</div>
	</section>

</body>

</html>