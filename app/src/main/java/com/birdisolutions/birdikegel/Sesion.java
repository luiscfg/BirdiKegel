package com.birdisolutions.birdikegel;

import java.util.Vector;

/**
 * Created by luiscarlosfernandez on 10/05/17.
 */

public class Sesion {

    Vector m_vector=new Vector();
    public void add_serie(Serie m_serie){
      m_vector.addElement(m_serie);
    }
    public Serie coje_serie(int indice){
        return (Serie) m_vector.get(indice);
    }
    public int n_elementos(){
        return m_vector.size();
    }
}
