package com.w.sasanka.guessmaster;

public class Person extends Entity{

	//Instance variables
	private String gender;

	//Constructor
	public Person(String nameInput, Date bornInput, String genderInput, Double diffInput){
		super(nameInput, bornInput,diffInput);
		gender = genderInput;
	}

	//Copy Constructor
	public Person(Person person) {
		super(person.getName(),person.getBorn(),person.getDiff());
		person.getGender();
	}

	public String entityType() {
		String returnMsg = "This entity is a Person!";
		return returnMsg;
	}

	//clone() method
	public Person clone() {
		return new Person(this);
	}

	public String setGender(String genderInput) {
		gender = genderInput;
		return gender;
	}

	public String getGender() {
		return gender;
	}

	//toString() method
	public String toString() {
		String  genderPrint = ("\nGender: " + gender);
		return super.toString() + genderPrint;
	}

}
