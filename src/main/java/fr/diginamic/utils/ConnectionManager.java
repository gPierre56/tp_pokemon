package fr.diginamic.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionManager {

	private static ResourceBundle dbProperties = ResourceBundle.getBundle("db");
	/** con : Connection */
	private static Connection con;

	/**
	 * @return retourne une instance de connexion à la base de données
	 */
	public static Connection getInstance() {
		try {
			if (con == null || con.isClosed()) {
				String url = dbProperties.getString("url");
				String user = dbProperties.getString("user");
				String password = dbProperties.getString("password");

				con = DriverManager.getConnection(url, user, password);

			}
		} catch (SQLException e) {
			System.out.println("Connexion à la base impossible");
		}

		return con;
	}

	/**
	 * @return renvoie les informations concernant le driver
	 */
	public static String getDriver() {
		String driverName = dbProperties.getString("driver");
		return driverName;
	}

}
