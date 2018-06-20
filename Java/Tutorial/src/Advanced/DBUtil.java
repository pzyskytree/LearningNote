package Advanced;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@JDBCConfig(ip = "127.0.0.1", database = "test", encoding = "UTF-8", user = "root", password = "admin")
public class DBUtil {

//	static String ip = "127.0.0.1";
//	static int port = 3306;
//	static String database = "how2java";
//	static String encoding = "UTF-8";
//	static String user = "root";
//	static String password = "admin";
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		JDBCConfig config = DBUtil.class.getAnnotation(JDBCConfig.class);
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
		System.out.println(getConnection());
	}
 }
