package com.birdisolutions.birdikegel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import static android.R.attr.drawable;
import static android.R.attr.id;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button mconfiguracion;

 // Boton Configuración

        mconfiguracion= (Button)findViewById(R.id.boton_config);
        mconfiguracion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mconfiguracion.setBackgroundResource(R.drawable.ajustes_pulsado); ;
                //Iniciar Configuración de la aplicación
                Intent i =new Intent(MainActivity.this, Configuracion.class);
                startActivity(i);
            }
        });



    }
}
