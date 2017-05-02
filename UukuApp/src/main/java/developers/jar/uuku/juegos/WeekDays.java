package developers.jar.uuku.juegos;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import developers.jar.uuku.R;


public class WeekDays extends Activity {
    MediaPlayer monday,tuesday, wednesday, thursday, friday, saturday, sunday; //variables for sound files


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_days);

        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Instrucciones.");
        alertDialog.setMessage("Pulse el día deseado y aprende a pronunciarlo. ");
        alertDialog.setButton("¡Vamos!", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        alertDialog.setIcon(R.drawable.question);//this is the question mark icon on the hint popup page
        alertDialog.show();//this tells the above icon to show

        //assigns the variables to an associated audio file in the "raw" folder
        monday = MediaPlayer.create(this, R.raw.lunes);
        tuesday = MediaPlayer.create(this, R.raw.martes);
        wednesday = MediaPlayer.create(this, R.raw.miercoles);
        thursday = MediaPlayer.create(this, R.raw.jueves);
        friday = MediaPlayer.create(this, R.raw.viernes);
        saturday = MediaPlayer.create(this, R.raw.sabado);
        sunday = MediaPlayer.create(this, R.raw.domingo);

    }


    public void mondayBtn(View view) {//method for playing monday audio file
        monday.start();
    }
    public void tuesdayBtn(View view){//tuesday audio file
        tuesday.start();
    }
    public void wednesdayBtn(View view){//wednesday audio file
        wednesday.start();
    }
    public void thursdayBtn(View view){//thursday audio file
        thursday.start();
    }
    public void fridayBtn(View view){//friday audio file
        friday.start();
    }
    public void saturdayBtn(View view){//saturday audio file
        saturday.start();
    }
    public void sundayBtn(View view){//sunday audio file
        sunday.start();
    }
}
