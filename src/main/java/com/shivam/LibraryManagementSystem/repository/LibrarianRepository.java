package com.shivam.LibraryManagementSystem.repository;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shivam.LibraryManagementSystem.entity.Book;

import jakarta.transaction.Transactional;

public interface LibrarianRepository extends JpaRepository<Book, Integer>{

	List<Book> findByBookNum(String bookNum);

	@Modifying
	@Transactional
	@Query("UPDATE Book SET quantity = :quantity where bookNum = :bookNum")
	void updateQuantity(@Param("bookNum") String bookNum,@Param("quantity") int quantity);

	@Modifying
	@Transactional
	@Query("UPDATE Book SET issuedBookQty = :issuedQuantity where bookNum = :bookNum")
	void updateIssuedQuantity(@Param("bookNum") String bookNum,@Param("issuedQuantity") int issuedQuantity);
}
