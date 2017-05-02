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


public class LetterGuess extends Activity {
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
        setContentView(developers.jar.uuku.R.layout.activity_letter_guess);

        timeLimit=(TextView)findViewById(developers.jar.uuku.R.id.CountdownLbl); //this variable updates the countdown ticker in the game

        correctSound = MediaPlayer.create(this, developers.jar.uuku.R.raw.correcto);
        wrongSound = MediaPlayer.create(this, developers.jar.uuku.R.raw.incorrecto);

        //this code is for the instructions alert box that pops up as this activity loads.
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Instrucciones.");
        alertDialog.setMessage("Hola amiguito aqui puedes probar tus conocimientos. " +
                "\nToca la letra que falta en la palabra que se te muestra. " +
                "\nPuedes tocar la imagen si necesitas una pista, aunque te advierto " +
                "\nObtienes mas puntos sin usar pista." );
        alertDialog.setButton("Got it!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                new CountDownTimer(60000, 1000) { // adjust the milli seconds here - 1000 = 1 second

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
            for (int i = 1; i < 27; i++) {//adding the numbers 1-3 to the indexes in the array
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
                alertDialog.setMessage("Tu puntuacion es: " + score +
                        "\nVamos a tratar de superar eso!!");
            }
            alertDialog.setButton("Continuar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which){}});

            timeout = false;
            alertDialog.setIcon(developers.jar.uuku.R.drawable.arbol);//this is the question mark icon on the hint popup page
            alertDialog.show();//this tells the above icon to show
        }
        else if (myList.get(0) == 1) {//if the integer at index 0 is a 1, set the question and answer to RED - answer is set in button methods below
            btn.setImageResource(developers.jar.uuku.R.drawable.arbol);
            content = MediaPlayer.create(this, developers.jar.uuku.R.raw.arbol);
        }
        else if (myList.get(0) == 2){//if the integer at index 0 is a 1, set the question and answer to YELLOW - answer is set in button methods below
            btn.setImageResource(developers.jar.uuku.R.drawable.bote);
            content = MediaPlayer.create(this, developers.jar.uuku.R.raw.bote);
        }
        else if (myList.get(0) == 3){//if the integer at index 0 is a 1, set the question and answer to PINK - answer is set in button methods below
            btn.setImageResource(developers.jar.uuku.R.drawable.cama);
            content = MediaPlayer.create(this, developers.jar.uuku.R.raw.cama
            );
        }
        else if (myList.get(0) == 4){//if the integer at index 0 is a 1, set the question and answer to GREEN - answer is set in button methods below
            btn.setImageResource(developers.jar.uuku.R.drawable.dado);
            content = MediaPlayer.create(this, developers.jar.uuku.R.raw.dado);
        }
        else if (myList.get(0) == 5){//if the integer at index 0 is a 1, set the question and answer to PURPLE - answer is set in button methods below
            btn.setImageResource(developers.jar.uuku.R.drawable.estatua);
            content = MediaPlayer.create(this, developers.jar.uuku.R.raw.estatua);
        }
        else if (myList.get(0) == 6){//if the integer at index 0 is a 1, set the question and answer to ORANGE - answer is set in button methods below
            btn.setImageResource(developers.jar.uuku.R.drawable.foca);
            content = MediaPlayer.create(this, developers.jar.uuku.R.raw.foca);
        }
        else if (myList.get(0) == 7){//if the integer at index 0 is a 1, set the question and answer to BLUE - answer is set in button methods below
            btn.setImageResource(developers.jar.uuku.R.drawable.guante);
            content = MediaPlayer.create(this, developers.jar.uuku.R.raw.guante);
        }
        else if (myList.get(0) == 8){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(developers.jar.uuku.R.drawable.humo);
            content = MediaPlayer.create(this, developers.jar.uuku.R.raw.humo);
        }
        else if (myList.get(0) == 9){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(developers.jar.uuku.R.drawable.isla);
            content = MediaPlayer.create(this, developers.jar.uuku.R.raw.isla);
        }
        else if (myList.get(0) == 10){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(developers.jar.uuku.R.drawable.jeringa);
            content = MediaPlayer.create(this, developers.jar.uuku.R.raw.jeringa);
        }
        else if (myList.get(0) == 11){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(developers.jar.uuku.R.drawable.kilos);
            content = MediaPlayer.create(this, developers.jar.uuku.R.raw.kilos);
        }
        else if (myList.get(0) == 12){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(developers.jar.uuku.R.drawable.lana);
            content = MediaPlayer.create(this, developers.jar.uuku.R.raw.lana);
        }
        else if (myList.get(0) == 13){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(developers.jar.uuku.R.drawable.mama);
            content = MediaPlayer.create(this, developers.jar.uuku.R.raw.mama);
        }
        else if (myList.get(0) == 14){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(developers.jar.uuku.R.drawable.nido);
            content = MediaPlayer.create(this, developers.jar.uuku.R.raw.nido);
        }
        else if (myList.get(0) == 15){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(developers.jar.uuku.R.drawable.oro);
            content = MediaPlayer.create(this, developers.jar.uuku.R.raw.oro);
        }
        else if (myList.get(0) == 16){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(developers.jar.uuku.R.drawable.pan);
            content = MediaPlayer.create(this, developers.jar.uuku.R.raw.pan);
        }
        else if (myList.get(0) == 17){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(developers.jar.uuku.R.drawable.queso);
            content = MediaPlayer.create(this, developers.jar.uuku.R.raw.queso);
        }
        else if (myList.get(0) == 18){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(developers.jar.uuku.R.drawable.roca);
            content = MediaPlayer.create(this, developers.jar.uuku.R.raw.roca);
        }
        else if (myList.get(0) == 19){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(developers.jar.uuku.R.drawable.sarten);
            content = MediaPlayer.create(this, developers.jar.uuku.R.raw.sarten);
        }
        else if (myList.get(0) == 20){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(developers.jar.uuku.R.drawable.tenedor);
            content = MediaPlayer.create(this, developers.jar.uuku.R.raw.tenedor);
        }
        else if (myList.get(0) == 21){//if the integer at index 0 is a 1, set the question and answer to BLACK - answer is set in button methods below
            btn.setImageResource(developers.jar.uuku.R.drawable.uva);
            content = MediaPlayer.create(this, developers.jar.uuku.R.raw.uva);
        }

    }



