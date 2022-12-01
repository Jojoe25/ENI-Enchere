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
import fr.eni.ENIEnchere.bo.Categorie;
import fr.eni.ENIEnchere.bo.Retrait;
import fr.eni.ENIEnchere.bo.Utilisateur;
import fr.eni.ENIEnchere.dal.ConnectionProvider;
import fr.eni.ENIEnchere.dal.DAOFactory;
import fr.eni.ENIEnchere.dal.RetraitDAO;
import fr.eni.ENIEnchere.dal.UtilisateurDAO;
import fr.eni.ENIEnchere.dal.ArticleVendusDAO;
import fr.eni.ENIEnchere.dal.CategoriesDAO;
import fr.eni.ENIEnchere.dal.CodesResultatDAL;
import fr.eni.ENIEnchere.dal.jdbc.RetraitDAOJdbcImpl;

public class ArticleVendusDAOJdbcImpl implements ArticleVendusDAO {
	private static final String INSERT_ARTICLEVENDUS = "INSERT INTO ARTICLES_VENDUS ( nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) values(?,?,?,?,?,?,1,?);";

	//private static UtilisateurDAO utilisateurDAO = new UtilisateurDAOJdbcImpl();
	//private static CategoriesDAO categorieDAO = new CategorieDAOJdbcImpl();
	//private static RetraitDAO retraitDAO = new RetraitDAOJdbcImpl();
	
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
	}
	/*public ArticleVendus getById(int id) throws BusinessException {

		ArticleVendus articlevendus = null;

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(GET_BY_ID);
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				articlevendus = articleBuilder(rs);

			}

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_ARTICLES_ECHEC);
			throw businessException;

		}
		return articlevendus;
	}

	public List<ArticleVendus> getAll() throws BusinessException {

		List<ArticleVendus> articleliste = new ArrayList<>();

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement statement = cnx.prepareStatement(GET_ALL);

			ResultSet rs = statement.executeQuery();

			ArticleVendus articlevendus = null;

			while (rs.next()) {
				articlevendus = articleBuilder(rs);
				articleliste.add(articlevendus);
			}

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_ARTICLES_ECHEC);
			throw businessException;

		}
		return articleliste;
	}

	public List<ArticleVendus> getByVendeur(int id) throws BusinessException {

		List<ArticleVendus> articleliste = new ArrayList<>();

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(GET_BY_VENDEUR);
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			ArticleVendus articlevendus = null;

			while (rs.next()) {
				articlevendus = articleBuilder(rs);
				articleliste.add(articlevendus);

			}

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_ARTICLES_ECHEC);
			throw businessException;

		}
		return articleliste;
	}

	public void update(ArticleVendus articlevendus) throws BusinessException {

		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement statement = cnx.prepareStatement(UPDATE);

			statement.setString(1, articlevendus.getNom_article());
			statement.setString(2, articlevendus.getDescription());
			statement.setDate(3, java.sql.Date.valueOf(articlevendus.getDate_debut_encheres()));
			statement.setDate(4, java.sql.Date.valueOf(articlevendus.getDate_fin_encheres()));
			statement.setInt(5, articlevendus.getPrix_initial());
			statement.setInt(6, articlevendus.getPrix_vente());
			statement.setInt(7, articlevendus.getVendeur().getUtilisateurId());
			statement.setInt(8, articlevendus.getNo_categorie());
			if (articlevendus.getRetrait() != null) {
				statement.setInt(9, articlevendus.getRetrait().getId());
			} else {
				statement.setNull(9, Types.INTEGER);
			}
			statement.setInt(10, articlevendus.getNo_article());

			statement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.UPDATE_OBJET_ECHEC);
			throw businessException;

		}
	}

	@Override
	public void delete(int id) throws BusinessException {
		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement pstmt = cnx.prepareStatement(DELETE);
			pstmt.setInt(1, id);

			// Gestion des dépendances
			ArticleVendus article = this.getById(id);
			article.setVendeur(null);
 			article.setNo_categorie(null);
          	        article.setRetrait(null);
			RetraitDAO.delete(article.getRetrait().getId());

			// Supprimer l'article
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.test);
			throw businessException;

		}
	}

	@Override
	public List<ArticleVendus> getByRetrait(Retrait retrait) throws BusinessException {

		List<ArticleVendus> listeArticleVendu = new ArrayList<ArticleVendus>();

		try (Connection cnx = ConnectionProvider.getConnection()) {

			ArticleVendus articleVendu = null;

			PreparedStatement statement = cnx.prepareStatement(GET_BY_RETRAIT);
			statement.setInt(1, retrait.getId());

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				articleVendu = articleBuilder(rs);
				listeArticleVendu.add(articleVendu);
			}

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_RETRAIT_ECHEC);
			throw businessException;

		}

		return listeArticleVendu;

	}

	public ArticleVendus articleBuilder(ResultSet rs) throws BusinessException, SQLException {

		Utilisateur vendeur = this.getVendeurArticle(rs.getInt("no_utilisateur"));
		Categorie categorie = this.getCategorieArticle(rs.getInt("no_categorie"));
		Retrait retrait = this.getRetraitArticle(rs.getInt("no_retrait"));

		ArticleVendus articlevendus = new ArticleVendus();

		articlevendus.setNo_article(rs.getInt("no_article"));
		articlevendus.setNom_article(rs.getString("nom_article"));
		articlevendus.setDescription(rs.getString("description"));
		articlevendus.setDate_debut_encheres((rs.getDate("date_debut_encheres").toLocalDate()));
		articlevendus.setDate_fin_encheres(rs.getDate("date_fin_encheres").toLocalDate());
		articlevendus.setPrix_initial(rs.getInt("prix_initial"));
		articlevendus.setPrix_vente(rs.getInt("prix_vente"));
		articlevendus.setVendeur(vendeur);
		articlevendus.setNo_categorie(rs.getInt("no_categorie"));
		articlevendus.setRetrait(retrait);

		return articlevendus;

	}

	private Utilisateur getVendeurArticle(int vendeurId) {
		UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
		Utilisateur vendeurArticle = null;
		try {
			vendeurArticle = utilisateurDAO.getUtilisateurByID(vendeurId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vendeurArticle;
	}

	private Categorie getCategorieArticle(int categorieId) {
		CategoriesDAO categorieDAO = DAOFactory.getCategoriesDAO();
		Categorie categorieArticle = null;
		try {
			categorieArticle = categorieDAO.selectById(categorieId);
	*	} catch (Exception e) {
	*		e.printStackTrace();
	*	}
*		return categorieArticle;
*	}
*
	*private Retrait getRetraitArticle(int retraitId) {
	*	RetraitDAO retraitDAO = DAOFactory.getRetraitDAO();
	*	Retrait retraitArticle = null;
	*	try {
		*	retraitArticle = retraitDAO.getById(retraitId);
		*} catch (Exception e) {
		*	e.printStackTrace();
	*	}
		*return retraitArticle;
	*/

}
	


	
	

	
