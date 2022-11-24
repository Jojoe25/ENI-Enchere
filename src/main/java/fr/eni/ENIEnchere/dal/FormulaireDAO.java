package fr.eni.ENIEnchere.dal;

import fr.eni.ENIEnchere.BusinessException;
import fr.eni.ENIEnchere.bo.Utilisateur;

public interface FormulaireDAO {
/**
 * en cas de soucis ca renvois les erreure vers la buisnesse
 */
	public void insert(Utilisateur utilisateur) throws BusinessException;
}
