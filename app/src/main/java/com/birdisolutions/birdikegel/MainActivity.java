package com.birdisolutions.birdikegel;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {
    Button sesion_suave,sesion_media,sesion_rapida,sesion_resistencia,sesion_intensa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

 //Botones Ejercicios Libres

        sesion_suave=(Button)findViewById(R.id.boton_suave);
        sesion_media=(Button)findViewById(R.id.boton_medio);
        sesion_intensa=(Button)findViewById(R.id.boton_intenso);
        sesion_rapida=(Button)findViewById(R.id.boton_rapido);
        sesion_resistencia=(Button)findViewById(R.id.boton_resistencia);

 /*       sesion_suave.setOnClickListener((View.OnClickListener) this);
        sesion_media.setOnClickListener((View.OnClickListener) this);
        sesion_intensa.setOnClickListener((View.OnClickListener) this);
        sesion_rapida.setOnClickListener((View.OnClickListener) this);
        sesion_resistencia.setOnClickListener((View.OnClickListener) this);

*/
        final ImageButton mconfiguracion;

// Scroll Inferior: creación de listener y botones
/*
        LinearLayout m_ejercicios_libres=(LinearLayout)findViewById(R.id.ejercicios_libres);
        m_ejercicios_libres.setClickable(true);
       m_ejercicios_libres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case(R.id.boton_suave):
                        break;

                    case (R.id.boton_medio):

                        break;

                    case(R.id.boton_rapido):

                        break;

                    case(R.id.boton_resistencia):
                        break;

                    case(R.id.boton_intenso):
                        break;
                }
            }
        });
*/
 // Boton Configuración

        mconfiguracion= (ImageButton)findViewById(R.id.boton_config);
        mconfiguracion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Iniciar Configuración de la aplicación
                Intent i =new Intent(MainActivity.this, Configuracion.class);
                startActivity(i);
            }
        });



    }


}
