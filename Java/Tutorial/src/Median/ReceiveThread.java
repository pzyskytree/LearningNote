package Median;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ReceiveThread extends Thread{

	private Socket s;
	
	public ReceiveThread (Socket s, String str) {
		super(str);
		this.s = s;
	}
	
	public void run() {
		try {
			InputStream is = this.s.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			while(true) {
				String msg = dis.readUTF();
				System.out.println(this.getName() + " receive message: " + msg);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}

