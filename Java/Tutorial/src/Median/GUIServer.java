package Median;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUIServer {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(8888);
			Socket s = ss.accept();
			JFrame f = new JFrame("Server");
			f.setBounds(100, 100, 400, 400);
			f.setLayout(null);
			JButton b = new JButton("Send");
			b.setBounds(30, 30, 80, 30);
			JTextField tf = new JTextField();
			tf.setBounds(30, 100, 80, 30);
			JTextArea ta = new JTextArea();
			ta.setBounds(120, 30, 250, 300);
			f.add(b);
			f.add(tf);
			f.add(ta);
			f.setVisible(true);
			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();
			DataInputStream dis = new DataInputStream(is);
			DataOutputStream dos = new DataOutputStream(os);
			new Thread() {
				public void run() {
					while(true) {
						String words = null;
						try {
							words = dis.readUTF();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						ta.append("Client: " + words);
					}
				}
			}.start();
			b.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					String text = tf.getText();
					if (text != null && text.length() > 0) {
						try {
							ta.append("Server: " + text + "\n");
							dos.writeUTF(text + "\n");
							tf.setText("");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
					}
				}
				
			});
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
