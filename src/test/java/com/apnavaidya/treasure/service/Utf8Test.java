package com.apnavaidya.treasure.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Utf8Test {

	public static void main(String[] args) {
		String str = "अपना";
		str = "Loss_of weight";
		StringBuilder str1 = new StringBuilder(str);
		str1.insert(2, ':');
		System.out.println(str1);

		try {

			// String str1 = "000001244";
			// System.out.println(Long.parseLong(str1));
			//
			// String str2 = "pradeep\n\n\n";
			// System.out.println(str2.matches("\n"));

			// Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("IST"));
			//
			// cal.add(Calendar.DAY_OF_MONTH, 1);
			// System.out
			// .println(cal.getTime() + " , day of week : " +
			// cal.get(Calendar.DAY_OF_WEEK) + " , day of month : "
			// + cal.get(Calendar.DAY_OF_MONTH) + " , hour of day : " +
			// cal.get(Calendar.HOUR_OF_DAY)
			// + " , minute : " + cal.get(Calendar.MINUTE) + " , second :" +
			// cal.get(Calendar.SECOND)
			// + " ,date : " + cal.get(Calendar.DATE) + " , Hour : " +
			// cal.get(Calendar.HOUR));
			// // Date currentTime = cal.getTime();
			// System.out.println(currentTime + ",---," + currentTime.getDay() +
			// ",Time() : " + currentTime.getTime()
			// + ",Date() : " + currentTime.getDate() + ",Month() : " +
			// currentTime.getMonth());
			// // cal.add(Calendar.MONTH, 3);
			// Date nextTime = cal.getTime();
			// // System.out.println(nextTime + ",---," + nextTime.getDay());
			// // cal.add(Calendar.HOUR, 1);
			// // nextTime = cal.getTime();
			// // System.out.println(nextTime + ",---," + nextTime.getDay());
			// cal.add(Calendar.MINUTE, 30);
			// nextTime = cal.getTime();
			// System.out.println(nextTime + ",---," + nextTime.getDay());
			//
			// System.out.println("Difference in time is : " +
			// (nextTime.getTime() - currentTime.getTime()));
			//
			// nextTime.setHours(10);
			// nextTime.setMinutes(0);
			// nextTime.setSeconds(0);
			// System.out.println(nextTime + ",last--," + nextTime.getDay());
			// System.out.println("Am-Pm format : " +
			// getTimeInAmPmFormat(nextTime));
			//
			// String dateString = nextTime.toString();
			//
			// System.out.println("\n\n\nYour date test is here ---,initial :\n"
			// + dateString + "\n");
			//
			// Date date = null;
			// String formatteddate1 = null, formatteddate2 = null;
			// DateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss 'IST'
			// yyyy");
			// DateFormat df1 = new SimpleDateFormat("dd-MM-yyyy");
			// DateFormat df2 = new SimpleDateFormat("HH:mm");
			// try {
			// date = df.parse(dateString);
			//
			// System.out.println("Parsed date : " + date);
			// formatteddate1 = df1.format(date);
			// formatteddate2 = df2.format(date);
			// } catch (Exception ex) {
			// System.out.println(ex);
			// }
			// System.out.println(" format1--> " + formatteddate1);
			// System.out.println(" format2--> " + formatteddate2);

			System.out.println(str);

			String encoded = null, decoded = null;
			encoded = URLEncoder.encode(str, "UTF-8");
			 System.out.println(encoded);
			decoded = URLDecoder.decode(encoded, "UTF-8");
			 System.out.println(decoded);
			 decoded = URLDecoder.decode(encoded, "UTF-8");
			 System.out.println(decoded);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

	public static String getTimeInAmPmFormat(Date date) {
		String time = null;
		DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
		time = dateFormat.format(date).toString();
		return time;
	}
}
