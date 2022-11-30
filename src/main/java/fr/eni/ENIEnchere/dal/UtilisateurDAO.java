package fr.eni.ENIEnchere.dal;

import fr.eni.ENIEnchere.BusinessException;
import fr.eni.ENIEnchere.bo.Utilisateur;

public interface UtilisateurDAO {
	
	public Utilisateur getUtilisateurByPseudo(String pseudo) throws BusinessException;
	public Utilisateur getUtilisateurByMail(String mail) throws BusinessException;
	public Utilisateur getUtilisateurByID(int vendeurId) throws BusinessException;
	
}
