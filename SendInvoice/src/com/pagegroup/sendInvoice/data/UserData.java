package com.pagegroup.sendInvoice.data;
import java.sql.Connection;

import java.sql.SQLException;
import com.pagegroup.sendInvoice.config.ConnectionFactory;



public class UserData {
	private Connection connection;

	public UserData() {
		try {
			connection = new ConnectionFactory().sqlConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
