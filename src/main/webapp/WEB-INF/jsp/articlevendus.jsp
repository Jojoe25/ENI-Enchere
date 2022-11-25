<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="fr.eni.ENIEnchere.dal.messages.LecteurMessage"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Met ton article en vente !</title>

</head>

<body>

    <h3>NOUVELLE VENTE</h3>
    <form action="ServletArticleVendus" method="POST">
    
     <p>
        <label for="nom_article">Nom de l'article : </label>
        <input type="text" name="nom_article" id="nom_article" required><br/>
    </p>
    
     <p>
        <label for="description">Description : </label>
        <textarea input type="text" name="description" id="description" required placeholder="300mots maxi!"></textarea>
    </p>

    <p>
        <label for="no_categorie">Selectionnez une catégorie:</label>
        <name="no_categorie" id="no_categorie" required>
        <select name="no_categorie">
            <option value="Confirmé" input type="text" value ="1">Informatique</option>
            <option value="Professionnel" input type="text" value ="2">Ameublement</option>
            <option value="Débutant" input type="text" value ="3">Vêtement</option>
            <option value="Débutant" input type="text" value ="4">Sport & loisirs</option>
        </select>
    </p>

    <p>
        <label for="photos">Photo de l'article:</label>
        <input type="file" id="photos" name="photos" accept="image/png, image/jpeg">
        
    </p>

        <label for="prix_initial">Mise à Prix:</label>
        <input type="number" id="prix_initial" name="prix_initial">

    <p>
        <label for="date_debut_encheres">Date du début de l'enchère : </label>
        <input type="date" name="date_debut_encheres" id="date_debut_encheres" required><br/>
    </p>

    <p>
        <label for="date_fin_encheres">Date de fin de l'enchère : </label>
        <input type="date" name="date_fin_encheres" id="date_fin_encheres" required><br/>
    </p>


    <h3>RETRAIT DE L'ARTICLE :</h3>

    <p>
    <label for="rue">Rue : </label>
    <input type="text" name="rue" value="${utilisateur.rue}"><br/>
    </p>

    <p>
    <label for="code_postal">Code Postal : </label>
    <input type="text" name="code_postal" value="${utilisateur.code_postal}"><br/>
    </p>

    <p>
    <label for="ville">Ville : </label>
    <input type="text" name="ville" value="${utilisateur.ville }"><br/>
    </p>
    
    <input type="submit" name="submit" value="VALIDER">

    </form>
    
</body>

</html>