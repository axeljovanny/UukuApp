package developers.jar.uuku.juegos;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;


public class WordMatchActivity extends Activity {

    MediaPlayer content, correctSound, wrongSound;//variables for sound files
    ImageView btn; //this variable is for changing the image in the advanced activity
    TextView scoreText; //this variable is used for updating the score info
    int score;
    boolean counter = (true);
    String scoreString;

    private ArrayList<Integer> myList = new ArrayList<>();//arraylist to hold sequential numbers from 1 to however many objects I need.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(developers.jar.uuku.R.layout.activity_word_match);

        correctSound = MediaPlayer.create(this, developers.jar.uuku.R.raw.correcto);
        wrongSound = MediaPlayer.create(this, developers.jar.uuku.R.raw.incorrecto);

        //this code is for the instructions alert box that pops up as this activity loads.
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Intrucciones.");
        alertDialog.setMessage("Asocia la imagen con las palabras");
        alertDialog.setButton("A Jugar!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {}});

        alertDialog.setIcon(developers.jar.uuku.R.drawable.question);//this is the question mark icon on the hint popup page
        alertDialog.show();//this tells the above icon to show

        scoreText = (TextView) findViewById(developers.jar.uuku.R.id.scoreTxt); //creating a variable for the text within the score label
        scoreText.setText("0");//setting the score text to 0

        btn = (ImageView) findViewById(developers.jar.uuku.R.id.imageBtn);//identifying the image button to be changed in the colourse
        Random();//Running the random method to select which image button will be chosen.
    }
    public void Random() {
        while (counter == (true)) {//Making sure arraylist only writes initial values on first application load, not after every question.
            for (int i = 1; i < 9; i++) {//adding the numbers 1-3 to the indexes in the array
                myList.add(Integer.valueOf(i));//adding the i value to the arrayList. There's a BIG difference between int and Integer, I learned today.
            }
            Collections.shuffle(myList);//shuffling the array indexes around so int numbers are jumbled
            counter = (false);//used to ensure that population of the array only happens on first execution,
        }
        if (myList.isEmpty()){
            //TO DO: set a method here that tells them the game is over. thanks for playing, yadaydaydaa.
            //this alert ends the game an outputs the score
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();

            if (score == 24){//checked no hints were used and max points achieved, user == BOSS!
                alertDialog.setTitle("Puntuación:");
                alertDialog.setMessage("Felicidades! 100%" +
                        "\nPuntuación: " + score);
            }
            else{//returns user score if they didn't use hints but didn't score max points.
                alertDialog.setTitle("Puntuación:");
                alertDialog.setMessage("Felicidades, Tu Puntuación es " + score);
            }
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                   // Intent intent = new Intent(WordMatchActivity.this, KidsActivity.class);
                   // startActivity(intent);
                }});

            alertDialog.setIcon(developers.jar.uuku.R.drawable.question);//this is the question mark icon on the hint popup page
            alertDialog.show();//this tells the above icon to show
        }
        else if (myList.get(0) == 1) {//if the integer at index 0 is a 1, set the question and answer to RED - answer is set in button methods below
            btn.setImageResource(developers.jar.uuku.R.drawable.baker);
        }
        else if (myList.get(0) == 2){//if the integer at index 0 is a 2, set the question and answer to YELLOW - answer is set in button methods below
            btn.setImageResource(developers.jar.uuku.R.drawable.chairtwo);
        }
        else if (myList.get(0) == 3){//if the integer at index 0 is a 3, set the question and answer to PINK - answer is set in button methods below
            btn.setImageResource(developers.jar.uuku.R.drawable.clock);
        }
        else if (myList.get(0) == 4){//if the integer at index 0 is a 4, set the question and answer to GREEN - answer is set in button methods below
            btn.setImageResource(developers.jar.uuku.R.drawable.computer);
        }
        else if (myList.get(0) == 5){//if the integer at index 0 is a 5, set the question and answer to PURPLE - answer is set in button methods below
            btn.setImageResource(developers.jar.uuku.R.drawable.mouse);
        }
        else if (myList.get(0) == 6){//if the integer at index 0 is a 6, set the question and answer to ORANGE - answer is set in button methods below
            btn.setImageResource(developers.jar.uuku.R.drawable.pineapple);
        }
        else if (myList.get(0) == 7){//if the integer at index 0 is a 7, set the question and answer to BLUE - answer is set in button methods below
            btn.setImageResource(developers.jar.uuku.R.drawable.plane);
        }
        else if (myList.get(0) == 8){//if the integer at index 0 is a 8, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(developers.jar.uuku.R.drawable.table);
        }

        //set home as up
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    public void redAnsBtn(View view){
        if(myList.get(0) == 1){
            correctSound.start();
            score = score +3; //add 3 to the score
            scoreString = Integer.toString(score); //parsing the score as a string
            scoreText.setText(scoreString); //setting the parsed score string to the text label
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again, question wont be asked twice
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void yellowAnsBtn(View view){
        if(myList.get(0) == 2){
            correctSound.start();
            score = score +3; //add 3 to the score
            scoreString = Integer.toString(score); //parsing the score as a string
            scoreText.setText(scoreString); //setting the parsed score string to the text label
        }
        else{
            wrongSound.start();
        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again, question wont be asked twice
        Random();//regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void pinkAnsBtn(View view){
        if(myList.get(0) == 3){
            correctSound.start();
            score = score +3; //add 3 to the score
            scoreString = Integer.toString(score); //parsing the score as a string
            scoreText.setText(scoreString); //setting the parsed score string to the text label
        }
        else{
            wrongSound.start();
        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again, question wont be asked twice
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void greenAnsBtn(View view){
        if(myList.get(0) == 4){
            correctSound.start();
            score = score +3; //add 3 to the score
            scoreString = Integer.toString(score); //parsing the score as a string
            scoreText.setText(scoreString); //setting the parsed score string to the text label
        }
        else{
            wrongSound.start();
        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again, question wont be asked twice
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void purpleAnsBtn(View view){
        if(myList.get(0) == 5){
            correctSound.start();
            score = score +3; //add 3 to the score
            scoreString = Integer.toString(score); //parsing the score as a string
            scoreText.setText(scoreString); //setting the parsed score string to the text label
        }
        else{
            wrongSound.start();
        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again, question wont be asked twice
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void orangeAnsBtn(View view){
        if(myList.get(0) == 6){
            correctSound.start();
            score = score +3; //add 3 to the score
            scoreString = Integer.toString(score); //parsing the score as a string
            scoreText.setText(scoreString); //setting the parsed score string to the text label
        }
        else{
            wrongSound.start();
        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again, question wont be asked twice
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void blueAnsBtn(View view){
        //if(blue == (true)){
        if(myList.get(0) == 7){
            correctSound.start(); //outputting the sound to indicate correct answer
            score = score +3; //add 3 to the score
            scoreString = Integer.toString(score); //parsing the score as a string
            scoreText.setText(scoreString); //setting the parsed score string to the text label
        }
        else{
            wrongSound.start(); //outputting the sound to indicate incorrect answer
        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again, question wont be asked twice
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void blackAnsBtn(View view){
        if(myList.get(0) == 8){
            correctSound.start();
            score = score +3; //add 3 to the score
            scoreString = Integer.toString(score); //parsing the score as a string
            scoreText.setText(scoreString); //setting the parsed score string to the text label
        }
        else{
            wrongSound.start();
        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again, question wont be asked twice
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }
}
