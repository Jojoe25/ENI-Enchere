package fr.eni.ENIEnchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import fr.eni.ENIEnchere.BusinessException;
import fr.eni.ENIEnchere.bll.CodesResultatBLL;
import fr.eni.ENIEnchere.bo.Utilisateur;
import fr.eni.ENIEnchere.dal.CodesResultatDAL;
import fr.eni.ENIEnchere.dal.ConnectionProvider;
import fr.eni.ENIEnchere.dal.FormulaireDAO;

public class FormulaireDAOjdbcImpl implements FormulaireDAO{
	private static final String INSERT_UTILISATEUR="INSERT INTO UTILISATEURS ( pseudo,  nom,  prenom,  email,  telephone,  rue, code_postal, ville, mot_de_passe, credit, administrateur) values(?,?,?,?,?,?,?,?,?,?,?);";

public void insert(Utilisateur utilisateur)throws BusinessException{
	if(utilisateur==null)
	{
	BusinessException businessException = new BusinessException();
	businessException.ajouterErreur(CodesResultatBLL.INSERT_OBJET_NULL);
	throw businessException;
}
	try(Connection cnx = ConnectionProvider.getConnection())
	{

	PreparedStatement pstmt = cnx.prepareStatement(INSERT_UTILISATEUR, PreparedStatement.RETURN_GENERATED_KEYS);
	pstmt.setString(1, utilisateur.getPseudo());
	pstmt.setString(2, utilisateur.getNom());
	pstmt.setString(3, utilisateur.getPrenom());
	pstmt.setString(4, utilisateur.getEmail());
	pstmt.setString(5, utilisateur.getTelephone());
	pstmt.setString(6, utilisateur.getRue());
	pstmt.setString(7, utilisateur.getCode_postal());
	pstmt.setString(8, utilisateur.getVille());
	pstmt.setString(9, utilisateur.getMot_de_passe());
	pstmt.setInt(10, utilisateur.getCredit());
	pstmt.setBoolean(11, utilisateur.isAdministrateur());

	pstmt.executeUpdate();
	ResultSet rs = pstmt.getGeneratedKeys();
	if(rs.next())
	{
		utilisateur.setUtilisateurId(rs.getInt(1));
	}
}
catch(Exception e)
{
	e.printStackTrace();
	BusinessException businessException = new BusinessException();
	if(e.getMessage().contains("CK_UTILISATEUR"))
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

@Override
public void delete(Utilisateur utilisateur) throws BusinessException {
	// TODO Auto-generated method stub
	
}

@Override
public List<Utilisateur> selectAll() throws BusinessException {
	// TODO Auto-generated method stub
	return null;
}}