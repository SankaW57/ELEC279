public class Politician extends Person {

	// Instance variable
	private String party;

	// Constructor
	public Politician(String nameIn, Date bornIn, String genderIn, String partyIn, Double difficultyIn) {
		super(nameIn, bornIn, genderIn, difficultyIn);
		party = partyIn;
	}

	// Copy Constructor
	public Politician(Politician politician) {
		super(politician.getName(), politician.getBorn(), politician.getGender(), politician.getDifficulty());
		politician.getParty();
	}
	
	// EntityType method
	public String entityType() {
		return "This entity is a Politician!";
	}
	
	// Clone method
	public Politician clone() {
		return new Politician(this); // No privacy leaks
	}
	
	// Accessor method
	public String getParty() {
		return party;
	}

	// toString method
	public String toString() {
		return super.toString() + "\nParty: " + party;
	}

}
