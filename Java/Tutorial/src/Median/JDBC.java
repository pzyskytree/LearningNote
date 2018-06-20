package Median;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JDBC {

	public static Hero get(int id) {
		Hero h = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "select * from hero where id = ?";
		try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?racterEncoding=UTF-8", 
				"root", "admin");
			PreparedStatement ps = c.prepareStatement(sql)){
			ps.setInt(1, id);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while (rs.next()) {
				h = new Hero();
				h.id = rs.getInt(1);
				h.name = rs.getString("name");
				h.hp = rs.getFloat(3);
				h.damage = rs.getInt("damage");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return h;
	}
	
	public static void add(Hero h) {
		if (h == null)
			return;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String insertSql = "insert into hero values(?, ?, ?, ?)";
		String querySql = "select * from hero where id = ?";
		try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?racterEncoding=UTF-8",
			"root", "admin");
			PreparedStatement insertPs = c.prepareStatement(insertSql);
			PreparedStatement queryPs = c.prepareStatement(querySql)){
			c.setAutoCommit(false);
			queryPs.setInt(1, h.id);
			ResultSet rs = queryPs.executeQuery();
			if (!rs.next()) {
				insertPs.setInt(1, h.id);
				insertPs.setString(2, h.name);
				insertPs.setFloat(3, h.hp);
				insertPs.setInt(4, h.damage);
				insertPs.execute();
				c.commit();
				System.out.println("Insert hero " + h.name);
			}else {
				System.out.println("The ID already exists");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void delete(Hero h) {
		if (h == null)
			return;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String deleteSql = "delete from hero where id = ? and name = ? and hp = ? and damage = ?";
		try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?racterEncoding=UTF-8",
			"root", "admin");
			PreparedStatement deletePs = c.prepareStatement(deleteSql);){
			c.setAutoCommit(false);
			deletePs.setInt(1, h.id);
			deletePs.setString(2, h.name);
			deletePs.setFloat(3, h.hp);
			deletePs.setInt(4, h.damage);
			int i = deletePs.executeUpdate();
			if (i > 0) {
				System.out.println("Delete hero " + h.name);
				c.commit();
			}else {
				System.out.println("The Hero does not exist");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void update(Hero oldH, Hero newH) {
		if (oldH == null || newH == null)
			return;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String updateSql = "update hero set id = ?, name = ? , hp = ?, damage = ? "
				+ "where id = ? and name = ? and hp = ? and damage = ?";
		try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?racterEncoding=UTF-8",
			"root", "admin");
			PreparedStatement updatePs = c.prepareStatement(updateSql);){
			c.setAutoCommit(false);
			updatePs.setInt(1, newH.id);
			updatePs.setString(2, newH.name);
			updatePs.setFloat(3, newH.hp);
			updatePs.setInt(4, newH.damage);
			updatePs.setInt(5, oldH.id);
			updatePs.setString(6, oldH.name);
			updatePs.setFloat(7, oldH.hp);
			updatePs.setInt(8, oldH.damage);
			int i = updatePs.executeUpdate();
			if (i > 0) {
				System.out.println("Update hero " + oldH + " to new Hero " + newH );
				c.commit();
			}else {
				System.out.println("The old Hero does not exist");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static List<Hero> list(){
		List<Hero> list = new ArrayList<Hero>();
		Hero h = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "select * from hero";
		try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?racterEncoding=UTF-8", 
				"root", "admin");
			Statement s = c.createStatement()){
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				h = new Hero();
				h.id = rs.getInt(1);
				h.name = rs.getString("name");
				h.hp = rs.getFloat(3);
				h.damage = rs.getInt("damage");
				list.add(h);
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
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
		
		//Special Operation:
		//1.Get auto-increment ID
		sql = "insert into hero values(null, ?, ?, ?)";
		try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?racterEncoding=UTF-8",
				"root", "admin");
			PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			ps.setString(1, "garen");
			ps.setFloat(2, 100);
			ps.setInt(3, 22);
//			ps.execute();
			//Get Generated ID
			ResultSet rs = ps.getGeneratedKeys();
			while (rs.next()){
				int id = rs.getInt(1);
				System.out.println("ID: " + id);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		//2. Meta Data Data related to the databasae database tables fields fields name
		try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?racterEncoding=UTF-8", 
			"root", "admin")){
			
			DatabaseMetaData dbmd = c.getMetaData();
			System.out.println("Database's name " + dbmd.getDatabaseProductName());
			System.out.println("Dabtase's version " + dbmd.getDatabaseProductVersion());
			System.out.println("Databse and table's seperator " + dbmd.getCatalogSeparator());
			System.out.println("Driver version " + dbmd.getDriverVersion());
			System.out.println("Available databse list ");
			ResultSet rs = dbmd.getCatalogs();
			while (rs.next()) {
				System.out.println("database name " + rs.getString(1));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		//Transaction
		//Without transaction
		try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?racterEncoding=UTF-8", 
			"root", "admin");
			Statement s = c.createStatement()){
			sql = "update hero set hp = hp + 1 where name = 'new'";
//			s.execute(sql);//Even though the subtract hp sql is wrong the first one can still be executed;
			sql = "updata hero set hp = hp - 1 where name = 'new'";//It is not automic
//			s.execute(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		//With transaction
		//If all succeed or all fail //Commit by hand
		try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?racterEncoding=UTF-8",
			"root", "admin");
			Statement s = c.createStatement()){
			c.setAutoCommit(false);
			sql = "update hero set hp = hp + 1 where name = 'new'";
//			s.execute(sql);
			sql = "updata hero set hp = hp - 1 where name = 'new'";
//			s.execute(sql);
			c.commit();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		//ORM: Object RelationShip Database Mapping
		Hero h = get(344);
		System.out.println(h);
		Hero newHero = new Hero(100, "teemo", 133, 23);
		delete(newHero);
		add(newHero);
		System.out.println(newHero);
//		update(newHero,new Hero(2,"garen",143, 11));
		List<Hero> list = list();
		for (Hero hero : list) {
			System.out.println(hero);
		}
		
		//DAO: Data Access Object
		HeroDAO hdao = new HeroDAO();
		System.out.println(hdao.getTotal());
		h = hdao.get(344);
		System.out.println(h);
		newHero = new Hero(100, "teemo", 133, 23);
		hdao.delete(newHero);
		hdao.add(newHero);
		System.out.println(newHero);
		hdao.update(new Hero(2,"garen",143, 11));
		list = hdao.list();
		for (Hero hero : list) {
			System.out.println(hero);
		}
		list = hdao.list(23,4);
		for (Hero hero : list) {
			System.out.println(hero);
		}
		
		//Database ConnectionPool
		//Create the connetion inside the pool, all the connection will be borrowed by the threads and never 
		//close
		ConnectionPool cp = new ConnectionPool(3);
//		for (int i = 0; i < 10; i++) {
//			WorkingThread wt = new JDBC.WorkingThread("Thread " + i, cp);
//			wt.start();
//		}
		
		
		traditionVSConnectionPool();
		
//		delete10Records();
//		deletePreviousRecord();
//		list(2,4);
//		insert100Records();
	}
	
	private static class WorkingThread extends Thread{
		private ConnectionPool connections;
		
		public WorkingThread(String name, ConnectionPool connections) {
			super(name);
			this.connections = connections;
		}
		
		public void run() {
			Connection c = connections.getConnection();
			try(Statement s = c.createStatement()){
				System.out.print("Thread " + this.getName() + " get a connection");
				Thread.sleep(1000);
				String sql = "select count(*) from hero";
				s.execute(sql);
				ResultSet rs = s.getResultSet();
				while (rs.next()) {
					int total = rs.getInt(1);
					System.out.println(total + " ");
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}finally {
				connections.returnConnection(c);
			}
		}
	}
	
	//Practice
	public static void traditionVSConnectionPool() {
		//ConnectionPool
		ConnectionPool cp = new ConnectionPool(20);
		List<Thread> threadList = new ArrayList<Thread>(); 
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			Thread t = new Thread() {
				public void run() {
					Connection c = cp.getConnection();
					String sql = "insert into hero values(null, ?, ?, ?)";
					try (PreparedStatement ps = c.prepareStatement(sql)){
						ps.setString(1, "CP");
						ps.setFloat(2, 100);
						ps.setInt(3, 100);
						ps.execute();
					}catch(SQLException e) {
						e.printStackTrace();
					}finally {
						cp.returnConnection(c);
					}
				}
			};
			threadList.add(t);
			t.start();
		}
		for (Thread t : threadList) {
			try {
				t.join();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		long time = System.currentTimeMillis() - start;
		System.out.println("Connection Pooling insert 100 record using " + time + " milliseconds");
		//tradition
		threadList = new ArrayList<Thread>();
		start = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			Thread t = new Thread() {
				public void run() {
					String sql = "insert into hero values(null, ?, ?, ?)";
					try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?racterEncoding=UTF-8", 
					"root", "admin");
						PreparedStatement ps = c.prepareStatement(sql)){
						ps.setString(1, "Tradition");
						ps.setFloat(2, 111);
						ps.setInt(3, 111);
						ps.execute();
					}catch(SQLException e) {
						e.printStackTrace();
					}
				}
			};
			threadList.add(t);
			t.start();
		}
		for (Thread t: threadList) {
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		time = System.currentTimeMillis() - start;
		System.out.println("Tradition insert 100 record using " + time + " milliseconds");
		
	}
	
	
	public static void delete10Records() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?racterEncoding=UTF-8", 
			"root", "admin");
			Statement s = c.createStatement();
			Statement sDelete = c.createStatement()){
			c.setAutoCommit(false);
			String sql = "select * from hero limit 10";
			ResultSet rs = s.executeQuery(sql);
			int i = 0;
			while (rs.next()) {
				sql = "delete from hero where id = " + rs.getInt(1);
				System.out.println("Try to delete hero with ID " + rs.getInt(1) + " and name " + rs.getString(2));
				sDelete.execute(sql);
			}
			while(true) {
				System.out.println("Is to delete the data or not ? (y/n)");
				Scanner sc = new Scanner(System.in);
				String str = sc.nextLine();
				if ("y".equals(str)) {
					c.commit();
					System.out.println("Commit Delete");
					break;
				}else if("n".equals(str)) {
					System.out.println("Cancel Delete");
					break;
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void deletePreviousRecord() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String insertSql = "insert into hero values(null, ?, ?, ?)";
		String deleteSql = "delete from hero where id = ?";
		try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?ractorEncoding=UTF-8", 
			"root", "admin");
			PreparedStatement insertPs = c.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
			PreparedStatement deletePs = c.prepareStatement(deleteSql)){
			insertPs.setString(1, "new");
			insertPs.setFloat(2,111);
			insertPs.setInt(3, 222);
			insertPs.execute();
			ResultSet rs = insertPs.getGeneratedKeys();
			int previousID = 0;
			if (rs.next())
				previousID = rs.getInt(1);
			int changeNum = 0;
			do {
				previousID--;
				deletePs.setInt(1, previousID);
				changeNum = deletePs.executeUpdate();
			}while (changeNum == 0 && previousID > 0);
			if (changeNum > 0)
				System.out.println("Delete record with id " + previousID);
		}catch(SQLException e) {
			e.printStackTrace();
		}
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
