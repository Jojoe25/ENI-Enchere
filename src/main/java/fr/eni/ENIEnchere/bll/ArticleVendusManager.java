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
	
	public void  ajouterArticleVendus (ArticleVendus articlevendus) throws BusinessException {
		article.insert(articlevendus);}
	
	public ArticleVendus ajouter(String	nom_article, String description, String date_debut_encheres, String date_fin_encheres, String prix_initial, String prix_vente, String no_utilisateur, String no_categorie) throws BusinessException {
		
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
}
