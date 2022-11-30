package fr.eni.ENIEnchere.dal;

import java.util.List;

import fr.eni.ENIEnchere.bo.Categorie;
import fr.eni.ENIEnchere.dal.jdbc.DALException;

public interface CategoriesDAO {
	boolean checkForUniqueCategorieLibelle(String libelleVerif) throws DALException;

	void insert(Categorie categorie) throws DALException;

	Categorie selectById(int id) throws DALException;

	List<Categorie> selectALL();
}
