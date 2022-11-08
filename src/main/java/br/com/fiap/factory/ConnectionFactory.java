package br.com.fiap.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	@SuppressWarnings("unused")
	private Connection conn = null;
	
	public Connection getConnection() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "rm93613", "150503");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
