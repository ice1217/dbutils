package dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ImpalaLookUp extends DBLookUp {
	public ImpalaLookUp(){
    	super();
    }
    
    public void setData(String serverHost, String database, String userName, String password){
    	super.serverHost = "jdbc:impala://"+serverHost+"/";
    	super.database = database;
    	super.userName = userName;
    	super.password = password;
    }
    
    public Connection getConnected(){
    	try {
			Class.forName("com.cloudera.impala.jdbc4.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Where is your Impala JDBC Driver?");
		}

    	Connection con = null;
		try {
			con = DriverManager.getConnection(serverHost+database, userName, password);
//			System.out.println("connected");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Connection Failed! Check output console");
		}
    	 
    	 return con;
    }
}
