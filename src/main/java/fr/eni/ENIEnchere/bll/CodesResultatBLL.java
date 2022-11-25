package fr.eni.ENIEnchere.bll;

/**
 * Les codes disponibles sont entre 20000 et 29999
 */
public abstract class CodesResultatBLL {
	public static final int INSERT_OBJET_ECHEC=10000;
	
	public static final int INSERT_OBJET_NULL=10000;
	/**
	 * Echec le nom de l'article ne respecte pas les règles définies
	 */
	public static final int IDENTIFIANT_KO=20000;
	/**
	 * Echec le nom de l'article ne respecte pas les règles définies
	 */
	public static final int REGLE_LISTE_NOM_ERREUR = 20001;
	/**
	 * Echec le champ 'nom' n'est pas valide
	 */
	public static final int REGLE_UTILISATEUR_NOM_ERREUR = 20002;
	/**
	 * Echec le champ 'pseudo' n'est pas valide
	 */
	public static final int REGLE_UTILISATEUR_PSEUDO_ERREUR = 20003;
	/**
	 *Echec le champ 'prenom' n'est pas valide
	 */
	public static final int REGLE_UTILISATEUR_PRENOM_ERREUR = 20004;
	/**
	 * Echec le champ 'email' n'est pas valide
	 */
	public static final int REGLE_UTILISATEUR_EMAIL_ERREUR = 20005;
	/**
	 * Echec le champ 'telephone' n'est pas valide
	 */
	public static final int REGLE_UTILISATEUR_TELEPHONE_ERREUR = 20006;
	/**
	 * Echec le champ 'rue' n'est pas valide
	 */
	public static final int REGLE_UTILISATEUR_RUE_ERREUR = 20007;
	/**
	 * Echec le champ 'code postal' n'est pas valide
	 */
	public static final int REGLE_UTILISATEUR_CODEPOSTAL_ERREUR = 20008;
	/**
	 * Echec le champ 'ville' n'est pas valide
	 */
	public static final int REGLE_UTILISATEUR_VILLE_ERREUR = 20009;
	/**
	 * Echec le champ 'mot de passe' n'est pas valide
	 */
	public static final int REGLE_UTILISATEUR_MOTDEPASSE_ERREUR = 20010;
	/**
	 * Echec le champ 'numéro de catégorie' n'est pas valide
	 */
	public static final int REGLE_ARTICLEVENDUS_NO_CATEGORIE_ERREUR = 20011;
	/**
	 * Echec le champ 'numéro d'utilisateur' n'est pas valide
	 */
	public static final int REGLE_ARTICLEVENDUS_NO_UTILISATEUR_ERREUR = 20012;
	/**
	 * Echec le champ 'date de fin' n'est pas valide
	 */
	public static final int REGLE_ARTICLEVENDUS_DATE_FIN_ENCHERES_ERREUR = 20013;
	/**
	 * Echec le champ 'date de début' n'est pas valide
	 */
	public static final int REGLE_ARTICLEVENDUS_DATE_DEBUT_ENCHERES_ERREUR = 20014;
	/**
	 * Echec le champ 'description de l'article' n'est pas valide
	 */
	public static final int REGLE_ARTICLEVENDUS_DESCRIPTION_ERREUR = 20015;
	/**
	 * Echec le champ 'nom de l'article' n'est pas valide
	 */
	public static final int REGLE_ARTICLEVENDUS_NOM_ARTICLE_ERREUR = 20016;
	/**
	 * Echec le champ 'prix de vente' n'est pas valide
	 */
	public static final int REGLE_ARTICLEVENDUS_PRIX_VENTE_ERREUR = 20017;
	/**
	 * Echec le champ 'prix initial' n'est pas valide
	 */
	public static final int REGLE_ARTICLEVENDUS_PRIX_INITIAL_ERREUR = 20018;
	
	
	
	
	
	
	
}
