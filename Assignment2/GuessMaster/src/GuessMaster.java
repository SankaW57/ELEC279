import java.util.Scanner;
import java.util.Random;

public class GuessMaster 
{
	// Instance variables
	private int numberOfCandidateEntities = 0; //Number of entities in the game
	private Entity[] entities = new Entity [numberOfCandidateEntities]; // Array that holds the entities
	public int totalTickets = 0; // variable used to keep count of tickets won
	
	// Constructor
	public GuessMaster() {
		entities = new Entity[150]; // Arbitrary array value so index not out of range
	}
	
	// New add entity method
	public void addEntity(Entity entity) {
		entities[numberOfCandidateEntities++] = entity;
	}
	

	// PlayGame methods start
	public void playGame(Entity entity) {
		
		while (true) {
			Scanner keyboard = new Scanner(System.in); //Take in user input
			Date bornEntity = entity.getBorn(); // Invoke get method for birthday from Entity class
			int ticketsAwarded = entity.getAwardTicketNumber(entity) ; //Tickets given per round
		
			System.out.println("*****************************");
			System.out.println(entity.welcomeMessage());
			System.out.println("\nGuess " + entity.getName() + "'s birthday");
			System.out.println("(mm/dd/yyyy)");
			System.out.println("Enter \"Quit\" to leave game");
			
			String bornInput = keyboard.nextLine(); //Take input as string

			// Case if user wants to quit game
			if (bornInput.equals("Quit") || bornInput.equals("quit")) { // Exit game when user inputs quit
				System.out.println("Quitting, Thank you for playing!");
				System.exit(0); // Leaves java program
				keyboard.close(); // Close scanner
			}
			
			// Case if date inputted is correct
			else if (new Date (bornInput).equals(bornEntity)) {
				System.out.println("*************Bingo!**************");
				System.out.println("You won " + ticketsAwarded + " tickets in this round.");
				totalTickets += ticketsAwarded; // Increment award by difficulty value
				System.out.println("The total number of your ticket is " + totalTickets);
				System.out.println("*********************************");
				System.out.println(entity.closingMessage());
				
			}
			
			// Case if earlier date is inputted
			else if (new Date(bornInput).precedes(bornEntity)) {
				System.out.println("Incorrect. Try a later date!\n");
			}
			
			// Case if later date is inputted
			else if (!new Date(bornInput).precedes(bornEntity)) {
				System.out.println("Incorrect. Try an earlier date!\n");
			}
			
		}

	}
	public void playGame() {
		playGame(genRandomEntityInd()); // Getting random num
	}

	public void playGame(int entityInd) {
		Entity ent = entities[entityInd];
		playGame(ent);
	}
	
	 // PlayGame methods end
	
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
		
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("=======================\n");
		System.out.println("    Guessmaster 2.0\n");
		System.out.println("=======================");

		// Create objects for the game
		Politician jTrudeau = new Politician("Justin Trudeau", new Date("December", 25, 1971), "Male", "Liberal", 0.25);
		Singer cDion = new Singer("Celine Dion", new Date("March", 30, 1961), "Female", "La voix du bon Dieu",
		Person myCreator = new Person("myCreater", new Date("September", 1, 2000), "Female", 1);
		Country unitedStates = new Country("United States", new Date("July", 4, 1776), "Washington D.C", 0.1);

		GuessMaster gm = new GuessMaster();
		gm.addEntity(jTrudeau);
		gm.addEntity(cDion);
		gm.addEntity(myCreator);
		gm.addEntity(unitedStates);

		while (true) { // While loop so the game keeps going, even after answer is correct
			gm.playGame();
		}
		
				
		
		
	}	
}
	

