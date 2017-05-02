package developers.jar.uuku.cards;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import developers.jar.uuku.juegos.HangmanActivity;
import developers.jar.uuku.juegos.ListenAndLearnActivity;
import developers.jar.uuku.juegos.WeekDays;
import developers.jar.uuku.juegos.WordMatchActivity;


/**
 * Created by axel_ on 18/04/2017.
 */

public class CardLogicActivity extends Activity implements View.OnClickListener {

    CardView uno, dos, tres, cuatro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(developers.jar.uuku.R.layout.card_logic);
        uno = (CardView)findViewById(developers.jar.uuku.R.id.card_uno);
        dos = (CardView)findViewById(developers.jar.uuku.R.id.card_dos);
        tres = (CardView)findViewById(developers.jar.uuku.R.id.card_tres);
        cuatro = (CardView)findViewById(developers.jar.uuku.R.id.card_cuatro);

        uno.setOnClickListener(this);
        dos.setOnClickListener(this);
        tres.setOnClickListener(this);
        cuatro.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case developers.jar.uuku.R.id.card_uno:
                Intent a = new Intent(getApplicationContext(), HangmanActivity.class);
                startActivity(a);
                break;
            case developers.jar.uuku.R.id.card_dos:
                Intent g = new Intent(getApplicationContext(), WeekDays.class);
                startActivity(g);
                break;
            case developers.jar.uuku.R.id.card_tres:
                Intent c = new Intent(getApplicationContext(), ListenAndLearnActivity.class);
                startActivity(c);
                break;
            case developers.jar.uuku.R.id.card_cuatro:
                Intent h = new Intent(getApplicationContext(), WordMatchActivity.class);
                startActivity(h);
                break;


            default:

                break;
        }
    }
}
