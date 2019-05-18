package modelos;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class sprite extends Image {

    protected Punto posicion;

    public sprite(String ruta) throws SlickException {
        this(ruta, new Punto(0.0f, 0.0f));
    }

    public sprite(String ruta, float x, float y) throws SlickException {
        this(ruta, new Punto(x, y));
    }

    public sprite(String ruta, Punto posicion) throws SlickException {
        super(ruta);
        this.posicion = posicion;
    }

    public void draw() {
        super.draw(this.posicion.getX(), this.posicion.getY());
    }

    public Punto getPosicion() {
        return this.posicion;
    }

    public void setPosicion(float x, float y) {
        this.posicion = new Punto(x, y);
    }

    public void setPosicion(Punto posicion) {
        this.posicion = posicion;
    }
}