package com.dealer.beans;

public class Offer {
	
	int offerID;
	int carID;
	String userName;
	int offerAmount;
	String offerStatus;
	
	public Offer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Offer(int offerID, int carID, String userName, int offerAmount, String offerStatus) {
		super();
		this.offerID = offerID;
		this.carID = carID;
		this.userName = userName;
		this.offerAmount = offerAmount;
		this.offerStatus = offerStatus;
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getOfferStatus() {
		return offerStatus;
	}
	public void setOfferStatus(String offerStatus) {
		this.offerStatus = offerStatus;
	}
	public int getOfferID() {
		return offerID;
	}
	public void setOfferID(int offerID) {
		this.offerID = offerID;
	}
	public int getCarID() {
		return carID;
	}
	public void setCarID(int carID) {
		this.carID = carID;
	}
	public int getOfferAmount() {
		return offerAmount;
	}
	public void setOfferAmount(int offerAmount) {
		this.offerAmount = offerAmount;
	}
	@Override
	public String toString() {
		return "Offer [offerID=" + offerID + ", carID=" + carID + ", userName=" + userName + ", offerAmount="
				+ offerAmount + ", offerStatus=" + offerStatus + "]";
	}
	
	
	
	

}
