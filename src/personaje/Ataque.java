package personaje;

public class Ataque {

    private int golpe, usos, probabilidadFallo, usosMax;
    private String nombreGolpe, descripcionGolpe;

    public Ataque(int golpe, int usos, String nombreGolpe, String descripcionGolpe, int probabilidadFallo) {
        this.usosMax = usos;
        this.golpe = golpe;
        this.usos = usos;
        this.nombreGolpe = nombreGolpe;
        this.descripcionGolpe = descripcionGolpe;
        this.probabilidadFallo = probabilidadFallo;
    }

    public String getNombreGolpe() {
        return nombreGolpe;
    }

    public void setNombreGolpe(String nombreGolpe) {
        this.nombreGolpe = nombreGolpe;
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

    public String getDescripcionGolpe() {
        return descripcionGolpe;
    }

    public void setDescripcionGolpe(String descripcionGolpe) {
        this.descripcionGolpe = descripcionGolpe;
    }

    public boolean isAcertado() {  //devuelve si acierta el ataque o no
        boolean acertado;
        int contador = 0;
        for (int i = 0; i < 10; i++) {
            int valor = (int) (Math.floor(Math.random() * 2)); //suma 0 o 1
            contador += valor;
        }
        contador = contador * 10;
        acertado = contador >= probabilidadFallo;
        return acertado;
    }
}
