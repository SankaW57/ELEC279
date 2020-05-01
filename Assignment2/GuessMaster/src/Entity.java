abstract public class Entity 
{
	 // Instance variables
	private String name;
	private Date born;
	private double difficulty;
	
	// Constructor
	public Entity(String nameIn, Date bornIn, double difficultyIn)
	{
		born = bornIn;
		name = nameIn;
		difficulty = difficultyIn;
	}
	
	// Copy constructor
	public Entity (Entity entity) {
		this.name = entity.name;
		this.born = new Date(entity.born); 
		
	}

	// Abstract methods
	public abstract String entityType ();
	public abstract Entity clone ();
	
	
	public String welcomeMessage () {
		return "Welcome! Let's start the game! \n" + entityType();
	}
	
	public String closingMessage () {
		return "Congratulations! The detailed information of the entity you guessed is\n" + toString();
	}
	
	// Accessor methods
	public String getName()
    {
        return name;
    }

    public Date getBorn()
    {
        return new Date(born);
    }
    
    public Double getDifficulty()
    {
        return difficulty;
    }
    
	// Method for tickets given
	public int getAwardTicketNumber (Entity entity) {
		int tickets = (int)entity.difficulty*100;
		return tickets;
	}
    
    
    public boolean equals(Entity entity)
	{
	    if (entity == null)
	        return false;
	    else
	        return ((born == entity.born) && (name.equals(entity.name)));
    }	
    
    public String toString() 
	{
		 return "Name: " + name + "\n" + "Born on:" + born;
	}
	
    	
	

}

