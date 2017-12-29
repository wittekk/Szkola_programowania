package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbManagerOld {
	static Connection conn;
	public static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/"; //127.0.0.1
        String dbName = "szkola?useSSL=false"; 
        String userName = "root";
        String password = "coderslab";
        if(conn==null){
        		conn = DriverManager.getConnection(url + dbName, userName,password);
        }else if(conn.isClosed()){
        		conn = DriverManager.getConnection(url + dbName, userName,password);
        }
        return conn;
    }
	public static PreparedStatement getPreparedStatement(String sql, String[] columns){
		try {
			return getConnection().prepareStatement(sql, columns);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
	public static PreparedStatement getPreparedStatement(String sql){
		try {
			return getConnection().prepareStatement(sql);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
	public static void close(){
		try {
			conn.close();
	    } catch (SQLException e) {
	    	System.err.println(e.getMessage());
	    }
	}
}