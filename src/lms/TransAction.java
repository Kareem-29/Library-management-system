/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;


public class TransAction {
	
	// TransAction attributes
	private Borrower borrower;
	private LibraryItem item;
	
	// TransAction constructor
	public TransAction(Borrower borrower, LibraryItem item) {
		this.borrower = borrower;
		this.item = item;
	}
	
	public Borrower getBorrower() {
		return borrower;
	}
	
	public LibraryItem getItem() {
		return item;
	}
	
	// display
	public String displayTransActions() {
		return "\nFirstName: " + borrower.getFirstName() + "\nLastName: " + borrower.getLastName() + "\nAddress: " + borrower.getAddress()
		+ "\nPhoneNumber :" + borrower.getPhoneNumber() + "\nItemTitle: " + item.getTitle() + "\nItemAuthor: " + item.getAuthor()
		+ "\nCost: "+ item.getCost() + "\nStatus: " + item.getStatus();  
	}
	
	// display transaction's item
	public void displayItemInfo() {
		System.out.println(item.displayDetails());
	}
	

}
