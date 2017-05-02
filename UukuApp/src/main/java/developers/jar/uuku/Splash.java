package developers.jar.uuku;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.widget.VideoView;

import java.util.Timer;
import java.util.TimerTask;


public class Splash extends Activity {

    private static final long SPLASH_SCREEN_DELAY=12000;//Duracion
    //metodo onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        VideoView videoView = (VideoView) findViewById(R.id.videoView_video);

        Uri path = Uri.parse("android.resource://developers.jar.uuku/"
                + R.raw.splashh);

        videoView.setVideoURI(path);
        videoView.start();



        initComponents();
    }

    private void initComponents() {


        TimerTask task=new TimerTask() {

            @Override
            public void run() {
                startActivity(new Intent().setClass( Splash.this, MainActivity.class));

            }
        };

        Timer timer=new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
