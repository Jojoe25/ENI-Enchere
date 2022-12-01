<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="fr.eni.ENIEnchere.bo.Utilisateur"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Modification du profil</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="style.css">

</head>

<body>

<h2 class="titre"> Modifier votre profil </h2>

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

<form class="form" action="modifierProfil" method="POST">
		<div class="container">
			<ul class="flex-outer">
				<li>
					<label class="label">Pseudo :</label> <input class="input"
						type="text" name="pseudo" value="${user.pseudo}"><br>
				</li>
				<li>
					<label class="label">Prénom :</label> <input class="input"
						type="text" name="prenom" value="${user.prenom}"><br>
				</li>
				<li>
					<label class="label">Téléphone :</label> <input class="input"
						type="text" name="telephone" value="${user.telephone}"><br>
				</li>
				<li>
					<label class="label">Code Postal :</label> <input class="input"
						type="text" name="codePostal" value="${user.code_postal}"><br>
				</li>

				<li>
					<label class="label">Nom :</label> <input class="input" type="text"
						name="nom" value="${user.nom}"><br>
				</li>
				<li>
					<label class="label">Email :</label> <input class="input"
						type="text" name="email" value="${user.email}"><br>
				</li>
				<li>
					<label class="label">Rue :</label> <input class="input" type="text"
						name="rue" value="${user.rue}"><br>
				</li>
				<li>
					<label class="label">Ville :</label> <input class="input"
						type="text" name="ville" value="${user.ville}"><br>
				</li>
				<li>
					<label class="label">Mot de passe actuel:</label> <input class="input"
						type="password" name="mot_de_passe"><br>
				</li>
								<li>
					<label class="label">Nouveau mot de passe:</label> <input class="input"
						type="password" name="new_mot_de_passe"><br>
				</li>
				<li>
					<label class="label">Confirmation :</label> <input class="input"
						type="password" name="new_mot_de_passe_confirmation"><br>
				</li>
				<li class="credit">
					<p>Vos Crédit : ${user.credit}points </p>
				</li>
			</ul>
			
		</div>
		<div class="btn">
			<input class="btn_enregistrer" type="submit" name="enregistrer" value="Enregistrer">
			<input class="btn_supprimer" type="submit" name="supprimerUser" value="Supprimer mon compte">
		</div>
</form>

</body>
</html>