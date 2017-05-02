package developers.jar.uuku.juegos;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;




public class HangmanActivity extends Activity {

    //string array of the words
    private String[] words;
    //random for word selection
    private Random rand;
    //store the current word
    private String currWord;
    //the layout that holds the answer
    private LinearLayout wordLayout;
    //text view array for each letter in the answer
    private TextView[] letterViews;
    //letter buttons
    private GridView letters;
    //letter button adapter
    private LetterAdapter ltrAdapt;
    //
    private ImageView[] bodyParts;
    //total parts of the body
    private int numParts=6;
    //current part
    private int currPart;
    //the number of characters in the answer
    private int numChars;
    //the number of correct answers
    private int numCorr;
    //dialog box for help instructions
    private AlertDialog helpAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(developers.jar.uuku.R.layout.activity_hangman);

        //read answer words in
        Resources res = getResources();
        words = res.getStringArray(developers.jar.uuku.R.array.words);

        //initialize random
        rand = new Random();
        //initialize word
        currWord="";

        //get answer area
        wordLayout = (LinearLayout)findViewById(developers.jar.uuku.R.id.word);

        //get letter button grid
        letters = (GridView)findViewById(developers.jar.uuku.R.id.letters);

        //get body part images
        bodyParts = new ImageView[numParts];
        bodyParts[0] = (ImageView)findViewById(developers.jar.uuku.R.id.head);
        bodyParts[1] = (ImageView)findViewById(developers.jar.uuku.R.id.body);
        bodyParts[2] = (ImageView)findViewById(developers.jar.uuku.R.id.arm1);
        bodyParts[3] = (ImageView)findViewById(developers.jar.uuku.R.id.arm2);
        bodyParts[4] = (ImageView)findViewById(developers.jar.uuku.R.id.leg1);
        bodyParts[5] = (ImageView)findViewById(developers.jar.uuku.R.id.leg2);

        //set home as up
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //start gameplay
        startGame();

    }



    //play a new game
    private void startGame(){

        //choose a word
        String newWord = words[rand.nextInt(words.length)];
        //make sure not same word as last time
        while(newWord.equals(currWord)) newWord = words[rand.nextInt(words.length)];
        //update current word
        currWord = newWord;

        //create new array for character text views
        letterViews = new TextView[currWord.length()];

        //remove any existing letters
        wordLayout.removeAllViews();

        //loop through characters
        for(int c=0; c<currWord.length(); c++){
            letterViews[c] = new TextView(this);
            //set the current letter
            letterViews[c].setText(""+currWord.charAt(c));
            //set layout
            letterViews[c].setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT));
            letterViews[c].setGravity(Gravity.CENTER);
            letterViews[c].setTextColor(Color.WHITE);
            letterViews[c].setBackgroundResource(developers.jar.uuku.R.drawable.letter_bg);
            //add to display
            wordLayout.addView(letterViews[c]);
        }

        //reset adapter
        ltrAdapt=new LetterAdapter(this);
        letters.setAdapter(ltrAdapt);

        //start part at zero
        currPart=0;
        //set word length and correct choices
        numChars=currWord.length();
        numCorr=0;

        //hide all parts
        for(int p=0; p<numParts; p++){
            bodyParts[p].setVisibility(View.INVISIBLE);
        }
    }

    //letter pressed method
    public void letterPressed(View view){
        //find out which letter was pressed
        String ltr=((TextView)view).getText().toString();
        char letterChar = ltr.charAt(0);
        //disable view
        view.setEnabled(false);
        view.setBackgroundResource(developers.jar.uuku.R.drawable.letter_down);
        //check if correct
        boolean correct=false;
        for(int k=0; k<currWord.length(); k++){
            if(currWord.charAt(k)==letterChar){
                correct=true;
                numCorr++;
                letterViews[k].setTextColor(Color.BLACK);
            }
        }
        //check in case won
        if(correct){
            if(numCorr==numChars){
                //disable all buttons
                disableBtns();
                //let user know they have won, ask if they want to play again
                AlertDialog.Builder winBuild = new AlertDialog.Builder(this);
                winBuild.setTitle("Felisidades");
                winBuild.setMessage("Ganaste!\n\nLa respuesta era:\n\n"+currWord);
                winBuild.setPositiveButton("Juega de nuevo",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                HangmanActivity.this.startGame();
                            }});
                winBuild.setNegativeButton("Salir",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                HangmanActivity.this.finish();
                            }});
                winBuild.show();
            }
        }
        //check if user still has guesses
        else if(currPart<numParts){
            //show next part
            bodyParts[currPart].setVisibility(View.VISIBLE);
            currPart++;
        }
        else{
            //user has lost
            disableBtns();
            //let the user know they lost, ask if they want to play again
            AlertDialog.Builder loseBuild = new AlertDialog.Builder(this);
            loseBuild.setTitle("Lo siento");
            loseBuild.setMessage("Perdiste!\n\nLa respuesta era:\n\n"+currWord);
            loseBuild.setPositiveButton("Juega de nuevo",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            HangmanActivity.this.startGame();
                        }});
            loseBuild.setNegativeButton("Salir",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            HangmanActivity.this.finish();
                        }});
            loseBuild.show();
        }
    }

    //disable letter buttons
    public void disableBtns(){
        int numLetters = letters.getChildCount();
        for(int l=0; l<numLetters; l++){
            letters.getChildAt(l).setEnabled(false);
        }
    }

    //method to display help information to infor user of the instructions of the game


}
