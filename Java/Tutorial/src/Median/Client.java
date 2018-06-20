package Median;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("127.0.0.1", 8888);
			System.out.println(s);
			
			new SendThread(s).start();
			new ReceiveThread(s, "Client").start();
			
			
//			OutputStream os = s.getOutputStream();
//			InputStream is = s.getInputStream();
//			os.write(110);
//			Scanner sc = new Scanner(System.in);
//			DataOutputStream dos = new DataOutputStream(os);
//			String str = sc.nextLine();
//			dos.writeUTF("Legendary");
//			dos.writeUTF(str);
			
//			dos.close();
//			DataInputStream dis = new DataInputStream(is);
//			DataOutputStream dos = new DataOutputStream(os);
//			
//			while (true) {
//				Scanner sc = new Scanner(System.in);
//				String sendMsg = sc.nextLine();
//				dos.writeUTF(sendMsg);
//				String receiveMsg = dis.readUTF();
//				System.out.println(receiveMsg);
//			}
//			
//			os.close();
//			s.close();
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
