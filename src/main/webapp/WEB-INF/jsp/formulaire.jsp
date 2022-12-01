<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="fr.eni.ENIEnchere.dal.messages.LecteurMessage"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">

<head>
<meta charset="utf-8">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Enchere et en os ! / Formulaire d'inscription</title>
<link rel="stylesheet" href="formulaire.css">
</head>

<body>

	<form action="newuser" method="POST" class="formulaire">
		<h2>Inscrivez-vous</h2>
		<p>En remplissant le formulaire ci-dessous</p>
		<p>
			<input type="text" name="pseudo" id="pseudo" placeholder="Pseudo"
				required><br />
		</p>
		<p>
			<input type="text" name="nom" id="nom" placeholder="Nom" required><br />
		</p>
		<p>
			<input type="text" name="prenom" id="prenom" placeholder="Prénom"
				required><br />
		</p>
		<p>
			<input type="email" name="email" id="email" placeholder="Email"
				required><br />
		</p>
		<p>
			<input type="tel" name="telephone" id="telephone"
				placeholder="Téléphone" required><br />
		</p>
		<p>
			<input type="text" name="rue" id="rue" placeholder="N° et Rue"
				required><br />
		</p>
		<p>
			<input type="text" name="code_postal" id="code_postal"
				placeholder="Code Postal" required><br />
		</p>
		<p>
			<input type="text" name="ville" id="ville" placeholder="Ville"
				required><br />
		</p>
		<p>
			<input type="password" name="mot_de_passe" id="mot_de_passe"
				placeholder="Mot de passe" required><br />
		</p><br/>
		<input type="submit" name="valider" value="valider" class="button1">
		<input type="reset" name="annuler" value="annuler" class="button2">
	</form>

</body>
</html>