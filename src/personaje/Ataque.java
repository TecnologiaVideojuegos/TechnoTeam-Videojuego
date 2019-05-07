/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personaje;

import org.newdawn.slick.Sound;

/**
 *
 * @author jgomezsu
 */
public class Ataque {

    private int golpe, usos, probabilidadFallo, usosMax;
    private String nombre, descripcion;
    private Sound efecto;

    public Ataque(int golpe, int usos, String nombreAtaque, String descripcionAtaque, int probabilidadFallo, Sound efecto) {
        this.usosMax = usos;
        this.golpe = golpe;
        this.usos = usos;
        this.nombre = nombreAtaque;
        this.descripcion = descripcionAtaque;
        this.probabilidadFallo = probabilidadFallo;
        this.efecto = efecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getUsosMax() {
        return usosMax;
    }

    public void setUsosMax(int usosMax) {
        this.usosMax = usosMax;
    }

    public int getProbabilidadFallo() {
        return probabilidadFallo;
    }

    public void setProbabilidadFallo(int probabilidadFallo) {
        this.probabilidadFallo = probabilidadFallo;
    }

    public int getGolpe() {
        return golpe;
    }

    public void setGolpe(int golpe) {
        this.golpe = golpe;
    }

    public int getUsos() {
        return usos;
    }

    public void setUsos(int usos) {
        this.usos = usos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Sound getEfecto() {
        return efecto;
    }

    public void setEfecto(Sound efecto) {
        this.efecto = efecto;
    }

    public boolean isAcertado() {
        boolean acertado;
        int prob = 0;
        for (int i = 0; i < 10; i++) {
            int valor = (int) (Math.floor(Math.random() * 2));
            prob += valor;
        }
        prob = prob * 10;
        acertado = prob >= probabilidadFallo; 
        return acertado;
    }
}

