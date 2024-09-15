package com.shivam.LibraryManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivam.LibraryManagementSystem.entity.Librarian;

import jakarta.transaction.Transactional;

public interface AdminRepository extends JpaRepository<Librarian, Integer> {

	List<Librarian> findByName(String name);
	
	@Transactional
	List<Librarian> deleteByName(String name);
}
