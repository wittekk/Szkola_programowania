package sql;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class zapytania_sql {
	//kod zapytania SQL tworzącego tabelę	
	public static String queryCreateTable1 = "CREATE TABLE IF NOT EXISTS users(" 
			+   "id BIGINT(20) NOT NULL AUTO_INCREMENT," 
			+ 	"username VARCHAR(255),"  
			+	"email VARCHAR(255) UNIQUE," 
			+	"password VARCHAR(255)," 
			+	"salt VARCHAR(255)," 
			+	"person_group_id INT(11),"
			+	"PRIMARY KEY(id)," 
			+   "FOREIGN KEY(person_group_id) REFERENCES user_group(id));";

	public static String queryCreateTable2 = "CREATE TABLE IF NOT EXISTS user_group("
			+ "id int(11) NOT NULL AUTO_INCREMENT,"
			+ "name VARCHAR(255),"
			+ "PRIMARY KEY(id))";

	public static String queryCreateTable3 = "CREATE TABLE IF NOT EXISTS exercise("
			+ "id int(11) NOT NULL AUTO_INCREMENT,"
			+ "title varchar(255),"
			+ "description TEXT,"
			+ "PRIMARY KEY(id))";
	
	public static String queryCreateTable4 = "CREATE TABLE IF NOT EXISTS solution("
			+ "id int(11) NOT NULL AUTO_INCREMENT,"			
			+ "created DATETIME,"
			+ "updated DATETIME,"
			+ "description TEXT,"
			+ "exercise_id int(11),"
			+ "users_id BIGINT(20),"			
			+ "PRIMARY KEY(id),"
			+ "FOREIGN KEY(exercise_id) REFERENCES exercise(id),"
			+ "FOREIGN KEY(users_id) REFERENCES users(id));";

	public static void main(String[] args) {
		PreparedStatement stmt = DbManagerOld.getPreparedStatement(queryCreateTable4);
		try {
			stmt.executeUpdate();
			//stmt.executeQuery();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
}
