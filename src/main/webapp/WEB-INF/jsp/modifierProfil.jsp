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
<link rel="stylesheet" href="modifierprofil.css">

</head>

<body>

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

	<form action="newuser" method="POST" class="formulaire">
		<h2>Modifiez votre profil</h2>
		<div class="container">
			<div class="flex-outer">
				<input class="input" type="text" name="pseudo"
					value="${user.pseudo}" placeholder="Pseudo">
				<input class="input" type="text" name="nom" value="${user.nom}"
					placeholder="Nom">
				<input class="input" type="text" name="prenom"
					value="${user.prenom}" placeholder="Prénom">
				<input class="input" type="text" name="email" value="${user.email}"
					placeholder="Mail">
				<input class="input" type="tel" name="telephone"
					value="${user.telephone}" placeholder="Téléphone">
				<input class="input" type="text" name="rue" value="${user.rue}"
					placeholder="N° et Rue">
				<input class="input" type="text" name="codePostal"
					value="${user.code_postal}" placeholder="Code Postal">
				<input class="input" type="text" name="ville" value="${user.ville}"
					placeholder="Ville">
				<input class="input" type="password" name="mot_de_passe"
					placeholder="Mot de Passe">
				<input class="input" type="password" name="new_mot_de_passe"
					placeholder="Nouveau mot de passe">
				<input class="input" type="password"
					name="new_mot_de_passe_confirmation"
					placeholder="Confirmez le nouveau mot de passe">
				<div class="credit">
					<br/><p>Vos Crédit : ${user.credit}points</p>
				</div>
			</div>

		</div>
		<div class="btn">
			<input class="btn_enregistrer" type="submit" name="enregistrer"
				value="Enregistrer"> <br/>
			<input class="btn_supprimer"
				type="submit" name="supprimerUser" value="Supprimer mon compte">
		</div>
	</form>

</body>
</html>