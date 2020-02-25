/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author 21695
 */
public class SQLDATA {
  
       
	public Connection getConnection(){          
		Connection connection=null;                      
		System.out.println("Connection called");                  
		try {                                                                  
			Class.forName("com.mysql.jdbc.Driver");              
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tgt", "root", "");
                System.out.println("connexion etablie");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
                        System.out.println("non etablie");
		} catch (SQLException e) {
			e.printStackTrace();
                        System.out.println("non etablie");
		}
		return connection;
	}
}
    

