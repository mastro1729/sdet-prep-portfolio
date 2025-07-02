package com.dsa.practice;

public class Switch_DayOfWeek {
	public static String getDayName(int dayNumber) {
        switch (dayNumber) {
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            case 7:
                return "Sunday";
            default:
                return "Invalid Day";
        }
    }
	
	public static void main(String[] args) {
		int day = 5;
        System.out.println("Day " + day + " is " + getDayName(day));
	}
}