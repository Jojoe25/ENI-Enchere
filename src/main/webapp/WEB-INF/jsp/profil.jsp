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
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link rel="stylesheet" href="style.css">
	</head>

<body>

     <!-- Navbar -->
     
<c:choose> 

	<c:when test = "${empty sessionScope.user}">
			 <nav class="navbar">
		        <div class="navbar-links">
		            <ul>
		                <li><a href="newuser">Créer Un Compte</a></li>
		                <li><a href="seconnecter">Se Connecter</a></li>
		            </ul>
		        </div>
		    </nav>
	</c:when>
	
	<c:otherwise>
	    <nav class="navbar">
	      <div class="navbar-links">
	          <ul>
	              <li><a href="Index">Enchères</a></li>
	              <li><a href="Vendre">Vendre</a></li>
	              <li><a href="Profil">Mon Profil</a></li>
	              <li><a href="AccueilDeconnected">Deconnexion</a></li>
	          </ul>
	      </div>
	    </nav>
	</c:otherwise>
	
</c:choose>
 	
      <!--Head-->
      <div class="head">
        <h1>Profil utilisateur : ${sessionScope.user.pseudo}!</h1>
      </div>

		<form action="avoir." method="POST">
			<div class="center">
				<p><span class="ChampProfil" >Pseudo : </span><span class="model" >${user.pseudo}</span></p>
			</div>
			<div class="center">
				<p><span class="ChampProfil" >Nom : </span><span class="model" >${user.nom}</span></p>
			</div>
			<div class="center">
				<p><span class="ChampProfil">Prénom : </span><span class="model" >${user.prenom}</span></p>
			</div>
			<div class="center"> 
				<p><span class="ChampProfil">Email : </span><span class="model" >${user.email}</span></p>
			</div>
			<div class="center">
				<p><span class="ChampProfil">Telephone : </span><span class="model" >${user.telephone}</span></p>
			</div>
			<div class="center">
				<p><span class="ChampProfil">Rue : </span><span class="model" >${user.rue}</span></p>
			</div>
			<div class="center">
				<p><span class="ChampProfil">Code Postal : </span><span class="model" >${user.code_postal}</span></p>
			</div>
			<div class="center">
				<p><span class="ChampProfil">Ville : </span><span class="model" >${user.ville}</span></p>
			</div>
		</form>
	        
	  	<c:if test= "${sessionScope.user.pseudo == requestScope.user.pseudo}">      
	        	    
		<div class=btn-large>
	    	<form action="updateProfil" method="post">
	    		<input class="btn" type="submit" name="buttonUpdate" value="Modifier mon compte"/>
	    	</form>       
	    </div>
	    <div class=btn-large>
	    	<form action="deleteProfil" method="post">
	    		<input class="btn" type="submit" name="buttonDelete" value="Supprimer mon compte"/>
	    	</form>       
	    </div>
	    
	    </c:if>
	    
	</section>

</body>
</html>