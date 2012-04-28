package com.stee.softserv.carhome.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * 
 * @author nathenup
 * @description mainly for get a connection to the db
 * @version 1.0
 * 
 */
public class ConnectionFactory {
	private static Properties config = new Properties();
	static {
		InputStream in = ConnectionFactory.class
				.getResourceAsStream("dbConfig.properties");
		if (in == null) {
			throw new RuntimeException("not found the file");
		}
		try {
			config.load(in);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError("the file load fail!");
		}

	}

	/**
	 * 
	 * @return DB connection just from the jdbc
	 */
	public static Connection getDirectConnection() {
		Connection con = null;
		String jdbcDriver = null;
		String jdbcUrl = null;
		String userName = null;
		String password = null;
		try {
			jdbcDriver = config.getProperty("driver");
			jdbcUrl = config.getProperty("url");
			userName = config.getProperty("user");
			password = config.getProperty("password");
			Class.forName(jdbcDriver);
			con = DriverManager.getConnection(jdbcUrl, userName, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * 
	 * @return DB connection just from the DataSource JNDI
	 */
	public static Connection getJNDIConnection() {
		Connection con = null;
		String jndiName = config.getProperty("jndiName");
		System.out.println(jndiName + "11111111111111111111");
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context
					.lookup("java:jdbc/" + jndiName);
			con = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static Connection getConnection() throws SQLException {
		Connection con = null;
		System.out.println(config.getProperty("jndiName"));
		if (config.getProperty("jndiName") != null) {
			try {
				con = getJNDIConnection();

			} catch (Exception e) {
				e.printStackTrace();
			}

			if (con == null) {
				con = getDirectConnection();
			}
		} else {
			con = getDirectConnection();
		}

		return con;
	}

	public static void closeAll(ResultSet rs, PreparedStatement ps,
			Statement st, Connection con) {
		try {
			if (rs != null) {

				rs.close();
			}
			if (ps != null) {

				ps.close();
			}
			if (st != null) {

				st.close();
			}
			if (con != null) {

				con.close();
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
