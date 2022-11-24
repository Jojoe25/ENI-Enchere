package fr.eni.ENIEnchere.dal;

import fr.eni.ENIEnchere.dal.jdbc.UtilisateurDAOJdbcImpl;
import fr.eni.ENIEnchere.dal.jdbc.FormulaireDAOjdbcImpl;
public abstract class DAOFactory {
	
	public static UtilisateurDAO getUtilisateurDAO()
	{
		return new UtilisateurDAOJdbcImpl();
	}
	public static FormulaireDAO getFormulaireDAO()
	{
		return new FormulaireDAOjdbcImpl();
	}
	
}
	