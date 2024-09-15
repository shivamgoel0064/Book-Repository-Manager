package com.shivam.LibraryManagementSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shivam.LibraryManagementSystem.entity.Librarian;
import com.shivam.LibraryManagementSystem.service.impl.AdminServiceImpl;

@Controller
public class AdminController {
	
	AdminServiceImpl service;

	public AdminController(AdminServiceImpl service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/authenticateAdmin") 
	public String authenticateAdmin(@RequestParam String userid, String password) {
		
		return service.authenticateAdmin(userid, password);
	}

	@PostMapping("/saveLibrarian")
	public String saveLibrarian(Librarian lib) {
		
		return service.saveLibrarian(lib);
	}

	@GetMapping("/viewLibrarians")
	public String viewLibrarians(Model model) {
		
		model.addAttribute("librarians",service.getLibrarians());
		return "showLibrarians";
	}

	@PostMapping("/deleteLibrarians")
	public String deleteLibrarian(@RequestParam String name) {
		
		return service.deleteLibrarian(name);
	}

}
