package fr.eni.ENIEnchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ENIEnchere.BusinessException;
import fr.eni.ENIEnchere.bll.CodesResultatBLL;
import fr.eni.ENIEnchere.bo.ArticleVendus;
import fr.eni.ENIEnchere.dal.ConnectionProvider;
import fr.eni.ENIEnchere.dal.ArticleVendusDAO;

public class ArticleVendusDAOJdbcImpl implements ArticleVendusDAO {
	private static final String INSERT_ARTICLEVENDUS = "INSERT INTO ARTICLES_VENDUS ( nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) values(?,?,?,?,?,?,1,?);";

	public void insert(ArticleVendus articlevendus)throws BusinessException{
		if(articlevendus==null)
		{
		BusinessException businessException = new BusinessException();
		businessException.ajouterErreur(CodesResultatBLL.INSERT_OBJET_NULL);
		throw businessException;
	}
		try(Connection cnx = ConnectionProvider.getConnection())
		{

			PreparedStatement statement = cnx.prepareStatement(INSERT_ARTICLEVENDUS, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, articlevendus.getNom_article());
			statement.setString(2, articlevendus.getDescription());
			statement.setDate(3, java.sql.Date.valueOf(articlevendus.getDate_debut_encheres()));
			statement.setDate(4, java.sql.Date.valueOf(articlevendus.getDate_fin_encheres()));
			statement.setInt(5, articlevendus.getPrix_initial());
			statement.setInt(6, articlevendus.getNo_utilisateur());
			statement.setInt(7, articlevendus.getNo_categorie());

			statement.executeUpdate();

			ResultSet rs = statement.getGeneratedKeys();

			if (rs.next()) {
				articlevendus.setNo_article(rs.getInt(1));
			}

		} catch (Exception e) {
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
	}}

	
	

	
