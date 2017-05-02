package developers.jar.uuku.juegos;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import developers.jar.uuku.cards.CardColorActivity;

import java.util.ArrayList;
import java.util.Collections;


public class ReadAndListen extends Activity {
    MediaPlayer content; //variable for sound files
    ImageButton btn;
    boolean counter = (true);

    private ArrayList<Integer> myList = new ArrayList<>();//arraylist to hold sequential numbers from 1 to however many objects I need.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(developers.jar.uuku.R.layout.activity_read_and_listen);

        //alert box that pops up as this activity loads.
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Instrucciones.");
        alertDialog.setMessage("Muy bien, ahora aprenderemos combinaciones. " +
                "\n¿Sabias que si junto colores se pueden hacer otros? " +
                "\n Pues muy bien, ¡a aprender!" );
        alertDialog.setButton("¡ A jugar!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {}});

        alertDialog.setIcon(developers.jar.uuku.R.drawable.question);//this is the question mark icon on the hint popup page
        alertDialog.show();//this tells the above icon to show


        content = MediaPlayer.create(this, developers.jar.uuku.R.raw.cobmorado);

        btn = (ImageButton) findViewById(developers.jar.uuku.R.id.theIBtn);//identifying the image button to be changed
        Random();//Running the random method
    }
    public void Random() {
        while (counter == (true)) {
            for (int i = 1; i < 6; i++) {
                myList.add(Integer.valueOf(i));
            }
            Collections.shuffle(myList);
            counter = (false);
        }

        if (myList.isEmpty()) {
            //TO DO: set a method here that tells them the game is over.
            //this alert ends the game an outputs the score
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("HEI HEI HEI");
            alertDialog.setMessage("Felicidades, Estas Aprendiendo! ");
            alertDialog.setButton("Continuar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            alertDialog.setIcon(developers.jar.uuku.R.drawable.combmorado);//this is the question mark icon on the hint popup page
            alertDialog.show();//this tells the above icon to show

        }
        if (myList.get(0) == 1) {//if the integer at index 0 is a 1, set image to THE.
            btn.setImageResource(developers.jar.uuku.R.drawable.combmorado);
            content = MediaPlayer.create(this, developers.jar.uuku.R.raw.commorado);
        } else if (myList.get(0) == 2) {//if the integer at index 0 is a 2, set image to ADD.
            btn.setImageResource(developers.jar.uuku.R.drawable.combverde);
            content = MediaPlayer.create(this, developers.jar.uuku.R.raw.comverde);
        } else if (myList.get(0) == 3) {//if the integer at index 0 is a 3, set image to AGE.
            btn.setImageResource(developers.jar.uuku.R.drawable.combnaranja);
            content = MediaPlayer.create(this, developers.jar.uuku.R.raw.comnaranja);
        } else if (myList.get(0) == 4) {//if the integer at index 0 is a 4, set image to CAN.
            btn.setImageResource(developers.jar.uuku.R.drawable.combblanco);
            content = MediaPlayer.create(this, developers.jar.uuku.R.raw.comblanco);
        } else if (myList.get(0) == 5) {//if the integer at index 0 is a 5, set image to DRY.
            btn.setImageResource(developers.jar.uuku.R.drawable.combnegro);
            content = MediaPlayer.create(this, developers.jar.uuku.R.raw.comnegro);
        }
    }







    public void playSound(View view) {
        content.start();

    }

    public void quit(View view) {
        Intent intent = new Intent(this, CardColorActivity.class);startActivity(intent);
    }

    public void theBtn(View view){
        content.start();
    }

    public void nextBtn(View view){
        myList.remove(0);
        Random();
    }

}