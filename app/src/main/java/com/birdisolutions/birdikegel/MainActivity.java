package com.birdisolutions.birdikegel;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.io.ObjectInputStream;

import static android.R.attr.drawable;
import static android.R.attr.id;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

  //Constantes
    public static final String SONIDO_MENUS= "com.birdisolutions.birdikegel.sonido_menus";
    public static final String SONIDO_TEXTO= "com.birdisolutions.birdikegel.sonido_texto";
    public static final String PRESION_MERCURIO= "com.birdisolutions.birdikegel.presion_mercurio";

    public  final static String CLAVE_INDICE_SERIE= "com.birdisolutions.birdikegel.clave_indice_serie";
    public final static String CLAVE_ENTORNO= "com.birdisolutions.birdikegel.clave_entorno_juego";

    public enum TipodeEntorno {FORZUDO,BEBE,MONITOR};

    Button sesion_suave,sesion_media,sesion_rapida,sesion_resistencia,sesion_intensa;
    ImageButton m_configuracion,m_mail,m_salir;

    Sesion m_Sesion_suave,m_Sesion_media,m_Sesion_intensa,m_Sesion_rapida,m_Sesion_resistencia;
    Serie m_serie;

    public Datos_Configuracion m_Datos_Configuracion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);// Lectura configuración

        m_Datos_Configuracion= leer_configuracion();

 //Botones Ejercicios Libres:asignacion Id

        sesion_suave=(Button)findViewById(R.id.boton_suave);
        sesion_media=(Button)findViewById(R.id.boton_medio);
        sesion_intensa=(Button)findViewById(R.id.boton_intenso);
        sesion_rapida=(Button)findViewById(R.id.boton_rapido);
        sesion_resistencia=(Button)findViewById(R.id.boton_resistencia);

//asignación listeners

        sesion_suave.setOnClickListener(this);
        sesion_media.setOnClickListener(this);
        sesion_intensa.setOnClickListener(this);
        sesion_rapida.setOnClickListener(this);
        sesion_resistencia.setOnClickListener(this);

//Botones Button:asignacion Id

        m_configuracion=(ImageButton)findViewById(R.id.boton_config);
        m_mail=(ImageButton)findViewById(R.id.boton_mensajes);
        m_salir=(ImageButton)findViewById(R.id.salir);

//asignación listeners

        m_configuracion.setOnClickListener(this);
        m_mail.setOnClickListener(this);
        m_salir.setOnClickListener(this);

//Creación de Sesiones ejercicios Libre

        m_Sesion_suave=new Sesion();
        m_serie= new Serie(2,3,2,1);
        m_Sesion_suave.add_serie(m_serie);
        m_serie=new Serie (2,2,1,1);
        m_Sesion_suave.add_serie(m_serie);


        m_Sesion_media=new Sesion();
        m_Sesion_intensa=new Sesion();
        m_Sesion_rapida=new Sesion();
        m_Sesion_resistencia=new Sesion();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case(R.id.boton_suave):ejecuta_sesion(m_Sesion_suave);

                break;

            case (R.id.boton_medio):

                break;

            case(R.id.boton_rapido):

                break;

            case(R.id.boton_resistencia):
                break;

            case(R.id.boton_intenso):
                break;

            case(R.id.boton_config):
                Intent ij =new Intent(MainActivity.this, Configuracion.class);
                startActivity(ij);
                break;

            case(R.id.salir):
                finish();
                break;


            case(R.id.boton_mensajes):
                break;

        }
    }


/* Ejecución de sesiones:Presenta pantallas resumen y ejecuta cada uno de las series.
   La sesion se encuentra almacenada en el comunicador.
   Las variables de configuración se encuientran almacenadas en archivo de configuración
   1. Recibe sesión.
   2.Ejecuta cada uno de las series
            Presenta Resumen de serie
 */
    int ejecuta_sesion(Sesion mi_sesion){

        Serie mi_serie;
        TipodeEntorno entorno;
        entorno=TipodeEntorno.FORZUDO;

        Comunicador.setObjeto(mi_sesion);  //Actualiza comunicador con la sesión a ejecutar.

        //Empezamos ejeciciones de series

        int numero_series=mi_sesion.dime_tamano(); //Leemos número de series
        int numero_serie=0;
        for (numero_serie=1;numero_serie<numero_series;numero_serie++){

            //Ejecucución entorno forzudo. A modificar laq selección.
            Intent i = new Intent(MainActivity.this, Entorno_Juego.class);
            // Añade configuración
            i.putExtra(SONIDO_MENUS,m_Datos_Configuracion.isSonido_en_menus());
            i.putExtra(SONIDO_TEXTO,m_Datos_Configuracion.isSonido_texto());
            i.putExtra(PRESION_MERCURIO,m_Datos_Configuracion.isPresion_en_mercurio());

            startActivity(i);
        }

       return (0);

    }


//Lectura configuración

    public Datos_Configuracion  leer_configuracion(){
        Datos_Configuracion m_Datos_Configuracion;
        try
        {
            ObjectInputStream ois =
                    new ObjectInputStream(
                            openFileInput("configuracion.txt"));
            this.m_Datos_Configuracion= (Datos_Configuracion) ois.readObject();
            ois.close();
        }
        catch (Exception ex)
        {
            Log.e("Ficheros", "Error al leer fichero configuracion desde memoria interna");
        }

        return (this.m_Datos_Configuracion);
    }

}
