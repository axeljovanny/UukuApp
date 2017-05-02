package developers.jar.uuku.Login;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import developers.jar.uuku.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button consultar;
    Button consultarporid;
    Button insertar;
    Button actualizar;
    Button borrar;
    EditText idendificador;
    EditText nombre;
    EditText escuela;
    EditText grupo;
    EditText contrasenia;
    EditText confcontrasenia;
    EditText correo;
    TextView resultado;


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
        setContentView(R.layout.activity_main);



        // Enlaces con elementos visuales del XML

        consultar = (Button)findViewById(R.id.consultar);
        consultarporid = (Button)findViewById(R.id.consultarid);
        insertar = (Button)findViewById(R.id.insertar);
        actualizar = (Button)findViewById(R.id.actualizar);
        borrar = (Button)findViewById(R.id.borrar);
        idendificador = (EditText)findViewById(R.id.eid);
        nombre = (EditText)findViewById(R.id.enombre);
        escuela = (EditText)findViewById(R.id.eescuela);
        grupo = (EditText)findViewById(R.id.egrupo);
        contrasenia = (EditText)findViewById(R.id.econtrasenia);
        confcontrasenia = (EditText)findViewById(R.id.econfcontrasenia);
        correo = (EditText)findViewById(R.id.ecorreo);
        resultado = (TextView)findViewById(R.id.resultado);

        // Listener de los botones

        consultar.setOnClickListener(this);
        consultarporid.setOnClickListener(this);
        insertar.setOnClickListener(this);
        actualizar.setOnClickListener(this);
        borrar.setOnClickListener(this);




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
        switch (v.getId()){
            case R.id.consultar:

                hiloconexion = new ObtenerWebService();
                hiloconexion.execute(GET,"1");   // Parámetros que recibe doInBackground

                break;
            case R.id.consultarid:

                hiloconexion = new ObtenerWebService();
                String cadenallamada = GET_BY_ID + "?id=" + idendificador.getText().toString();
                hiloconexion.execute(cadenallamada,"2");   // Parámetros que recibe doInBackground


                break;
            case R.id.insertar:

                hiloconexion = new ObtenerWebService();
                hiloconexion.execute(INSERT,"3",nombre.getText().toString(),escuela.getText().toString(),
                        grupo.getText().toString(),contrasenia.getText().toString(),confcontrasenia.getText().toString(),
                        correo.getText().toString());   // Parámetros que recibe doInBackground


                break;
            case R.id.actualizar:

                hiloconexion = new ObtenerWebService();
                hiloconexion.execute(UPDATE,"4",idendificador.getText().toString(),nombre.getText().toString(),escuela.getText().toString(),
                        grupo.getText().toString(),contrasenia.getText().toString(),confcontrasenia.getText().toString(),
                        correo.getText().toString());   // Parámetros que recibe doInBackground


                break;
            case R.id.borrar:

                hiloconexion = new ObtenerWebService();
                hiloconexion.execute(DELETE,"5",idendificador.getText().toString());   // Parámetros que recibe doInBackground


                break;
            default:

                break;
        }
    }

    public class ObtenerWebService extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... params) {

            String cadena = params[0];
            URL url = null; // Url de donde queremos obtener información
            String devuelve ="";



            if(params[1]=="1"){    // Consulta de todos los alumnos

                try {
                    url = new URL(cadena);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection(); //Abrir la conexión
                    connection.setRequestProperty("User-Agent", "Mozilla/5.0" +
                            " (Linux; Android 1.5; es-ES) Ejemplo HTTP");
                    //connection.setHeader("content-type", "application/json");

                    int respuesta = connection.getResponseCode();
                    StringBuilder result = new StringBuilder();

                    if (respuesta == HttpURLConnection.HTTP_OK){


                        InputStream in = new BufferedInputStream(connection.getInputStream());  // preparo la cadena de entrada

                        BufferedReader reader = new BufferedReader(new InputStreamReader(in));  // la introduzco en un BufferedReader

                        // El siguiente proceso lo hago porque el JSONOBject necesita un String y tengo
                        // que tranformar el BufferedReader a String. Esto lo hago a traves de un
                        // StringBuilder.

                        String line;
                        while ((line = reader.readLine()) != null) {
                            result.append(line);        // Paso toda la entrada al StringBuilder
                        }

                        //Creamos un objeto JSONObject para poder acceder a los atributos (campos) del objeto.
                        JSONObject respuestaJSON = new JSONObject(result.toString());   //Creo un JSONObject a partir del StringBuilder pasado a cadena
                        //Accedemos al vector de resultados

                        String resultJSON = respuestaJSON.getString("estado");   // estado es el nombre del campo en el JSON



                        if (resultJSON=="1"){      // hay alumnos a mostrar
                            JSONArray usuariosJSON = respuestaJSON.getJSONArray("usuarios");   // estado es el nombre del campo en el JSON
                            for(int i=0;i<usuariosJSON.length();i++){
                                devuelve = devuelve + usuariosJSON.getJSONObject(i).getString("id") + " " +
                                        usuariosJSON.getJSONObject(i).getString("nombre") + " " +
                                        usuariosJSON.getJSONObject(i).getString("escuela") + " " +
                                        usuariosJSON.getJSONObject(i).getString("grupo") + " " +
                                        usuariosJSON.getJSONObject(i).getString("contrasenia") + " " +
                                        usuariosJSON.getJSONObject(i).getString("confcontrasenia") + " " +
                                        usuariosJSON.getJSONObject(i).getString("correo") + "\n";

                            }

                        }
                        else if (resultJSON=="2"){
                            devuelve = "No hay usuarios";
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
            else if(params[1]=="2"){    // consulta por id

                try {
                    url = new URL(cadena);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection(); //Abrir la conexión
                    connection.setRequestProperty("User-Agent", "Mozilla/5.0" +
                            " (Linux; Android 1.5; es-ES) Ejemplo HTTP");
                    //connection.setHeader("content-type", "application/json");

                    int respuesta = connection.getResponseCode();
                    StringBuilder result = new StringBuilder();

                    if (respuesta == HttpURLConnection.HTTP_OK){


                        InputStream in = new BufferedInputStream(connection.getInputStream());  // preparo la cadena de entrada

                        BufferedReader reader = new BufferedReader(new InputStreamReader(in));  // la introduzco en un BufferedReader

                        // El siguiente proceso lo hago porque el JSONOBject necesita un String y tengo
                        // que tranformar el BufferedReader a String. Esto lo hago a traves de un
                        // StringBuilder.

                        String line;
                        while ((line = reader.readLine()) != null) {
                            result.append(line);        // Paso toda la entrada al StringBuilder
                        }

                        //Creamos un objeto JSONObject para poder acceder a los atributos (campos) del objeto.
                        JSONObject respuestaJSON = new JSONObject(result.toString());   //Creo un JSONObject a partir del StringBuilder pasado a cadena
                        //Accedemos al vector de resultados

                        String resultJSON = respuestaJSON.getString("estado");   // estado es el nombre del campo en el JSON

                        if (resultJSON=="1"){      // hay un alumno que mostrar
                            devuelve = devuelve + respuestaJSON.getJSONObject("usuario").getString("id") + " " +
                                    respuestaJSON.getJSONObject("usuario").getString("nombre") + " " +
                                    respuestaJSON.getJSONObject("usuario").getString("escuela") + " " +
                                    respuestaJSON.getJSONObject("usuario").getString("grupo") + " " +
                                    respuestaJSON.getJSONObject("usuario").getString("contrasenia") + " " +
                                    respuestaJSON.getJSONObject("usuario").getString("confcontrasenia") + " " +
                                    respuestaJSON.getJSONObject("usuario").getString("escuela");

                       }
                        else if (resultJSON=="2"){
                            devuelve = "No hay usuarios";
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
            else if(params[1]=="3"){    // insert

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
                    jsonParam.put("nombre", params[2]);
                    jsonParam.put("escuela", params[3]);
                    jsonParam.put("grupo", params[4]);
                    jsonParam.put("contrasenia", params[5]);
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
            else if(params[1]=="4"){    // update

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
                    jsonParam.put("id",params[2]);
                    jsonParam.put("nombre", params[3]);
                    jsonParam.put("escuela", params[4]);
                    jsonParam.put("grupo", params[5]);
                    jsonParam.put("contrasenia", params[6]);
                    jsonParam.put("confcontrasenia", params[7]);
                    jsonParam.put("correo", params[8]);
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
                            devuelve = "Usuario actualizado correctamente";

                        } else if (resultJSON == "2") {
                            devuelve = "El usuario no pudo actualizarse";
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
            else if(params[1]=="5") {    // delete

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
                    jsonParam.put("id", params[2]);
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
                            devuelve = "Usuario borrado correctamente";

                        } else if (resultJSON == "2") {
                            devuelve = "No hay usuarios";
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
            resultado.setText(s);
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

}
