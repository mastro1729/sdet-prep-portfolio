package com.dsa.practice;

public class Switch_CountryCodeResolver {
	 public static String getCountryName(String code) {
	        if (code == null) return "Unknown Country";

	        switch (code.toUpperCase()) {
	            case "US":
	                return "United States";
	            case "IN":
	                return "India";
	            case "UK":
	                return "United Kingdom";
	            case "CA":
	                return "Canada";
	            case "AU":
	                return "Australia";
	            default:
	                return "Unknown Country";
	        }
	    }
	 
	public static void main(String[] args) {
		String countryCode = "IN";
        System.out.println("Country: " + getCountryName(countryCode));
	}
}