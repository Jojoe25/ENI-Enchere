package fr.eni.ENIEnchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.ENIEnchere.BusinessException;
import fr.eni.ENIEnchere.bo.Utilisateur;
import fr.eni.ENIEnchere.dal.CodesResultatDAL;
import fr.eni.ENIEnchere.dal.ConnectionProvider;
import fr.eni.ENIEnchere.dal.UtilisateurDAO;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
    private static final String SELECT_USER_BY_PSEUDO = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur FROM UTILISATEURS WHERE pseudo =?;";
    private static final String SELECT_USER_BY_EMAIL = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur FROM UTILISATEURS WHERE email =?;";
    private static final String SELECT_USER_BY_ID = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur FROM UTILISATEURS WHERE no_utilisateur =?";
    private Utilisateur getUtilisateurByLogin(String login, String requete) throws BusinessException {
        Utilisateur user = null;
        try (Connection cnx = ConnectionProvider.getConnection();
                PreparedStatement pstmt = cnx.prepareStatement(requete)) {
            pstmt.setString(1, login);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    user = new Utilisateur(rs.getInt("no_utilisateur"),
                    		rs.getString("pseudo"),
                    		rs.getString("nom"),
                            rs.getString("prenom"),
                            rs.getString("email"),
                            rs.getString("telephone"),
                            rs.getString("rue"),
                            rs.getString("code_postal"),
                            rs.getString("ville"),                        
                            rs.getString("mot_de_passe"),
                            rs.getInt("credit"),
                            rs.getBoolean("administrateur"));
                }
            }
        } catch (SQLException e) {
            BusinessException be = new BusinessException();
            be.ajouterErreur(CodesResultatDAL.SQL_EXCEPTION);
            e.printStackTrace();
            throw be;
        }
        return user;
    }
    
    private Utilisateur getUtilisateurByID(int login, String requete) throws BusinessException {
        Utilisateur user = null;
        try (Connection cnx = ConnectionProvider.getConnection();
                PreparedStatement pstmt = cnx.prepareStatement(requete)) {
            pstmt.setInt(1, login);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    user = new Utilisateur(rs.getInt("no_utilisateur"),
                    		rs.getString("pseudo"),
                    		rs.getString("nom"),
                            rs.getString("prenom"),
                            rs.getString("email"),
                            rs.getString("telephone"),
                            rs.getString("rue"),
                            rs.getString("code_postal"),
                            rs.getString("ville"),                        
                            rs.getString("mot_de_passe"),
                            rs.getInt("credit"),
                            rs.getBoolean("administrateur"));
                }
            }
        } catch (SQLException e) {
            BusinessException be = new BusinessException();
            be.ajouterErreur(CodesResultatDAL.SQL_EXCEPTION);
            e.printStackTrace();
            throw be;
        }
        return user;
    }

    @Override
    public Utilisateur getUtilisateurByMail(String email) throws BusinessException {

        return getUtilisateurByLogin(email, SELECT_USER_BY_EMAIL);
    }

    @Override
    public Utilisateur getUtilisateurByPseudo(String pseudo) throws BusinessException {

        return getUtilisateurByLogin(pseudo, SELECT_USER_BY_PSEUDO);
    }

	@Override
	public Utilisateur getUtilisateurByID(int vendeurid) throws BusinessException {
		// TODO Auto-generated method stub
		return getUtilisateurByID(vendeurid,SELECT_USER_BY_ID);
	}
}