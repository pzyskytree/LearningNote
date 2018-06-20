package Median;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Network {

	public static void main(String[] args) {
		try {
			InetAddress host = InetAddress.getLocalHost();
			String ip = host.getHostAddress();
			System.out.println("Host IP " + ip);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Process p = Runtime.getRuntime().exec("ping 119.75.217.109");
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine())!= null) {
				if (line.length() != 0) {
					sb.append(line + "\n");
				}
			}
//			System.out.println("The return message");
//			System.out.println(sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ipAddresses();
	}
	
	//Practice
	
	
	public static void ipAddresses() {
		try {
			InetAddress host = InetAddress.getLocalHost();
			String ip = host.getHostAddress();
//			String ip = "119.75.217.109";
			String netIp = ip.substring(0, ip.lastIndexOf('.'));
			System.out.println("IP Address: " + ip);
			System.out.println("Net IP Address: " + netIp);
			
			List<String> ips = Collections.synchronizedList(new ArrayList<String>());
			ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS, 
					new LinkedBlockingQueue<Runnable>());
			AtomicInteger number = new AtomicInteger();
			for (int i = 0; i < 256; i++) {
				String testIP = netIp + "." + i;
				threadPool.execute(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						boolean reachable = isReachable(testIP);
						if (reachable) {
							System.out.println("Find Connected IP " + testIP);
							ips.add(testIP);
						}
						synchronized(number) {
							System.out.println("Finish " + number.incrementAndGet() + " IP tests");
						}
					}
					
				});
			}
			
			threadPool.shutdown();
			if (threadPool.awaitTermination(1, TimeUnit.HOURS)) {
				System.out.println("These ips can be connected");
				for (String theip : ips) {
					System.out.println(theip);
				}
				System.out.println("There are " + ips.size() + " ips");
			}
		}catch(UnknownHostException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("finally")
	public static boolean isReachable(String ip) {
		boolean readable = false;
		BufferedReader br = null;
		try {
			Process p = Runtime.getRuntime().exec("ping " + ip);
			br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine())!= null) {
				if (line.length() != 0) {
					sb.append(line + "\n");
				}
			}
			readable = sb.toString().contains("TTL");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return readable;
		}
	}
}
