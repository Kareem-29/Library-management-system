/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;


public class Borrower {
	// borrower attribute
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	private LibraryCard libraryCard;
	
	// borrower constructor
	public Borrower(String firstName, String lastName, String address, String phoneNumber) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.address=address;
		this.phoneNumber=phoneNumber;
		this.libraryCard = new LibraryCard(this);
		this.libraryCard.setExpiritionDate("December 2021");
	}
	
	public LibraryCard getLibraryCard() {
		return libraryCard;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setName(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	// display
	public String displayInfo() {
		return "\nFirstName: " + firstName + "\nLastName: " +lastName + "\nAddress: " + address + "\nPhoneNumber :" + phoneNumber + "\n";
	}
	
}
