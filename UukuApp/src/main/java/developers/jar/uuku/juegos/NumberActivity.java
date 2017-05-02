package developers.jar.uuku.juegos;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;


public class NumberActivity extends Activity {
    //variables to store the sound files for each number
    MediaPlayer one, two, three, four, five, six, seven, eight, nine, ten, twenty, thirty, forty, fifty, sixty, seventy, eighty, ninety, hundred, letsplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(developers.jar.uuku.R.layout.activity_number);
        //assigning the variables to the corrisponding audio file
        one = MediaPlayer.create(this, developers.jar.uuku.R.raw.uno);
        two = MediaPlayer.create(this, developers.jar.uuku.R.raw.dos);
        three = MediaPlayer.create(this, developers.jar.uuku.R.raw.tres);
        four = MediaPlayer.create(this, developers.jar.uuku.R.raw.cuatro);
        five = MediaPlayer.create(this, developers.jar.uuku.R.raw.cinco);
        six = MediaPlayer.create(this, developers.jar.uuku.R.raw.seis);
        seven = MediaPlayer.create(this, developers.jar.uuku.R.raw.siete);
        eight = MediaPlayer.create(this, developers.jar.uuku.R.raw.ocho);
        nine = MediaPlayer.create(this, developers.jar.uuku.R.raw.nueve);
        ten = MediaPlayer.create(this, developers.jar.uuku.R.raw.diez);
        twenty = MediaPlayer.create(this, developers.jar.uuku.R.raw.veinte);
        thirty = MediaPlayer.create(this, developers.jar.uuku.R.raw.treinta);
        forty = MediaPlayer.create(this, developers.jar.uuku.R.raw.cuarenta);
        fifty = MediaPlayer.create(this, developers.jar.uuku.R.raw.cincuenta);
        sixty = MediaPlayer.create(this, developers.jar.uuku.R.raw.sesenta);
        seventy = MediaPlayer.create(this, developers.jar.uuku.R.raw.setenta);
        eighty = MediaPlayer.create(this, developers.jar.uuku.R.raw.ochenta);
        ninety = MediaPlayer.create(this, developers.jar.uuku.R.raw.noventa);
        hundred = MediaPlayer.create(this, developers.jar.uuku.R.raw.cien);


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

    public void twenty(View view) {//method for playing twenty audio file
        twenty.start();

    }

    public void thirty(View view) {//method for playing thirty audio file
        thirty.start();

    }

    public void forty(View view) {//method for playing forty audio file
        forty.start();

    }

    public void fifty(View view) {//method for playing fifty audio file
        fifty.start();

    }

    public void sixty(View view) {//method for playing sixty audio file
        sixty.start();

    }

    public void seventy(View view) {//method for playing seventy audio file
        seventy.start();

    }

    public void eighty(View view) {//method for playing eighty audio file
        eighty.start();

    }

    public void ninety(View view) {//method for playing ninety audio file
        ninety.start();

    }

    public void hundred(View view) {//method for playing 100 audio file
        hundred.start();

    }

    public void letsPlay(View view) {//method for playing letsplay audio file and lanching the game
        letsplay.start();//plays "lets play" audio file
        Intent intent = new Intent(this, NumberGame.class);//activates the advanced/games activity
        startActivity(intent);

    }
}
