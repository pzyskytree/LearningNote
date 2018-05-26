package Median;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

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
		FileInputStream fis = null;
		try {
			File f = new File("e:/Java/Test/test.txt");
			fis = new FileInputStream(f);
			byte[] data = new byte[(int)f.length()];
			fis.read(data);
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if (fis != null) {
				try {
					 fis.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
		//3. use try()
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
			fw.write(outData.toCharArray());
		}catch(IOException e) {
			e.printStackTrace();
		}
		
//		writeFile();
//		getMaxMinFile();
//		getMaxMinFileRecursively(new File("c:/Windows"));
//		System.out.println(maxFile + " length: " + maxFile.length());
//		System.out.println(minFile + " length: " + minFile.length());
//		decomposeFile();
//		composeFile();
//		encodeFile(inFile, outFile);
		decodeFile(inFile,outFile);
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
