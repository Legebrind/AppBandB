//Clase abstracta que contiene todos los parámetros comunes a las clases
import java.util.ArrayList;
import  java.util.HashMap;
public abstract class Clases extends Jugador{

    private int Ataque, NR, PG;
    private ArrayList<String> TipoDano,Salvaciones;
    private ArrayList<Objeto> Equipo;
    protected HashMap <Integer, Integer> TablaAtaque;
    protected void setAtaque(int a){
        this.Ataque=a;

    }
    protected void setNR(int a){
        this.NR=a;
    }
    protected void setSalvacion(String b){
        this.Salvaciones.add(b);
    }
    protected void setTipoDano(String b){
        this.TipoDano.add(b);
    }
    protected int getAtaque(){
        return this.Ataque;

    }
    protected int getNR(){
        return this.NR;
    }
    protected String getSalvacion(int a){
        return this.Salvaciones.get(a);
    }
    protected String getTipoDano(int a){
        return this.TipoDano.get(a);
    }

    protected void setPG(int a){
        this.PG=a;
    }

    protected int getPG(){
        return this.PG;
    }

    public abstract int getAtaqueBase();
    public void EquipoInicial(){
        this.Equipo= new ArrayList (4);
    }

}