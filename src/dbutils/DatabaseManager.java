package dbutils;

public class DatabaseManager {
	
	public static DBLookUp getDBLookUp (String dbType) {
		DBLookUp out = null;
		if (dbType.equalsIgnoreCase("mysql")) out = new MySqlLookUp();
		if (dbType.equalsIgnoreCase("sql")) out = new SqlLookUp();
		if (dbType.equalsIgnoreCase("hive")) out = new HiveLookUp();
		if (dbType.equalsIgnoreCase("impala")) out = new ImpalaLookUp();
		return out;
	}
	
}
