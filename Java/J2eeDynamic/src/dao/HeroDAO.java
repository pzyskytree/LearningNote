package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Hero;

public class HeroDAO {

	public HeroDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("finally")
	public Connection getConnection() {
		Connection c = null;
		try {
			c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
			"root", "admin");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			return c;
		}
	}
	
	@SuppressWarnings("finally")
	public int getTotal() {
		String sql = "select count(*) from hero";
		int total = 0;
		try (Connection c = getConnection();
			Statement s = c.createStatement()){
			ResultSet rs = s.executeQuery(sql);
			if (rs.next()) {
				total = rs.getInt(1);
			}
			System.out.println("Total Number: " + total);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			return total;
		}
	}
	
	public void add(Hero hero) {
		String sql = "insert into hero values(null, ?, ?, ?)";
		try(Connection c = getConnection();
			PreparedStatement ps = c.prepareStatement(sql)){
			ps.setString(1, hero.getName());
			ps.setFloat(2, hero.getHp());
			ps.setInt(3, hero.getDamage());
			ps.execute();
			
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				hero.setId(rs.getInt(1));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Hero hero) {
		String sql = "update hero set name = ?, hp = ?, damage = ? where id = ?";
		try(Connection c = getConnection();
			PreparedStatement ps = c.prepareStatement(sql)){
			ps.setString(1, hero.getName());
			ps.setFloat(2, hero.getHp());
			ps.setInt(3, hero.getDamage());
			ps.setInt(4, hero.getId());
			ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		String sql = "delete from hero where id = ?";
		try(Connection c = getConnection();
			PreparedStatement ps = c.prepareStatement(sql)){
			ps.setInt(1, id);
			ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("finally")
	public Hero get(int id) {
		Hero hero = null;
		String sql = "select * from hero where id = ?";
		try(Connection c = getConnection();
			PreparedStatement ps = c.prepareStatement(sql)){
			ps.setInt(1, id);
			ResultSet rs =  ps.executeQuery();
			if (rs.next()) {
				hero = new Hero();
				hero.setId(rs.getInt(1));
				hero.setName(rs.getString(2));
				hero.setHp(rs.getFloat(3));
				hero.setDamage(rs.getInt(4));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			return hero; 
		}
	}
	
	@SuppressWarnings("finally")
	public List<Hero> list(int start, int count){
		List<Hero> list = new ArrayList<Hero>();
		String sql = "select * from hero order by id limit ?, ?";
		try(Connection c = getConnection();
			PreparedStatement ps = c.prepareStatement(sql)){
			ps.setInt(1, start);
			ps.setInt(2, count);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Hero hero = new Hero();
				hero.setId(rs.getInt(1));
				hero.setName(rs.getString(2));
				hero.setHp(rs.getFloat(3));
				hero.setDamage(rs.getInt(4));
				list.add(hero);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			return list;
		}
	}
	
	public List<Hero> list(){
		return list(0, Short.MAX_VALUE);
	}
}
