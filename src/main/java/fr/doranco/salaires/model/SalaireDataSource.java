package fr.doranco.salaires.model;

import java.sql.Connection;
import java.sql.DriverManager;

public final class SalaireDataSource {

	private SalaireDataSource() {

	}

	public static Connection getConnection() throws Exception {

		String user = "root";
		String password = "root";
		String url = "jbdc:mysql://127.0.0.7:3306/users_db?serverTimezone=UTC&amp;useSSL=fales";

		Connection connection = DriverManager.getConnection(url, user, password);
		return connection;
	}
}
