package com.manhnguyen.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

public abstract class BaseService {
	private static String user = "learner";
	private static String pass = "Manh16112";
	private static String db = "students_management_system";
	private static String url = "jdbc:mysql://127.0.0.1:3306/" + db;

	@Resource(name = "jdbc/students_management_system")
	public static DataSource dataSource;

	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;

	}

}
