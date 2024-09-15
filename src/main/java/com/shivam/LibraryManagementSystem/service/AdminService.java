package com.shivam.LibraryManagementSystem.service;

import java.util.List;

import com.shivam.LibraryManagementSystem.entity.Librarian;

public interface AdminService {

	String authenticateAdmin(String username, String password);
	
	String saveLibrarian(Librarian lib);
	
	List<Librarian> getLibrarians();
	
	String deleteLibrarian(String name);
}
