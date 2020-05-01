package com.w.sasanka.guessmaster;

public class Country extends Entity {

	// Instance variables
	private String capital;

	//Constructor
	public Country(String nameInput, Date bornInput, Double diffInput, String capitalInput){
		super(nameInput, bornInput,diffInput);
		capital = capitalInput;
	}

	//Copy Constructor
	public Country(Country country) {
		super(country.getName(),country.getBorn(),country.getDiff());
		country.getCapital();
	}

	public String entityType() {
		String returnMsg = "This entity is a country!";
		return returnMsg;
	}

	//clone() method
	public Country clone() {
		return new Country(this);
	}

	public String setCapital(String input) {
		input = capital;
		return capital;
	}

	public String getCapital() {
		return capital;
	}

	//toString method
	public String toString() {
		String capitalPrint = ("\nCapital: " + capital);
		return super.toString() + capitalPrint;
	}

}