    public void imageBtn(View view) {//code for playing description sound
        content.start();
        scorePenalty = 1;
        hint = true;
    }

    public void ABtn(View view){
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

    public void BBtn(View view){
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

    public void CBtn(View view){
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

    public void DBtn(View view){
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

    public void EBtn(View view){
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

    public void FBtn(View view){
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

    public void GBtn(View view){
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

    public void HBtn(View view){
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

    public void IBtn(View view){
        if(myList.get(0) == 9){
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

    public void JBtn(View view){
        if(myList.get(0) == 10){
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

    public void KBtn(View view){
        if(myList.get(0) == 11){
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

    public void LBtn(View view){
        if(myList.get(0) == 12){
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

    public void MBtn(View view){
        if(myList.get(0) == 13){
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

    public void NBtn(View view){
        if(myList.get(0) == 14){
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

    public void OBtn(View view){
        if(myList.get(0) == 15){
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

    public void PBtn(View view){
        if(myList.get(0) == 16){
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

    public void QBtn(View view){
        if(myList.get(0) == 17){
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

    public void RBtn(View view){
        if(myList.get(0) == 18){
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

    public void SBtn(View view){
        if(myList.get(0) == 19){
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

    public void TBtn(View view){
        if(myList.get(0) == 20){
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

    public void UBtn(View view){
        if(myList.get(0) == 21){
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


}
