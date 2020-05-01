public class Person extends Entity {

	// Instance variables
	private String gender;

	// Constructor
	public Person(String nameIn, Date bornIn, String genderIn,  double difficultyIn) {
		super(nameIn, bornIn, difficultyIn);
		gender = genderIn;
	}

	// Copy constructor
	public Person(Person person) {
		super(person.getName(), person.getBorn(), person.getDifficulty());
	}

	// EntityType method
	public String entityType() {
		return "This entity is a Person!";
	}
	
	// Clone method
	public Person clone() {
		return new Person(this);
	}

	public String toString() {
		return super.toString() + "\nGender: " + gender;
	}

	// Mutator method
	public String setGender(String genderIn) {
		gender = genderIn;
		return gender;
	}

	// Accessor method
	public String getGender() {
		return gender;
	}


}
