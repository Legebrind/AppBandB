//Clase abstracta que contiene todos los parámetros comunes a las clases
import java.util.ArrayList;
import  java.util.HashMap;
public abstract class Clases extends Jugador{

    private int Ataque, NR, PG;
    private ArrayList<Objeto> Equipo;
    private int EquipoMax=4;
    private int EquipoActual=0;
    protected HashMap <Integer, Integer> TablaAtaque;
    protected void setAtaque(int a){
        this.Ataque=a;

    }
    protected void setNR(int a){
        this.NR=a;
    }
   
 
    protected int getAtaque(){
        return this.Ataque;

    }
    protected int getNR(){
        return this.NR;
    }
  
    protected void setPG(int a){
        this.PG=a;
    }

    protected int getPG(){
        return this.PG;
    }

    public abstract int getAtaqueBase(int NivelMundo);
    public void EquipoInicial(){
        this.Equipo= new ArrayList<Objeto>(4); 
    }
    public void equipar(Objeto objeto){
    if (EquipoActual<3){
        this.Equipo.add(EquipoActual,objeto);
        EquipoActual++;
    }              
    else{System.out.println("Ande vas, no te caben mas equipo");}
    }

    public void eliminarEquipo(int a){
        this.Equipo.remove(a);
        EquipoActual--;
    }
        }

    

