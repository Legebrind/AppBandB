/*Clase Jugador, es abstracta quedando definida a través del tipo de clase que escoja ser
//quedando definidos todos los campos y métodos para acceder a ellos.
Se utiliza la clase Enums para establecer el tipo de clase y raza.
*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public abstract class Jugador {
    protected String Nombre;//Nombre del jugador
    protected boolean Is_Jefe,Debilitado,Envenenado,Perdida_de_Nivel;
    protected boolean HaJugado;
    protected int Fichas_Dano,Puntos_Golpe;
    protected Enums.Tipo_Clase Clase;
    protected Enums.Tipo_Raza Raza;    
    protected ArrayList<Objeto> Equipo;
    private final int EquipoMax=4;
    protected int NR;
    protected HashMap <Integer, Integer> TablaAtaque;
    protected ArrayList<Salvacion> Salvaciones;
    protected ArrayList<TipoDano> TipoAtaque;
    protected boolean IsAtaqueMagico;
    


    
    
    protected void iniciarNombre(Scanner input){
        System.out.println("Introduce tu nombre");
        String Nom;
        Nom= input.nextLine();
        this.Nombre=Nom;
    }
    protected void setJefe(boolean a){
        this.Is_Jefe=a;
    }
    protected void setDebilitado(Boolean b){
        this.Debilitado=b;
    };
    protected void setEnvenedado(Boolean b){
        this.Envenenado=b;
    };
    protected void setPerdida_de_Nivel(Boolean b){
        this.Perdida_de_Nivel=b;
    };
    protected void setFichas_Dano(int a){
        this.Fichas_Dano=a;
    }
    public String getNombre(){
        return this.Nombre;
    }
    public boolean getJefe(){
        return this.Is_Jefe;
    }
    
    public int getFichas_Dano(int a){
        return this.Fichas_Dano=a;
    }
    public abstract int atacar(Scanner input, int nivelMundo);

    public Enums.Tipo_Raza getRaza(){
        return this.Raza;
    }
    public Enums.Tipo_Clase getClase(){
        return this.Clase;
    }
    public void setRaza(Scanner input){
        System.out.println("Escoge raza, y con cuidado, nadie quiere ser un apestoso Gnomo y mucho menos de género fluido");
        int aux=1;
        for (Enums.Tipo_Raza x: Enums.Tipo_Raza.values()) {
            
            System.out.println(aux+") "+x);
            aux++;
        }
        int i=input.nextInt();
        while(i<=0 || i>aux){
            System.out.println("No me toques los cojones escoge un número de la raza que quieras ser, no me hagas elegir a mi\n Puto Gnomo de los cojones");
            i=input.nextInt();
            input.nextLine();
        }
        input.nextLine();
        this.Raza=Enums.Tipo_Raza.values()[i-1];

    }
    protected void setHajugado(boolean Hajugado){
        this.HaJugado=Hajugado;

    }
    protected boolean getHajugado(){
       return this.HaJugado;

    }
    protected abstract int ataqueMagico(int nivelMundo);



}