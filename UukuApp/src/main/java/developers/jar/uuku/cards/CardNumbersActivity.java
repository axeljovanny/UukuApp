package developers.jar.uuku.cards;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;


import developers.jar.uuku.juegos.NumberActivity;
import developers.jar.uuku.juegos.NumberGame;

/**
 * Created by axel_ on 18/04/2017.
 */

public class CardNumbersActivity extends Activity implements View.OnClickListener {
    CardView uno, dos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(developers.jar.uuku.R.layout.card_numbers);
        uno = (CardView)findViewById(developers.jar.uuku.R.id.card_uno);
        dos = (CardView)findViewById(developers.jar.uuku.R.id.card_dos);

        uno.setOnClickListener(this);
        dos.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case developers.jar.uuku.R.id.card_uno:
                Intent a = new Intent(getApplicationContext(), NumberActivity.class);
                startActivity(a);
                break;
            case developers.jar.uuku.R.id.card_dos:
                Intent b = new Intent(getApplicationContext(), NumberGame.class);
                startActivity(b);
                break;


            default:

                break;
        }
    }
}
