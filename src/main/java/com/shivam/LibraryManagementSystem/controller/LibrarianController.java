package com.shivam.LibraryManagementSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shivam.LibraryManagementSystem.entity.Book;
import com.shivam.LibraryManagementSystem.entity.IssuedBook;
import com.shivam.LibraryManagementSystem.service.LibrarianService;

@Controller
public class LibrarianController {

	private LibrarianService service;
	
	public LibrarianController(LibrarianService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/authenticateLibrarian")
	public String authenticateLibrarian(@RequestParam String userid, String password) {
		
		return service.authenticateLibrarian(userid,password);
	}
	
	@PostMapping("/saveBook")
	public String saveBook(Book book) {
		
		return service.saveBook(book);
	}
	

	@GetMapping("/viewBooks")
	public String viewBooks(Model model) {
		
		model.addAttribute("books",service.getAllBooks());
		return "showBooks";
	}
	
	@PostMapping("/issueTheBook")
	public String issueBook(IssuedBook book) {
		
		return service.issueBook(book);
	}
	
	@GetMapping("/viewIssuedBooks")
	public String viewIssuedBooks(Model model) {
		
		model.addAttribute("issuedBooks", service.getAllIssuedBooks());
		return "showIssuedBooks";
	}
	
	@PostMapping("/returnTheBook")
	public String returnBook(@RequestParam String bookNum) {
		
		service.returnBook(bookNum);
		return "librarianPanel";
	}
}
