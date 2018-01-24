package com.pagegroup.sendInvoice.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionFactory {
	private ResourceBundle bundle = ResourceBundle.getBundle("database");
	private Connection con;
	private String user;
	private String password;
	private String url;
	private String driver;
	
	public Connection axConnection(String country) throws SQLException {
		

		user = bundle.getString("sql_ax."+country+".user");
		password = bundle.getString("sql_ax."+country+".password");
		url = bundle.getString("sql_ax."+country+".url");
		driver = bundle.getString("sql_ax.driver");
		
		try {
		Class.forName(driver).newInstance();
		con = DriverManager.getConnection(url,user,password);
		return con;
		} catch (ClassNotFoundException ex) {
			System.err.println("Drive não encontrado");
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Connection sqlConnection()throws SQLException{
		user = bundle.getString("sql.user");
		password = bundle.getString("sql.password");
		url = bundle.getString("sql.url");
		driver = bundle.getString("sql.driver");
		
		try {
			Class.forName(driver).newInstance();
			con = DriverManager.getConnection(url,user,password);
			return con;
			} catch (ClassNotFoundException ex) {
				System.err.println("Drive não encontrado");
				ex.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	}
}