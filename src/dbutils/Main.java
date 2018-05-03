package dbutils;

import java.sql.Connection;

import com.google.gson.JsonArray;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBLookUp db = DatabaseManager.getDBLookUp("mysql");
		db.setData("localhost:3306", "arrivaldata", "datauser", "P@ssw0rd");
		String q = "select * from monthlydata where destination='INDONESIA' AND arrivalyear='2017'";
		
		Connection con = db.getConnected();
		JsonArray output = db.select(q, con);
		System.out.println(output);
//		ArrayList<ArrayList<String>> output2 = db.executeSelect(q, con, false);
//		System.out.println(output2);
		db.closeDB(con);
	}

}
