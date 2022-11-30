package fr.eni.ENIEnchere.dal;

import java.util.List;

import fr.eni.ENIEnchere.BusinessException;
import fr.eni.ENIEnchere.bo.ArticleVendus;
import fr.eni.ENIEnchere.bo.Retrait;


public interface ArticleVendusDAO {

	public void insert(ArticleVendus articlevendus) throws BusinessException;
	public static ArticleVendus getById(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	public static List<ArticleVendus> getAll() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	public static  List<ArticleVendus> getByVendeur(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	public static void update (ArticleVendus articlevendus) throws BusinessException {
		// TODO Auto-generated method stub
		
	}
	public void delete (int id) throws BusinessException;
	public List<ArticleVendus> getByRetrait(Retrait retrait) throws BusinessException;
}
