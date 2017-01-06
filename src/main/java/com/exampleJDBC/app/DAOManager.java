package com.exampleJDBC.app;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.* ;

import com.exampleJDBC.app.Person;

public class DAOManager {

	public DAOManager() {
		// TODO Auto-generated constructor stub
	}		
	
	public static void main(String args[]){
		String URL = "jdbc:oracle:thin:@INPUHJPC09722:1521:ORCL";
		String USER = "Srikanth";
		String PASS = "orcl";		
		List l1 = new ArrayList<Person>();
		try {
			   Class.forName("oracle.jdbc.driver.OracleDriver");
			   Properties info = new Properties();
			   FileInputStream fs = new FileInputStream("src/main/java/db.properties");			   
			   info.load(fs);
			   //info.put("user", "Srikanth");
			   //info.put("password", "orcl");
			   Connection conn = DriverManager.getConnection(URL, info);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from Persons");		 	
				while(rs.next()){						
					Person p1 = new Person();
					p1.setId(rs.getInt(1));
					p1.setFirstName(rs.getString(2));
					p1.setLastName(rs.getString(3));
					l1.add(p1);
				} 
				System.out.println(l1.toString().toString());
				conn.close();
		}
		catch(ClassNotFoundException ex) {
			   System.out.println("Error: unable to load driver class!");
			   System.exit(1);
		}
		catch(SQLException ex){
			System.out.println(ex);
		}
		catch(Exception ex){
			System.out.println(ex);
		}	
	}
		
}
