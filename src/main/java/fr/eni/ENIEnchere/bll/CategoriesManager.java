package fr.eni.ENIEnchere.bll;

import java.util.List;

import fr.eni.ENIEnchere.bo.Categorie;
import fr.eni.ENIEnchere.dal.jdbc.DALException;
import fr.eni.ENIEnchere.dal.CategoriesDAO;
import fr.eni.ENIEnchere.dal.DAOFactory;

public class CategoriesManager {
	private static CategoriesDAO categoriesDAO;
	
	static {
		categoriesDAO = DAOFactory.getCategoriesDAO();
	}

	public void createCategorie(Categorie categorie) throws DALException, BLLException {
		BLLException blle = new BLLException();
		if (categorie.getLibelle().length() > 30) {
			blle.addError(ErrorCodesBLL.ERREUR_LONGUEUR_LIBELLE_CATEGORIE);
		}
		if (!categoriesDAO.checkForUniqueCategorieLibelle(categorie.getLibelle())) {
			blle.addError(ErrorCodesBLL.ERREUR_CATEGORIE_DEJA_UTILISE);
		}
		if (blle.hasErrors()) {
			throw blle;
		} 
		else {
			categoriesDAO.insert(categorie);
		}
	}
	
	public Categorie getCategorieByID(int id) throws DALException {
		return categoriesDAO.selectById(id);
	}
	
	public List<Categorie> getAllCategories() throws DALException {
		return categoriesDAO.selectALL();
	}
}
