package Basic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

public class DateAndCalendar {

	public static void main(String[] args) {
	
		//Current Time
		Date now = new Date();
		System.out.println(now);
		System.out.println(now.getTime());
		System.out.println(System.currentTimeMillis());
		Date origin = new Date(0);
		System.out.println(origin);
		Date date = new Date(100000);//1 = 1 millisecond
		System.out.println(date);
		System.out.println(date.getTime());
		//Date Format
		//Date to String:
		//y: year, M: month, d: day, H: 24 hour, h: 12h, m: minute, s: second,S:millisecond
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		Date d = new Date();
		String str = sdf.format(d);
		System.out.println(str);
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		String str2 = sdf2.format(d);
		System.out.println(str2);
		//String to Date
		str = "2016/2/3 12:12:12";
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try {
			Date date1 = sdf3.parse(str);
			System.out.println(date1);
		}catch(ParseException e) {
			e.printStackTrace();
		}
		
		//Calendar singlton pattern
		Calendar c = Calendar.getInstance();
		d = c.getTime();//getTime()
		System.out.println(d);
		c.setTime(new Date(0));//setTime()
		System.out.println(c.getTime());
		//add set
		c.add(Calendar.YEAR, 2);
		System.out.println(c.getTime());
		c.add(Calendar.MONTH, -1);
		System.out.println(c.getTime());
		c.set(Calendar.DATE, 3);
		System.out.println(c.getTime());
		
		getDate();
//		dateSort();
		
//		getRandomTime();
	}
	
	public static void getRandomTime() {
		long second = 1000;
		long minute = 60 * second;
		long hour = 60 * minute;
		long day = 24 * hour;
		long stime = 5 * hour + day * 365 * 25;
		for (int i = 1970; i < 1995; i++) {
			if (i % 4 == 0)
				stime += day;
		}
		Date start = new Date(stime);
		long etime = stime + day * 365 - second;
		Date end = new Date(etime);
		System.out.println(start);
		System.out.println(end);
		long randTime =  (long)(Math.random() * (etime - stime)) + stime;
		Date randDate = new Date(randTime);
		System.out.println(randDate);
	}
	
	
	public static void dateSort() {
		long second = 1000;
		long minute = 60 * second;
		long hour = 60 * minute;
		long day = 24 * hour;
		long start = hour * 5;
		long end = day * 365 * (2000 - 1970 + 1) + (2000 - 1972 + 4) / 4 * day - 1000 + start;
		Date[] dates = new Date[9];
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (int i = 0; i < 9; i++) {
			dates[i] = new Date((long)(Math.random() * (end - start)) + start);
			String str = sdf.format(dates[i]);
			System.out.print(str + "  ");
		}
		System.out.println();
		Arrays.sort(dates, new Comparator() {
			@Override
			public int compare(Object arg0, Object arg1) {
				// TODO Auto-generated method stub
				Date d1 = (Date)arg0;
				Date d2 = (Date)arg1;
				if ((d1.getTime()) % day < (d2.getTime()) % day)
					return -1;
				else 
					return 1;
			}
		});
		for (int i = 0; i < 9; i++) {
			String str = sdf.format(dates[i]);
			System.out.print(str + "  ");
		}
	}
	
	public static void getDate() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 2);
		c.set(Calendar.DATE, 1);
		c.add(Calendar.DATE, -3);
		System.out.println(c.getTime());
	}
	
	
}
