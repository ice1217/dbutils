package dbutils;

import java.sql.Connection;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBLookUp db = DatabaseManager.getDBLookUp("mysql");
		db.setData("localhost:3306", "arrivaldata", "datauser", "P@ssw0rd");
		Connection con = db.getConnected();
//		ArrayList<ArrayList<String>> out = db.executeSelect("", con, false);
//		System.out.println(out);
		db.closeDB(con);
	}

}
