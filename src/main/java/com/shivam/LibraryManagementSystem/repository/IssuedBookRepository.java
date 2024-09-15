package com.shivam.LibraryManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivam.LibraryManagementSystem.entity.Book;
import com.shivam.LibraryManagementSystem.entity.IssuedBook;

import jakarta.transaction.Transactional;

public interface IssuedBookRepository extends JpaRepository<IssuedBook, Integer>{

	List<IssuedBook> findByBookNum(String bookNum);

	@Transactional
	List<IssuedBook> deleteByBookNum(String bookNum);
}
