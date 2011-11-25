package com.talend.tac.cases.executePlan;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class TriggerDate {
	public String minutes = "";
	public String hours = "";
	public String days = "";
	public String months = "";
	public String years = "";

	public TriggerDate getFuture(int hour) {
		TriggerDate time = new TriggerDate();
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
		date.setHours(date.getHours() + hour);
		String s = df.format(date);// system date
		s.replaceAll(" ", "-");
		s.replaceAll(":", "-");
		String after = (s.replaceAll(" ", "-").replaceAll(":", "-"));
		String dates[] = after.split("-");
		time.years += dates[0];
		time.months += dates[1];
		time.days += Integer.parseInt(dates[2]);
		time.hours += dates[3];
		time.minutes += dates[4];
		return time;

	}

	@SuppressWarnings("deprecation")
	public static TriggerDate getCurrent() {
		TriggerDate time = new TriggerDate();
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
		String s = df.format(date);// system date
		s.replaceAll(" ", "-");
		s.replaceAll(":", "-");
		String after = (s.replaceAll(" ", "-").replaceAll(":", "-"));
		String dates[] = after.split("-");
		time.years += dates[0];
		time.months += dates[1];
		time.days += Integer.parseInt(dates[2]);
		time.hours += dates[3];
		time.minutes += dates[4];
		return time;
	}

	public static boolean isClickFutureMonthButton(TriggerDate dateFuture) {
		TriggerDate current = getCurrent();
		boolean ok = false;
		if((Integer.parseInt(dateFuture.days)) < (Integer.parseInt(current.days))){
			ok = true;
		}
		return ok;
	}

	public static boolean isClickPastMonthButton(TriggerDate datePast) {
		TriggerDate current = getCurrent();
		boolean ok = false;
		if((Integer.parseInt(datePast.months)) < (Integer.parseInt(current.months))){
			ok = true;
		}
		return ok;
	}

	public HashMap<String, String> getMonthmap() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("01", "January");
		map.put("02", "February");
		map.put("03", "March");
		map.put("04", "April");
		map.put("05", "May");
		map.put("06", "June");
		map.put("07", "July");
		map.put("08", "August");
		map.put("09", "September");
		map.put("10", "October");
		map.put("11", "November");
		map.put("12", "December");
		return map;

	}

	public TriggerDate getPast(int hour) {
		TriggerDate time = new TriggerDate();
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
		date.setHours(date.getHours() - hour);
		String s = df.format(date);// system date
		s.replaceAll(" ", "-");
		s.replaceAll(":", "-");
		String after = (s.replaceAll(" ", "-").replaceAll(":", "-"));
		String dates[] = after.split("-");
		time.years += dates[0];
		time.months += dates[1];
		time.days += Integer.parseInt(dates[2]);
		time.hours += dates[3];
		time.minutes += dates[4];
		return time;
	}

	public String getFuture(String num) {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
		date.setHours(date.getHours() + Integer.parseInt(num));
		String s = df.format(date);// system date
		return s;
	}

	public String getPast(String num) {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
		date.setHours(date.getHours() - Integer.parseInt(num));
		String s = df.format(date);// system date
		return s;
	}

	public static void main(String args[]) {
		TriggerDate a = new TriggerDate();
		System.out.println(a.getFuture(24).days);
		System.out.println(a.getFuture(48).days);
		System.out.println(a.getPast(48).days);
		if(isClickFutureMonthButton(a.getFuture(48))){
			System.out.println("yes");
			
		}
	}
}
