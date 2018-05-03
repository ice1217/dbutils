package dbutils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBLookUp {
	
	protected String serverHost;
	protected String database;
	protected String userName;
	protected String password;
	protected String dbType;
	
	public DBLookUp() {
		
	}
	
	public void setData(String serverHost, String database, String userName, String password) {
		
    }
    
    public Connection getConnected() {
    	Connection con = null;
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
      
      public ArrayList<String> getColumnName(String query, Connection con) {
      	
      	ArrayList<String> finalArray = new ArrayList<String>();
      	ResultSet rset;
      	
      	try{
  			Statement stmt = con.createStatement();
  			rset = stmt.executeQuery(query);
  			ResultSetMetaData rsmd = rset.getMetaData();
  			int maxColumn = rsmd.getColumnCount();
  			int current = 1;
  			
  			while(current<=maxColumn){
  				finalArray.add(rsmd.getColumnName(current)+"="+rsmd.getColumnTypeName(current));
  				current++;
  			}
      	}
      	catch(Exception e){
      		e.printStackTrace();
      	}
      	
      	return finalArray;
      }
      
      public ArrayList<ArrayList<String>> executeSelect(String query, Connection con, boolean useHeader) {
  		
      	ArrayList<ArrayList<String>> finalArray = new ArrayList<ArrayList<String>>();
  		
  		ResultSet rset;
  		try {
  			Statement stmt = con.createStatement();
  			rset = stmt.executeQuery(query);
  			ResultSetMetaData rsmd = rset.getMetaData();
  			int maxColumn = rsmd.getColumnCount();
//  			System.out.println(maxColumn);
  			int column = 1;		
  			ArrayList<String> outlist = new ArrayList<String>();
  			if(useHeader){
  				while(column<=maxColumn){
  					outlist.add(rsmd.getColumnName(column));
  					column++;
  				}
  				finalArray.add(outlist);
//  				System.out.println(finalArray);
  			}
  			column = 1;
  			while (rset.next()){
//  				System.out.println("writing all result query");
  				outlist = new ArrayList<String>();
  				while(column<=maxColumn){
  					outlist.add(rset.getString(column));
  					column++;
  				}
  				column = 1;
//  				System.out.println(outlist);
  				finalArray.add(outlist);			      
  			}
//  			System.out.println(finalArray);
  			
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  		
  		return finalArray;
  	}
      
      public boolean executeStatement(String query, Connection con) {
  		
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
