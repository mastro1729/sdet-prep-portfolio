package com.dsa.practice;

public class LearningGitHub {

	public static void main(String[] args) {
		System.out.println("Welcome to GitHub");
		
		// Once we run git init inside any project folder, it becomes a Local Git Repository because Git creates a hidden .git folder that tracks version control history for that project.
		
		// After running git init, the folder contains both the Working Directory and the Local Repository.
		// The Working Directory holds actual project files, and the Local Repository is the hidden .git folder that stores Git's history and commit data.
		// They both exist inside the same project folder but serve different purposes
		
		// Any changes we make will first reflect in the Working Directory.
		// If we want those changes to become part of your Local Git Repository (permanent in Git history), we must stage and commit them.
		
		// origin' is just the default name (alias) we give to the remote repository URL 
		// when linking a local Git repository to a remote like GitHub
			
		// After creating a remote repository on GitHub, 
		// we run git remote add origin <URL> to link our local Git repository with that remote repo.
		
		// git push origin main' means 
		// pushing the local 'main' branch into 
		// the remote repository named 'origin', which points to our GitHub repository.
			
		// The word "main" here refers to your local branch name,
		// and Git will by default push it to the same branch name on remote, unless you specify otherwise.
		
		// origin --	Destination (Where to push → Remote repo URL)
		// main -- Source (What to push → Local branch name)
		
		// We can push a local branch into a differently named remote branch by using git push origin localBranch:remoteBranch.
	}

}
