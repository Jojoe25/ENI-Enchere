package fr.eni.ENIEnchere.dal;

/**
 * 
 * Les codes disponibles sont entre 20000 et 29999
 *
 */

public abstract class CodesResultatDAL {
	
	/**
	 * Echec le nom de l'éarticcle ne respecte pas les règles definies
	 */
	
	public static final int SQL_EXCEPTION=10000;
	
	/**
	 * Echec le nom de l'éarticcle ne respecte pas les règles definies
	 */
	
	public static final int REGLE_LISTE_NOM_ERREUR = 0;

	public static final int LECTURE_ARTICLES_ECHEC = 0;

	public static final int UPDATE_OBJET_ECHEC = 0;

	public static final int LECTURE_RETRAIT_ECHEC = 0;

	public static final int DELETE_OBJET_ECHEC = 0;

	public static int test;

	
	
}
