package com.birdisolutions.birdikegel;

import java.util.Vector;

/**
 * Created by luiscarlosfernandez on 10/05/17.
 */

//El comunicador nos sirve como recurso para pasar la sesión entre activities. Hay una clase estática Comunicador, donde se almacena y se recoge la sesión a realizar.

class Comunicador {
    private static Object objeto = null;

    public static void setObjeto(Object newObjeto) {
        objeto = newObjeto;
    }

    public static Object getObjeto() {
        return objeto;
    }
}
public class Sesion {

    Vector m_vector=new Vector();
    int n_elementos=m_vector.size();

    public void add_serie(Serie m_serie){
      m_vector.addElement(m_serie);
    }
    public Serie coje_serie(int indice){

        return (Serie) m_vector.get(indice);
    }

    public int dime_tamano(){
        return n_elementos;
    }


}
