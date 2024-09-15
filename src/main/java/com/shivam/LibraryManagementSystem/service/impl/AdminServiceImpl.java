package com.shivam.LibraryManagementSystem.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shivam.LibraryManagementSystem.entity.Librarian;
import com.shivam.LibraryManagementSystem.repository.AdminRepository;
import com.shivam.LibraryManagementSystem.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	private AdminRepository repo;

	public AdminServiceImpl(AdminRepository repo) {
		super();
		this.repo = repo;
	}
	
	@Override
	public String authenticateAdmin(String username, String password) {
		
		if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin123")) {
			return "adminPanel";
		}
		return "index";
	}

	@Override
	public String saveLibrarian(Librarian lib) {
		
		repo.save(lib);
		return "adminPanel";
	}

	@Override
	public List<Librarian> getLibrarians() {
		
		return repo.findAll();
	}

	@Override
	public String deleteLibrarian(String name) {
		
		repo.deleteByName(name);
		return "adminPanel";
	}
}
