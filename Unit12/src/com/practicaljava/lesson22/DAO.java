/**
 * 
 */
package com.practicaljava.lesson22;

import com.sun.rowset.CachedRowSetImpl;

import javax.sql.rowset.CachedRowSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author Svyatoslav Strygin <svyatoslav.strygin@gmail.com>
 */
public class DAO {

	public Connection connectToDB(){
		
		Connection conn = null;
		try {
			Class.forName("org.firebirdsql.jdbc.FBDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Properties props = new Properties();
		props.setProperty("user", "SYSDBA");
		props.setProperty("password", "masterkey");
		props.setProperty("encoding", "WIN1251");
		try {
			 conn = DriverManager.getConnection("jdbc:firebirdsql:191.168.1.7:MyTestDB", props);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn; 
	}
	
	
	public ResultSet extractDataBySqlQyery(String sqlQuery) {
		
		ResultSet resultSet = null;
		CachedRowSet cachedRowSet = null;
		Connection connection = connectToDB();

		try {
			cachedRowSet = new CachedRowSetImpl();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlQuery);
			cachedRowSet.populate(resultSet);
			statement.close();
			connection.close();
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
			System.out.println("sql exception: " + e.getMessage());
		}

		return cachedRowSet;
	}

	
	public void insertQuote(String symbol, int quantity, double price)
	{
		Connection connection = connectToDB();
		
		String insertQuery = "insert into quote (symbol, quantity, price) values (?,?,?);";
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement(insertQuery);
			
			statement.setString(1, symbol);
			statement.setInt(2, quantity);
			statement.setDouble(3, price);
			statement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
}
