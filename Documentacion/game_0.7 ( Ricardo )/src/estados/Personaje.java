package estados;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.SpriteSheet;
import modelos.Ataque;


public class Personaje {
	private int vida, vidaMax;
    private String nombre;
    private ArrayList<Ataque> ataques;
    private SpriteSheet spritePJ;
    private Animation animD, animI, animC,baile; //animD y animI --> movimineto derecha e izquierda, animC -->combate
    private Music musicB8, musicH8,musicBnormal,musicHnormal; //la b se refiere a batalla y la h al pasillo
    private Image HUD;

    public Personaje(int vida, String nombre, SpriteSheet sprite, Animation animD, Animation animI, Music musicB8, Music musicH8,Music musicBnormal,Music musicHnormal ,Image HUD, Animation animC,Animation baile) {
        this.vidaMax = vida;
        this.vida = vida;
        this.nombre = nombre;
        ataques = new ArrayList<>();
        spritePJ = sprite;
        this.animD = animD;
        this.animI = animI;
        this.musicB8 = musicB8;
        this.musicH8 = musicH8;
        this.musicBnormal = musicBnormal;
        this.musicHnormal = musicHnormal;
        this.HUD = HUD;
        this.animC=animC;
        this.baile=baile;
    }

    public Animation getAnimC() {
        return animC;
    }

    public void setAnimC(Animation animC) {
        this.animC = animC;
    }

    public Music getMusicBnormal() {
        return musicBnormal;
    }

    public void setMusicBnormal(Music musicBnormal) {
        this.musicBnormal = musicBnormal;
    }

    public Music getMusicHnormal() {
        return musicHnormal;
    }

    public void setMusicHnormal(Music musicHnormal) {
        this.musicHnormal = musicHnormal;
    }

    public Image getHUD() {
        return HUD;
    }

    public void setHUD(Image HUD) {
        this.HUD = HUD;
    }

    public Music getMusicB8() {
        return musicB8;
    }

    public void setMusicB8(Music musicB) {
        this.musicB8 = musicB;
    }

    public Music getMusicH8() {
        return musicH8;
    }

    public void setMusicH8(Music musicH) {
        this.musicH8 = musicH;
    }

    public Animation getAnimD() {
        return animD;
    }

    public void setAnimD(Animation animD) {
        this.animD = animD;
    }

    public Animation getAnimI() {
        return animI;
    }

    public void setAnimI(Animation animI) {
        this.animI = animI;
    }

    public Personaje() {

    }

    public int getVidaMax() {
        return vidaMax;
    }

    public void setVidaMax(int vidaMax) {
        this.vidaMax = vidaMax;
    }

    public SpriteSheet getSpritePJ() {
        return spritePJ;
    }

