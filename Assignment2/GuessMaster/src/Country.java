public class Country extends Entity{
	
	// Instance variables
	private String capital;

	//Constructor
	public Country (String nameIn, Date bornIn, String capitalIn, double difficultyIn) {
		super(nameIn, bornIn, difficultyIn);
		capital = capitalIn;	
		
	}
	
	// Copy constructor
	public Country (Country country) {
		super(country.getName(), country.getBorn(), country.getDifficulty());
	}

	//Clone method using country copy constructor
	public Country clone() {
		return new Country(this);
	}
	
	public String toString () {
		return (super.toString() + "\nCapital: " + capital + "\n"); //toString called in entity class
	}

	public String entityType() {
		return "This entity is a country!";
	}
	
	
	
	
}
