/*Clase Jugador, es abstracta quedando definida a través del tipo de clase que escoja ser
//quedando definidos todos los campos y métodos para acceder a ellos.
Se utiliza la clase Enums para establecer el tipo de clase y raza.
*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public abstract class Jugador {
    private String Nombre;//Nombre del jugador
    private boolean Is_Jefe,Debilitado,Envenenado,Perdida_de_Nivel;
    private boolean HaJugado;
    private int Fichas_Dano,Puntos_Golpe;
    private Enums.Tipo_Clase Clase;
    private Enums.Tipo_Raza Raza;    
    private ArrayList<Objeto> Equipo;
    private final int EquipoMax=4;
    private int NR;
    private HashMap <Integer, Integer> TablaAtaque;
    private ArrayList<Enums.Tipo_Salvacion> Salvaciones;
    private ArrayList<Enums.Tipo_Ataque> TipoAtaque;
    private boolean IsAtaqueMagico;
    

    public int getNR() {
        return NR;
    }
    public void setNR(int nR) {
        NR = nR;
    }
    public void setRaza(Enums.Tipo_Raza raza) {
        Raza = raza;
    }

    public void setClase(Enums.Tipo_Clase clase) {
        Clase = clase;
    }
    
    public boolean isIsAtaqueMagico() {
        return IsAtaqueMagico;
    }
    public void setIsAtaqueMagico(boolean isAtaqueMagico) {
        IsAtaqueMagico = isAtaqueMagico;
    }
    public void iniciarNombre(Scanner input){
        System.out.println("Introduce tu nombre");
        String Nom;
        Nom= input.nextLine();
        this.Nombre=Nom;
    }
    public void setJefe(boolean a){
        this.Is_Jefe=a;
    }
    public void setDebilitado(Boolean b){
        this.Debilitado=b;
    };
    public void setEnvenedado(Boolean b){
        this.Envenenado=b;
    };
    public void setPerdida_de_Nivel(Boolean b){
        this.Perdida_de_Nivel=b;
    };
    public void setFichas_Dano(int a){
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
    public void setHajugado(boolean Hajugado){
        this.HaJugado=Hajugado;

    }
    public boolean isHajugado(){
       return this.HaJugado;

    }

    public int getPuntos_Golpe() {
        return Puntos_Golpe;
    }
    public void setPuntos_Golpe(int puntos_Golpe) {
        Puntos_Golpe = puntos_Golpe;
    }
    public int getFichas_Dano() {
        return Fichas_Dano;
    }
    public boolean isPerdida_de_Nivel() {
        return Perdida_de_Nivel;
    }
    public void setPerdida_de_Nivel(boolean perdida_de_Nivel) {
        Perdida_de_Nivel = perdida_de_Nivel;
    }
    public boolean isEnvenenado() {
        return Envenenado;
    }
    public void setEnvenenado(boolean envenenado) {
        Envenenado = envenenado;
    }
    public boolean isDebilitado() {
        return Debilitado;
    }
    public void setDebilitado(boolean debilitado) {
        Debilitado = debilitado;
    }

    public HashMap<Integer, Integer> getTablaAtaque() {
        return TablaAtaque;
    }
    public void setTablaAtaque(HashMap<Integer, Integer> tablaAtaque) {
        TablaAtaque = tablaAtaque;
    }

    public ArrayList<Enums.Tipo_Salvacion> getSalvaciones() {
        return Salvaciones;
    }
    public void setSalvaciones(ArrayList<Enums.Tipo_Salvacion> salvaciones) {
        Salvaciones = salvaciones;
    }
    public void addSalvaciones(Enums.Tipo_Salvacion salvacion){
        this.Salvaciones.add(salvacion);
    }

    public ArrayList<Enums.Tipo_Ataque> getTipoAtaque() {
        return TipoAtaque;
    }
    public void setTipoAtaque(ArrayList<Enums.Tipo_Ataque> tipoAtaque) {
        TipoAtaque = tipoAtaque;
    }
    public void addTipoAtaque(Enums.Tipo_Ataque tipoAtaque){
        this.TipoAtaque.add(tipoAtaque);

    }
    public ArrayList<Objeto> getEquipo() {
        return Equipo;
    }
    public void setEquipo(ArrayList<Objeto> equipo) {
        Equipo = equipo;
    }

    public int getEquipoMax() {
        return EquipoMax;
    }
    public abstract int ataqueMagico(int nivelMundo);



}