/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 * @author Techno team
 */

/** 
 * Constructor de las frases de los NPC
 *
 */
public class Frase {
    private int idPersonaje;
    private String personaje;
    private String frase;
    
    public Frase(int idPersonaje, String personaje, String frase){
        this.idPersonaje = idPersonaje;
        this.personaje = personaje;
        this.frase = frase;
    }

    public int getIdPersonaje() {
        return idPersonaje;
    }

    public String getFrase() {
        return frase;
    }

    public String getPersonaje() {
        return personaje;
    }
    
}
