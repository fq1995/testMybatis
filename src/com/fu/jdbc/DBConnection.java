package com.fu.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class DBConnection {
static final Logger log=Logger.getLogger(DBConnection.class);
	
	static final String CLASS_NAME;
	static final String URL;
	static final String USERNAME;
	static final String PASSWORD;
	
	static{
		Properties prop=new Properties();
		try {
			prop.load(DBConnection.class.getResourceAsStream("/jdbc.properties"));
		} catch (IOException e) {
			log.error("jdbc.properties file not found..."+e.getMessage());
		}
		CLASS_NAME=prop.getProperty("jdbc.className");
		URL=prop.getProperty("jdbc.url");
		USERNAME=prop.getProperty("jdbc.userName");
		PASSWORD=prop.getProperty("jdbc.password");
		try {
			Class.forName(CLASS_NAME);
		} catch (ClassNotFoundException e) {
			log.error("class file not found..."+e.getMessage());
		}
	}
	
	public static Connection getConnection(){
		Connection connection=null;
		try {
			connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (SQLException e) {
			log.error("connection error..."+e.getMessage());
		}
		return connection;
	}
	
	public static void closeConnection(Connection connection){
		if(null!=connection){
			try {
				connection.close();
			} catch (SQLException e) {
				log.error("close connection error...."+e.getMessage());
			}
		}
	}
}
