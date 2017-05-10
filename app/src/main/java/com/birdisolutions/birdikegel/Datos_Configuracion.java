package com.birdisolutions.birdikegel;

import java.io.Serializable;

/**
 * Created by luiscarlosfernandez on 10/05/17.
 */


public class Datos_Configuracion implements Serializable {

        private String nombre;
        private int pin;
        private int agno;
        private int mes;
        private int dia;
        private boolean sonido_texto,sonido_en_menus,presion_en_mercurio;
        public Datos_Configuracion(String nombre, int pin,int agno,int mes, int dia){
            this.sonido_en_menus=true;
            this.sonido_texto=true;
            this.presion_en_mercurio=true;
        }
        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getPin() {
            return pin;
        }

        public void setPin(int pin) {
            this.pin = pin;
        }

        public int getAgno() {
            return agno;
        }

        public void setAgno(int agno) {
            this.agno = agno;
        }

        public int getMes() {
            return mes;
        }

        public void setMes(int mes) {
            this.mes = mes;
        }

        public int getDia() {
            return dia;
        }

        public void setDia(int dia) {
            this.dia = dia;
        }

        public boolean isSonido_texto() {
            return sonido_texto;
        }

        public void setSonido_texto(boolean sonido_texto) {
            this.sonido_texto = sonido_texto;
        }

        public boolean isSonido_en_menus() {
            return sonido_en_menus;
        }
        public void setSonido_en_menus(boolean sonido_en_menus) {
        this.sonido_en_menus = sonido_en_menus;
        }
        public void setPresion_en_mercurio(boolean presion_en_mercurio) {
            this.presion_en_mercurio = presion_en_mercurio;
        }
        public boolean isPresion_en_mercurio() {
            return presion_en_mercurio;
        }


    }

