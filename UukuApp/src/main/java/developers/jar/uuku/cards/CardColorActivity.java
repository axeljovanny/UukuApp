package developers.jar.uuku.cards;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import developers.jar.uuku.juegos.ColorActivity;
import developers.jar.uuku.juegos.ColoursGame;
import developers.jar.uuku.juegos.ReadAndListen;

public class CardColorActivity extends Activity implements View.OnClickListener {
    MediaPlayer colours;
    CardView uno, dos, tres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(developers.jar.uuku.R.layout.card_colors);
        uno = (CardView)findViewById(developers.jar.uuku.R.id.card_uno);
        dos = (CardView)findViewById(developers.jar.uuku.R.id.card_dos);
        tres = (CardView)findViewById(developers.jar.uuku.R.id.card_tres);

        uno.setOnClickListener(this);
        dos.setOnClickListener(this);
        tres.setOnClickListener(this);

        colours = MediaPlayer.create(this, developers.jar.uuku.R.raw.colours);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case developers.jar.uuku.R.id.card_uno:
                Intent a = new Intent(getApplicationContext(), ColorActivity.class);
                startActivity(a);
                break;
            case developers.jar.uuku.R.id.card_dos:
                Intent e = new Intent(getApplicationContext(), ColoursGame.class);
                startActivity(e);
                break;
            case developers.jar.uuku.R.id.card_tres:
                Intent i = new Intent(getApplicationContext(), ReadAndListen.class);
                startActivity(i);
                break;


            default:

                break;
        }
    }
}
