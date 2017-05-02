package developers.jar.uuku.juegos;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;


public class ColorActivity extends Activity {
    //below are variables to store the audio files for activity_colour_game/numbers section
    MediaPlayer    turquesaBtn, amarilloBtn, blancoBtn, verdeBtn, azulBtn, naranjaBtn, rosaBtn,grisBtn, verdeaguaBtn, rojoBtn, violetaBtn, cafeBtn, azulmarinoBtn, guindaBtn, moradoBtn, negroBtn
, one, two, three, four, five, six, seven, eight, nine, ten, letsplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(developers.jar.uuku.R.layout.activity_color);
        //activity_colour_game - assigns the variables to an associated audio file in the "raw" folder
        turquesaBtn = MediaPlayer.create(this, developers.jar.uuku.R.raw.turquesa);
        amarilloBtn = MediaPlayer.create(this, developers.jar.uuku.R.raw.amarillo);
        blancoBtn = MediaPlayer.create(this, developers.jar.uuku.R.raw.blanco);
        verdeBtn = MediaPlayer.create(this, developers.jar.uuku.R.raw.verde);
        azulBtn = MediaPlayer.create(this, developers.jar.uuku.R.raw.azul);
        naranjaBtn = MediaPlayer.create(this, developers.jar.uuku.R.raw.naranja);
        rosaBtn = MediaPlayer.create(this, developers.jar.uuku.R.raw.rosa);
        grisBtn = MediaPlayer.create(this, developers.jar.uuku.R.raw.gris);
        verdeaguaBtn = MediaPlayer.create(this, developers.jar.uuku.R.raw.verdeagua);
        rojoBtn = MediaPlayer.create(this, developers.jar.uuku.R.raw.rojo);
        violetaBtn = MediaPlayer.create(this, developers.jar.uuku.R.raw.violeta);
        cafeBtn = MediaPlayer.create(this, developers.jar.uuku.R.raw.cafe);
        azulmarinoBtn = MediaPlayer.create(this, developers.jar.uuku.R.raw.azulmarino);
        guindaBtn = MediaPlayer.create(this, developers.jar.uuku.R.raw.guinda);
        moradoBtn = MediaPlayer.create(this, developers.jar.uuku.R.raw.morado);
        negroBtn = MediaPlayer.create(this, developers.jar.uuku.R.raw.negro);

        //numbers - assigns the variables to an associated audio file in the "raw" folder
        one = MediaPlayer.create(this, developers.jar.uuku.R.raw.one);
        two = MediaPlayer.create(this, developers.jar.uuku.R.raw.two);
        three = MediaPlayer.create(this, developers.jar.uuku.R.raw.three);
        four = MediaPlayer.create(this, developers.jar.uuku.R.raw.four);
        five = MediaPlayer.create(this, developers.jar.uuku.R.raw.five);
        six = MediaPlayer.create(this, developers.jar.uuku.R.raw.six);
        seven = MediaPlayer.create(this, developers.jar.uuku.R.raw.seven);
        eight = MediaPlayer.create(this, developers.jar.uuku.R.raw.eight);
        nine = MediaPlayer.create(this, developers.jar.uuku.R.raw.nine);
        ten = MediaPlayer.create(this, developers.jar.uuku.R.raw.ten);

    }




    public void tur (View view) {//method for playing red audio file
        turquesaBtn.start();

    }

    public void  amar (View view) {//method for playing yellow audio file
        amarilloBtn.start();

    }

    public void azul(View view) {//method for playing pink audio file
        azulBtn.start();

    }

    public void blan (View view) {//method for playing green audio file
        blancoBtn.start();

    }

    public void verde (View view) {//method for playing purple audio file
        verdeBtn.start();

    }

    public void nara (View view) {//method for playing orange audio file
        naranjaBtn.start();

    }

    public void rosa (View view) {//method for playing blue audio file
        rosaBtn.start();

    }

    public void gri (View view) {//method for playing black audio file
        grisBtn.start();

    }

    public void veagu  (View view) {//method for playing red audio file
        verdeaguaBtn.start();

    }

    public void roj (View view) {//method for playing yellow audio file
        rojoBtn.start();

    }

    public void vio (View view) {//method for playing pink audio file
        violetaBtn.start();

    }

    public void caf (View view) {//method for playing green audio file
        cafeBtn.start();

    }

    public void azma(View view) {//method for playing purple audio file
        azulmarinoBtn.start();

    }

    public void guin (View view) {//method for playing orange audio file
        guindaBtn.start();

    }

    public void mor (View view) {//method for playing blue audio file
        moradoBtn.start();

    }

    public void negr (View view) {//method for playing black audio file
        negroBtn.start();

    }


    public void one(View view) {//method for playing one audio file
        one.start();

    }

    public void two(View view) {//method for playing two audio file
        two.start();

    }

    public void three(View view) {//method for playing three audio file
        three.start();

    }

    public void four(View view) {//method for playing four audio file
        four.start();

    }

    public void five(View view) {//method for playing five audio file
        five.start();

    }

    public void six(View view) {//method for playing six audio file
        six.start();

    }

    public void seven(View view) {//method for playing seven audio file
        seven.start();

    }

    public void eight(View view) {//method for playing eight audio file
        eight.start();

    }

    public void nine(View view) {//method for playing nine audio file
        nine.start();

    }

    public void ten(View view) {//method for playing ten audio file
        ten.start();

    }


}
