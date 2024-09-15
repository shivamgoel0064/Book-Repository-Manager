package com.shivam.LibraryManagementSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.shivam.LibraryManagementSystem.entity.Book;
import com.shivam.LibraryManagementSystem.entity.IssuedBook;
import com.shivam.LibraryManagementSystem.entity.Librarian;

@Controller
public class ViewController {

	@GetMapping({"/", "/logout"})
	public String homePage() {
		return "index";
	}
	
	@GetMapping("/adminLogin")
	public String getAdminLogin() {
		return "adminLogin";
	}
	
	@GetMapping("/adminPanel")
	public String getAdminPanel() {
		return "adminPanel";
	}

	@GetMapping("/deleteLibrarian")
	public String getDeleteLibrarian() {
		return "deleteLibrarian";
	}
	
	@GetMapping("/librarianLogin")
	public String getLibrarianLogin() {
		return "librarianLogin";
	}

	@GetMapping("/addLibrarian")
	public String getAddLibrarian(@ModelAttribute("librarian") Librarian librarian) {
		return "addLibrarian";
	}

	@GetMapping("/addBook")
	public String getAddBook(@ModelAttribute("book") Book book) {
		return "addBook";
	}

	@GetMapping("/librarianPanel")
	public String getLibrarianPanel() {
		return "librarianPanel";
	}
	
	@GetMapping("/issueBook")
	public String getIssueBook(@ModelAttribute("issuedBook") IssuedBook issuedBook) {
		return "issueBook";
	}
	
	@GetMapping("/returnBook")
	public String getReturnBook() {
		return "returnBook";
	}

}
