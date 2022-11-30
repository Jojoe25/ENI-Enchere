package fr.eni.ENIEnchere.dal;

import java.util.List;

import fr.eni.ENIEnchere.BusinessException;
import fr.eni.ENIEnchere.bo.Retrait;

public interface RetraitDAO {
	
public Retrait insert (Retrait retrait) throws BusinessException;
public Retrait getById (int id) throws BusinessException;
public List<Retrait> getAll() throws BusinessException;
public void update(Retrait retrait) throws BusinessException;
public static  void delete(int id) throws BusinessException {
	// TODO Auto-generated method stub
	
}

}