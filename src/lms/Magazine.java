/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;


public class Magazine extends LibraryItem{
	// Magazine attribute
	private String issueDate;
	
	// Magazine constructor
	public Magazine(String title, float replacementCost, String author, String status, int typeNumber,
			String issueDate) {
		super(title, replacementCost, author, status, typeNumber);
		this.issueDate = issueDate;
	}
	
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	// display
	public String displayDetails() {
		return "issue Date : " + this.issueDate + super.displayDetails();
	}

}

