package fr.eni.ENIEnchere.bo;

public class ArticleVendus {
	private Integer no_article;
	private	String	nom_article;
	private String description;
	private	String date_debut_encheres;
	private	String date_fin_encheres;
	private	Integer prix_initial;
	private	Integer prix_vente;
	private	Integer no_utilisateur;
	private	Integer no_categorie;
	
	public ArticleVendus(Integer no_article, String	nom_article, String description, String date_debut_encheres, String date_fin_encheres, Integer prix_initial, Integer prix_vente, Integer no_utilisateur, Integer no_categorie) {
		super();
		this.no_article = no_article;
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_encheres = date_debut_encheres;
		this.date_fin_encheres = date_fin_encheres;
		this.prix_initial = prix_initial;
		this.prix_vente = prix_vente;
		this.no_utilisateur = no_utilisateur;
		this.no_categorie = no_categorie;
	}
	public ArticleVendus(String	nom_article, String description, String date_debut_encheres, String date_fin_encheres, Integer prix_initial, Integer prix_vente, Integer no_utilisateur, Integer no_categorie) {
		super();
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_encheres = date_debut_encheres;
		this.date_fin_encheres = date_fin_encheres;
		this.prix_initial = prix_initial;
		this.prix_vente = prix_vente;
		this.no_utilisateur = no_utilisateur;
		this.no_categorie = no_categorie;
	}
	public Integer getNo_article() {
		return no_article;
	}
	public void setNo_article(Integer no_article) {
		this.no_article = no_article;
	}
	public String getNom_article() {
		return nom_article;
	}
	public void setNom_article(String nom_article) {
		this.nom_article = nom_article;
	}
	public String getDescription() {
		return description;
	}
	public void setPseudo(String description) {
		this.description = description;
	}
	public String getDate_debut_encheres() {
		return date_debut_encheres;
	}
	public void setDate_debut_encheres(String date_debut_encheres) {
		this.date_debut_encheres = date_debut_encheres;
	}
	public String getDate_fin_encheres() {
		return date_fin_encheres;
	}
	public void setDate_fin_encheres(String date_fin_encheres) {
		this.date_fin_encheres = date_fin_encheres;
	}
	public Integer getPrix_initial() {
		return prix_initial;
	}
	public void setPrix_initial(Integer prix_initial) {
		this.prix_initial = prix_initial;
	}
	public Integer getPrix_vente() {
		return prix_vente;
	}
	public void setPrix_vente(Integer prix_vente) {
		this.prix_vente = prix_vente;
	}
	public Integer getNo_utilisateur() {
		return no_utilisateur;
	}
	public void setNo_utilisateur(Integer no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}
	public Integer getNo_categorie() {
		return no_categorie;
	}
	public void setNo_categorie(Integer no_categorie) {
		this.no_categorie = no_categorie;
	}
}