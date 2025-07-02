package com.dsa.practice;

public class Switch_HttpStatusCode {
	
	public static String getStatusMessage(int statusCode) {
		switch(statusCode) {
		case 200:
			return "OK";
		case 201:
			return "Created";
		case 400:
			return "Bad Request";
		case 401:
			return "Unauthorised";
		case 403:
			return "Forbidden";
		case 404:
			return "Not Found";
		case 500:
			return "Internal Server Error";
		default:
			return "Unknown status";
		}
	}
	
	public static void main(String[] args) {
		int statusCode = 403;
		String statusMessage = getStatusMessage(statusCode);
		System.out.println("Status for code " + statusCode + " is: " + statusMessage);
	}
}