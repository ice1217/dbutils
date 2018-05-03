package dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlLookUp extends DBLookUp {
    
    public MySqlLookUp(){
    	super();
    }
    
    public void setData(String serverHost, String database, String userName, String password){
    	super.serverHost = "jdbc:mysql://"+serverHost+"/";
    	super.database = database+"?";
    	super.userName = userName;
    	super.password = password;
    }
    
    public Connection getConnected(){
		String connString = serverHost+database;
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Where is your MYSQL JDBC Driver?");
		}

    	Connection con = null;
		try {
			con = DriverManager.getConnection(connString, userName,password);
//			System.out.println("connected");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Connection Failed! Check output console");
		}
    	 
    	 return con;
    }

}
