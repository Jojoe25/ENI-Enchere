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
	
	
	
}
