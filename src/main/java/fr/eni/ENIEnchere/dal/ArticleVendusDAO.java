package fr.eni.ENIEnchere.dal;

import fr.eni.ENIEnchere.BusinessException;
import fr.eni.ENIEnchere.bo.ArticleVendus;


public interface ArticleVendusDAO {

	public void insert(ArticleVendus articlevendus) throws BusinessException;
	
}
