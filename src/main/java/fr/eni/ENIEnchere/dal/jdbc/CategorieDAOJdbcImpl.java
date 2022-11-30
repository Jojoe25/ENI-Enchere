package fr.eni.ENIEnchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import fr.eni.ENIEnchere.bo.Categorie;
import fr.eni.ENIEnchere.dal.CategoriesDAO;
import fr.eni.ENIEnchere.dal.ErrorCodesDAL;

public class CategorieDAOJdbcImpl implements CategoriesDAO {
	
	
	public void insert(Categorie categorie) throws DALException {
		Connection cnx = JdbcTools.connect();
		try {
			String INSERT = "INSERT INTO CATEGORIES (libelle) VALUES (?)";
			PreparedStatement pstmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, categorie.getLibelle());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				categorie.setNoCategorie(rs.getInt(1));
			}
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
			DALException dalException = new DALException();
			dalException.addError(ErrorCodesDAL.ERROR_SQL_INSERT);
			throw dalException;
		}
	}
	
	public Categorie selectById(int id) throws DALException {
		Connection cnx = JdbcTools.connect();
		Categorie categorie = null;
		try {
			String SELECT_BY_ID = "SELECT * FROM CATEGORIES WHERE no_categorie = ?";
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, id);
			pstmt.execute();
			ResultSet rs = pstmt.getResultSet();
			if (rs.next()) {
				categorie = new Categorie(rs.getInt("no_categorie"), rs.getString("libelle"));
			}
			cnx.close();
		}  catch (SQLException e) {
			e.printStackTrace();
			DALException dalException = new DALException();
			dalException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
			throw dalException;
		}
		return categorie;
	}
	
	public List<Categorie> selectAll() throws DALException {
		Connection cnx = JdbcTools.connect();
		List<Categorie> categories = new ArrayList<>();
		try {
			Statement pstmt = cnx.createStatement();
			String SELECT_ALL = "SELECT * FROM CATEGORIES";
			pstmt.execute(SELECT_ALL);
			ResultSet rs = pstmt.getResultSet();
			while (rs.next()) {
				categories.add(new Categorie(rs.getInt("no_categorie"),rs.getString("libelle")));
			}
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
			DALException dalException = new DALException();
			dalException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
			throw dalException;
		}
		return categories;
	}

	public void update(Categorie categorie) throws DALException {
	}
	
	public void delete(Categorie categorie) throws DALException {
	}
	
	public boolean checkForUniqueCategorieLibelle(String libelleVerif) throws DALException {
		Connection cnx = JdbcTools.connect();
		boolean isUnique = true;
		try {
			String CHECK_IF_LIBELLE_IS_UNIQUE = "SELECT * FROM CATEGORIES WHERE libelle LIKE ?";
			PreparedStatement pstmt = cnx.prepareStatement(CHECK_IF_LIBELLE_IS_UNIQUE);
			pstmt.setString(1, libelleVerif);
			pstmt.execute();
			ResultSet rs = pstmt.getResultSet();
			if (rs.next()) {
				isUnique = false;
			}
			
		cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
			DALException dalException = new DALException();
			dalException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
			throw dalException;
		}
		return isUnique;
	}

	@Override
	public List<Categorie> selectALL() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
