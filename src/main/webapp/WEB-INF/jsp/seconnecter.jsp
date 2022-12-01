<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="fr.eni.ENIEnchere.dal.messages.LecteurMessage"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		<link rel="stylesheet" href="seconnecter.css">
<title>se Connecter</title>
</head>
<body>

	<form method="post">

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
		
<div class="login-box">
<h2>Login</h2>
<form>
		<div class="user-box">
		<input type="text" id="login" name="login" required=""/>
		<label for="login">Identifiant</label>
		</div>
		<div class="user-box">
		<input type="password" id="mdp" name="mdp" required=""/>
		<label for="mdp">Mot de passe</label> 
		</div>
		<a href="submit">
		<span></span>
		<span></span>
		<span></span>
		<span></span>
		<button type="submit">Let's GO !</button>
		</a>
		
</form>
</div>

</body>
</html>