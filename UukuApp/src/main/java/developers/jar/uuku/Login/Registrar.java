package developers.jar.uuku.Login;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import developers.jar.uuku.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by axel_ on 17/04/2017.
 */

public class Registrar extends AppCompatActivity implements View.OnClickListener {

        Button consultar;
        Button consultarporid;
        Button insertar;
        Button actualizar;
        Button borrar;
        EditText idendificador;
        EditText nombre;
        Spinner escuela;
        EditText grupo;
        EditText contrasenia;
        EditText confcontrasenia;
        EditText correo;
        TextView login;


        // IP de mi Url
        String IP = "http://uuku.esy.es/";
        // Rutas de los Web Services
        String GET = IP + "/obtener_usuarios.php";
        String GET_BY_ID = IP + "/obtener_usuario_por_id.php";
        String UPDATE = IP + "/actualizar_usuario.php";
        String DELETE = IP + "/borrar_usuario.php";
        String INSERT = IP + "/insertar_usuario.php";

        ObtenerWebService hiloconexion;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_register);



            // Enlaces con elementos visuales del XML


            insertar = (Button)findViewById(R.id.insertar);

            nombre = (EditText)findViewById(R.id.txt_username);
            escuela = (Spinner)findViewById(R.id.txt_school);
            grupo = (EditText)findViewById(R.id.txt_group);
            contrasenia = (EditText)findViewById(R.id.txt_pwd1);
            confcontrasenia = (EditText)findViewById(R.id.txt_pwd2);
            correo = (EditText)findViewById(R.id.txt_email);
            Spinner spinner = (Spinner) findViewById(R.id.txt_school);
            login = (TextView)findViewById(R.id.link_login) ;

            // Spinner click listener


            // Spinner Drop down elements
            List<String> categories = new ArrayList<String>();
            categories.add("Beatriz Velasco de Aleman");
            categories.add("Otra");


            // Creating adapter for spinner
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

            // Drop down layout style - list view with radio button
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            // attaching data adapter to spinner
            spinner.setAdapter(dataAdapter);

            // Listener de los botones


            insertar.setOnClickListener(this);





        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }

        @Override
        public void onClick(View v) {
            String name = nombre.getText().toString();
            String school = escuela.getSelectedItem().toString();
            String email = correo.getText().toString();
            String group = grupo.getText().toString();
            String password = contrasenia.getText().toString();
            String reEnterPassword = confcontrasenia.getText().toString();

            if (name.isEmpty() || name.length() < 3) {
                nombre.setError("Nombre debe ser mayor a 3 caracteres");
                return;
            }

            if (group.isEmpty()) {
                grupo.setError("Ingresa un grupo");
                return;
            }


            if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                correo.setError("Ingresa un correo electronico valido");
                return;
            }



            if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
                contrasenia.setError("Contraseña entre 4 y 10 caracteres alfanumericos");
                return;
            }

            if (reEnterPassword.isEmpty() || reEnterPassword.length() < 4 || reEnterPassword.length() > 10 || !(reEnterPassword.equals(password))) {
                confcontrasenia.setError("Las contraseñas no coinciden");
            } else {
                switch (v.getId()){

                    case R.id.insertar:

                        hiloconexion = new ObtenerWebService();
                        hiloconexion.execute(INSERT,"3",nombre.getText().toString(),escuela.getSelectedItem().toString(),
                                grupo.getText().toString(),contrasenia.getText().toString(),confcontrasenia.getText().toString(),
                                correo.getText().toString());   // Parámetros que recibe doInBackground


                        break;

                    default:

                        break;
                }
            }

        }

        public class ObtenerWebService extends AsyncTask<String,Void,String>{

            @Override
            protected String doInBackground(String... params) {

                String cadena = params[0];
                URL url = null; // Url de donde queremos obtener información
                String devuelve ="";




                if(params[1]=="3"){    // insert

                    try {
                        HttpURLConnection urlConn;

                        DataOutputStream printout;
                        DataInputStream input;
                        url = new URL(cadena);
                        urlConn = (HttpURLConnection) url.openConnection();
                        urlConn.setDoInput(true);
                        urlConn.setDoOutput(true);
                        urlConn.setUseCaches(false);
                        urlConn.setRequestProperty("Content-Type", "application/json");
                        urlConn.setRequestProperty("Accept", "application/json");
                        urlConn.connect();
                        //Creo el Objeto JSON
                        JSONObject jsonParam = new JSONObject();
                        jsonParam.put("USERNAME", params[2]);
                        jsonParam.put("escuela", params[3]);
                        jsonParam.put("grupo", params[4]);
                        jsonParam.put("PASSWORD", params[5]);
                        jsonParam.put("confcontrasenia", params[6]);
                        jsonParam.put("correo", params[7]);
                        // Envio los parámetros post.
                        OutputStream os = urlConn.getOutputStream();
                        BufferedWriter writer = new BufferedWriter(
                                new OutputStreamWriter(os, "UTF-8"));
                        writer.write(jsonParam.toString());
                        writer.flush();
                        writer.close();

                        int respuesta = urlConn.getResponseCode();


                        StringBuilder result = new StringBuilder();

                        if (respuesta == HttpURLConnection.HTTP_OK) {


                            String line;
                            BufferedReader br=new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
                            while ((line=br.readLine()) != null) {
                                result.append(line);
                                //response+=line;
                            }

                            //Creamos un objeto JSONObject para poder acceder a los atributos (campos) del objeto.
                            JSONObject respuestaJSON = new JSONObject(result.toString());   //Creo un JSONObject a partir del StringBuilder pasado a cadena
                            //Accedemos al vector de resultados

                            String resultJSON = respuestaJSON.getString("estado");   // estado es el nombre del campo en el JSON


                            if (resultJSON == "1") {      // hay un alumno que mostrar
                                devuelve = "Usuario insertado correctamente";

                            } else if (resultJSON == "2") {
                                devuelve = "El usuario no pudo insertarse";
                            }



                        }

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    return devuelve;




                }
                return null;
            }

            @Override
            protected void onCancelled(String s) {
                super.onCancelled(s);
            }

            @Override
            protected void onPostExecute(String s) {



                //super.onPostExecute(s);
            }


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onProgressUpdate(Void... values) {
                super.onProgressUpdate(values);
            }

        }

    public void btnGoLogin_Click(View v) {
        Intent i = new Intent(Registrar.this, LoginActivity.class);
        startActivityForResult(i, 1);
    }
    @Override
    public void onBackPressed() {
        // Disable going back to the MainActivity
        moveTaskToBack(false);
    }

    }


