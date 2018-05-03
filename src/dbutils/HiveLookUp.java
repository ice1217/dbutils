package dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HiveLookUp extends DBLookUp {
	public HiveLookUp(){
    	super();
    }
    
    public void setData(String serverHost, String database, String userName, String password){
    	super.serverHost = "jdbc:hive2://"+serverHost+"/";
    	super.database = database;
    	super.userName = userName;
    	super.password = password;
    }
    
    public Connection getConnected(){
    	try {
			Class.forName("org.apache.hive.jdbc.HiveDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Where is your Hive JDBC Driver?");
		}

    	Connection con = null;
		try {
			con = DriverManager.getConnection(serverHost+database, userName, password);
			System.out.println("connected");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Connection Failed! Check output console");
		}
    	 
    	 return con;
    }
}
