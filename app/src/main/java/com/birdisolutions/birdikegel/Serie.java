package com.birdisolutions.birdikegel;

import java.util.Vector;

/**
 * Created by luiscarlosfernandez on 10/05/17.
 * Se encarga de mantener los dartos y operaciones sobre los ejercicios
 */
public class Serie {
    int repeticiones,tiempo_relajacion,tiempo_contraccion, n_Muestras;
    public final int  V_MUESTREO = 10;

    int numero_muestras;
    Serie(int repeticiones, int tiempo_relajacion, int tiempo_contraccion) {
        this.repeticiones=repeticiones;
        this.tiempo_relajacion=tiempo_relajacion;
        this.tiempo_contraccion=tiempo_contraccion;
        n_Muestras= V_MUESTREO*repeticiones*(tiempo_relajacion+tiempo_contraccion);
//        int[] array_muestras= new int[n_Muestras];
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    public int getTiempo_relajacion() {
        return tiempo_relajacion;
    }

    public void setTiempo_relajacion(int tiempo_relajacion) {
        this.tiempo_relajacion = tiempo_relajacion;
    }

    public int getTiempo_contraccion() {
        return tiempo_contraccion;
    }

    public void setTiempo_contraccion(int tiempo_contraccion) {
        this.tiempo_contraccion = tiempo_contraccion;
    }


}


