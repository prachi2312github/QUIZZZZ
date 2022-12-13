package com.quiz;
import java.sql.DriverManager;
import java.sql.Connection;

public class ConnectionTest
{
	Connection connection=null;
	public Connection getConnectionDetails()
	
	{
	try
	   {
	   
		   Class.forName("com.mysql.jdbc.Driver");
		   connection =   DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root","root");
	   }
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return connection;
}
}

