package com.birdisolutions.birdikegel;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import static com.birdisolutions.birdikegel.MainActivity.CLAVE_INDICE_SERIE;
import static com.birdisolutions.birdikegel.MainActivity.SESION_BIRDI;

public class Entorno_Juego extends AppCompatActivity {

    ProgressBar progressBarHorizontal;
    Button btnProgress;
    ImageButton btnsalir;
    ImageView texto_imagen;

    int numero_serie;
    private Sesion la_sesion;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entorno__juego);

        añadirVistas();

// Recibimos la sesión a realizar. Se realiza a través de la clase Comunicador y sus métodos estáticos. Queda almacenada en la variable la_esión

        la_sesion = (Sesion) Comunicador.getObjeto();
// Recibimos el número de la serie e ejecutar:

       numero_serie= getIntent().getIntExtra(CLAVE_INDICE_SERIE, 0);

//Definimos escuchadores en botones

        btnProgress.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                new AsyncTask_load().execute();
                btnProgress.setClickable(false);
            }
        });

        btnsalir.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


    private void añadirVistas() {

        btnProgress = (Button)findViewById(R.id.btn1);
        btnsalir = (ImageButton)findViewById(R.id.salir);
        texto_imagen = (ImageView) findViewById(R.id.mensaje);
        texto_imagen.setBackground(null);

        progressBarHorizontal = (ProgressBar)findViewById(R.id.progressbar_Horizontal);
        progressBarHorizontal.setProgress(0);



    }


    public class AsyncTask_load extends AsyncTask<Void, Integer, Void> {

        int progreso;


        @Override
        protected void onPreExecute() {
            Toast.makeText(Entorno_Juego.this, "onPreExecute", Toast.LENGTH_LONG).show();
            progreso = 0;
        }

        @Override
        protected Void doInBackground(Void... params) {
        Serie mi_serie=la_sesion.coje_serie(numero_serie);


            int n_repeticiones=mi_serie.getRepeticiones();

            long tiempo_Relajacion=1000*mi_serie.getTiempo_relajacion();
            long tiempo_Contraccion=1000*mi_serie.getTiempo_contraccion(), tiempo_cero;

            while (n_repeticiones>0){

                tiempo_cero=System.currentTimeMillis();
                SystemClock.sleep(2);
                progreso=0;
                while ((System.currentTimeMillis()-tiempo_cero)<tiempo_Relajacion){

                    // Ejecuta relaja: Indica Relaja
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                        texto_imagen.setImageResource(R.drawable.relaja_relax_reducido);
                        }
                    });

//                  Código actuando sobre botón
 /*                   texto_imagen.post(new Runnable() {
                        public void run() {
                        texto_imagen.setImageResource(R.drawable.relaja_relax_reducido);
                        }
                    });
*/
                    SystemClock.sleep(20);
                    progreso= (int) (100.*(System.currentTimeMillis()-tiempo_cero)/tiempo_Relajacion);
                    publishProgress(progreso);


                }
                tiempo_cero=System.currentTimeMillis();
                SystemClock.sleep(20);
                progreso=0;
                while ((System.currentTimeMillis()-tiempo_cero)<tiempo_Contraccion){

                //Ejecuta Contrae: Indica Contrae
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                        texto_imagen.setImageResource(R.drawable.contrae_squeeze_reducido);
                    }
                 });

//                  Código actuando sobre botón
/*                   texto_imagen.post(new Runnable() {
                        public void run() {
                        texto_imagen.setImageResource(R.drawable.contrae_squeeze_reducido);
                        }
                    });
*/
                    SystemClock.sleep(20);
                    progreso= (int) (100.*(System.currentTimeMillis()-tiempo_cero)/tiempo_Contraccion);
                    publishProgress(progreso);

                }
                n_repeticiones--;
            }
            return null;
        }


        @Override
        protected void onProgressUpdate(Integer... values) {

            progressBarHorizontal.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Void result) {
            Toast.makeText(Entorno_Juego.this, "onPostExecute", Toast.LENGTH_LONG).show();
            btnProgress.setClickable(true);
        }


    }




}
