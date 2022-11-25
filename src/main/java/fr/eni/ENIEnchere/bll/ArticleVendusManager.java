package fr.eni.ENIEnchere.bll;

import fr.eni.ENIEnchere.BusinessException;
import fr.eni.ENIEnchere.bo.ArticleVendus;
import fr.eni.ENIEnchere.bo.Utilisateur;
import fr.eni.ENIEnchere.dal.ArticleVendusDAO;
import fr.eni.ENIEnchere.dal.DAOFactory;
import fr.eni.ENIEnchere.dal.FormulaireDAO;

public class ArticleVendusManager {
	private static ArticleVendusManager instance = null;
	private ArticleVendusDAO article;
	public static ArticleVendusManager getInstance() {
		if (instance == null) {
			instance = new ArticleVendusManager();
		}
		return instance;
	 }

	
	private ArticleVendusManager() {
		this.article = DAOFactory.getArticleVendusDAO();
	}
	
	public void  ajouterUtilisateur (ArticleVendus articlevendus) throws BusinessException {
		article.insert(articlevendus);}
	
	public ArticleVendus ajouter(String	nom_article, String description, String date_debut_encheres, String date_fin_encheres, Integer prix_initial, Integer prix_vente, Integer no_utilisateur, Integer no_categorie) throws BusinessException {
		
		BusinessException exception = new BusinessException();
		
		ArticleVendus articlevendus = new ArticleVendus(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie);
		
		this.validerNom_article(articlevendus, exception);
		this.validerDescription(articlevendus, exception);
		this.validerDate_debut_encheres(articlevendus, exception);
		this.validerDate_fin_encheres(articlevendus, exception);
		this.validerPrix_initial(articlevendus, exception);
		this.validerPrix_vente(articlevendus, exception);
		this.validerNo_utilisateur(articlevendus, exception);
		this.validerNo_categorie(articlevendus, exception);
		
		if(!exception.hasErreurs()) {
			article.insert(articlevendus);
		}
		else {
			throw exception;
		}
		return articlevendus;
	}


	private void validerNo_categorie(ArticleVendus articlevendus, BusinessException exception) throws BusinessException {
		if(articlevendus.getNo_categorie()== null) {
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatBLL.REGLE_ARTICLEVENDUS_NO_CATEGORIE_ERREUR);
			throw be;
		}
	}


	private void validerNo_utilisateur(ArticleVendus articlevendus, BusinessException exception) throws BusinessException {
		if(articlevendus.getNo_utilisateur()== null) {
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatBLL.REGLE_ARTICLEVENDUS_NO_UTILISATEUR_ERREUR);
			throw be;
		}
	}


	private void validerPrix_vente(ArticleVendus articlevendus, BusinessException exception) throws BusinessException {
		if(articlevendus.getPrix_vente()== null) {
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatBLL.REGLE_ARTICLEVENDUS_PRIX_VENTE_ERREUR);
			throw be;
		}
	}


	private void validerPrix_initial(ArticleVendus articlevendus, BusinessException exception) throws BusinessException {
		if(articlevendus.getPrix_initial()== null) {
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatBLL.REGLE_ARTICLEVENDUS_PRIX_INITIAL_ERREUR);
			throw be;
		}
	}


	private void validerDate_fin_encheres(ArticleVendus articlevendus, BusinessException exception) throws BusinessException {
		if(articlevendus.getDate_fin_encheres()== null) {
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatBLL.REGLE_ARTICLEVENDUS_DATE_FIN_ENCHERES_ERREUR);
			throw be;
		}
	}


	private void validerDate_debut_encheres(ArticleVendus articlevendus, BusinessException exception) throws BusinessException {
		if(articlevendus.getDate_debut_encheres()== null) {
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatBLL.REGLE_ARTICLEVENDUS_DATE_DEBUT_ENCHERES_ERREUR);
			throw be;
		}
	}


	private void validerDescription(ArticleVendus articlevendus, BusinessException exception) throws BusinessException {
		if(articlevendus.getDescription()== null || articlevendus.getDescription().length() > 300) {
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatBLL.REGLE_ARTICLEVENDUS_DESCRIPTION_ERREUR);
			throw be;
		}
	}


	private void validerNom_article(ArticleVendus articlevendus, BusinessException exception) throws BusinessException {
		if(articlevendus.getNom_article()== null || articlevendus.getNom_article().length() > 30) {
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatBLL.REGLE_ARTICLEVENDUS_NOM_ARTICLE_ERREUR);
			throw be;
		}
	}
	
}