package com.shivam.LibraryManagementSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sno;
	private String bookNum;
	private String bookName;
	private String author;
	private String publisher;
	private int quantity;
	private int issuedBookQty = 0;
	
	public Book() {
		
	}
	
	public Book(String bookNum, String bookName, String author, String publisher, int quantity) {
		super();
		this.bookNum = bookNum;
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.quantity = quantity;
	}
	
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getBookNum() {
		return bookNum;
	}
	public void setBookNum(String bookNum) {
		this.bookNum = bookNum;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getIssuedBookQty() {
		return issuedBookQty;
	}

	public void setIssuedBookQty(int issuedBookQty) {
		this.issuedBookQty = issuedBookQty;
	}
	@Override
	public String toString() {
		return "Book [sno=" + sno + ", bookNum=" + bookNum + ", bookName=" + bookName + ", author=" + author
				+ ", publisher=" + publisher + ", quantity=" + quantity + "]";
	}
}
