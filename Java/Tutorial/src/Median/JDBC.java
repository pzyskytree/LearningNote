package Median;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");//Driver Class
			System.out.println("The MySQL database is loaded sucessfully");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
//		Connection c = null;
//		Statement s = null;
//		try {
//			c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?"
//					+ "racterEncoding=UTF-8", "root", "admin");
//			System.out.println("Successfully Connect to the database: " + c);
//			s = c.createStatement();	
//			System.out.println("Get Statement Object: " + s);
//			String sql = "insert into hero values(null, 'teemo', 313.0, 50)";
//			s.execute(sql);
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}finally {
//			if (null != s) {
//				try {
//					s.close();
//				}catch(SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (null != c) {
//				try {
//					c.close();
//				}catch(SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		try(Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?racterEncoding=UTF-8",
//				"root", "admin");
//			Statement statement = connection.createStatement();
//			){
//			String sql = "insert into hero values(null, 'leesin', 100, 23)";
//			statement.execute(sql);
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
		
		//CRUD
		//C: Create, R: Retrieve, U: Update, D: Delete
		//C: Insert D: delete U: upadte R: Query
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?racterEncoding=UTF-8",
				"root", "admin");
			Statement statement = connection.createStatement();
			){
			String sql = "insert into hero values(null, 'sheepherd', 100, 23)";
//			statement.execute(sql);
			sql = "delete from hero where hp = 313";
//			statement.execute(sql);
			sql = "update hero set name = 'teemo' where id = 107";
//			statement.execute(sql);
			execute(sql);
			sql = "select * from hero";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");//use column name 
				String name = rs.getString(2);//Use index based on 1
				float hp = rs.getFloat("hp");
				int damage = rs.getInt(4);
				System.out.printf("%d\t%s\t%.2f\t%d\n", id, name, hp, damage);
			}
			sql =  "select count(*) from hero";
			rs = statement.executeQuery(sql);
			int total = 0;
			if (rs.next())
				total = rs.getInt(1);
			System.out.println("The total number of hero is " + total);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		//Check if password is right or not
		try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?racterEncoding=UTF-8",
				"root", "admin");
			Statement s = c.createStatement()){
			String name = "dashen";
			String password = "password";
			String sql = "select * from user where name='" + name + "' and password='" + password + "';";
			ResultSet rs = s.executeQuery(sql);
			if (rs.next())
				System.out.println("Account and Password are right");
			else 
				System.out.println("Account and Password are wrong");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		String sql = "insert into hero values(null, ?, ?, ?)";
		try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?racterEncoding=UTF-8",
				"root", "admin");
			PreparedStatement ps = c.prepareStatement(sql)
			){
			ps.setString(1, "lessin"); //Index starting from 1
			ps.setFloat(2, 313.0f);
			ps.setInt(3, 50);
//			ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		//1. PreparedStatement pre-compile
		try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?racterEncoding=UTF-8",
				"root", "admin");
			Statement s = c.createStatement();
			PreparedStatement ps = c.prepareStatement(sql)
			){
			//It will pass the sql to the database 10 times
			// For each time it will compile the sql.
			for (int i = 0; i < 10; i++) {
				String sql0 = "insert into hero values(null, 'teemo', 100, 23)";
//				s.execute(sql0);
			}
			
			//It only passes the sql sentence 1 time
			//1. it use less netword transition
			//2. Database doesn't need to compile fo the sql.
			for (int i = 0; i < 10; i++) {
				ps.setString(1, "lessin"); //Index starting from 1
				ps.setFloat(2, 313.0f);
				ps.setInt(3, 50);
//				ps.execute();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		//2. PreparedStatement prevents SQL insertion
		//select * from hero where name = "garen" or 1=1; Since 1=1 will be true all the time it will
		//return all the records.
		sql = "select * from hero where name = ?";
		try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?racterEncoding=UTF-8",
				"root", "admin");
			Statement s = c.createStatement();
			PreparedStatement ps = c.prepareStatement(sql)){
			String name = "'teemo' or 1=1";
			String sql0 = "select * from hero where name = " + name;
			ResultSet rs = s.executeQuery(sql0);
			System.out.println("Statement result");
			while (rs.next()) {
				int id = rs.getInt("id");//use column name 
				String heroname = rs.getString(2);//Use index based on 1
				float hp = rs.getFloat("hp");
				int damage = rs.getInt(4);
				System.out.printf("%d\t%s\t%.2f\t%d\n", id, heroname, hp, damage);
			}
			System.out.println("PreparedStatement result");
			ps.setString(1, name);
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");//use column name 
				String heroname = rs.getString(2);//Use index based on 1
				float hp = rs.getFloat("hp");
				int damage = rs.getInt(4);
				System.out.printf("%d\t%s\t%.2f\t%d\n", id, heroname, hp, damage);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		//ExecuteUpdate and Execute
		//Same trait can execute insert uoadte delete
		try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?racterEncoding=UTF-8",
				"root", "admin");
			Statement s = c.createStatement()){
			String sqlInsert = "insert into hero values(null, 'new', 200, 30)";
			String sqlDelete = "delete from hero where hp = 313";
			String sqlUpdate = "update hero set hp = 300 where id = 1";
//			s.execute(sqlInsert);
//			s.execute(sqlDelete);
//			s.execute(sqlUpdate);
			sqlInsert = "insert into hero values(null, 'newU', 201, 30)";
			sqlDelete = "delete from hero where hp = 100";
			sqlUpdate = "update hero set damage = 23 where id < 300";
//			s.executeUpdate(sqlInsert);
//			s.executeUpdate(sqlDelete);
//			s.executeUpdate(sqlUpdate);
			
			//Difference 1
			//execute can execute query whiel executeUpdate cannot
			String sqlSelect = "select * from hero";
			s.execute(sqlSelect);
//			ResultSet rs = s.executeQuery(sqlSelect);
			ResultSet rs = s.getResultSet();
			while (rs.next()) {
				int id = rs.getInt("id");//use column name 
				String heroname = rs.getString(2);//Use index based on 1
				float hp = rs.getFloat("hp");
				int damage = rs.getInt(4);
				System.out.printf("%d\t%s\t%.2f\t%d\n", id, heroname, hp, damage);
			}
//			s.executeUpdate(sqlSelect);//Cannot execute select
			//Difference 2: execute return boolean type while executeUpdate return int.
			boolean isSelect =  s.execute(sqlSelect);//True for select
			System.out.println(isSelect);
			boolean isUpdate = s.execute(sqlUpdate);//False for update, insert and delete
			System.out.println(isUpdate);
			
			int num = s.executeUpdate(sqlUpdate);//Return how many records have been influenced.
			System.out.println(num);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
//		list(2,4);
//		insert100Records();
	}
	
	public static void list(int start, int count) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?racterEncoding=UTF-8",
				"root", "admin");
			Statement s = c.createStatement()){
			String sql = "select * from hero limit " + start +", " + count;
//			ResultSet rs = s.executeQuery(sql);
			boolean isQuery = s.execute(sql);
			if (isQuery) {
				ResultSet rs = s.getResultSet();
				while (rs.next()) {
					int id = rs.getInt(1);
					String name = rs.getString("name");
					float hp = rs.getFloat("hp");
					int damage = rs.getInt(4);
					System.out.printf("%d\t%s\t%.2f\t%d\n", id, name, hp, damage);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void execute(String sql) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?racterEncoding=UTF-8", 
				"root","admin");
			Statement s = c.createStatement();
			){
			s.execute(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void insert100Records() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Get the JDBC");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?racterEncoding=UTF-8", 
				"root", "admin");
			Statement s = c.createStatement()){
			for (int i = 0; i < 100; i++) {
				String sql = "insert into hero values(null, " + "'hero" + i + "' , 313, 50)";
				s.execute(sql);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
