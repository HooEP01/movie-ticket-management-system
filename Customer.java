package application;
//-----Author: Hoo Ern Ping
//-----ID: B200152B

import java.util.Arrays;

public class Customer {
	//-----instance variable
	private int id;
	private String name;
	private String movie;
	private String[] seatID;
	private int adultQty;
	private int kidQty;
	
	//-----default constructor
	public Customer() {
		id = 0;
		name = "unknown";
		movie = "unknown";
		seatID = new String[adultQty + kidQty];
		adultQty = 0;
		kidQty = 0;
	}
	
	//-----constructor with parameter
	public Customer(int id, String name, String movie, 
					String[] seatID, int adultQty, int kidQty) {
		
		this.id = id;
		this.name = name;
		this.movie = movie;
		this.seatID = seatID;
		this.adultQty = adultQty;
		this.kidQty = kidQty;	
	}
	
	//-----get method
	public int getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getMovie() {
		return movie;
	}
	
	public String[] getSeatID() {
		return seatID;
	}
	
	public int getAdultQty() {
		return adultQty;
	}
	
	public int getKidQty() {
		return kidQty;
	}
	
	//-----set method
	public void setID(int theID) {
		id = theID;
	}
	
	public void setName(String theName) {
		name = theName;
	}
	
	public void setMovie(String theMovie) {
		movie = theMovie;
	}
	
	public void setSeatID(String[] theSeatID) {
		seatID = theSeatID;
	}
	
	public void setAdultQty(int theAdultQty) {
		adultQty = theAdultQty; 
	}
	
	public void setKidQty(int theKidQty) {
		kidQty = theKidQty;
	}
	
	//-----task method
	public double calcTotalPrice() {
		int adultPrice = 20;
		int kidPrice = 13;
		
		return getAdultQty() * adultPrice + getKidQty() * kidPrice;
	}
	
	//-----print price method
	public String printPrice() {
		return String.format("%.2f",calcTotalPrice());
	}
	
	//-----print method
	public String toString() {
		return  "Customer ID: "+getID()+
				"\nCustomer Name: "+getName()+
				"\nMovie: "+ getMovie()+
				"\nCustomer Seat: "+Arrays.toString(getSeatID())+
				"\nAdult Quantity: "+getAdultQty()+
				"\nKid Quantity: "+getKidQty()+
				"\nTotal Price: "+String.format("%.2f",calcTotalPrice());
	}
}
