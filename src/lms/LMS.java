/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

/**
 *
 * @author Kareem_29
 */
import java.util.ArrayList;
import java.util.Scanner;

public class LMS {

	// main method
	public static void main(String[] args) {

		// the scanner object to take input
		Scanner input = new Scanner(System.in);

		// Variables to keep track of input
		int option = 0;

		// ArrayLists that are needed ..
		ArrayList<Borrower> borrowers = new ArrayList<>();
		ArrayList<LibraryItem> items = new ArrayList<>();
		ArrayList<TransAction> trans = new ArrayList<>();

		do {
			// select user type
			System.out.println("Enter 1 For [ Library Borrower ]");
			System.out.println("Enter 2 For [ Library Administrator ]");
			System.out.println("Enter 3 For [ Terminationg The program off ]");
			boolean error = true;
			// check the user input if it's number or not
			while (error) {
				System.out.println("Choice: ");
				try {
					option = input.nextInt();
					error = false;
				} catch (Exception e) {
					// exception happened
					System.out.println("Please Enter a number");
					input.next();
				}
			}
			switch (option) {
			case 1: {
				System.out.println("Libraby Borrower");
				do {
					// the basic menu for user
					System.out.println("\n[1] Register new borrower:");
					System.out.println("[2] Show My Information:");
					System.out.println("[3] Show Available Library items:");
					System.out.println("[4] Check-out/return/reserve library item:");
					System.out.println("[5] Search For an Item");
					System.out.println("[6] Exit:");
					error = true;
					// check the input
					while (error) {
						// while the input is wrong
						System.out.println("Choice: ");
						try {
							option = input.nextInt();
							error = false;
						} catch (Exception e) {
							System.out.println("Please Enter a number");
							input.next();
						}
					}

					switch (option) {
					// case 1 to register
					case 1: {
						boolean create = true;
						// borrower information
						System.out.println("Enter First Name: ");
						String first_name = input.next();
						System.out.println("Enter Last Name: ");
						String last_name = input.next();
						System.out.println("Enter Address: ");
						String address = input.next();
						System.out.println("Enter Phone Number: ");
						String phone = input.next();
						for (Borrower b : borrowers) {
							if (b.getPhoneNumber().equals(phone)) {
								create = false;
							}
						}
						// if the phone number isn't duplicated we will go to this block ..
						if (create == true) {
							System.out.println("\n[Registered successfully] ..\n");
							borrowers.add(new Borrower(first_name, last_name, address, phone));
						}
						// if the phone number is duplicated we will go to this block ..
						else {
							System.out.println("Another borrower registered with that phone number");
						}
						break;
					}
					// end of case 1
					case 2: {
						// we will verify the LibraryCard of the borrower
						System.out.println("Enter Your LibraryCard: ");
						String librarycard = input.next();
						boolean auth = false;
						for (Borrower b : borrowers) {
							if (b.getLibraryCard().getCardNumber().equals(librarycard)) {
								// if the LibraryCard is verified we will display the info of the customer and
								// his items ..
								System.out.print("Borrower Info :\n");
								System.out.print("========================");
								System.out.print(b.displayInfo());
								System.out.print("LibraryCard: " + b.getLibraryCard().getCardNumber() + "\n");
								auth = true;
								for (TransAction s : trans) {
									if (s.getBorrower() == b) {
										// display transaction info
										s.displayItemInfo();
									}

								}
								System.out.print("========================\n\n");
							}
						}
						if (auth == false) {
							// if the card does not exists or wrong card number.
							System.out.println("\nAuth System : Invalid LibraryCard. \n");
						}
						break;
					}
					// end of case 2
					case 3:
						// case for to display available items in the library.
						// using a menu also.
						System.out.println("Enter an option: ");
						System.out.println("[1] To display Books: ");
						System.out.println("[2] To display Magazines: ");
						System.out.println("[3] To display AudiTapes: ");
						System.out.println("[4] To display All Items: ");
						int item_selections = input.nextInt();
						switch (item_selections) {
						// depends on the input of the user we will display the items of the selected
						// category.
						// we will also check the status of the item if it's Available or returned we
						// will display it's info otherwise no.
						case 1:
							System.out.println("\nDisplaying all Available books .. \n");
							boolean foundBook = false;
							for (LibraryItem s : items) {
								if (s.getTypeNumber() == 1) {
									// display item that is Returned or Available
									if (s.getStatus().equals("Available") || s.getStatus().equals("Returned")) {
										foundBook = true;
										System.out.println(s.displayDetails());
									}
								}

							}
							if (foundBook == false) {
								System.out.println("There is no Available books!");
							}
							break;

						case 2:
							System.out.println("\nDisplaying all Available Magazines .. \n");
							boolean foundMagazine = false;
							for (LibraryItem s : items) {
								if (s.getTypeNumber() == 2) {
									// display item that is Returned or Available
									if (s.getStatus().equals("Available") || s.getStatus().equals("Returned")) {
										System.out.println(s.displayDetails());
										foundMagazine = true;
									}
								}

							}
							if (foundMagazine == false) {
								System.out.println("There is no Available magazines!");
							}
							break;
						case 3:
							System.out.println("\nDisplaying all Available Audio Tapes .. \n");
							boolean foundTapes = false;
							for (LibraryItem s : items) {
								if (s.getTypeNumber() == 3) {
									// display item that is Returned or Available
									if (s.getStatus().equals("Available") || s.getStatus().equals("Returned")) {
										System.out.println(s.displayDetails());
										foundTapes = true;
									}
								}

							}
							if (foundTapes == false) {
								System.out.println("There is no Available Audio Tapes!");
							}
						case 4:
							System.out.println("\nDisplaying all Available Items .. \n");
							boolean foundItems = false;
							for (LibraryItem s : items) {
								// display item that is Returned or Available
								if (s.getStatus().equals("Available") || s.getStatus().equals("Returned")) {
									System.out.println(s.displayDetails());
									foundItems = true;
								}

							}
							if (foundItems == false) {
								System.out.println("There is no Available Items!");
							}
							break;
						default:
							// if the input is incorrect
							System.out.println("Wrong Option !");
							break;
						}
						break;

					// end of case 3
					case 4:
						// case 4 to make a transAction ..
						boolean auth = false;
						// check the Library card of the borrower before making anything.
						System.out.println("Enter LibraryCard: ");
						String card = input.next();
						for (Borrower b : borrowers) {
							if (card.equals(b.getLibraryCard().getCardNumber())) {
								// if this true and the card is valid, we will print a hello message and then
								// jump to next block
								System.out.println("========================");
								System.out.println("You Have logged In, Welcome To The System");
								System.out.print("========================\n");
								auth = true;
							}
						}
						if (auth == false) {
							// if card is incorrect ..
							System.out.println("\nAuth System : Invalid LibraryCard. \n");
						}

						else if (auth == true) {
							// menu to select the option of item to make a transAction to it.
							System.out.println("Enter an option: ");
							System.out.println("[1] for Books: ");
							System.out.println("[2] for Magazines: ");
							System.out.println("[3] for AudiTapes: ");
							item_selections = input.nextInt();
							if (item_selections == 1 || item_selections == 2 || item_selections == 3) {
								item_selections = 1;
								switch (item_selections) {
								// we will check the unique id of the item before making the transActions.
								case 1:
									System.out.println("Enter Unique id, of the wanted item: ");
									System.out.println("Enter Unique id: ");
									int id = input.nextInt();
									boolean foundItem = false;
									for (LibraryItem item : items) {
										if (item.getUniqueId() == id && item.getTypeNumber() == 1) {
											// options
											System.out.println("Enter an option: ");
											System.out.println("[1] to Check-Out the item: ");
											System.out.println("[2] to Return the item: ");
											System.out.println("[3] to Reserve the item: ");
											foundItem = true;
											item_selections = input.nextInt();
											switch (item_selections) {
											case 1:
												if (item.getStatus().equals("Reserved")) {
													// case 1
													System.out.println("You can't checkout a resrved item");
												} else if (item.getStatus().equals("CheckedOut")) {
													// case 2
													System.out.println("That item is already checkedOut");
												} else if (item.getStatus().equals("Available")
														|| item.getStatus().equals("Returned")) {
													// check out the item and change it's status and also add a new
													// transaction
													item.setStatus("CheckedOut");
													for (Borrower b : borrowers) {
														if (b.getLibraryCard().getCardNumber().equals(card)) {
															trans.add(new TransAction(b, item));
															System.out.println(
																	// check out the item
																	"================================================");
															System.out.println(
																	"System : You have checkedout that item successfully....");
															System.out.println(
																	"================================================");
															System.out.println(
																	"You will be charged: " + item.getCost() + "$");
														}
													}

												}
												break;

											case 2:
												if (item.getStatus().equals("Reserved")) {
													// case 1
													item.setStatus("Returned");
													for (Borrower b : borrowers) {
														trans.add(new TransAction(b, item));
														System.out.println(
																"================================================");
														System.out.println(
																"System : You have returned that item successfully....");
														System.out.println(
																"================================================");
														break;
													}
												} else if (item.getStatus().equals("Available")) {
													// case 3
													System.out.println("You can't return an Available item!");
												} else if (item.getStatus().equals("CheckedOut")) {
													// case 3
													item.setStatus("Returned");
													for (Borrower b : borrowers) {
														if (b.getLibraryCard().getCardNumber() == card) {
															trans.add(new TransAction(b, item));
															System.out.println(
																	"================================================");
															System.out.println(
																	"System : You have returned that item successfully....");
															System.out.println(
																	"================================================");
														}
													}
													// return the item and change it's status and also add a new
													// transaction
												}
												break;
											case 3:
												if (item.getStatus().equals("Reserved")) {
													// case 1
													System.out.println("You can't reserve a resrved item");
												} else if (item.getStatus().equals("CheckedOut")) {
													// case 2
													System.out.println("You can't reserve a checkedout item");
												} else if (item.getStatus().equals("Available")) {
													// case 3
													item.setStatus("Reserved");
													for (Borrower b : borrowers) {
														if (b.getLibraryCard().getCardNumber() == card) {
															// reserve the item
															trans.add(new TransAction(b, item));
															System.out.println(
																	"================================================");
															System.out.println(
																	"System : You have reserved that item successfully....");
															System.out.println(
																	"================================================");
															System.out.println(
																	"You will be charged: " + item.getCost() + "$");
														}
													}

													break;
												}
											default:
												// if the input is incorrect.
												System.out.println("\nWrong Option..\n");
											}
										}

									}
									if (foundItem == false) {
										System.out.println("Wrong item id!");
									}
									break;
								}
							} else {
								System.out.println("Invalid Choice!");
							}
						}
						break;
					// end of case 4
					case 5:
						// ask the user for the item id
						boolean foundTheItem = false;
						int id = 0;
						error = true;
						// check user input
						while (error) {
							System.out.println("Enter item's unique id: ");
							try {
								id = input.nextInt();
								error = false;
							} catch (Exception e) {
								System.out.println("Please Enter a number");
								input.next();
							}
						}
						for (LibraryItem item : items) {
							// search for the item
							if (item.getUniqueId() == id) {
								System.out.println(item.displayDetails());
								foundTheItem = true;
							}
						}
						if (foundTheItem == false) {
							// if the item has not been found
							System.out.println("Did not find the item.");
						}
						break;
					// end of case 5
					}

				} while (option != 6);
				break;
			}
			case 2: {
				System.out.println("Libraby Admin");
				do {
					// the basic menu for admin
					System.out.println("\n[1] Search and display borrowers info using ID card number:");
					System.out.println("[2] Add new Library item:");
					System.out.println("[3] Display Library items:");
					System.out.println("[4] Display Library TransActions:");
					System.out.println("[5] Search for an item:");
					System.out.println("[6] Update Library item:");
					System.out.println("[7] Delete Library item:");
					System.out.println("[8] Exit:");
					error = true;
					// check the input
					while (error) {
						System.out.println("Choice:");
						try {
							option = input.nextInt();
							error = false;
						} catch (Exception e) {
							System.out.println("Please Enter a number");
							input.next();
						}
					}

					switch (option) {

					case 1: {
						// we will verify the LibraryCard
						System.out.println("Enter LibraryCard:");
						String librarycard = input.next();
						boolean auth = false;
						for (Borrower b : borrowers) {
							if (b.getLibraryCard().getCardNumber().equals(librarycard)) {
								// if the LibraryCard is verified we will display all info
								System.out.print("Borrower Info :\n");
								System.out.print("========================");
								System.out.print(b.displayInfo());
								System.out.print("LibraryCard: " + b.getLibraryCard().getCardNumber() + "\n");
								auth = true;
								for (TransAction s : trans) {
									if (s.getBorrower() == b) {
										s.displayItemInfo();
									}

								}
								System.out.print("========================\n\n");
							}
						}
						if (auth == false) {
							// if the card does not exists or wrong card number.
							System.out.println("\nAuth System : Invalid LibraryCard. \n");
						}
						break;
					}
					// end of case 2
					case 2:
						// case 3 to add items ;d
						// a menu also
						System.out.println("Enter an option: ");
						System.out.println("[1] To add Book: ");
						System.out.println("[2] To add Magazine: ");
						System.out.println("[3] To add AudiTape: ");
						int item_selections = input.nextInt();
						switch (item_selections) {
						// now we will go through instructions of adding the item depends on the input
						// of the user .
						// one all inputs are entered we will register that item and add it into the
						// ArrayList
						case 1:
							// enter book info
							System.out.println("Enter Book Title: ");
							String title = input.next();
							float cost = 0;
							error = true;
							while (error) {
								System.out.println("Enter Book Cost (float) : ");
								try {
									cost = input.nextFloat();
									error = false;
								} catch (Exception e) {
									System.out.println("Please Enter a number");
									input.next();
								}
							}
							System.out.println("Enter Book Author: ");
							String author = input.next();
							System.out.println("Enter Book ISBN: ");
							String isbn = input.next();
							// create the object and add it to the arrayList
							items.add(new Book(title, cost, author, "Available", 1, isbn));
							System.out.println("\nYou have added a book...\n");
							for (LibraryItem i : items) {
								if (i.getTypeNumber() == 1) {
									if (i.getAuthor() == author) {
										if (i.getTitle() == title) {
											// display item's unique id
											System.out.println("[ Item Unique ID: " + i.getUniqueId() + " ]\n");
										}
									}
								}
							}
							break;

						case 2:
							// magazine addition
							System.out.println("Enter Title: ");
							title = input.next();
							cost = 0;
							error = true;
							while (error) {
								System.out.println("Enter Cost (float) : ");
								try {
									cost = input.nextFloat();
									error = false;
								} catch (Exception e) {
									System.out.println("Please Enter a number");
									input.next();
								}
							}
							System.out.println("Enter Author: ");
							author = input.next();
							System.out.println("Enter issue date (String) : ");
							String issue_date = input.next();
							// create the object and add it to the arrayList
							items.add(new Magazine(title, cost, author, "Available", 2, issue_date));
							System.out.println("\nYou have added a magazine...\n");
							for (LibraryItem i : items) {
								if (i.getTypeNumber() == 2) {
									if (i.getAuthor() == author) {
										if (i.getTitle() == title) {
											// display item's unique id
											System.out.println("[ Item Unique ID: " + i.getUniqueId() + " ]\n");
										}
									}
								}
							}
							break;

						case 3:
							// audio tape addition
							System.out.println("Enter Title: ");
							title = input.next();
							cost = 0;
							error = true;
							// check for input
							while (error) {
								System.out.println("Enter Cost (float) : ");
								try {
									cost = input.nextFloat();
									error = false;
								} catch (Exception e) {
									System.out.println("Please Enter a number");
									input.next();
								}
							}
							System.out.println("Enter Author: ");
							author = input.next();
							System.out.println("Enter TrackNo (int) : ");
							int trackNo = input.nextInt();
							items.add(new AudioTape(title, cost, author, "Available", 3, trackNo));
							System.out.println("\nYou have added an AudioTape...\n");
							for (LibraryItem i : items) {
								if (i.getTypeNumber() == 2) {
									if (i.getAuthor() == author) {
										if (i.getTitle() == title) {
											// display item's unique id
											System.out.println("[ Item Unique ID: " + i.getUniqueId() + " ]\n");
										}
									}
								}
							}
							break;

						default:
							// if the input is not correct.. "option"
							System.out.println("OPS!!, that was a wrong option!!");

						}
						break;
					// end of case 3
					case 3:
						// displaying all items
						System.out.println("Enter 1 to display Available items");
						System.out.println("Enter 2 to display not Available items");
						int option1 = 0;
						boolean foundItems = false;
						error = true;
						// check the input
						while (error) {
							System.out.println("Choice: ");
							try {
								option1 = input.nextInt();
								error = false;
							} catch (Exception e) {
								System.out.println("Please Enter a number");
								input.next();
							}
						}
						if (option1 == 1) {
							// case 1
							for (LibraryItem item : items) {
								if (item.getStatus().equals("Available") || item.getStatus().equals("Returned")) {
									System.out.println(item.displayDetails());
									foundItems = true;
								}
							}
						} else if (option1 == 2) {
							// case 2
							for (LibraryItem item : items) {
								if (item.getStatus().equals("Reserved") || item.getStatus().equals("CheckedOut")) {
									System.out.println(item.displayDetails());
									foundItems = true;
								}
							}
						} else {
							// wrong input number
							System.out.println("Wrong input");
						}

						if (foundItems == false) {
							System.out.println("No items have been found!");
						}
						break;

					// end of case 3
					case 4:
						// displaying all transactions
						System.out.println("All Librabry TransActions");
						boolean foundTransActions = false;
						for (TransAction t : trans) {
							System.out.println("\n===============================");
							System.out.println(t.displayTransActions());
							foundTransActions = true;
							System.out.println("===============================\n");
						}
						if (foundTransActions == false) {
							System.out.println("No transActions have been found!");
						}
						break;
					// end of case 4.
					case 5:
						// ask for the item's id
						System.out.println("Enter item's unique id: ");
						boolean foundTheItem = false;
						int id = 0;
						error = true;
						// check the input
						while (error) {
							System.out.println("Choice: ");
							try {
								id = input.nextInt();
								error = false;
							} catch (Exception e) {
								System.out.println("Please Enter a number");
								input.next();
							}
						}
						for (LibraryItem item : items) {
							if (item.getUniqueId() == id) {
								// display the item
								System.out.println(item.displayDetails());
								foundTheItem = true;
							}
						}
						if (foundTheItem == false) {
							// no item found has an id that the user has asked for
							System.out.println("Did not find the item.");
						}
						break;
					// end of case 5
					case 6:
						// ask for the item's id
						System.out.println("Enter item's unique id: ");
						foundTheItem = false;
						id = input.nextInt();
						for (LibraryItem item : items) {
							// search for the item
							if (item.getUniqueId() == id) {
								// that's the same item the user wants
								System.out.println("Enter 1 to udpate the title");
								System.out.println("Enter 2 to udpate the author");
								System.out.println("Enter 3 to udpate the cost");
								int updateOption = 0;
								error = true;
								// check for input
								while (error) {
									System.out.println("Choice: ");
									try {
										updateOption = input.nextInt();
										error = false;
									} catch (Exception e) {
										System.out.println("Please Enter a number");
										input.next();
									}
								}

								if (updateOption == 1) {
									// case 1 update title
									System.out.println("Enter updated title:");
									item.setTitle(input.next());
									System.out.println("Updated");
								} else if (updateOption == 2) {
									// case 2 update author
									System.out.println("Enter updated author");
									item.setAuthor(input.next());
									System.out.println("Updated");
								} else if (updateOption == 3) {
									// check for valid cost
									error = true;
									while (error) {
										// case 3 update cost
										System.out.println("Enter updated cost: ");
										try {
											item.setCost(input.nextFloat());
											error = false;
										} catch (Exception e) {
											System.out.println("Please Enter a float number");
											input.next();
										}
									}
									System.out.println("Updated");
								} else {
									// input number is wrong
									System.out.println("wrong value");
								}

								foundTheItem = true;
							}
						}
						if (foundTheItem == false) {
							// no item has the id entered by the user
							System.out.println("Did not find the item.");
						}
						break;
					case 7:
						LibraryItem itemToBeDeleted = null;
						// ask the item's id
						foundTheItem = false;
						id = 0;
						error = true;
						// check the input
						while (error) {
							System.out.println("Enter item's unique id: ");
							try {
								id = input.nextInt();
								error = false;
							} catch (Exception e) {
								// exception happened
								System.out.println("Please Enter a number");
								input.next();
							}
						}
						for (LibraryItem item : items) {
							// search for the item
							if (item.getUniqueId() == id) {
								// found the same item the user searched for
								itemToBeDeleted = item;
								foundTheItem = true;
								System.out.println("Item removed from library");
								System.out.println("");
							}
						}
						// delete the item from the arrayList
						items.remove(itemToBeDeleted);
						if (foundTheItem == false) {
							// no item has that id
							System.out.println("Did not find the item.");
							System.out.println("");
						}

						break;

					}

				} while (option != 8);
				break;
			}
			case 3: {

				System.out.println("We hope that you have enjoed using the system");
				break;
			}
			default:
				System.out.println("Wrong input\n");
				break;
			}
		} while (option != 3);
		// end of do while loop ..
		System.out.println("Thanks for using this Library System");
	}

}