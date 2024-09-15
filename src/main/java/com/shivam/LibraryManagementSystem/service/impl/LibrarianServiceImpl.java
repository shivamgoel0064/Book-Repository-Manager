package com.shivam.LibraryManagementSystem.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shivam.LibraryManagementSystem.entity.Book;
import com.shivam.LibraryManagementSystem.entity.IssuedBook;
import com.shivam.LibraryManagementSystem.entity.Librarian;
import com.shivam.LibraryManagementSystem.repository.AdminRepository;
import com.shivam.LibraryManagementSystem.repository.IssuedBookRepository;
import com.shivam.LibraryManagementSystem.repository.LibrarianRepository;
import com.shivam.LibraryManagementSystem.service.LibrarianService;

import jakarta.transaction.Transactional;

@Service
public class LibrarianServiceImpl implements LibrarianService {

	private LibrarianRepository repo;
	private AdminRepository adminRepo;
	private IssuedBookRepository issueRepo;
	
	public LibrarianServiceImpl(LibrarianRepository repo, AdminRepository adminRepo, IssuedBookRepository issueRepo) {
		super();
		this.repo = repo;
		this.adminRepo = adminRepo;
		this.issueRepo = issueRepo;
	}

	@Override
	public String authenticateLibrarian(String userid, String password) {
		List<Librarian> libs = adminRepo.findByName(userid);
		if(libs.size() > 0) {
			for(Librarian lib : libs) {
				if(password.equals(lib.getPassword())) {
					return "librarianPanel";
				}
			}
		} 
		return "index";
	}

	@Override
	public String saveBook(Book book) {
		repo.save(book);
		return "librarianPanel";
	}

	@Override
	public List<Book> getAllBooks() {
		
		return repo.findAll();
	}

	@Override
	@Transactional
	public String issueBook(IssuedBook issuedBook) {
		List<Book> books = repo.findByBookNum(issuedBook.getBookNum());
		if(books.size() == 0) {
			return "librarianPanel";
		}
		if(books.get(0).getQuantity() == 0) {
			return "librarianPanel";
		}
		Book book = books.get(0);
		System.out.println(book);
		book.setQuantity(book.getQuantity()-1);
		book.setIssuedBookQty(book.getIssuedBookQty()+1);
		repo.save(book);
		issueRepo.save(issuedBook);
		return "librarianPanel";
	}

	@Override
	public List<IssuedBook> getAllIssuedBooks() {
		
		return issueRepo.findAll();
	}

	@Override
	@Transactional
	public String returnBook(String bookNum) {
//		List<IssuedBook> issuedBooks = issueRepo.findByBookNum(bookNum);
//		if(issuedBooks.size() == 0) {
//			return "librarianPanel";
//		}
		List<Book> books = repo.findByBookNum(bookNum);
		if(books.size() == 0) {
			return "librarianPanel";
		}
		if(books.get(0).getIssuedBookQty() == 0) {
			return "librarianPanel";
		}
		issueRepo.deleteByBookNum(bookNum);
		repo.updateQuantity(bookNum, books.get(0).getQuantity() + 1);
		repo.updateIssuedQuantity(bookNum, books.get(0).getIssuedBookQty() - 1);
		return "librarianPanel";
	}
}
