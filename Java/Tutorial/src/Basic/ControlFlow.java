package Basic;

public class ControlFlow {

	public static void main(String[] args) {
		//If Statement
		if (true) {
			System.out.println("Yes");
		}
		if (false)
			System.out.println("state1");
		    System.out.println("state2");
	    if (true) {
	    	System.out.println("state1");
		    System.out.println("state2");
	    }
	    if(false);//Pay attention to the comma
	    	System.out.println("Yes");
	    
	    boolean b = false;
	    if (b) {
	    	System.out.println("yes");
	    }else {
	    	System.out.println("No");	
	    }
		
	    int year = 2000;
	    if (year % 400 == 0) {
	    	System.out.println("Leap Year");
	    }else if (year % 4 == 0 && year % 100 != 0) {
	    	System.out.println("Leap Year");
	    }else {
	    	System.out.println("Normal Year");
	    }
	    
	    //Switch: Type: byte, short, int, char, String, enum
	    int month = 2;
	    switch(month) {
	    	case 2:
	    	case 3:
	    	case 4: System.out.println("Spring");
	    	   		break;
	    	case 5:
	    	case 6:
	    	case 7:System.out.println("Summer");
	    		   break;
	    	case 8:
	    	case 9:
	    	case 10:System.out.println("Autumn");
	    			break;
	    	case 11:
	    	case 12:
	    	case 1:System.out.println("Winter");
					break;
			default:
					System.out.println("Wrong input");
	    }
	    
	    //While, Do While loop
	    int i = 11;
	    int res = 1;
	    while (i > 1) {
	    	res *= i;
	    	i--;
	    }
	    System.out.println(res);
	    res = 1;
	    i = 11;
	    do {
	    	res *= i;
	    	i--;
	    }while(i > 0);//Pay attention to the semicolon
	    System.out.println(res);
		
	    //For
	    res = 0;
	    int dailyIncome = 1;
	    for (i = 1; i <= 10; i++) {
	    	res += dailyIncome;
	    	dailyIncome *= 2;
	    }
	    System.out.println(res);
	    
	    //Continue
	    for (i = 1; i <= 100; i++) {
	    	if (i % 3 == 0 || i % 5 == 0)
	    		continue;
	    	System.out.println(i);
	    }
	    
	    //Break inner loop
	    int target = (int)1e6;
	    int p = (int)1.2e4;
	    float r = 0.2f;
	    int n = 0;
	    int income = 0;
	    while (true) {
	    	income += p;
	    	income *= (1 + r);
	    	n++;
	    	if (income >= target)
	    		break;
	    }
	    System.out.println(n);
	    
	    //Break Outer loop
	    outloop:
	    for (i = 0; i < 10; i++) {
	    	for (int j = 0; j < 10; j++) {
	    		System.out.println(i + "," + j);
	    		if (i + j == 10) {
	    			break outloop;
	    		}
	    	}
	    }
	    
	    findGoldPoint();
	    daffodilsNumber();
	}
	
	//Practice
	public static void findGoldPoint() {
		float distance = 0.618f;
		int numerator = 1;
		int denominator = 1;
		for (int i = 1; i < 20; i++) {
			for (int j = i + 1; j < 20; j++) {
				if (i % 2 == 0 && j % 2 == 0)
					continue;
				if (Math.abs((float) i / (float) j - 0.618) < distance) {
					numerator = i;
					denominator = j;
					distance = (float) Math.abs((float) i / (float) j - 0.618); 
				}
			}
		}
		System.out.println(numerator + ", " + denominator);
	}
	
	public static void daffodilsNumber() {
		for (int i = 100; i < 1000; i++) {
			int digits = i % 10;
			int tens = i / 10 % 10;
			int hundreds = i / 100;
			if (i == Math.pow(digits, 3) + Math.pow(tens, 3) + Math.pow(hundreds, 3)) {
				System.out.println(i);
			}
		}
	}
}

