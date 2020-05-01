package com.w.sasanka.guessmaster;


public class Politician extends Person{

	// Instance variables
	private String party;

	// Constructor
	public Politician(String nameInput, Date bornInput, String genderInput, String partyInput, Double diffInput) {
		super(nameInput, bornInput,genderInput,diffInput);
		party = partyInput;
	}

	// Copy Constructor
	public Politician(Politician politician) {
		super(politician.getName(),politician.getBorn(),politician.getGender(),politician.getDiff());
		politician.getParty();
	}


	// entityType()
	public String entityType() {
		String returnMsg = "This entity is a Politician!";
		return returnMsg;
	}

	// Mutator
	public String setParty(String partyInput) {
		party = partyInput;
		return party;
	}

	// Accessor
	public String getParty() {
		return party;
	}

	//clone() method
	public Politician clone() {
		return new Politician(this);
	}

	//toString() method
	public String toString() {
		String PartyInfo = ("\nParty: "+ party);
		return super.toString() + PartyInfo;
	}

}
