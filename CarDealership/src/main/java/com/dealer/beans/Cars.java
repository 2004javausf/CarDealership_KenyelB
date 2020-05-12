package com.dealer.beans;

public class Cars {
	
	private int id;
	private String make;
	private String model;
	private String color;
	private String door;
	private String transmission;
	private int year;
	private int mileage;
	private double cost;
	private String owned;
	
	



	public Cars(int id, String make, String model, String color, int year, int mileage, String door, String transmission,  
			double cost, String owned) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.color = color;
		this.door = door;
		this.transmission = transmission;
		this.year = year;
		this.mileage = mileage;
		this.cost = cost;
		this.owned = owned;
	}


	public String getMake() {
		return make;
	}


	public void setMake(String make) {
		this.make = make;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getDoor() {
		return door;
	}


	public void setDoor(String door) {
		this.door = door;
	}


	public String getTransmission() {
		return transmission;
	}


	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public int getMileage() {
		return mileage;
	}


	public void setMileage(int mileage) {
		this.mileage = mileage;
	}


	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}


	public String isOwned() {
		return owned;
	}


	public void setOwned(String owned) {
		this.owned = owned;
	}


	@Override
	public String toString() {
		return "Cars [id="+ id +", make=" + make + ", model=" + model + ", color=" + color + ", door=" + door + ", transmission="
				+ transmission + ", year=" + year + ", mileage=" + mileage + ", cost=" + cost + ", owned=" + owned
				+ "]";
	}


	public int getID() {
		return id;
	}


	public void setID(int id) {
		this.id=id;
	}
	
	

}
