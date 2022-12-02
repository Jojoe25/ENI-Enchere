	<!-- NAVBAR -->
	<!-- page en mode connected et not connected. -->

<c:choose>

		<c:when test="${empty sessionScope.user}">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link rel="stylesheet" href="nav1.css">
			<nav class="navbar d-flex justify-content-end">
				<div class="navbar-links">
					<ul>
						<li><a href="newuser">Créer Un Compte</a></li>
						<li><a href="seconnecter">Se Connecter</a></li>
					</ul>
				</div>
			</nav>
		</c:when>

		<c:otherwise>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link rel="stylesheet" href="nav1.css">
			<nav class="navbar d-flex justify-content-end">
				<div class="navbar-links">
					<ul>
						<li><a href="Index">Enchères</a></li>
						<li><a href="ArticleVendus">Vendre</a></li>
						<li><a href="Profil">Mon Profil</a></li>
						<li><a href="AccueilDeconnected">Deconnexion</a></li>
					</ul>
				</div>
			</nav>
		</c:otherwise>

</c:choose>
