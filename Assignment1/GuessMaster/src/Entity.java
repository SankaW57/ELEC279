public class Entity 
{
	 // Two instance variables
	private String name;
	private Date born;
	
	// Constructor
	public Entity(String nameIn, Date bornIn)
	{
		born = bornIn;
		name = nameIn;
	}
	
	public String getName()
    {
        return name;
    }

    public Date getBorn()
    {
        return new Date(born);
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
		 return (name + ", born on " + born);
	}
	
    	
	

}

