package fr.eni.ENIEnchere.dal;

import java.util.List;

import fr.eni.ENIEnchere.BusinessException;
import fr.eni.ENIEnchere.bo.Utilisateur;

public interface FormulaireDAO {
/**
 * en cas de soucis ca renvois les erreure vers la buisnesse
 */
	 	public void insert(Utilisateur utilisateur) throws BusinessException;
		public void delete(Utilisateur utilisateur) throws BusinessException; // supprimer un utilisateur 
		public List<Utilisateur> selectAll() throws BusinessException; // recuperer la liste des utilisateurs 
}
