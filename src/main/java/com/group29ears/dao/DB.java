package com.group29ears.dao;
import java.sql.Connection;
import java.sql.DriverManager;
public class DB {


	public static Connection getCon(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:8080/MARCUS","root","");
		}catch(Exception ex){System.out.println(ex);}
		return con;
	}
	}


