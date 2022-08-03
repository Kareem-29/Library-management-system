/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;


public abstract class LibraryItem {
	
	// LibraryItem attributes.
	private String title;
	private float cost;
	private String author;
	private String Status;
	private int typeNumber;
	private int uniqueId;
	private static int counter=1;
	
	// constructor 
	public LibraryItem(String title, float cost, String author, String status, int typeNumber
			) {
		this.title = title;
		this.cost = cost;
		this.author = author;
		Status = status;
		this.typeNumber = typeNumber;
		this.uniqueId = counter;
		counter++;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public float getCost() {
		return cost;
	}
	
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getStatus() {
		return Status;
	}
	
	public void setStatus(String status) {
		Status = status;
	}
	
	public int getUniqueId() {
		return uniqueId;
	}
	
	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}
	// display item details
	public String displayDetails() {
		return "\nTitle: " + this.title + "\nCost: " + this.cost + "\nAuthor: " + this.author + "\nStatus: " + this.Status + "\n";
	}
	
	public String searchLibraryItem(String item) {
		return item;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public int getTypeNumber() {
		return typeNumber;
	}
	
	public void setTypeNumer(int typeNumer) {
		this.typeNumber=typeNumer;
	}

}
