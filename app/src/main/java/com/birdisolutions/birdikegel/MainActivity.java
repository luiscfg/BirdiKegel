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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button sesion_suave,sesion_media,sesion_rapida,sesion_resistencia,sesion_intensa;
    ImageButton m_configuracion,m_mail,m_salir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    }

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

            case(R.id.boton_config):
                Intent i =new Intent(MainActivity.this, Configuracion.class);
                startActivity(i);
                break;

            case(R.id.salir):
                finish();
                break;

            case(R.id.boton_mensajes):
                break;

        }
    }
}

