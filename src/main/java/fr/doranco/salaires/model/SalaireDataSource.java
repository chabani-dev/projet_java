package fr.doranco.salaires.model;

import java.sql.Connection;
import java.sql.DriverManager;

public final class SalaireDataSource {

	private SalaireDataSource() {

	}

	public static Connection getConnection() throws Exception {
		
		String url = "jdbc:mysql://localhost:3306/users_db?serverTimezone=UTC";
		String user = "root";
		String password = "root";

		Connection connection = DriverManager.getConnection(url, user, password);
		return connection;
	}
}
