package com.w.sasanka.guessmaster;

public class Singer extends Person{

	private String debutAlbum;
	private Date releaseDate;

	// Constructor
	public Singer(String nameInput, Date bornInput, String genderInput, String albumInput, Date releaseInput, Double diffInput) {
		super(nameInput, bornInput,genderInput,diffInput);
		debutAlbum = albumInput;
		releaseDate = releaseInput;
	}

	// Copy Constructor
	public Singer(Singer singer) {
		super(singer.getName(),singer.getBorn(),singer.getGender(),singer.getDiff());
		singer.getDebutAlbum();
		singer.getReleaseDate();
	}

	public String entityType() {
		String returnMsg = "This entity is a Singer!";
		return returnMsg;
	}

	// Mutator methods
	public String setDebutAlbum(String albumInput) {
		debutAlbum = albumInput;
		return debutAlbum;
	}

	public Date setReleaseDate(Date dateInput) {
		releaseDate = dateInput;
		return releaseDate;
	}

	// Accessor methods
	public String getDebutAlbum() {
		return debutAlbum;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	// clone() method
	public Person clone() {
		return new Person(this);
	}

	// toString() method
	public String toString() {
		String debutInfo = ("\nDebut Album: "+ debutAlbum + "\nRelease Date: " + releaseDate);
		return super.toString() + debutInfo;
	}
}
