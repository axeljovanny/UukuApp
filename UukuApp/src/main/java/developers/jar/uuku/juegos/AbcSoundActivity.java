package developers.jar.uuku.juegos;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class AbcSoundActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(developers.jar.uuku.R.layout.activity_abc);

        ImageView aButton = (ImageView)findViewById(developers.jar.uuku.R.id.aButton);
        aButton.setOnClickListener(this);

        ImageView bButton = (ImageView)findViewById(developers.jar.uuku.R.id.bButton);
        bButton.setOnClickListener(this);

        ImageView cButton = (ImageView)findViewById(developers.jar.uuku.R.id.cButton);
        cButton.setOnClickListener(this);

        ImageView dButton = (ImageView)findViewById(developers.jar.uuku.R.id.dButton);
        dButton.setOnClickListener(this);

        ImageView eButton = (ImageView)findViewById(developers.jar.uuku.R.id.eButton);
        eButton.setOnClickListener(this);

        ImageView fButton = (ImageView)findViewById(developers.jar.uuku.R.id.fButton);
        fButton.setOnClickListener(this);

        ImageView gButton = (ImageView)findViewById(developers.jar.uuku.R.id.gButton);
        gButton.setOnClickListener(this);

        ImageView hButton = (ImageView)findViewById(developers.jar.uuku.R.id.hButton);
        hButton.setOnClickListener(this);

        ImageView iButton = (ImageView)findViewById(developers.jar.uuku.R.id.iButton);
        iButton.setOnClickListener(this);

        ImageView jButton = (ImageView)findViewById(developers.jar.uuku.R.id.jButton);
        jButton.setOnClickListener(this);

        ImageView kButton = (ImageView)findViewById(developers.jar.uuku.R.id.kButton);
        kButton.setOnClickListener(this);

        ImageView lButton = (ImageView)findViewById(developers.jar.uuku.R.id.lButton);
        lButton.setOnClickListener(this);

        ImageView mButton = (ImageView)findViewById(developers.jar.uuku.R.id.mButton);
        mButton.setOnClickListener(this);

        ImageView nButton = (ImageView)findViewById(developers.jar.uuku.R.id.nButton);
        nButton.setOnClickListener(this);
        ImageView gnButton = (ImageView)findViewById(developers.jar.uuku.R.id.gnButton);
        nButton.setOnClickListener(this);

        ImageView oButton = (ImageView)findViewById(developers.jar.uuku.R.id.oButton);
        oButton.setOnClickListener(this);

        ImageView pButton = (ImageView)findViewById(developers.jar.uuku.R.id.pButton);
        pButton.setOnClickListener(this);

        ImageView qButton = (ImageView)findViewById(developers.jar.uuku.R.id.qButton);
        qButton.setOnClickListener(this);

        ImageView rButton = (ImageView)findViewById(developers.jar.uuku.R.id.rButton);
        rButton.setOnClickListener(this);

        ImageView sButton = (ImageView)findViewById(developers.jar.uuku.R.id.sButton);
        sButton.setOnClickListener(this);

        ImageView tButton = (ImageView)findViewById(developers.jar.uuku.R.id.tButton);
        tButton.setOnClickListener(this);

        ImageView uButton = (ImageView)findViewById(developers.jar.uuku.R.id.uButton);
        uButton.setOnClickListener(this);

        ImageView vButton = (ImageView)findViewById(developers.jar.uuku.R.id.vButton);
        vButton.setOnClickListener(this);

        ImageView wButton = (ImageView)findViewById(developers.jar.uuku.R.id.wButton);
        wButton.setOnClickListener(this);

        ImageView xButton = (ImageView)findViewById(developers.jar.uuku.R.id.xButton);
        xButton.setOnClickListener(this);

        ImageView yButton = (ImageView)findViewById(developers.jar.uuku.R.id.yButton);
        yButton.setOnClickListener(this);

        ImageView zButton = (ImageView)findViewById(developers.jar.uuku.R.id.zButton);
        zButton.setOnClickListener(this);


    }

    public void onClick(View view) {
        //handle clicks
        if (view.getId() == developers.jar.uuku.R.id.aButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, developers.jar.uuku.R.raw.dearbol);
            mediaPlayer.start();//Waits for the click of the button and when it is clicked the audio file plays

        } else if (view.getId() == developers.jar.uuku.R.id.bButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, developers.jar.uuku.R.raw.debote);
            mediaPlayer.start();
        } else if (view.getId() == developers.jar.uuku.R.id.cButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, developers.jar.uuku.R.raw.decama);
            mediaPlayer.start();
        } else if (view.getId() == developers.jar.uuku.R.id.dButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, developers.jar.uuku.R.raw.dedado);
            mediaPlayer.start();
        } else if (view.getId() == developers.jar.uuku.R.id.eButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, developers.jar.uuku.R.raw.deestatua);
            mediaPlayer.start();
        } else if (view.getId() == developers.jar.uuku.R.id.fButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, developers.jar.uuku.R.raw.defoca);
            mediaPlayer.start();
        } else if (view.getId() == developers.jar.uuku.R.id.gButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, developers.jar.uuku.R.raw.deguante);
            mediaPlayer.start();
        } else if (view.getId() == developers.jar.uuku.R.id.hButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, developers.jar.uuku.R.raw.dehumo);
            mediaPlayer.start();
        } else if (view.getId() == developers.jar.uuku.R.id.iButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, developers.jar.uuku.R.raw.deisla);
            mediaPlayer.start();
        } else if (view.getId() == developers.jar.uuku.R.id.jButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, developers.jar.uuku.R.raw.dejeringa);
            mediaPlayer.start();
        } else if (view.getId() == developers.jar.uuku.R.id.kButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, developers.jar.uuku.R.raw.dekilos);
            mediaPlayer.start();
        } else if (view.getId() == developers.jar.uuku.R.id.lButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, developers.jar.uuku.R.raw.delana);
            mediaPlayer.start();
        } else if (view.getId() == developers.jar.uuku.R.id.mButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, developers.jar.uuku.R.raw.demama);
            mediaPlayer.start();
        } else if (view.getId() == developers.jar.uuku.R.id.nButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, developers.jar.uuku.R.raw.denido);
            mediaPlayer.start();
        } else if (view.getId() == developers.jar.uuku.R.id.gnButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, developers.jar.uuku.R.raw.degnandu);
            mediaPlayer.start();
        } else if (view.getId() == developers.jar.uuku.R.id.oButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, developers.jar.uuku.R.raw.deoro);
            mediaPlayer.start();
        } else if (view.getId() == developers.jar.uuku.R.id.pButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, developers.jar.uuku.R.raw.depan);
            mediaPlayer.start();
        } else if (view.getId() == developers.jar.uuku.R.id.qButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, developers.jar.uuku.R.raw.dequeso);
            mediaPlayer.start();
        } else if (view.getId() == developers.jar.uuku.R.id.rButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, developers.jar.uuku.R.raw.deroca);
            mediaPlayer.start();
        } else if (view.getId() == developers.jar.uuku.R.id.sButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, developers.jar.uuku.R.raw.desarten);
            mediaPlayer.start();
        } else if (view.getId() == developers.jar.uuku.R.id.tButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, developers.jar.uuku.R.raw.detenedor);
            mediaPlayer.start();
        } else if (view.getId() == developers.jar.uuku.R.id.uButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, developers.jar.uuku.R.raw.deuvas);
            mediaPlayer.start();
        } else if (view.getId() == developers.jar.uuku.R.id.vButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, developers.jar.uuku.R.raw.ventana);
            mediaPlayer.start();
        } else if (view.getId() == developers.jar.uuku.R.id.wButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, developers.jar.uuku.R.raw.dewaffle);
            mediaPlayer.start();
        } else if (view.getId() == developers.jar.uuku.R.id.xButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, developers.jar.uuku.R.raw.dexilofono);
            mediaPlayer.start();
        } else if (view.getId() == developers.jar.uuku.R.id.yButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, developers.jar.uuku.R.raw.deyoyo);
            mediaPlayer.start();
        } else if (view.getId() == developers.jar.uuku.R.id.zButton) {
            MediaPlayer mediaPlayer = MediaPlayer.create(this, developers.jar.uuku.R.raw.dezanahoria);
            mediaPlayer.start();
        }
    }


}
