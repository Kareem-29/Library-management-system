/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;


public class LibraryCard {
	// libraryCard attribute
	private String expiritionDate;
	String card;
	Borrower b;
	
	// constructor
	public LibraryCard(Borrower b) {
		this.b = b;
		generateCardNo(b);
	}
	
	// private method to generate the card
	private void generateCardNo(Borrower b) {
		String fname =b.getFirstName().substring(0,1);
		String lname = b.getLastName().substring(0,1);
		String phone = b.getPhoneNumber();
		card = fname+lname+phone;
		setCard(card);
		System.out.println("Your LibrarayCard is: ["+ card +"]\n");
	}
	
	public void setCard(String card) {
		this.card = card;
	}
	
	public void setExpiritionDate(String expiritionDate) {
		this.expiritionDate = expiritionDate;
	}
	
	public String printCard() {
		return "CardNumber: " + card + " ExpiritionDate: " + expiritionDate + " \n";
	}
	
	public String getExpiritionDate() {
		return "Your card expires in : " + expiritionDate;
	}
	
	public String getCardNumber() {
		return card;
	}
	

}