    public void setSpritePJ(SpriteSheet spritePJ) {
        this.spritePJ = spritePJ;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Animation getBaile() {
        return baile;
    }

    public void setBaile(Animation baile) {
        this.baile = baile;
    }

    public ArrayList<Ataque> getAtaques() {
        return ataques;
    }

    public void setAtaques(ArrayList<Ataque> ataques) {
        this.ataques = ataques;
    }

    @Override
    public String toString() {
        return "Personaje{" + "vida=" + vida + ", nombre=" + nombre + ", ataques=" + ataques + '}';
    }

    public String atacar(Personaje penemigo, int seleccion) {
        String texto = "";

        if (this.getVida() > 0) {
            if (this.getAtaques().get(seleccion).getUsos() != 0) { //si a�n tiene usos disponibles del ataque elegido
                this.getAtaques().get(seleccion).setUsos(this.getAtaques().get(seleccion).getUsos() - 1); //le restamos un uso a ese ataque
                if (this.getAtaques().get(seleccion).isAcertado()) {
                    //if (!this.getAtaques().get(seleccion).getEfecto().playing()) {
                        this.getAtaques().get(seleccion).getEfecto().play();
                    //}
                    ClaseEstatica.setUltimoAtaque(this.getAtaques().get(seleccion).getNombre());
                    ClaseEstatica.setAtaqueAcertado(true);
                    //System.out.println("Clase estatica ataque --> "+ClaseEstatica.getUltimoAtaque());
                    penemigo.setVida(penemigo.getVida() - this.getAtaques().get(seleccion).getDmg());
                    System.out.println("Ahora " + penemigo.getNombre() + " tiene: " + penemigo.getVida() + " vida");
                    texto = this.getNombre() + " us�: " + this.getAtaques().get(seleccion).getNombre() + " y caus�: " + this.getAtaques().get(seleccion).getDmg() + " de da�o";
                    //texto += "\n"+"Ahora "+penemigo.getNombre()+" tiene: "+penemigo.getVida()+" vida";
                } else {
                    //if(!ClaseEstatica.getFail().playing())
                    ClaseEstatica.setAtaqueAcertado(false);
                    ClaseEstatica.getFail().play();
                    System.out.println("OHHH que pena!!! " + this.getNombre() + " ha FALLADO EL ATAQUE!!!");
                    ClaseEstatica.setUltimoAtaque("fallado");
                    texto = "OHHH que pena!!!  " + this.getNombre() + " ha FALLADO EL ATAQUE!!!";
                }
            } else {
                System.out.println("NO TE QUEDAN USOS");
                texto = "NO TE QUEDAN USOS. PIERDES TU TURNO";
            }
        } else {
            System.out.println("�HAS MUERTO!");
            texto = "�HAS MUERTO!";
        }
        return texto;
    }

    public String ataqueEnemigo(Personaje personajeBueno) {
        String texto = "";
        /*try{
            sleep(4000);
        }catch(InterruptedException ie){}*/
        int ataqueEnemigo = 0;
        boolean usosSufiecientes = false;
        if (this.getVida() > 0) {
            while (!usosSufiecientes) {
                ataqueEnemigo = (int) Math.floor(Math.random() * 3);
                if (this.getAtaques().get(ataqueEnemigo).getUsos() > 0) {
                    usosSufiecientes = true;
                }
            }
            if (this.getAtaques().get(ataqueEnemigo).isAcertado()) { //si acierta el ataque
                personajeBueno.setVida(personajeBueno.getVida() - this.getAtaques().get(ataqueEnemigo).getDmg());
                ClaseEstatica.setAtaqueAcertado(true);
                ClaseEstatica.getEnemigo().getAtaques().get(ataqueEnemigo).getEfecto().play(); //efecto ataque
                System.out.println(this.getNombre() + " us�: " + this.getAtaques().get(ataqueEnemigo).getNombre());
                ClaseEstatica.setUltimoAtaque(this.getAtaques().get(ataqueEnemigo).getNombre());    //<--clase est�tica
                System.out.println("Ahora " + personajeBueno.getNombre() + " tiene: " + personajeBueno.getVida() + " vida");
                texto = this.getNombre() + " us�: " + this.getAtaques().get(ataqueEnemigo).getNombre() + " y caus�: " + this.getAtaques().get(ataqueEnemigo).getDmg() + " de da�o";;
                //texto += "\n"+"Ahora "+personajeBueno.getNombre()+" tiene: "+personajeBueno.getVida()+ " vida";
            } else {
                //if(!ClaseEstatica.getFail().playing())
                ClaseEstatica.getFail().play();
                ClaseEstatica.setAtaqueAcertado(false);
                System.out.println("OHHH que pena!!!  " + this.getNombre() + " ha FALLADO EL ATAQUE!!!");
                ClaseEstatica.setUltimoAtaque("fallado");
                texto = "OHHH que pena!!! " + this.getNombre() + " ha FALLADO EL ATAQUE!!!";
            }
        }
        //System.out.println("Clase estatica ataque --> "+ClaseEstatica.getUltimoAtaque());
        return texto;
    }

    public void restaurarTodo() { //restaurar� todos los stats del personaje
        vida = vidaMax;
        for (int i = 0; i < ataques.size(); i++) {
            ataques.get(i).setUsos(ataques.get(i).getUsosMax());
        }
    }

    Object getPersonaje() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

