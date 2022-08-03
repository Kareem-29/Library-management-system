/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;


public class AudioTape extends LibraryItem {
	
	// AudioTape Attributes
	private int trackNo;
	
	// AudioTape constructor
	public AudioTape(String title, float replacementCost, String author, String status, int typeNumber,
			int trackNo) {
		super(title, replacementCost, author, status, typeNumber);
		this.trackNo = trackNo;
	}

	public void setTrackNo(int trackNo) {
		this.trackNo = trackNo;
	}
	
	// display
	public String displayDetails() {
		return "trackNo : " + trackNo + super.displayDetails();
	}
 
}
