package Median;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(8888);
			System.out.println("The server is listening on 8888 port");
			Socket s = ss.accept();
			System.out.println("There is a connection : " + s);
			
			new SendThread(s).start();
			new ReceiveThread(s, "Server").start();
			
//			InputStream is = s.getInputStream();
//			OutputStream os = s.getOutputStream();
//			int msg = is.read();
//			System.out.println(msg);
//			DataInputStream dis = new DataInputStream(is);
//			String msg = dis.readUTF();
//			System.out.println(msg);
			
//			dis.close();
//			DataInputStream dis = new DataInputStream(is);
//			DataOutputStream dos = new DataOutputStream(os);
//			
//			while (true) {
//				String msg = dis.readUTF();
//				String sendMsg = select(msg);
//				System.out.println("Server get Message: "+ msg);
//				if (null == sendMsg) {
//					dos.writeUTF("Nothing to tell");
//				}else {
//					dos.writeUTF(sendMsg);
//				}
//			}
//			while (true) {
//                String msg = dis.readUTF();
//                System.out.println("收到客户端信息"+msg);
//                Scanner sc = new Scanner(System.in);
//                String str = sc.next();
//                dos.writeUTF(str);
//            }
//			
//			dis.close();
//			is.close();
//			s.close();
//			ss.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public static String select(String rec) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		String result = null;
		String sql = "select * from dictionary where receive = ?";
		try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?racterEncoding=UTF-8", 
			"root", "admin");
			PreparedStatement ps = c.prepareStatement(sql)){
			ps.setString(1, rec);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				result = rs.getString(3);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			return result;
		}
		
		
	}
	
	public static void createTable() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "Create table dictionary(id int auto_increment, receive varchar(100),"
				+ " respose varchar(100), primary key(id))";
		try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?racterEncoding=UTF-8", 
			"root", "admin");
			Statement s = c.createStatement()){
			s.execute(sql);
		
		}catch(SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public static void insert(String rec, String res) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		String sql = "insert into dictionary values(null, ?, ?)";
		try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?racterEncoding=UTF-8", 
			"root", "admin");
			PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, rec);
			ps.setString(2, res);
			ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
				
			
	}
}
