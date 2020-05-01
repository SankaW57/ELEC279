package com.w.sasanka.guessmaster;

public abstract class Entity {

	//Instance variables
	private String name;
	private Date born;
	private Double difficulty;


	//Constructor
	public Entity(String nameInput, Date bornInput, Double diffInput)
	{
		name = nameInput;
		born = bornInput;
		difficulty = diffInput;
	}

	//Copy Constructor
	public Entity(Entity entity)
	{
		this(entity.getName(),entity.getBorn(),entity.getDiff());
	}

	//Accessors

	public String getName(){
		return name;
	}

	public Date getBorn(){
		return born;
	}

	public Double getDiff() {
		return difficulty;
	}


	public int getAwardedTicketNumber()
	{
		int ticketNumber = (int) (difficulty*100);
		return ticketNumber;
	}

	public String setName(String nameInput)
	{
		name = nameInput;
		return name;
	}

	public Date setBorn(Date bornInput)
	{
		born = bornInput;
		return born;
	}

	public Double setDiff(Double diffInput) {
		difficulty = diffInput;
		return difficulty;
	}

	public boolean equals(Entity entity)
	{
		if (entity == null)
			return false;
		else
			return ( (name.equals(entity.name)) &&
					(born == entity.born) );
	}

	// toString() method
	public String toString()
	{
		return ("\nName:"+ name + "\nBorn at: " + born);
	}


	public abstract String entityType();

	public abstract Entity clone();



	public String welcomeMessage()
	{
		String returnEntity = entityType();
		String returnString = ("Welcome! Let's start the game! " + returnEntity);
		return returnString;
	}

	public String closingMessage()
	{
		String returnEntityInfo = toString();
		String returnString = ("Congrats! The correct information of the entity you guessed is: " + returnEntityInfo);
		return returnString;
	}

}
