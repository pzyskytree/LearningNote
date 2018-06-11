package Median;

import java.util.List;

public class PasswordThread extends Thread{
	String password;
	List<String> passwords;
	boolean found = false;
	
	public PasswordThread(String password, List<String> passwords) {
		this.password = password;
		this.passwords = passwords;
	}
	
	public void run() {
		decode("", this.password);
	}
	
	public void decode(String password, String target) {
		if (this.found)
			return;
		if (password.length() == target.length()) {
			this.passwords.add(password);
			if (password.equals(target)) {
				System.out.println("Found " + password);
				found = true;
			}
		}else {
			for (short i = '0'; i <= 'z'; i++) {
				if (Character.isLetterOrDigit(i))
					decode(password + (char)i, target);
			}
		}
	}
}
