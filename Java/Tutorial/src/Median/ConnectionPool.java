package Median;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

public class ConnectionPool {

	LinkedList<Connection> connections = new LinkedList<Connection>();
	int size;

	public ConnectionPool(int size) {
		this.size = size;
		init();
	}
	
	public void init()  {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			for (int i = 0; i < this.size; i++) {
				connections.add(DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?racterEncoding=UTF-8", 
						"root", "admin"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized Connection getConnection() {
		while (connections.isEmpty()) {
			try {
				this.wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		Connection c = connections.removeFirst();
		return c;
	}
	
	public synchronized void returnConnection(Connection c) {
		if (c != null) {
			connections.add(c);
			this.notifyAll();
		}
	}
}
