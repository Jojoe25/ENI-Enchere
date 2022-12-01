<%@page import="fr.eni.ENIEnchere.bll.UtilisateurManager"%>
<%@page import="fr.eni.ENIEnchere.bo.Utilisateur"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<html lang="fr">
    <head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <meta http-equiv="X-UA-Compatible" content="ie=edge">
		<title>Enchere et en os ! / Mon profil</title>
		<link rel="stylesheet" href="profil.css">
	</head>

<body>

<%@ include file = "navbar.jsp" %>
 	
	<div class="login-box">
	       <h2>Salut ${sessionScope.user.pseudo} !</h2>
		<form action="Profil" method="POST">

			<div class="user-box">
				<p><span class="ChampProfil" >Pseudo : </span><span class="model" >${user.pseudo}</span></p>
			</div>
			<div class="user-box">
				<p><span class="ChampProfil" >Nom : </span><span class="model" >${user.nom}</span></p>
			</div>
			<div class="user-box">
				<p><span class="ChampProfil">Prénom : </span><span class="model" >${user.prenom}</span></p>
			</div>
			<div class="user-box"> 
				<p><span class="ChampProfil">Email : </span><span class="model" >${user.email}</span></p>
			</div>
			<div class="user-box">
				<p><span class="ChampProfil">Telephone : </span><span class="model" >${user.telephone}</span></p>
			</div>
			<div class="user-box">
				<p><span class="ChampProfil">Rue : </span><span class="model" >${user.rue}</span></p>
			</div>
			<div class="user-box">
				<p><span class="ChampProfil">Code Postal : </span><span class="model" >${user.code_postal}</span></p>
			</div>
			<div class="user-box">
				<p><span class="ChampProfil">Ville : </span><span class="model" >${user.ville}</span></p>
			</div>
		</form>
		
		<c:if test= "${sessionScope.user.pseudo == requestScope.user.pseudo}">          	    
		<div class="test">
		<a href="modifierProfil" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Modifier mon compte</a> 
	    </div>
		</c:if>
		
	</div>	
	        
</body>
</html>