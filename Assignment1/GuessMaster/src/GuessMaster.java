import java.util.Scanner;
import java.util.Random;

public class GuessMaster 
{
	// Instance variables
	private Entity ent;
	private int numberOfCandidateEntities = 3;
	private Entity[] entities = new Entity [numberOfCandidateEntities];
	private int entityIncrement = 0;
	
	public void addEntity(Entity entity) 
	{
		if(entity == null) // No entities
		{
			System.out.println("Error: Entity entry is null");
		}
		else // Add new entity into entity, and increment total candidates
		{
			entities[entityIncrement++] = entity;
			
		}
	}
	
	/*
	 *  PlayGame methods start
	 */
	public void playGame(Entity entity) {
		boolean isGamePlaying = false; // Boolean to check if game is playing or not

		while (!isGamePlaying) {

			Scanner keyboard = new Scanner(System.in);
			Date bornEntity = entity.getBorn(); // Invoke get method from Entity class
			System.out.println("(Please type your answer in the format MM/DD/YYYY)\n");
			System.out.println("Guess birth date of " + entity.getName() + " : \n");

			String bornEntityInput = keyboard.nextLine();
			Date dateBorn = new Date(bornEntityInput);
			System.out.println(dateBorn);

			if (dateBorn.equals(bornEntity)) {
				System.out.println("BINGO! You got it!!");
				break; // Break out of loop after answer is correct
			}

			else if (dateBorn.precedes(bornEntity))
				System.out.println("Incorrect. Try a later date!\n");
			else
				System.out.println("Incorrect. Try an earlier date!\n");
		}

	}

	public void playGame() {
		playGame(genRandomEntityInd()); // Getting random
	}

	public void playGame(int entityInd) {
		Entity ent = entities[entityInd];
		playGame(ent);
	}
	
	/*
	 *  PlayGame methods end
	 */
	
	
	int genRandomEntityInd() {
		Random random = new Random();
		int randomNum = random.nextInt(numberOfCandidateEntities) + 0;
		return randomNum;
	}
	
	// Generic isNumeric method
	public static boolean isNumeric(String stringIt) {
		try {
			int num1 = Integer.parseInt(stringIt);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	// Main method
	public static void main(String args[]){
		
	boolean gameIsOn = true;	
	while (gameIsOn) 
	{
		Scanner input = new Scanner(System.in);
					
		Entity jTrudeau = new Entity("Justin Trudeau", new Date("December",25,1971));
		Entity cDion = new Entity("Celine Dion", new Date("March",30,1968));
		Entity unitedStates = new Entity("United States", new Date("July",14,1776));
				
		GuessMaster gm = new GuessMaster();
		gm.addEntity(jTrudeau);
		gm.addEntity(cDion);
		gm.addEntity(unitedStates);
		
		// Start game
		System.out.println("Hey! Welcome to the Guess Master!\n");
		System.out.println("The following entities are available for Guess Master\n");
				
		int j = 0;
		while (j < gm.numberOfCandidateEntities) {
			gm.ent = gm.entities[j];
			String nameEntity = gm.ent.getName();
			System.out.print(j + " : " + nameEntity +"\n");
			j++;
		}
		
		// Option of random entity
		System.out.println();
		System.out.println("Please type an entity name or number you wish to play");
		System.out.println();
		System.out.println("You may also type \"random\" to receive a random entity");
		System.out.println("Please answer below");
		String answerInit = input.nextLine();
		// Make the first letter capital to make sure the input will match depending on how the user enters
		String output = answerInit.substring(0, 1).toUpperCase() + answerInit.substring(1);
		
			for(int i=0;i<gm.numberOfCandidateEntities;i++)
			{
				Entity entity = gm.entities[i];
				String nameOfEnt = entity.getName();
			
				if(output.equals(nameOfEnt)) 
				{
					gm.playGame(entity);
					break;
				}
				else if(isNumeric(answerInit) == !false)
				{
					int var = Integer.parseInt(output);
					gm.playGame(var);
					break;
				}
				else if(output.equals("Random"))
				{
					gm.playGame();
					break;
				}
				
			} 
			
			// Conditions set if player wants to continue on or leave the game
			System.out.println("Do you want play again?\n");
			System.out.println("Type in Yes or No\n");
			String answerConQuit = input.nextLine();	// Input for continue or quit answer given by user
			
			switch(answerConQuit) 
			{
			
			case "Yes":
				gameIsOn = true;
				break;
						
			case "No":
				System.out.println("Thank you for playing!\n");
				break;
			
			default:
				System.out.println("Error exiting game");
					
			}					
		
		}
		
	}	
}
	

