package developers.jar.uuku.juegos;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class ListenAndLearnActivity extends Activity {
    MediaPlayer mpSound, correctSound, wrongSound;
    EditText answerText;
    Button enter1, enter2, enter3, enter4, enter5, enter6, enter7, enter8, enter9, enter10;
    ImageView tweet;
    TextView score;
    int count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(developers.jar.uuku.R.layout.activity_listen_and_learn);

        tweet = (ImageView) findViewById(developers.jar.uuku.R.id.imageBtn);

        mpSound = MediaPlayer.create(this, developers.jar.uuku.R.raw.doctor);
        correctSound = MediaPlayer.create(this, developers.jar.uuku.R.raw.correcto);
        wrongSound = MediaPlayer.create(this, developers.jar.uuku.R.raw.incorrecto);

        answerText = (EditText) findViewById(developers.jar.uuku.R.id.editTextAnswer);

        score = (TextView) findViewById(developers.jar.uuku.R.id.totalScoreTV);
        count = 0;
        score.setText(count+"");

        enter2 = (Button) findViewById(developers.jar.uuku.R.id.enterBtn2);
        enter2.setVisibility(View.INVISIBLE);
        enter3 = (Button) findViewById(developers.jar.uuku.R.id.enterBtn3);
        enter3.setVisibility(View.INVISIBLE);
        enter4 = (Button) findViewById(developers.jar.uuku.R.id.enterBtn4);
        enter4.setVisibility(View.INVISIBLE);
        enter5 = (Button) findViewById(developers.jar.uuku.R.id.enterBtn5);
        enter5.setVisibility(View.INVISIBLE);
        enter6 = (Button) findViewById(developers.jar.uuku.R.id.enterBtn6);
        enter6.setVisibility(View.INVISIBLE);
        enter7 = (Button) findViewById(developers.jar.uuku.R.id.enterBtn7);
        enter7.setVisibility(View.INVISIBLE);
        enter8 = (Button) findViewById(developers.jar.uuku.R.id.enterBtn8);
        enter8.setVisibility(View.INVISIBLE);
        enter9 = (Button) findViewById(developers.jar.uuku.R.id.enterBtn9);
        enter9.setVisibility(View.INVISIBLE);
        enter10 = (Button) findViewById(developers.jar.uuku.R.id.enterBtn10);
        enter10.setVisibility(View.INVISIBLE);

        AlertDialog alertDialog = new AlertDialog.Builder(this).create();

        alertDialog.setTitle("Instrucciones");

        alertDialog.setMessage("\n" +
                "Aquí puedes probar tus conocimientos de habilidades de escucha y ortografía. " +

                "\nClick en la imagen para escuchar la palabra " +

                "\nIngrese tu respuesta " +

                "\n La puntuación será monitoreada y se puede guardar en la clasificación");

        alertDialog.setButton("¡Vamos!", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {}});



        alertDialog.setIcon(developers.jar.uuku.R.drawable.question);//this is the question mark icon on the hint popup page

        alertDialog.show();//this tells the above icon to show

        //set home as up
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }



    public void open(View view){
        //enables user to tweet about a score they have achieved i.e. share with friends
        String tweetUrl = "https://twitter.com/intent/tweet?text=New Score in POW app: " + count;
        Uri uri = Uri.parse(tweetUrl);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    public void playSound(View view) {
        mpSound.start();

    }

    public void enter(View view) {
        answerText = (EditText) findViewById(developers.jar.uuku.R.id.editTextAnswer);
        String answer  = answerText.getText().toString();
        if(answer.equalsIgnoreCase("Doctor")){
            Toast.makeText(ListenAndLearnActivity.this, "Felicitaciones. Eso es correcto", Toast.LENGTH_LONG).show();
            correctSound.start();
            count++;
            score.setText(count+"");

            ImageView myButton = (ImageView) findViewById(developers.jar.uuku.R.id.imageBtn);
            myButton.setImageResource(developers.jar.uuku.R.drawable.veterinario);

            mpSound = MediaPlayer.create(this, developers.jar.uuku.R.raw.veterinario);

            answerText.setText("");

            enter1 = (Button) findViewById(developers.jar.uuku.R.id.enterBtn);
            enter1.setVisibility(View.INVISIBLE);
            enter2.setVisibility(View.VISIBLE);

        }else if(answer.equals("")){
            Toast.makeText(ListenAndLearnActivity.this, "Porfavor ingresa tu respuesta", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(ListenAndLearnActivity.this, "Lo siento,pero eso no es correcto", Toast.LENGTH_LONG).show();
            wrongSound.start();

            ImageView myButton = (ImageView) findViewById(developers.jar.uuku.R.id.imageBtn);
            myButton.setImageResource(developers.jar.uuku.R.drawable.veterinario);

            mpSound = MediaPlayer.create(this, developers.jar.uuku.R.raw.veterinario);

            answerText.setText("");

            enter1 = (Button) findViewById(developers.jar.uuku.R.id.enterBtn);
            enter1.setVisibility(View.INVISIBLE);
            enter2.setVisibility(View.VISIBLE);
        }

    }

    public void enterQuestionTwo(View view) {
        answerText = (EditText) findViewById(developers.jar.uuku.R.id.editTextAnswer);
        String answer  = answerText.getText().toString();
        if(answer.equalsIgnoreCase("Veterinario")){
            Toast.makeText(ListenAndLearnActivity.this, "Felicitaciones. Eso es correcto", Toast.LENGTH_LONG).show();
            correctSound.start();
            count++;
            score.setText(count+"");

            ImageView myButton = (ImageView) findViewById(developers.jar.uuku.R.id.imageBtn);
            myButton.setImageResource(developers.jar.uuku.R.drawable.programador);

            mpSound = MediaPlayer.create(this, developers.jar.uuku.R.raw.programador);

            answerText.setText("");

            enter2.setVisibility(View.INVISIBLE);
            enter3.setVisibility(View.VISIBLE);

        }else if(answer.equals("")){
            Toast.makeText(ListenAndLearnActivity.this, "Porfavor ingresa tu respuesta", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(ListenAndLearnActivity.this, "Lo siento,pero eso no es correcto", Toast.LENGTH_LONG).show();
            wrongSound.start();

            ImageView myButton = (ImageView) findViewById(developers.jar.uuku.R.id.imageBtn);
            myButton.setImageResource(developers.jar.uuku.R.drawable.programador);

            mpSound = MediaPlayer.create(this, developers.jar.uuku.R.raw.programador);

            answerText.setText("");

            enter2.setVisibility(View.INVISIBLE);
            enter3.setVisibility(View.VISIBLE);
        }

    }

    public void enterQuestionThree(View view) {
        answerText = (EditText) findViewById(developers.jar.uuku.R.id.editTextAnswer);
        String answer  = answerText.getText().toString();
        if(answer.equalsIgnoreCase("Programador")){
            Toast.makeText(ListenAndLearnActivity.this, "Felicitaciones. Eso es correcto", Toast.LENGTH_LONG).show();
            correctSound.start();
            count++;
            score.setText(count+"");

            ImageView myButton = (ImageView) findViewById(developers.jar.uuku.R.id.imageBtn);
            myButton.setImageResource(developers.jar.uuku.R.drawable.policia);

            mpSound = MediaPlayer.create(this, developers.jar.uuku.R.raw.policia);

            answerText.setText("");

            enter3.setVisibility(View.INVISIBLE);
            enter4.setVisibility(View.VISIBLE);

        }else if(answer.equals("")){
            Toast.makeText(ListenAndLearnActivity.this, "Porfavor ingresa tu respuesta", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(ListenAndLearnActivity.this, "Lo siento,pero eso no es correcto", Toast.LENGTH_LONG).show();
            wrongSound.start();

            ImageView myButton = (ImageView) findViewById(developers.jar.uuku.R.id.imageBtn);
            myButton.setImageResource(developers.jar.uuku.R.drawable.policia);

            mpSound = MediaPlayer.create(this, developers.jar.uuku.R.raw.policia);

            answerText.setText("");

            enter3.setVisibility(View.INVISIBLE);
            enter4.setVisibility(View.VISIBLE);
        }

    }

    public void enterQuestionFour(View view) {
        answerText = (EditText) findViewById(developers.jar.uuku.R.id.editTextAnswer);
        String answer  = answerText.getText().toString();
        if(answer.equalsIgnoreCase("Policia")){
            Toast.makeText(ListenAndLearnActivity.this, "Felicitaciones. Eso es correcto", Toast.LENGTH_LONG).show();
            correctSound.start();
            count++;
            score.setText(count+"");

            ImageView myButton = (ImageView) findViewById(developers.jar.uuku.R.id.imageBtn);
            myButton.setImageResource(developers.jar.uuku.R.drawable.abogado);

            mpSound = MediaPlayer.create(this, developers.jar.uuku.R.raw.abogado);

            answerText.setText("");

            enter4.setVisibility(View.INVISIBLE);
            enter5.setVisibility(View.VISIBLE);

        }else if(answer.equals("")){
            Toast.makeText(ListenAndLearnActivity.this, "Porfavor ingresa tu respuesta", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(ListenAndLearnActivity.this, "Lo siento,pero eso no es correcto", Toast.LENGTH_LONG).show();
            wrongSound.start();

            ImageView myButton = (ImageView) findViewById(developers.jar.uuku.R.id.imageBtn);
            myButton.setImageResource(developers.jar.uuku.R.drawable.abogado);

            mpSound = MediaPlayer.create(this, developers.jar.uuku.R.raw.abogado);

            answerText.setText("");

            enter4.setVisibility(View.INVISIBLE);
            enter5.setVisibility(View.VISIBLE);
        }

    }

    public void enterQuestionFive(View view) {
        answerText = (EditText) findViewById(developers.jar.uuku.R.id.editTextAnswer);
        String answer  = answerText.getText().toString();
        if(answer.equalsIgnoreCase("Abogado")){
            Toast.makeText(ListenAndLearnActivity.this, "Felicitaciones. Eso es correcto", Toast.LENGTH_LONG).show();
            correctSound.start();
            count++;
            score.setText(count+"");

            ImageView myButton = (ImageView) findViewById(developers.jar.uuku.R.id.imageBtn);
            myButton.setImageResource(developers.jar.uuku.R.drawable.bombero);

            mpSound = MediaPlayer.create(this, developers.jar.uuku.R.raw.bombero);

            answerText.setText("");

            enter5.setVisibility(View.INVISIBLE);
            enter6.setVisibility(View.VISIBLE);

        }else if(answer.equals("")){
            Toast.makeText(ListenAndLearnActivity.this, "Porfavor ingresa tu respuesta", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(ListenAndLearnActivity.this, "Lo siento,pero eso no es correcto", Toast.LENGTH_LONG).show();
            wrongSound.start();

            ImageView myButton = (ImageView) findViewById(developers.jar.uuku.R.id.imageBtn);
            myButton.setImageResource(developers.jar.uuku.R.drawable.bombero);

            mpSound = MediaPlayer.create(this, developers.jar.uuku.R.raw.bombero);

            answerText.setText("");

            enter5.setVisibility(View.INVISIBLE);
            enter6.setVisibility(View.VISIBLE);
        }
    }

    public void quit(View view) {
       // Intent intent = new Intent(this, KidsActivity.class);
      //  startActivity(intent);
    }

    public void save(View view) {
        Bundle b = new Bundle();
        b.putString("Key", score.getText().toString());
       // Intent intent = new Intent(ListenAndLearnActivity.this, ScoreOptionsActivity.class);
       // intent.putExtras(b);
    }

    public void enterQuestionSix(View view) {
        answerText = (EditText) findViewById(developers.jar.uuku.R.id.editTextAnswer);
        String answer  = answerText.getText().toString();
        if(answer.equalsIgnoreCase("Bombero")){
            Toast.makeText(ListenAndLearnActivity.this, "Felicitaciones. Eso es correcto", Toast.LENGTH_LONG).show();
            correctSound.start();
            count++;
            score.setText(count+"");

            ImageView myButton = (ImageView) findViewById(developers.jar.uuku.R.id.imageBtn);
            myButton.setImageResource(developers.jar.uuku.R.drawable.chef);

            mpSound = MediaPlayer.create(this, developers.jar.uuku.R.raw.chef);

            answerText.setText("");

            enter6.setVisibility(View.INVISIBLE);
            enter7.setVisibility(View.VISIBLE);

        }else if(answer.equals("")){
            Toast.makeText(ListenAndLearnActivity.this, "Porfavor ingresa tu respuesta", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(ListenAndLearnActivity.this, "Lo siento,pero eso no es correcto", Toast.LENGTH_LONG).show();
            wrongSound.start();

            ImageView myButton = (ImageView) findViewById(developers.jar.uuku.R.id.imageBtn);
            myButton.setImageResource(developers.jar.uuku.R.drawable.chef);

            mpSound = MediaPlayer.create(this, developers.jar.uuku.R.raw.chef);

            answerText.setText("");

            enter6.setVisibility(View.INVISIBLE);
            enter7.setVisibility(View.VISIBLE);
        }
    }

    public void enterQuestionSeven(View view) {
        answerText = (EditText) findViewById(developers.jar.uuku.R.id.editTextAnswer);
        String answer  = answerText.getText().toString();
        if(answer.equalsIgnoreCase("Chef")){
            Toast.makeText(ListenAndLearnActivity.this, "Felicitaciones. Eso es correcto", Toast.LENGTH_LONG).show();
            correctSound.start();
            count++;
            score.setText(count+"");

            ImageView myButton = (ImageView) findViewById(developers.jar.uuku.R.id.imageBtn);
            myButton.setImageResource(developers.jar.uuku.R.drawable.cientifico);

            mpSound = MediaPlayer.create(this, developers.jar.uuku.R.raw.cientifico);

            answerText.setText("");

            enter7.setVisibility(View.INVISIBLE);
            enter8.setVisibility(View.VISIBLE);

        }else if(answer.equals("")){
            Toast.makeText(ListenAndLearnActivity.this, "Porfavor ingresa tu respuesta", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(ListenAndLearnActivity.this, "Lo siento,pero eso no es correcto", Toast.LENGTH_LONG).show();
            wrongSound.start();

            ImageView myButton = (ImageView) findViewById(developers.jar.uuku.R.id.imageBtn);
            myButton.setImageResource(developers.jar.uuku.R.drawable.cientifico);

            mpSound = MediaPlayer.create(this, developers.jar.uuku.R.raw.cientifico);

            answerText.setText("");

            enter7.setVisibility(View.INVISIBLE);
            enter8.setVisibility(View.VISIBLE);
        }
    }

    public void enterQuestionEight(View view) {
        answerText = (EditText) findViewById(developers.jar.uuku.R.id.editTextAnswer);
        String answer  = answerText.getText().toString();
        if(answer.equalsIgnoreCase("Cientifico")){
            Toast.makeText(ListenAndLearnActivity.this, "Felicitaciones. Eso es correcto", Toast.LENGTH_LONG).show();
            correctSound.start();
            count++;
            score.setText(count+"");

            ImageView myButton = (ImageView) findViewById(developers.jar.uuku.R.id.imageBtn);
            myButton.setImageResource(developers.jar.uuku.R.drawable.ingeniero);

            mpSound = MediaPlayer.create(this, developers.jar.uuku.R.raw.ingeniero);

            answerText.setText("");

            enter8.setVisibility(View.INVISIBLE);
            enter9.setVisibility(View.VISIBLE);

        }else if(answer.equals("")){
            Toast.makeText(ListenAndLearnActivity.this, "Porfavor ingresa tu respuesta", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(ListenAndLearnActivity.this, "Lo siento, pero eso no es correcto", Toast.LENGTH_LONG).show();
            wrongSound.start();

            ImageView myButton = (ImageView) findViewById(developers.jar.uuku.R.id.imageBtn);
            myButton.setImageResource(developers.jar.uuku.R.drawable.ingeniero);

            mpSound = MediaPlayer.create(this, developers.jar.uuku.R.raw.ingeniero);

            answerText.setText("");

            enter8.setVisibility(View.INVISIBLE);
            enter9.setVisibility(View.VISIBLE);
        }
    }

    public void enterQuestionNine(View view) {
        answerText = (EditText) findViewById(developers.jar.uuku.R.id.editTextAnswer);
        String answer  = answerText.getText().toString();
        if(answer.equalsIgnoreCase("Ingeniero")){
            Toast.makeText(ListenAndLearnActivity.this, "Felicitaciones. Eso es correcto", Toast.LENGTH_LONG).show();
            correctSound.start();
            count++;
            score.setText(count+"");

            ImageView myButton = (ImageView) findViewById(developers.jar.uuku.R.id.imageBtn);
            myButton.setImageResource(developers.jar.uuku.R.drawable.maestro);

            mpSound = MediaPlayer.create(this, developers.jar.uuku.R.raw.maestro);

            answerText.setText("");

            enter9.setVisibility(View.INVISIBLE);
            enter10.setVisibility(View.VISIBLE);

        }else if(answer.equals("")){
            Toast.makeText(ListenAndLearnActivity.this, "Porfavor ingresa tu respuesta", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(ListenAndLearnActivity.this, "Lo siento, pero eso no es correcto", Toast.LENGTH_LONG).show();
            wrongSound.start();

            ImageView myButton = (ImageView) findViewById(developers.jar.uuku.R.id.imageBtn);
            myButton.setImageResource(developers.jar.uuku.R.drawable.maestro);

            mpSound = MediaPlayer.create(this, developers.jar.uuku.R.raw.maestro);

            answerText.setText("");

            enter9.setVisibility(View.INVISIBLE);
            enter10.setVisibility(View.VISIBLE);
        }
    }

    public void enterQuestionTen(View view) {
        answerText = (EditText) findViewById(developers.jar.uuku.R.id.editTextAnswer);
        String answer  = answerText.getText().toString();
        if(answer.equalsIgnoreCase("Maestro")){
            Toast.makeText(ListenAndLearnActivity.this, "Felicitaciones. Eso es correcto", Toast.LENGTH_LONG).show();
            correctSound.start();
            count++;
            score.setText(count+"");

            if(count == 5) {

                AlertDialog alertDialog = new AlertDialog.Builder(this).create();

                alertDialog.setTitle("Fin del Juego");

                alertDialog.setMessage("Enhorabuena, has desbloqueado el logro del Trofeo de bronce \nTu puntaje es " + count);

                alertDialog.setIcon(developers.jar.uuku.R.drawable.achievebronze);

                alertDialog.setButton("GUARDA PUNTAJE!", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Bundle b = new Bundle();
                        b.putString("Key", score.getText().toString());
                     //   Intent intent = new Intent(ListenAndLearnActivity.this, ScoreOptionsActivity.class);
                      //  intent.putExtras(b);
                      //  startActivity(intent);
                    }
                });

                alertDialog.show();//this tells the above icon to show
            }
            else if(count == 6){
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();

                alertDialog.setTitle("Fin del juego");

                alertDialog.setMessage("Enhorabuena, has desbloqueado el logro del Trofeo de bronce \nTu puntaje es " + count);

                alertDialog.setIcon(developers.jar.uuku.R.drawable.achievebronze);

                alertDialog.setButton("GUARDA PUNTAJE!", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Bundle b = new Bundle();
                        b.putString("Key", score.getText().toString());
                       // Intent intent = new Intent(ListenAndLearnActivity.this, ScoreOptionsActivity.class);
                       // intent.putExtras(b);
                      //  startActivity(intent);
                    }
                });

                alertDialog.show();//this tells the above icon to show
            }
            else if(count == 7){
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();

                alertDialog.setTitle("Fin del juego");

                alertDialog.setMessage("Enhorabuena, has desbloqueado el logro del Trofeo de bronce \nTu puntaje es " + count);

                alertDialog.setIcon(developers.jar.uuku.R.drawable.achievebronze);

                alertDialog.setButton("GUARDA PUNTAJE!", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Bundle b = new Bundle();
                        b.putString("Key", score.getText().toString());
                        // Intent intent = new Intent(ListenAndLearnActivity.this, ScoreOptionsActivity.class);
                        // intent.putExtras(b);
                        //  startActivity(intent);
                    }
                });

                alertDialog.show();//this tells the above icon to show
            }
            else if(count == 8){
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();

                alertDialog.setTitle("Fin del juego");

                alertDialog.setMessage("Enhorabuena, has desbloqueado el logro del Trofeo de bronce \nTu puntaje es " + count);

                alertDialog.setIcon(developers.jar.uuku.R.drawable.achievebronze);

                alertDialog.setButton("GUARDA PUNTAJE!", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Bundle b = new Bundle();
                        b.putString("Key", score.getText().toString());
                        // Intent intent = new Intent(ListenAndLearnActivity.this, ScoreOptionsActivity.class);
                        // intent.putExtras(b);
                        //  startActivity(intent);
                    }
                });

                alertDialog.show();//this tells the above icon to show
            }
            else if(count == 9){
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();

                alertDialog.setTitle("Fin del juego");

                alertDialog.setMessage("Enhorabuena, has desbloqueado el logro del Trofeo de bronce \nTu puntaje es " + count);

                alertDialog.setIcon(developers.jar.uuku.R.drawable.achievebronze);

                alertDialog.setButton("GUARDA PUNTAJE!", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Bundle b = new Bundle();
                        b.putString("Key", score.getText().toString());
                        // Intent intent = new Intent(ListenAndLearnActivity.this, ScoreOptionsActivity.class);
                        // intent.putExtras(b);
                        //  startActivity(intent);
                    }
                });

                alertDialog.show();//this tells the above icon to show
            }
            else if(count == 10){
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();

                alertDialog.setTitle("Fin del juego");

                alertDialog.setMessage("Enhorabuena, has desbloqueado el logro del Trofeo de bronce \nTu puntaje es " + count);

                alertDialog.setIcon(developers.jar.uuku.R.drawable.achievebronze);

                alertDialog.setButton("GUARDA PUNTAJE!", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Bundle b = new Bundle();
                        b.putString("Key", score.getText().toString());
                        // Intent intent = new Intent(ListenAndLearnActivity.this, ScoreOptionsActivity.class);
                        // intent.putExtras(b);
                        //  startActivity(intent);
                    }
                });

                alertDialog.show();//this tells the above icon to show
            }
            else{
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();

                alertDialog.setTitle("Fin del juego");

                alertDialog.setMessage("Tu puntaje es " + count);

                alertDialog.setIcon(developers.jar.uuku.R.drawable.ic_launcher);

                alertDialog.setButton("Guarda puntaje!", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Bundle b = new Bundle();
                        b.putString("Key", score.getText().toString());
                       // Intent intent = new Intent(ListenAndLearnActivity.this, ScoreOptionsActivity.class);
                       // intent.putExtras(b);
                       // startActivity(intent);
                    }
                });

                alertDialog.show();//this tells the above icon to show
            }

        }else if(answer.equals("")){
            Toast.makeText(ListenAndLearnActivity.this, "Porfavor introduce tu respuesta", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(ListenAndLearnActivity.this, "Lo siento, pero eso no es correcto", Toast.LENGTH_LONG).show();
            wrongSound.start();

            if(count == 5) {

                AlertDialog alertDialog = new AlertDialog.Builder(this).create();

                alertDialog.setTitle("Fin del juego");

                alertDialog.setMessage("Enhorabuena, has desbloqueado el logro del Trofeo de bronce \nTu puntaje es " + count);

                alertDialog.setIcon(developers.jar.uuku.R.drawable.achievebronze);

                alertDialog.setButton("GUARDA PUNTAJE!", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Bundle b = new Bundle();
                        b.putString("Key", score.getText().toString());
                        // Intent intent = new Intent(ListenAndLearnActivity.this, ScoreOptionsActivity.class);
                        // intent.putExtras(b);
                        //  startActivity(intent);
                    }
                });

                alertDialog.show();//this tells the above icon to show
            }
            else if(count == 6){
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();

                alertDialog.setTitle("Fin del juego");

                alertDialog.setMessage("Enhorabuena, has desbloqueado el logro del Trofeo de bronce \nTu puntaje es " + count);

                alertDialog.setIcon(developers.jar.uuku.R.drawable.achievebronze);

                alertDialog.setButton("GUARDA PUNTAJE!", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Bundle b = new Bundle();
                        b.putString("Key", score.getText().toString());
                        // Intent intent = new Intent(ListenAndLearnActivity.this, ScoreOptionsActivity.class);
                        // intent.putExtras(b);
                        //  startActivity(intent);
                    }
                });

                alertDialog.show();//this tells the above icon to show
            }
            else if(count == 7){
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();

                alertDialog.setTitle("Fin del juego");

                alertDialog.setMessage("Enhorabuena, has desbloqueado el logro del Trofeo de bronce \nTu puntaje es " + count);

                alertDialog.setIcon(developers.jar.uuku.R.drawable.achievebronze);

                alertDialog.setButton("GUARDA PUNTAJE!", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Bundle b = new Bundle();
                        b.putString("Key", score.getText().toString());
                        // Intent intent = new Intent(ListenAndLearnActivity.this, ScoreOptionsActivity.class);
                        // intent.putExtras(b);
                        //  startActivity(intent);
                    }
                });

                alertDialog.show();//this tells the above icon to show
            }
            else if(count == 8){
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();

                alertDialog.setTitle("Fin del juego");

                alertDialog.setMessage("Enhorabuena, has desbloqueado el logro del Trofeo de bronce \nTu puntaje es " + count);

                alertDialog.setIcon(developers.jar.uuku.R.drawable.achievebronze);

                alertDialog.setButton("GUARDA PUNTAJE!", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Bundle b = new Bundle();
                        b.putString("Key", score.getText().toString());
                        // Intent intent = new Intent(ListenAndLearnActivity.this, ScoreOptionsActivity.class);
                        // intent.putExtras(b);
                        //  startActivity(intent);
                    }
                });

                alertDialog.show();//this tells the above icon to show
            }
            else if(count == 9){
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();

                alertDialog.setTitle("Fin del juego");

                alertDialog.setMessage("Enhorabuena, has desbloqueado el logro del Trofeo de bronce \nTu puntaje es " + count);

                alertDialog.setIcon(developers.jar.uuku.R.drawable.achievebronze);

                alertDialog.setButton("GUARDA PUNTAJE!", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Bundle b = new Bundle();
                        b.putString("Key", score.getText().toString());
                        // Intent intent = new Intent(ListenAndLearnActivity.this, ScoreOptionsActivity.class);
                        // intent.putExtras(b);
                        //  startActivity(intent);
                    }
                });

                alertDialog.show();//this tells the above icon to show
            }
            else if(count == 10){
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();

                alertDialog.setTitle("Fin del juego");

                alertDialog.setMessage("Enhorabuena, has desbloqueado el logro del Trofeo de bronce \nTu puntaje es " + count);

                alertDialog.setIcon(developers.jar.uuku.R.drawable.achievebronze);

                alertDialog.setButton("GUARDA PUNTAJE!", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Bundle b = new Bundle();
                        b.putString("Key", score.getText().toString());
                        // Intent intent = new Intent(ListenAndLearnActivity.this, ScoreOptionsActivity.class);
                        // intent.putExtras(b);
                        //  startActivity(intent);
                    }
                });

                alertDialog.show();//this tells the above icon to show
            }
            else{
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();

                alertDialog.setTitle("Fin del juego");

                alertDialog.setMessage("Enhorabuena, has desbloqueado el logro del Trofeo de bronce \nTu puntaje es " + count);

                alertDialog.setIcon(developers.jar.uuku.R.drawable.achievebronze);

                alertDialog.setButton("GUARDA PUNTAJE!", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Bundle b = new Bundle();
                        b.putString("Key", score.getText().toString());
                        // Intent intent = new Intent(ListenAndLearnActivity.this, ScoreOptionsActivity.class);
                        // intent.putExtras(b);
                        //  startActivity(intent);
                    }
                });

                alertDialog.show();//this tells the above icon to show
            }

        }
    }
}
