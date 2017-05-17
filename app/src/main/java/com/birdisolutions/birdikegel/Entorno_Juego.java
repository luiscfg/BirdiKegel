package com.birdisolutions.birdikegel;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import static com.birdisolutions.birdikegel.MainActivity.PRESION_MERCURIO;
import static com.birdisolutions.birdikegel.MainActivity.SONIDO_MENUS;
import static com.birdisolutions.birdikegel.MainActivity.SONIDO_TEXTO;


public class Entorno_Juego extends AppCompatActivity {

    ProgressBar progressBarHorizontal;
    Button btnProgress;
    ImageButton btnsalir;
    ImageView texto_imagen;
    TextView indicador_presion, contador_serie;

    int numero_serie;
    private Sesion la_sesion;
    boolean acabar_sesion, en_progreso;
    long tiempo_Relajacion, tiempo_Barra;
    long tiempo_Contraccion;
    long tiempo_cero;
    int progreso;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entorno__juego);

        añadirVistas();

 //     Datos Condiguración:

        boolean presion_mercurio= getIntent().getBooleanExtra(PRESION_MERCURIO, false);
        boolean sonido_texto= getIntent().getBooleanExtra(SONIDO_TEXTO, false);
        boolean sonido_menus= getIntent().getBooleanExtra(SONIDO_MENUS, false);

// Recibimos la sesión a realizar. Se realiza a través de la clase Comunicador y sus métodos estáticos. Queda almacenada en la variable la_esión

        la_sesion = (Sesion) Comunicador.getObjeto();


//Definimos escuchadores en botones

        btnProgress.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                ejecuta_sesion();
                btnProgress.setClickable(false);
            }
        });

        btnsalir.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });
        contador_serie.setText(null);
        if(presion_mercurio)indicador_presion.setText("mmHg");
        else indicador_presion.setText("cmH2O");


    }


    private void añadirVistas() {

        btnProgress = (Button) findViewById(R.id.btn1);
        btnsalir = (ImageButton) findViewById(R.id.salir);
        texto_imagen = (ImageView) findViewById(R.id.mensaje);
        texto_imagen.setBackground(null);

        progressBarHorizontal = (ProgressBar) findViewById(R.id.progressbar_Horizontal);
        progressBarHorizontal.setProgress(0);

        indicador_presion = (TextView) findViewById(R.id.indicador_presion);
        contador_serie = (TextView) findViewById(R.id.contador_series);
    }

    void ejecuta_sesion() {

        int numero_series = la_sesion.dime_tamano();
        int i = 1;
        while (i < numero_series) {
            contador_serie.setText((i + 1) + "/" + numero_series);
            ejecuta_serie(i);
            i++;
        }

    }

    void ejecuta_serie(int n_serie) {
        int i;
        Serie mi_serie = la_sesion.coje_serie(n_serie);
        int n_repeticiones = mi_serie.getRepeticiones();

        tiempo_Relajacion = 1000 * mi_serie.getTiempo_relajacion();
        tiempo_Contraccion = 1000 * mi_serie.getTiempo_contraccion();


        for (i = 0; i < n_repeticiones; i++) {
            texto_imagen.setImageResource(R.drawable.relaja_relax_reducido);
//Relaja

            tiempo_Barra = tiempo_Relajacion;
            tiempo_cero = System.currentTimeMillis();
            SystemClock.sleep(2);
            progreso = 0;

//            new BarraSerie().execute();

//Contrae

            texto_imagen.setImageResource(R.drawable.contrae_squeeze_reducido);
            tiempo_Barra = tiempo_Contraccion;
            tiempo_cero = System.currentTimeMillis();
            SystemClock.sleep(20);
            progreso = 0;

            new BarraSerie().execute();

        }

    }



        public class BarraSerie extends AsyncTask<Void, Integer, Void> {


            @Override
            protected void onPreExecute() {
                Toast.makeText(Entorno_Juego.this, "onPreExecute", Toast.LENGTH_SHORT).show();
                progreso = 0;

            }

            @Override
            protected Void doInBackground(Void... params) {

                tiempo_cero = System.currentTimeMillis();
                SystemClock.sleep(2);

                while ((System.currentTimeMillis() - tiempo_cero) < tiempo_Barra) {
                    SystemClock.sleep(20);
                    progreso = (int) (100. * (System.currentTimeMillis() - tiempo_cero) / tiempo_Barra);
                    publishProgress(progreso);

                }

                return null;
            }


            @Override
            protected void onProgressUpdate(Integer... values) {

                progressBarHorizontal.setProgress(values[0]);
            }

            @Override
            protected void onPostExecute(Void result) {
                Toast.makeText(Entorno_Juego.this, "onPostExecute", Toast.LENGTH_SHORT).show();
                btnProgress.setClickable(true);

            }



    }
}
