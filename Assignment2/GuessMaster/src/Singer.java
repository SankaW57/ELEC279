public class Singer extends Person{

	// Instance variables
	private String debutAlbum;
	private Date debutAlbumReleaseDate;
	
	// Constructor
	public Singer(String nameIn, Date bornIn, String genderIn,String debutAlbumIn, Date debutAlbumDate,  double difficultyIn) {
		super(nameIn, bornIn, genderIn, difficultyIn);
		debutAlbum = debutAlbumIn;
		debutAlbumReleaseDate = debutAlbumDate;
	}
	
	// Copy constructor
	public Singer(Singer singer) {
		super(singer.getName(),singer.getBorn(), singer.getGender(), singer.getDifficulty());
		singer.getDebutAlbum();
		singer.getReleaseDate();
	}
	
	// EntityType method
	public String entityType() {
		return "This entity is a Singer!";
	}
	
	public Person clone() {
		return new Person(this); // No privacy leaks
	}
	
	// Accessor methods
	public String getDebutAlbum() {
		return debutAlbum;
	}

	public Date getReleaseDate() {
		return debutAlbumReleaseDate;
	}	
	
	// toString() method
	public String toString() {
		return super.toString() + "\nDebut Album: " + debutAlbum + "\nRelease Date: " + debutAlbumReleaseDate;
	}

}


