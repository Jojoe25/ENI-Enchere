<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="fr.eni.ENIEnchere.dal.messages.LecteurMessage"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<title>Formulaire Inscription Enchere et en os !</title>

</head>

<body>

<form action="ServletCreerUtilisateur" method="POST">

 <p>
	<label for="pseudo">Pseudo : </label>
	<input type="text" name="pseudo" id="pseudo" required><br/>
</p>

 <p>
	<label for="nom">Nom : </label>
	<input type="text" name="nom" id="nom" required><br/>
</p>

 <p>
 	<label for="prenom">Prenom : </label>
	<input type="text" name="prenom" id="prenom" required><br/>
</p>

 <p>
  	<label for="email">Email : </label>
	<input type="email" name="email" id="email" required><br/>
</p>

 <p>
   	<label for="telephone">Tel : </label>
	<input type="tel" name="telephone" id="telephone" required><br/>
</p>

 <p>
    <label for="rue">Rue : </label>
	<input type="text" name="rue" id="rue" required><br/>
</p>

 <p>
    <label for="code_postal">Code postal : </label>
	<input type="text" name="code_postal" id="code_postal" required><br/>
</p>

 <p>
    <label for="ville">Ville : </label>
	<input type="text" name="ville" id="ville" required><br/>
</p>

 <p>
    <label for="mot_de_passe">Mot de passe : </label>
	<input type="password" name="mot_de_passe" id="mot_de_passe" required><br/>
</p>

 <p>
    100 crédit offert a la création du compte !!!
</p>

<input type="submit" name="valider" value="valider">

</form>

</body>
</html>