package developers.jar.uuku;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import developers.jar.uuku.Login.LoginActivity;
import developers.jar.uuku.about.AboutActivity;
import developers.jar.uuku.menu.MenuActivity;


/**
 * Created by axel_ on 18/04/2017.
 */

public class MainActivity extends Activity implements View.OnClickListener{
    ImageView entrar;
    ImageView config;
    ImageView about;
    ImageView user;
    MediaPlayer colours;
    MediaPlayer numbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main_activity);
        entrar = (ImageView)findViewById(R.id.btn_play);
        config = (ImageView)findViewById(R.id.btn_settings);

        user = (ImageView)findViewById(R.id.btn_user);

        entrar.setOnClickListener(this);
        config.setOnClickListener(this);

        user.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn_play:
                Intent i = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(i);
                break;
            case R.id.btn_settings:
                Intent e = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(e);
                break;
            case R.id.btn_user:
                Intent a = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(a);
                break;


            default:

                break;
        }
    }
}
