package Advanced;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtilChild extends DBUtil{
	
	public static Connection getConnection2() throws SQLException {
		JDBCConfig config = DBUtil.class.getAnnotation(JDBCConfig.class);//Can Use the JDBCConfig
		String ip = config.ip();
		int port = config.port();
		String database = config.database();
		String encoding = config.encoding();
		String user = config.user();
		String password = config.password();
		String url = String.format("jdbc:mysql://%s:%d/%s?ractorEncoding=%s", ip, port, database, encoding);
		return DriverManager.getConnection(url, user, password);
		
		
	}
	
	public static void main(String[] args) throws SQLException {
		System.out.println(getConnection2());
	}

}
