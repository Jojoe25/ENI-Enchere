	<!-- NAVBAR -->
	<!-- page en mode connected et not connected. -->
    
<c:choose>
		<c:when test="${empty sessionScope.user}">
			<nav class="navbar d-flex justify-content-end">
				<div class="navbar-links">
					<ul>
						<li><a href="newuser">Créer Un Compte</a></li></br>
						<li><a href="seconnecter">Se Connecter</a></li>
					</ul>
				</div>
			</nav>
		</c:when>

		<c:otherwise>
			<nav class="navbar d-flex justify-content-end">
				<div class="navbar-links">
					<ul>
						<li><a href="Index">Enchères</a></li></br>
						<li><a href="ArticleVendus">Vendre</a></li></br>
						<li><a href="Profil">Mon Profil</a></li></br>
						<li><a href="AccueilDeconnected">Deconnexion</a></li>
					</ul>
				</div>
			</nav>
		</c:otherwise>

</c:choose>
