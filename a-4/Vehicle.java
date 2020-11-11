import java.util.Stack;

public class Vehicle {

	private String owner;
	private String brand;
	private double price;
	Stack<Date> accidents;

	/**
	 * Default constructor
	 */
	public Vehicle() {
		owner = "";
		brand = "";
		price = 0;
		this.accidents=null; 
	}

	/**
	 * 
	 * @param owner_pass Owner of vehicle
	 * @param brand_pass Brand of vehicle
	 * @param price_pass Price of vehicle
	 * @param accidents_pass Accidents of vehicle
	 */
	public Vehicle(String owner_pass, String brand_pass, double price_pass, Stack<Date> accidents_pass) {
		this.owner = owner_pass;
		this.brand = brand_pass;
		this.price = price_pass;
		this.accidents = accidents_pass;
	}

	/**
	 * 
	 * @return Stack of previous accidents of the vehicle
	 */
	public Stack<Date> getAccidents() {
		return this.accidents;
	}
	
	/**
	 * 
	 * @return Owner of vehicle
	 */
	public String getOwner() {
		return this.owner;
	}
	
	/**
	 * 
	 * @return Brand of vehicle
	 */
	public String getBrand() {
		return this.brand;
	}
	
	/**
	 * 
	 * @return Price of vehicle
	 */
	public double getPrice() {
		return this.price;
	}

	/**
	 * @return vehicle as a string
	 */
	public String toString () {
		return ("Owner: "+this.owner+", Brand: "+this.brand+", Price: $"+this.price);
	}
}
