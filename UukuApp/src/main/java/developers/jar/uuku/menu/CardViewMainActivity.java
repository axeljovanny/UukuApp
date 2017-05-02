package developers.jar.uuku.menu;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import developers.jar.uuku.menu.stories.CircoMainActivity;
import developers.jar.uuku.menu.stories.CuentaMainActivity;
import developers.jar.uuku.menu.stories.DiasMainActivity;
import developers.jar.uuku.menu.stories.FamiliaMainActivity;
import developers.jar.uuku.menu.stories.ZooMainActivity;


public class CardViewMainActivity extends Activity implements View.OnClickListener {

    CardView uno, dos, tres, cuatro, cinco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(developers.jar.uuku.R.layout.card_cuentos);
        uno = (CardView)findViewById(developers.jar.uuku.R.id.card_uno);
        dos = (CardView)findViewById(developers.jar.uuku.R.id.card_dos);
        tres = (CardView)findViewById(developers.jar.uuku.R.id.card_tres);
        cuatro = (CardView)findViewById(developers.jar.uuku.R.id.card_cuatro);
        cinco = (CardView)findViewById(developers.jar.uuku.R.id.card_cinco);

        uno.setOnClickListener(this);
        dos.setOnClickListener(this);
        tres.setOnClickListener(this);
        cuatro.setOnClickListener(this);
        cinco.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case developers.jar.uuku.R.id.card_uno:
                Intent cuenta = new Intent(getApplicationContext(), CuentaMainActivity.class);
                startActivity(cuenta);
                break;
            case developers.jar.uuku.R.id.card_dos:
                Intent circo = new Intent(getApplicationContext(), CircoMainActivity.class);
                startActivity(circo);

                break;
            case developers.jar.uuku.R.id.card_tres:
                Intent dias = new Intent(getApplicationContext(), DiasMainActivity.class);
                startActivity(dias);
                break;

            case developers.jar.uuku.R.id.card_cuatro:
                Intent familia = new Intent(getApplicationContext(), FamiliaMainActivity.class);
                startActivity(familia);
                break;

            case developers.jar.uuku.R.id.card_cinco:
                Intent zoo = new Intent(getApplicationContext(), ZooMainActivity.class);
                startActivity(zoo);
                break;

            default:

                break;
        }
    }
}

