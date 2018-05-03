package dbutils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.google.gson.*;

public class DBLookUp {
	
	protected String serverHost;
	protected String database;
	protected String userName;
	protected String password;
	protected String dbType;
	protected Connection con;
	
	public DBLookUp() {
		
	}
	
	public void setData(String serverHost, String database, String userName, String password) {
		
    }
    
    public Connection getConnected() {
    	return con;
    }
	
    public void closeDB(Connection con) {
    	try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Failed to closeDB");
		}
    }
      
    public JsonArray select (String query, Connection con) {
    	JsonArray out = new JsonArray();
    	ResultSet rset;
  		try {
  			Statement stmt = con.createStatement();
  			rset = stmt.executeQuery(query);
  			ResultSetMetaData rsmd = rset.getMetaData();
  			int maxColumn = rsmd.getColumnCount();
//  			System.out.println(maxColumn);
  			
  			while (rset.next()) {
  	  			int column = 1;
  				JsonObject obj = new JsonObject();
  				while(column<=maxColumn) {
  					String colName = rsmd.getColumnName(column);
  					String val = rset.getString(column);
  					obj.addProperty(colName, val);
  					column++;
  				}
  				out.add(obj);
  			}
  			
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
    	return out;
    }
      
      public boolean query(String query, Connection con) {
  		
  		try {
  			Statement stmt = con.createStatement();
  			stmt.executeUpdate(query);
//  			con.commit();
  			return true;
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  			return false;
  		}
  	}
	
}
