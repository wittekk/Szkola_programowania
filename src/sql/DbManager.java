package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DbManager {
	
	private static DataSource ds;

	public static Connection getConn() throws SQLException {
		return getInstance().getConnection();
	}

	private static DataSource getInstance() {
		if (ds == null) {
			try {
				Context ctx = new InitialContext();
				ds = (DataSource) ctx.lookup("java:comp/env/jdbc/schoolRepo");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		return ds;
	}	
//	static Connection conn;
//	public static Connection getConn() throws Exception {
//        String url = "jdbc:mysql://localhost:3306/"; //127.0.0.1
//        String dbName = "szkola?useSSL=false"; 
//        String userName = "root";
//        String password = "coderslab";
//        if(conn==null){
//        		conn = DriverManager.getConnection(url + dbName, userName,password);
//        }else if(conn.isClosed()){
//        		conn = DriverManager.getConnection(url + dbName, userName,password);
//        }
//        return conn;
//    }
	public static void close(){
		try {
			((Connection) ds).close();
			System.out.println("Zakończono połączenie");
	    } catch (SQLException e) {
	    	System.err.println(e.getMessage());
	    }
	}	
	public static PreparedStatement getPreparedStatement(String sql, String[] columns){
		try {
			return getConn().prepareStatement(sql, columns);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
	public static PreparedStatement getPreparedStatement(String sql){
		try {
			return getConn().prepareStatement(sql);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
//	public static void close(){ czy zamykamy połącznie ctx??
//		try {
//			ctx.close();
//	    } catch (SQLException e) {
//	    	System.err.println(e.getMessage());
//	    }
//	}
}