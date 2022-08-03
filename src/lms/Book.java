/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;


public class Book extends LibraryItem {
	// Book attribute
	private String bookISBN;
	
	// book constructor
	public Book(String title, float cost, String author, String status, int typeNumber,
			String bookISBN) {
		super(title, cost, author, status, typeNumber);
		this.bookISBN = bookISBN;
	}

	public String getBookISBN() {
		return bookISBN;
	}
	
	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}
	// display
	public String displayDetails() {
		return "ISBN : " + bookISBN + super.displayDetails();
	}

}
