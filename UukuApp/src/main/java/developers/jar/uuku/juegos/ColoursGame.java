package developers.jar.uuku.juegos;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;


public class ColoursGame extends Activity {

    MediaPlayer content, correctSound, wrongSound;//variables for sound files
    ImageView btn; //this variable is for changing the image in the advanced activity
    TextView scoreText, timeLimit; //this variable is used for updating the score info
    int score, scorePenalty;
    boolean counter = (true);
    boolean timeout = (true);
    String scoreString;
    boolean hint = (false);//used to determine if the user used any hints when outputting the score.
    private static final String FORMAT = "%02d:%02d";//this string defines the format of the countdown timer in the game

    private ArrayList<Integer> myList = new ArrayList<>();//arraylist to hold sequential numbers from 1 to however many objects I need.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(developers.jar.uuku.R.layout.activity_colour_game);

        timeLimit=(TextView)findViewById(developers.jar.uuku.R.id.CountdownLbl); //this variable updates the countdown ticker in the game

        correctSound = MediaPlayer.create(this, developers.jar.uuku.R.raw.correcto);
        wrongSound = MediaPlayer.create(this, developers.jar.uuku.R.raw.incorrecto);

        //this code is for the instructions alert box that pops up as this activity loads.
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Instrucciones.");
        alertDialog.setMessage("¿Recuerdas los colores? " +
                "\nLee el color que se muestra en pantalla . " +
                "\ny preciona el color que es, si no lo puedes leer puedes obtener una pista pulsando la palabra" +
                "\n ,aunque obtienes mas puntos si no usas pistas." );
        alertDialog.setButton("¡a Jugar!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                new CountDownTimer(15000, 1000) { // adjust the milli seconds here - 1000 = 1 second

                    @TargetApi(Build.VERSION_CODES.GINGERBREAD)//this code lets the mnimum api to gingerbread. Froyo doesn't support countdown
                    public void onTick(long millisUntilFinished) {

                        timeLimit.setText(""+String.format(FORMAT,

                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) -
                                        TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                                TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) )));
                    }
                    public void onFinish() {//sets what will happen when the timer finishes
                        TimeOut();
                    }
                }.start();//starts the countdown timer
            }});

        alertDialog.setIcon(developers.jar.uuku.R.drawable.question);//this is the question mark icon on the hint popup page
        alertDialog.show();//this tells the above icon to show

        scoreText = (TextView) findViewById(developers.jar.uuku.R.id.scoreTxt); //creating a variable for the text within the score label
        scoreText.setText("0");//setting the score text to 0
        btn = (ImageView) findViewById(developers.jar.uuku.R.id.imageBtn);//identifying the image button to be changed in the colourse
        Random();//Running the random method to select which image button will be chosen.
    }
    public void TimeOut(){//this method stops the game when the timer gets to zero
        if (timeout = true) {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();

            alertDialog.setTitle("Puntuación:");
            alertDialog.setMessage("Tu puntuacion es: " + score +
                    "\nVamos a tratar de superar eso!!");
            alertDialog.setIcon(developers.jar.uuku.R.drawable.question);//this is the question mark icon on the hint popup page
            alertDialog.show();//this tells the above icon to show
        }
    }

    public void Random() {
        scorePenalty = 3;//resetting the score penalty value to 3 after it was set to one by using the hints.

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

            if (hint == (true) && score < 24) {//shows user their score, lets them know if they lost points to using hints
                alertDialog.setTitle("Puntuación:");
                alertDialog.setMessage("Tu puntuacion es: " + score +
                        "\nHas dejado caer algunos puntos por usar pistas!" +
                        "\n Puedes practica en la leccion de aprender colores y despues intentarlo de nuevo!");



            }
            else if (hint == false && score == 24){//checked no hints were used and max points achieved, user == BOSS!
                alertDialog.setTitle("Puntuacion:");
                alertDialog.setMessage("Wow, Eres el mejor! " +
                        "\n vaya que si sabes de colores, " +
                        "\n tu puntuacion fue de: " + score);
            }
            else{//returns user score if they didn't use hints but didn't score max points.
                alertDialog.setTitle("Puntuación:");
                alertDialog.setMessage("Tu puntuación es: " + score +
                        "\nVamos a tratar de superar eso!!");
            }
            alertDialog.setButton("Continuar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which){}});

            timeout = false;
            alertDialog.setIcon(developers.jar.uuku.R.drawable.question);//this is the question mark icon on the hint popup page
            alertDialog.show();//this tells the above icon to show

        }
        else if (myList.get(0) == 1) {//if the integer at index 0 is a 1, set the question and answer to RED - answer is set in button methods below
            btn.setImageResource(developers.jar.uuku.R.drawable.turquesa);
            content = MediaPlayer.create(this, developers.jar.uuku.R.raw.turquesa);
        }
        else if (myList.get(0) == 2){//if the integer at index 0 is a 1, set the question and answer to YELLOW - answer is set in button methods below
            btn.setImageResource(developers.jar.uuku.R.drawable.morado);
            content = MediaPlayer.create(this, developers.jar.uuku.R.raw.morado);
        }
        else if (myList.get(0) == 3){//if the integer at index 0 is a 1, set the question and answer to PINK - answer is set in button methods below
            btn.setImageResource(developers.jar.uuku.R.drawable.amarillo);
            content = MediaPlayer.create(this, developers.jar.uuku.R.raw.amarillo);
        }
        else if (myList.get(0) == 4){//if the integer at index 0 is a 1, set the question and answer to GREEN - answer is set in button methods below
            btn.setImageResource(developers.jar.uuku.R.drawable.rojo);
            content = MediaPlayer.create(this, developers.jar.uuku.R.raw.rojo);
        }
        else if (myList.get(0) == 5){//if the integer at index 0 is a 1, set the question and answer to PURPLE - answer is set in button methods below
            btn.setImageResource(developers.jar.uuku.R.drawable.gris);
            content = MediaPlayer.create(this, developers.jar.uuku.R.raw.gris);
        }
        else if (myList.get(0) == 6){//if the integer at index 0 is a 1, set the question and answer to ORANGE - answer is set in button methods below
            btn.setImageResource(developers.jar.uuku.R.drawable.azul);
            content = MediaPlayer.create(this, developers.jar.uuku.R.raw.azul);
        }
        else if (myList.get(0) == 7){//if the integer at index 0 is a 1, set the question and answer to BLUE - answer is set in button methods below
            btn.setImageResource(developers.jar.uuku.R.drawable.naranja);
            content = MediaPlayer.create(this, developers.jar.uuku.R.raw.naranja);
        }
        else if (myList.get(0) == 8){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(developers.jar.uuku.R.drawable.negro);
            content = MediaPlayer.create(this, developers.jar.uuku.R.raw.negro);
        }
    }



    public void imageBtn(View view) {//code for playing description sound
        content.start();
        scorePenalty = 1;
        hint = true;
    }

    public void turqBtn(View view){
        if(myList.get(0) == 1){
            correctSound.start();
            score = score + scorePenalty;
            scoreString = Integer.toString(score); //parsing the score as a string
            scoreText.setText(scoreString); //setting the parsed score string to the text label
        }
        else{
            wrongSound.start();

        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again, question wont be asked twice
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void amatBtn(View view){
        if(myList.get(0) == 2){
            correctSound.start();
            score = score + scorePenalty;
            scoreString = Integer.toString(score); //parsing the score as a string
            scoreText.setText(scoreString); //setting the parsed score string to the text label
        }
        else{
            wrongSound.start();
        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again, question wont be asked twice
        Random();//regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void amarBtn(View view){
        if(myList.get(0) == 3){
            correctSound.start();
            score = score + scorePenalty;
            scoreString = Integer.toString(score); //parsing the score as a string
            scoreText.setText(scoreString); //setting the parsed score string to the text label
        }
        else{
            wrongSound.start();
        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again, question wont be asked twice
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void rojoBtn(View view){
        if(myList.get(0) == 4){
            correctSound.start();
            score = score + scorePenalty;
            scoreString = Integer.toString(score); //parsing the score as a string
            scoreText.setText(scoreString); //setting the parsed score string to the text label
        }
        else{
            wrongSound.start();
        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again, question wont be asked twice
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void grisBtn(View view){
        if(myList.get(0) == 5){
            correctSound.start();
            score = score + scorePenalty;
            scoreString = Integer.toString(score); //parsing the score as a string
            scoreText.setText(scoreString); //setting the parsed score string to the text label
        }
        else{
            wrongSound.start();
        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again, question wont be asked twice
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void azulBtn(View view){
        if(myList.get(0) == 6){
            correctSound.start();
            score = score + scorePenalty;
            scoreString = Integer.toString(score); //parsing the score as a string
            scoreText.setText(scoreString); //setting the parsed score string to the text label
        }
        else{
            wrongSound.start();
        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again, question wont be asked twice
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void naraBtn(View view){
        //if(blue == (true)){
        if(myList.get(0) == 7){
            correctSound.start(); //outputting the sound to indicate correct answer
            score = score + scorePenalty;
            scoreString = Integer.toString(score); //parsing the score as a string
            scoreText.setText(scoreString); //setting the parsed score string to the text label
        }
        else{
            wrongSound.start(); //outputting the sound to indicate incorrect answer
        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again, question wont be asked twice
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void esmeBtn(View view){
        if(myList.get(0) == 8){
            correctSound.start();
            score = score + scorePenalty;
            scoreString = Integer.toString(score); //parsing the score as a string
            scoreText.setText(scoreString); //setting the parsed score string to the text label
        }
        else{
            wrongSound.start();
        }
        myList.remove(0);//removes the index 0 which has a unique number so this number cannot come up again, question wont be asked twice
        Random(); //regenerates the random method to get the next number. This number wont come up again as its been removed above
    }

    public void PostScore(View view){

    }

}
