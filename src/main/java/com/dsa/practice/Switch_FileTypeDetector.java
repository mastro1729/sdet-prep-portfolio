package com.dsa.practice;

public class Switch_FileTypeDetector {
	public static String getFileType(String extension) {
		if(extension == null)
			return "Unknown File Type";
		
		switch(extension.toLowerCase()) {
		case "pdf":
		case "doc":
		case "docx":
			return "Document";
			
		case "jpg":
		case "jpeg":
		case "png":
			return "Image";
			
		case "mp3":
		case "wav":
			return "Audio";
			
		case "mp4":
		case "avi":
			return "Video";
			
		default:
			return "Unknown File Type";
		}
	}
	
	public static void main(String[] args) {
		String extension = "jpg";
		String fileType = getFileType(extension);
		System.out.println("The file type for " + extension + " is: " + fileType);
	}
}