package Median;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HeroDAO implements DAO {
	
	public HeroDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection c = null;
		try {
			c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?racterEncoding=UTF-8", 
			"root", "admin");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			return c;
		}
	}

	@Override
	public void add(Hero h) {
		// TODO Auto-generated method stub
		String sql = "insert into hero values(null, ?, ?, ?)";
		try(Connection c = this.getConnection();
			PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			ps.setString(1, h.name);
			ps.setFloat(2, h.hp);
			ps.setInt(3, h.damage);
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				h.id = id;
			}
			System.out.println("Add a new Hero " + h.name);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Hero h) {
		// TODO Auto-generated method stub
		String sql = "delete from hero where id = ?";
		try(Connection c = this.getConnection();
			PreparedStatement ps = c.prepareStatement(sql)){
			ps.setInt(1, h.id);
			int i = ps.executeUpdate();
			if (i > 0) {
				System.out.println("Delete Hero");
			}else {
				System.out.println("The hero id does not exist");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Hero h) {
		// TODO Auto-generated method stub
		String sql = "update hero set name = ?, hp = ?, damage = ? where id = ?";
		try(Connection c = this.getConnection();
			PreparedStatement ps = c.prepareStatement(sql)){
			ps.setString(1, h.name);
			ps.setFloat(2, h.hp);
			ps.setInt(3, h.damage);
			ps.setInt(4, h.id);
			int i = ps.executeUpdate();
			if (i > 0) {
				System.out.println("The hero with id " + h.id + " has been update to " + h);
			}else {
				System.out.println("The hero with that id does not exist");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Hero get(int id) {
		// TODO Auto-generated method stub
		Hero h = null;
		String sql = "select * from hero where id = ?";
		try(Connection c = this.getConnection();
			PreparedStatement ps = c.prepareStatement(sql)){
			ps.setInt(1, id);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			if (rs.next()) {
				h = new Hero(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4));
			}else {
				System.out.println("The id does not exist");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			return h;
		}
	}

	@Override
	public List<Hero> list() {
		// TODO Auto-generated method stub
		return list(0, Short.MAX_VALUE);
	}

	@Override
	public List<Hero> list(int start, int count) {
		// TODO Auto-generated method stub
		Hero h = null;
		List<Hero> list = new ArrayList<Hero>();
		String sql = "select * from hero limit ?, ?";
		try(Connection c = this.getConnection();
			PreparedStatement ps = c.prepareStatement(sql)){
			ps.setInt(1, start);
			ps.setInt(2, count);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while(rs.next()) {
				h = new Hero(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4));
				list.add(h);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			return list;
		}
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		int n = 0;
		String sql = "select count(*) from hero";
		try(Connection c = this.getConnection();
			PreparedStatement ps = c.prepareStatement(sql)){
			ps.execute();
			ResultSet rs = ps.getResultSet();
			if (rs.next()) {
				n = rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			return n;
		}
	}

}
