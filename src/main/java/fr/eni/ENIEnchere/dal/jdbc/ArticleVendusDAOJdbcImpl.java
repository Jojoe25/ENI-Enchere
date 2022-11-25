package fr.eni.ENIEnchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import fr.eni.ENIEnchere.BusinessException;
import fr.eni.ENIEnchere.bll.CodesResultatBLL;
import fr.eni.ENIEnchere.bo.ArticleVendus;
import fr.eni.ENIEnchere.dal.ConnectionProvider;
import fr.eni.ENIEnchere.dal.ArticleVendusDAO;

public class ArticleVendusDAOJdbcImpl implements ArticleVendusDAO {
	private static final String INSERT_ARTICLEVENDUS = "INSERT INTO ARTICLES_VENDUS ( nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) values(?,?,?,?,?,?,?,?);";

	public void insert(ArticleVendus articlevendus)throws BusinessException{
		if(articlevendus==null)
		{
		BusinessException businessException = new BusinessException();
		businessException.ajouterErreur(CodesResultatBLL.INSERT_OBJET_NULL);
		throw businessException;
	}
		try(Connection cnx = ConnectionProvider.getConnection())
		{

		PreparedStatement pstmt = cnx.prepareStatement(INSERT_ARTICLEVENDUS, PreparedStatement.RETURN_GENERATED_KEYS);
		pstmt.setString(1, articlevendus.getNom_article());
		pstmt.setString(2, articlevendus.getDescription());
		pstmt.setString(3, articlevendus.getDate_debut_encheres());
		pstmt.setString(4, articlevendus.getDate_fin_encheres());
		pstmt.setString(5, articlevendus.getPrix_initial());
		pstmt.setString(6, articlevendus.getNo_utilisateur());
		pstmt.setString(7, articlevendus.getNo_categorie());
		pstmt.setString(8, articlevendus.getPrix_vente());

		pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();
		if(rs.next())
		{
			articlevendus.setNo_article(rs.getInt(1));
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		BusinessException businessException = new BusinessException();
		if(e.getMessage().contains("CK_ARTICLE_VENDUS"))
		{
			businessException.ajouterErreur(CodesResultatBLL.INSERT_OBJET_ECHEC);
		}
		else
		{
			businessException.ajouterErreur(CodesResultatBLL.INSERT_OBJET_ECHEC);
		}
		throw businessException;
	}	
	}
	}

	
