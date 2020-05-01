package com.w.sasanka.guessmaster;

// import necessary android libraries
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

//import java tools
import java.util.ArrayList;
import java.util.Random;

public class GuessMaster extends AppCompatActivity {

    // View components initialization
    private TextView entityName;
    private TextView ticketsum;
    private Button guessButton;
    private EditText userIn;
    private Button btnClearContent;
    private String user_input;
    private ImageView entityImage;
    private String answer;

    private int numberOfCandidateEntities;
    private  ArrayList<Entity> entities  = new ArrayList<Entity>();
    private int ticketCount;
    private int ticketAward;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_activity);

        //View components
        guessButton =   findViewById(R.id.btnGuess);
        userIn = findViewById(R.id.guessInput);
        btnClearContent =  findViewById(R.id.btnClear);
        entityImage = findViewById(R.id.entityImage);
        ticketsum =  findViewById(R.id.ticket);
        entityName =  findViewById(R.id.entityName);

        //Initialize entities
        Politician jtrudeau = new Politician("Justin Trudeau", new Date("December",25,1971),"Male","Liberal",0.25);
        Singer cdion = new Singer("Celine Dion", new Date("March",30,1961),"Female","La voix du bon Dieu",new Date("November",6,1981),0.5);
        Person  eMusk = new Person ("Elon Musk", new Date("June",28,1971),"Male",0.5);
        Country usa = new Country("United States", new Date("July",4,1776),0.5,"Washington D.C");

        //Adding Entities
        addEntity(jtrudeau);
        addEntity(cdion);
        addEntity(eMusk);
        addEntity(usa);

        final int randInd = genRandomEntityInd();   //Get a random number
        final Entity entity = entities.get(randInd);

        //OnClick Listener action for clear button
        btnClearContent.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){ changeEntity();}
        });

        //OnClick Listener action for submit button
        guessButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){playGame(entity);}
        });

        entityName.setText(entity.getName()); //Set the entity name/image according to the selected entity
        ImageSetter(entity); //Call to image setting method
        welcomeToGame(entity); //Call to welcome message


    }

    //Method to clear user entities and change from entity to random entity
    public void changeEntity()
    {
        userIn.setText(""); //Clear user input
        final int randInd = genRandomEntityInd(); //Get random number
        final Entity entity = entities.get(randInd);
        entityName.setText(entity.getName()); //Setting the entity name and picture
        ImageSetter(entity); //Setting image to entity selected

        //OnClick Listener action for submit button
        guessButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){playGame(entity);}
        });
    }

    //Method to set the image to the according entity
    public void ImageSetter(Entity entity)
    {

        if(entity.getName() == "Justin Trudeau")
        {
            entityImage.setImageResource(R.drawable.justint); //Get Trudeau's picture
        }
        if(entity.getName() == "Celine Dion")
        {
            entityImage.setImageResource(R.drawable.celidion); //Get Dion's picture
        }
        if(entity.getName() == "United States")
        {
            entityImage.setImageResource(R.drawable.usaflag); //Get USA's picture
        }
        if(entity.getName() == "Elon Musk")
        {
            entityImage.setImageResource(R.drawable.elon); //Get Musk's picture
        }


    }

    //Method to pop up welcome message
    public void welcomeToGame(Entity entity)
    {
        // Alert Dialog for welcome message
        AlertDialog.Builder welcomealert = new AlertDialog.Builder(this);
        welcomealert.setTitle("GuessMaster Game v3");
        welcomealert.setMessage(entity.welcomeMessage());
        welcomealert.setCancelable(false);
        welcomealert.setNegativeButton("START GAME", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                Toast.makeText(getBaseContext(), "Game is Starting...Enjoy", Toast.LENGTH_SHORT).show();}

        });

        AlertDialog dialog = welcomealert.create();
        dialog.show();
    }


    public void playGame(Entity entity)
    {
        // Get the correct birthday of selected entity
        answer = userIn.getText().toString();
        answer = answer.replace("\n","").replace("\r","");
        Date date = new Date(answer);

        Date bornEnt = entity.getBorn();

        // Case 1: Correct
        if (date.equals(bornEnt))
        {
            ticketAward = entity.getAwardedTicketNumber();
            ticketCount += ticketAward;
            ticketsum.setText("total ticket: " + ticketCount);

            AlertDialog.Builder winalert = new AlertDialog.Builder(GuessMaster.this);
            winalert.setTitle("Hooray!");
            winalert.setMessage("BINGO! " + entity.closingMessage());
            winalert.setCancelable(false);

            winalert.setNegativeButton("Continue", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i)
                {
                    Toast.makeText(getBaseContext(), "You won " + ticketAward + " tickets in this round.", Toast.LENGTH_SHORT).show();} //Feedback message

            });

            AlertDialog dialog = winalert.create();
            dialog.show();
            continueGame();
        }

        // Case 2: Late Date
        else if (!date.precedes(bornEnt))
        {
            AlertDialog.Builder earlierDate = new AlertDialog.Builder(GuessMaster.this);
            earlierDate.setTitle("Sorry that is incorrect!"); //Set title of alert
            earlierDate.setMessage("Please try an earlier date!"); //Set content of alert
            earlierDate.setCancelable(false);

            earlierDate.setNegativeButton("Continue",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    dialog.dismiss();
                }
            });
            AlertDialog dialog = earlierDate.create();
            dialog.show();
        }

        // Case 3: Early Date
        else if (date.precedes(bornEnt))
        {
            AlertDialog.Builder laterDate = new AlertDialog.Builder(GuessMaster.this);
            laterDate.setTitle("Sorry that is incorrect!");
            laterDate.setMessage("Please try a later date!");
            laterDate.setCancelable(false);
            laterDate.setNegativeButton("Continue",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    dialog.dismiss();
                }
            });
            AlertDialog dialog = laterDate.create();
            dialog.show();
        }

        // Case 3: No input
        else if (answer == "")
        {
            AlertDialog.Builder laterDate = new AlertDialog.Builder(GuessMaster.this);
            laterDate.setTitle("OOOPS!");
            laterDate.setMessage("Null Input! Try again");
            laterDate.setCancelable(false);
            laterDate.setNegativeButton("Continue",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    dialog.dismiss();
                }
            });
            AlertDialog dialog = laterDate.create();
            dialog.show();
        }

        // Other Case
        else
        {
            AlertDialog.Builder earlierDate = new AlertDialog.Builder(GuessMaster.this);
            earlierDate.setTitle("Sorry that is incorrect!");
            earlierDate.setMessage("Invalid date! Try again");
            earlierDate.setCancelable(false);

            earlierDate.setNegativeButton("Continue",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    dialog.dismiss();
                }
            });
            AlertDialog dialog = earlierDate.create();
            dialog.show();
        }

    }

    // Method that will continue game when called
    public void continueGame()
    {
        userIn.setText(""); //Clears the user input
        final int randInd = genRandomEntityInd();
        final Entity entity = entities.get(randInd);
        entityName.setText(entity.getName());
        ImageSetter(entity);
        guessButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){playGame(entity);}
        });
    }

    // Methods from assignment 2
    public void addEntity(Entity entity)
    {
        entities.add(entity);
        numberOfCandidateEntities++; //Increment the total number of candidates
    }

    public void playGame(int entityInd) {
        Entity indEnt = entities.get(entityInd);
        playGame(indEnt);
    }

    public void playGame() {
        int randomInd = genRandomEntityInd();
        playGame(randomInd);
    }


    public int genRandomEntityInd()
    {
        Random rand = new Random();
        int  r = rand.nextInt(numberOfCandidateEntities);
        return r; //Return the random number
    }

    // Generic isNumeric method
    public static boolean isNumeric(String str)
    {
        try
        {
            int d = Integer.parseInt(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

}
