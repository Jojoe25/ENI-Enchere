package fr.eni.ENIEnchere.dal.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import fr.eni.ENIEnchere.dal.ConnectionProvider;

public class JdbcTools {

	public static Connection connect() {
		Connection cnx = null;
		try {
			cnx = ConnectionProvider.getConnection();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return cnx;
	}

}
