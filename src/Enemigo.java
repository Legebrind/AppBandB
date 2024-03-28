import java.util.ArrayList;

public class Enemigo {

    private String Nombre;
    private String[] AreaPutada;
    public String getAreaPutada() {
        return AreaPutada;
    }
    public void setAreaPutada(String areaPutada) {
        AreaPutada = areaPutada;
    }
    private String[] Putada;
    private ArrayList<String> Caracteristicas;
    private int Ataque;
    private int PG, nivel;
    private boolean Boss;
    private ArrayList<Objeto> Equipo;
    public ArrayList<Objeto> getEquipo() {
        return Equipo;
    }
    public void setEquipo(ArrayList<Objeto> equipo) {
        Equipo = equipo;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String[] getPutada() {
        return Putada;
    }
    public void setPutada(String[] putada) {
        Putada = putada;
    }
    public ArrayList<String> getCaracteristicas() {
        return Caracteristicas;
    }
    public void setCaracteristicas(ArrayList<String> caracteristicas) {
        Caracteristicas = caracteristicas;
    }
    public int getAtaque() {
        return Ataque;
    }
    public void setAtaque(int ataque) {
        Ataque = ataque;
    }
    public int getPG() {
        return PG;
    }
    public void setPG(int pG) {
        PG = pG;
    }
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public boolean isBoss() {
        return Boss;
    }
    public void setBoss(boolean boss) {
        Boss = boss;
    }



}