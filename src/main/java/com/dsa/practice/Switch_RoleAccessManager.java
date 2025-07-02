package com.dsa.practice;

public class Switch_RoleAccessManager {
	
	public static String getAccessLevel(String role) {
		if(role == null)
			return "Unknown Role";
		
		switch(role.toLowerCase()) {
		case "admin":
			return "Full Access";
		case "editor":
			return "Edit Access";
		case "Viewer":
			return "Read-Only Access";
		case "guest":
			return "Limited Access";
		default:
			return "Unknown Role";
		}
	}
	
	public static void main(String[] args) {
		String role = "admin";
		String accessLevel = getAccessLevel(role);
		System.out.println("The access level for " + role + " is: " + accessLevel);
	}
}