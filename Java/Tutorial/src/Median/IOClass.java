package Median;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.StandardSocketOptions;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import Basic.Hero;

public class IOClass {

	private static File maxFile = null, minFile = null;
	public static void main(String[] args) {
		//Absolute Path
		File f1 = new File("d:/LOLFolder");
		System.out.println(f1.getAbsolutePath());
		
		//Relative Path
		File f2 = new File("LOL.exe");
		System.out.println(f2.getAbsolutePath());
		
		//Use f1 as directory
		File f3 = new File(f1, "LOL.exe");
		System.out.println(f3.getAbsolutePath());
		//File Method:
		File file = new File("E:/Java/Test");
		File file1 = new File(file, "test2.txt");
		System.out.println(file);
		//exists()
		System.out.println(file.exists());
		System.out.println(file1.exists());
		//isDirectory()
		System.out.println(file.isDirectory());
		System.out.println(file1.isDirectory());
		//isFile()
		System.out.println(file.isFile());
		System.out.println(file1.isFile());
		//length()
		System.out.println(file.length());
		System.out.println(file1.length());
		//LastModified Time
		long time = file1.lastModified();
		Date date = new Date(time);
		System.out.println(date);
		file1.setLastModified(111111111L);
		//renameTo()
		file1.renameTo(f3);//Fail
		File file3 = new File("e:/Java/Test/test.txt");
		file1.renameTo(file3);
		System.out.println(file1.getAbsolutePath());//Object does not change.
		//list();//All file'String name inside folder 
		System.out.println(Arrays.toString(file.list()));
		//listFiles(): All files inside folder
		File[] files = file.listFiles();
		//Parent folder
		//getParent() :Get parent folder string
		System.out.println(file.getParent());
		//get parent folder file
		File parent = file.getParentFile();
		//mkdir()
		file = new File("e:/Java/Test/Folder/folder");
		file.mkdir();//Folder does not exist, so it is invalid
		file.mkdirs();//Build Folder at the same time;
		//createFile()
		try {
			file = new File("e:/Java/Test/test3.txt");
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//List root 
		File[] roots = file.listRoots();
		System.out.println(Arrays.toString(roots));
		//Delete file;
		file.delete();
		
		
		//Byte Stream
//		InputStream, OutputStream //Abstract Class
		File inFile = new File("e:/Java/Test/input.txt");
		File outFile = new File("e:/Java/Test/output.txt");
		try {
			FileInputStream fis = new FileInputStream(inFile);
			byte[] inData = new byte[(int)inFile.length()];
			fis.read(inData);
			for (byte b : inData) {
				System.out.print(b + ", ");
			}
			fis.close();
			FileOutputStream fos = new FileOutputStream(outFile);
			fos.write(inData);
			fos.close();//Close Stream
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		//Close File
		//1: Close file inside try
		try{
			File f = new File("e:/Java/Test/test.txt");
			FileInputStream fis = new FileInputStream(f);
			byte[] data = new byte[(int)f.length()];
			fis.read(data);
			fis.close();//If there is exception the stream may not be closed
		}catch(IOException e) {
			e.printStackTrace();
		}
		//2. Close file in finally
		FileInputStream fileIs = null;
		try {
			File f = new File("e:/Java/Test/test.txt");
			fileIs = new FileInputStream(f);
			byte[] data = new byte[(int)f.length()];
			fileIs.read(data);
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if (fileIs != null) {
				try {
					 fileIs.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
		//3. use try() AutoClosable
		inFile = new File("e:/Java/Test/input.txt");
		outFile = new File("e:/Java/Test/output.txt");
		try(FileInputStream fileis = new FileInputStream(inFile);
		     FileOutputStream fileos = new FileOutputStream(outFile)){
			byte[] indata = new byte[(int)inFile.length()];
			fileis.read(indata);
			fileos.write(indata);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		//Character Stream Reader Writer
		try(FileReader fr = new FileReader(inFile);
			FileWriter fw = new FileWriter(outFile)){
			char[] data = new char[(int) inFile.length()];
			fr.read(data);
			for (char c : data) {
				System.out.print(c);
			}
			System.out.println();
			String outData = "12345678";
			fw.write(outData);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		//Chinese Problem
		//1: ISO ASCII 2: GBK, GB2312, BIG5 3: UNICODE UTF-8 (English Letter(1 byte), Chinese word(3-byte))
		String str = "中";
		//Read Chinese using FileInputStream
		file = new File("e:/Java/Test/test.txt");
		try(FileInputStream fis = new FileInputStream(file)){
			byte[] words = new byte[(int)file.length()];
			fis.read(words);
			for (byte b: words) {
				System.out.print(Integer.toHexString((int)(b) & 0Xff) + " ");
			}
			String s = new String(words, "GBK");
			System.out.println(s);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		//Read Chinese using FileReader
		System.out.println("Default Encoding Method:" + Charset.defaultCharset());
		try(FileReader fr = new FileReader(file)){
			char[] words = new char[(int)file.length()];
			fr.read(words);
			System.out.println("FileReader Using Default Character Set UTF-8:");
			System.out.println(String.valueOf(words));
		}catch(IOException e) {
			e.printStackTrace();
		}
		//InputStreamReader
		try(InputStreamReader isr = new InputStreamReader(new FileInputStream(file), Charset.forName("GBK"))){
			char[] words = new char[(int)file.length()];
			isr.read(words);
			System.out.println("InputStreamReader set char set as GBK:");
			System.out.println(String.valueOf(words));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		//BufferStream
		//InputStream and Reader will visit the disk for each read operation.
		//BufferStream put a lot of data into the buffer and visit buffer for each read.
		//Diminish the number of IO operation
		
		//BufferedReader
		file = new File("e:/Java/Test/input.txt");
		try(FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr)){
			while(true) {
				String line = br.readLine();//Not read the \n sign
				if (null == line)
					break;
				System.out.println(line);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		//PrintWriter
		file = new File("e:/Java/Test/output.txt");
		try(FileWriter fw = new FileWriter(file);
		    PrintWriter pw = new PrintWriter(fw)){
			pw.println("hello world");
			pw.flush();
			pw.write("Teemo");
			pw.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		//DataStream
		//DataInputStream, DataOutputStream
		write();
		read();
		
		//Object Stream:
		//Object serializable
		Hero garen = new Hero("garen", 100.0f);
		file = new File("e:/java/test/hero.obj");
		try(FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis)){
			oos.writeObject(garen);
			Hero hero = (Hero)ois.readObject();
			System.out.println(hero);
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		//System.in
//		try(InputStream is = System.in){
//			while(true) {
//				int i = is.read();//the asc II of each character
//				System.out.println(i);
//			}
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
		//Scanner
//		Scanner sc = new Scanner(System.in);
		//Read String
//		while(true) {
//			String s = sc.nextLine();
//			System.out.println(s);
//			int i = sc.nextInt();
//			System.out.println(i);
//		}
		
		
		str = new String("E:\\Java\\Test");
		String dest = "E:\\Java\\Test\\Test";
		search(new File(str), "name");
//		copyFolder(str, dest);
//		copyFile(str, dest);	
//		generateClass();
//		serializeArray();
//		removeComment();
//		getWord();
//		showCode(str);
//		writeFile();
//		getMaxMinFile();
//		getMaxMinFileRecursively(new File("c:/Windows"));
//		System.out.println(maxFile + " length: " + maxFile.length());
//		System.out.println(minFile + " length: " + minFile.length());
//		decomposeFile();
//		composeFile();
//		encodeFile(inFile, outFile);
//		decodeFile(inFile,outFile);
	}
	
	public static void read() {
		File file = new File("e:/java/test/dataStream.txt");
		try(FileInputStream fis = new FileInputStream(file);
			DataInputStream dis = new DataInputStream(fis)){
		    boolean b = dis.readBoolean();
			int i = dis.readInt();
			float f = dis.readFloat();
			String str = dis.readUTF();
			char c = dis.readChar();
			System.out.println(b + " " + i + " " + f + " " + str + " " + c);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void write() {
		File file = new File("e:/java/test/dataStream.txt");
		try(FileOutputStream fos = new FileOutputStream(file);
			DataOutputStream dos = new DataOutputStream(fos)){
			dos.writeBoolean(true);
			dos.writeInt(23);
			dos.writeFloat(123.4f);
			dos.writeUTF("Hello World");
			dos.writeChar('c');
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void getWord(){
		byte[] words = {(byte) 0xe5, (byte)0xb1, (byte)0x8c};
		try {
			System.out.println(new String(words, "UTF-8"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void showCode(String str) {
		String[] codes = {"GBK", "GB2312", "BIG5", "UTF-8", "UTF-16", "UTF-32"};
		for (String code : codes) {
			showCode(str, code);
		}
	}
	
	private static void showCode(String str, String code) {
		System.out.printf("Display the %s in %s code:%n", str, code);
		try {
			byte[] codes = str.getBytes(code);
			for (byte c : codes) {
				System.out.print(Integer.toHexString((int)c & 0xff) + " ");
			}
			System.out.println('\n');
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	//Practice
	
	public static void copyFile(String srcFile, String destFile) {
		File inFile = new File(srcFile);
		File outFile = new File(destFile);
		byte[] data =  new byte [10240];
		try(FileInputStream fis = new FileInputStream(inFile);
		    FileOutputStream fos = new FileOutputStream(outFile)){
			while(true) {
				int actualLength = fis.read(data);
				if (actualLength == -1)
					break;
			    fos.write(data, 0, actualLength);
				fos.flush();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void copyFolder(String srcFolder, String destFolder) {
		File inFolder = new File(srcFolder);
		File outFolder = new File(destFolder);
		File[] files = inFolder.listFiles();
		if (!inFolder.exists() || !inFolder.isDirectory() || inFolder.isFile())
			return;
		if (!outFolder.exists())
			outFolder.mkdirs();
		for (File f : files) {
			String dest = destFolder + "/" + f.getName();
			if (f.isDirectory()) {
				copyFolder(f.getAbsolutePath(), dest);
			}else {
				copyFile(f.getAbsolutePath(), dest);
			}
		}
	}
	
	public static void search(File folder, String search) {
		if (!folder.isDirectory())
			return;
		File[] files = folder.listFiles();
		for (File f : files) {
			if (f.isFile() && f.getName().toLowerCase().endsWith(".java")) {
				try(FileReader fr = new FileReader(f);
					BufferedReader br = new BufferedReader(fr)){
					while(true) {
						String line = br.readLine();
						if (null ==  line)
							break;
						if (line.contains(search)) {
							System.out.printf("Find String %s inside the file %s%n", search, f.getAbsoluteFile());
							break;
						}
					}
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}else {
				search(f, search);	
			}
		}
	}
	
	public static void generateClass() {
		String str = "public class %s { "
				+ "\n\tpublic %s %s; "
				+ "\n\tpublic %s() {"
				+ "\n\t}"
				+ "\n\tpublic void set%s (%s %s){"
		        + "\n\t\tthis.%s = %s;"
		        + "\n\t}\n"
		        + "\n\tpublic %s get%s(){"
		        + "\n\t\treturn this.%s;"
		        + "\n\t}"
				+ "\n}";
		Scanner sc = new Scanner(System.in);
		System.out.println("Class Name");
		String className = sc.nextLine();
		System.out.println("Attribute Type");
		String attributeType = sc.nextLine();
		System.out.println("Atrribute Name");
		String attributeName = sc.nextLine();
		File file = new File("e:/java/test/class.java");
		try(FileWriter fw = new FileWriter(file);
			PrintWriter pw = new PrintWriter(fw)){
			System.out.printf(str, className, attributeType, attributeName, className, 
					Character.toUpperCase(attributeName.charAt(0)) + attributeName.substring(1), 
					attributeType, attributeName, attributeName, attributeName, attributeType, 
					Character.toUpperCase(attributeName.charAt(0)) + attributeName.substring(1),
					attributeName);
			pw.printf(str, className, attributeType, attributeName, className, 
					Character.toUpperCase(attributeName.charAt(0)) + attributeName.substring(1), 
					attributeType, attributeName, attributeName, attributeName, attributeType, 
					Character.toUpperCase(attributeName.charAt(0)) + attributeName.substring(1),
					attributeName);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void serializeArray() {
		Hero[] heros = new Hero[10];
		for (int i = 0; i < heros.length; i++) {
			heros[i] = new Hero(String.valueOf(i));
		}
		File file = new File("e:/java/test/heros.lol");
		try(FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			){
			oos.writeObject(heros);
			
			Hero[] hs = (Hero[])ois.readObject();
			for(Hero h: hs) {
				System.out.println(h);
			}
			
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void removeComment() {
		File inFile = new File("e:/Java/Test/test.java");
		File outFile = new File("e:/Java/Test/out.java");
		try(FileReader fr = new FileReader(inFile);
		    BufferedReader br = new BufferedReader(fr);
		    FileWriter fw = new FileWriter(outFile);
		    PrintWriter pw = new PrintWriter(fw)){
			while(true) {
				String line = br.readLine();
				if (null == line)
					break;
			    String temp = line.trim();
				if (temp.startsWith("//"))
					continue;
				pw.println(line);
				pw.flush();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void getMaxMinFile() {
		File root = new File("c:/Windows");
		File[] subFiles = root.listFiles();
		if (subFiles == null)
			return;
		long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
		File minFile = null, maxFile = null;
		for (File f : subFiles) {
			if (f.isDirectory())
				continue;
			if (f.length() < min && f.length() > 0) {
				min = f.length();
				minFile = f;
			}
			if (f.length() > max) {
				max = f.length();
				maxFile = f;
			}
		}
		System.out.println(minFile + " length: " + min);
		System.out.println(maxFile + " length: " + max);
	}
	
	public static void getMaxMinFileRecursively(File root) {
		if (root.isFile())
			return;
		File[] files = root.listFiles();
		if (files == null || files.length == 0)
			return;
		for (File f : files) {
			if (f.isDirectory())
				getMaxMinFileRecursively(f);
			else {
				if (maxFile == null || f.length() > maxFile.length()) {
					maxFile = f;
				}
				if (minFile == null || f.length() < minFile.length() && f.length() > 0) {
					minFile = f;
				}
			}
		}	
	}
	
	public static void writeFile() {
		File file = new File("e:/Java/Test/writeTest/writeFile/output.txt");
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		try {
			byte[] data = {-17, -69, -65, 72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100};
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(data);
			fos.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void decomposeFile() {
		int size = 100 *(int)Math.pow(2, 10);
		File origin = new File("e:/Java/Test/apache.exe");
		if (origin.length() == 0)
			return;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(origin);
			byte[] inData = new byte[(int)origin.length()];
			int num = (int)(origin.length() / size + (origin.length() % size == 0 ? 0 : 1));
			byte[] outData;
			String outPath = "e:/Java/Test/Output/apache.exe-"; 
			for (int i = 0; i < num; i++) {
				if (i < num - 1) {
					outData = Arrays.copyOfRange(inData, i * size, (i + 1) * size);
				}else {
					outData = Arrays.copyOfRange(inData, i * size, inData.length);
				}
				File outFile = new File(outPath + i);
				if (!outFile.getParentFile().exists())
					outFile.getParentFile().mkdirs();
				fos = new FileOutputStream(outFile);
				fos.write(outData);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if (null != fis) {
				try {
					fis.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
			if (null != fos) {
				try {
					fos.close();
				}catch(IOException e) {
					e.printStackTrace();
				}	
			}
		}
	}
	
	public static void composeFile() {
		File folder = new File("e:/Java/Test/Output");
		File[] files = folder.listFiles();
		int size = 0;
		for (File f: files) {
			if (f.getAbsolutePath().contains("apache.exe-"))
				size += f.length();
		}
		byte[] outData = new byte[size];
		int j = 0;
		for (int i = 0; i < files.length; i++) {
			File file = new File(folder, "apache.exe-"+i);
			if (!file.exists())
				continue;
			try (FileInputStream fis = new FileInputStream(file);){
				byte[] inData = new byte[(int)file.length()];
				fis.read(inData);
				System.arraycopy(inData, 0, outData, j, (int)file.length());
				j += file.length();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		File outFile = new File(folder, "apache.exe"); 
		try (FileOutputStream fos = new FileOutputStream(outFile);){
			fos.write(outData);
		}catch(IOException e) {
			e.printStackTrace();
		}	
	}
	
	public static void encodeFile(File encodingFile, File encodedFile) {
		if (encodingFile == null || encodedFile == null || !encodingFile.exists())
			return;
		try(FileReader fr = new FileReader(encodingFile);
			FileWriter fw = new FileWriter(encodedFile)){
			char[] data = new char[(int)encodingFile.length()];
			fr.read(data);
			for (int i = 0; i < data.length; i++) {
				if (Character.isDigit(data[i])) {
					data[i] = (char)((data[i] - '0' + 1) % 10 + '0');
				}
				else if (Character.isUpperCase(data[i])) {
					data[i] = (char)((data[i] - 'A' + 1) % 26 + 'A');
				}else if (Character.isLowerCase(data[i])) {
					data[i] = (char)((data[i] - 'a' + 1) % 26 + 'a');
				}
			}
			fw.write(data);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void decodeFile(File decodingFile, File decodedFile) {
		if (decodingFile == null || decodedFile == null || !decodingFile.exists())
			return;
		try(FileReader fr = new FileReader(decodingFile);
			FileWriter fw = new FileWriter(decodedFile)){
			char[] data = new char[(int)decodingFile.length()];
			fr.read(data);
			for (int i = 0; i < data.length; i++) {
				if (Character.isDigit(data[i])) {
					data[i] = (char)((data[i] - '0' + 9) % 10 + '0');
				}else if (Character.isLowerCase(data[i])) {
					data[i] = (char)((data[i] - 'a' + 25) % 26 + 'a');
				}else if (Character.isUpperCase(data[i])) {
					data[i] = (char)((data[i] - 'A' + 25) % 26 + 'A');
				}
			}
			fw.write(data);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
