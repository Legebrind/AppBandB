/*Clase Jugador, es abstracta quedando definida a través del tipo de clase que escoja ser
//quedando definidos todos los campos y métodos para acceder a ellos.
Se utiliza la clase Enums para establecer el tipo de clase y raza.
*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public abstract class Jugador {
    private String Nombre;//Nombre del jugador
    //Estados del jugador
    private boolean Is_Jefe,Debilitado,Envenenado,Perdida_de_Nivel,jugador_inicial;

    private boolean HaJugado,BuscaTrampas;
    private ArrayList<Enums.Tipo_Salvacion> Salvaciones;
    //Control de daños, vida y modificadores temporales
    private int Fichas_Dano,Puntos_Golpe, Modificador,Modificador_toda_la_sala;
    //Listado de clases y razas
    private Enums.Tipo_Clase Clase;
    private Enums.Tipo_Raza Raza; //to do: por implementar
    //Bolsa de equipo    
    private ArrayList<Objeto> Equipo; // to do: por implementar
    private final int EquipoMax=4;
    //Parámetro que indica la resistencia del heróe y afecta directamente al PG a través de la TablaPg.java
    private int NR;
    //Tabla donde se indica el daño base, depende de cada clase.
    private HashMap <Integer, Integer> TablaAtaque;
    
   //Diferentes tipos de daño que puede realizar el jugador dependiendo de su clase.
    private ArrayList<Enums.Tipo_Ataque> TipoAtaque_Fisico;
    private ArrayList<Enums.Tipo_Ataque> TipoAtaque_Magico;
    // Para indicar si el ataque es mágico ya que el turno distingue entre ataques mágicos(van primero)
    //y ataques físicos para después
    private boolean IsAtaqueMagico;
    private boolean Ha_bebido;
    

    public boolean isHa_bebido() {
        return Ha_bebido;
    }
    public void setHa_bebido(boolean ha_bebido) {
        Ha_bebido = ha_bebido;
    }
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
        System.out.println("\nIntroduce tu nombre");
        var Nom= input.nextLine();
        this.Nombre=Nom;
    }
    public void setJefe(boolean a){
        this.Is_Jefe=a;
    }
    
    public String getNombre(){
        return this.Nombre;
    }
    public boolean getJefe(){
        return this.Is_Jefe;
    }
    
    //Metodos no implementados para la versión 1.0
    public void setFichas_Dano(int a){
        this.Fichas_Dano=a;
    }
    public int getFichas_Dano(int a){
        return this.Fichas_Dano=a;
    }
    
    public abstract int atacar(Scanner input, int nivelMundo,ArrayList<Enemigo>horda);//he tenido que añadir horda para que el paladin pueda castigar el mal
    //cada clase implementa el modo atar con sus particulares para obtener la cantidad de daño.
    //Este método se llama dentro del metod ataque_fisico.

    public abstract void ataque_magico(Scanner input, int nivelMundo,ArrayList<Enemigo> horda, ArrayList<Modificador> modificadores,Grupo aventureros);
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
            System.out.println("No me toques los cojones escoge un número de la raza que quieras ser, no me hagas elegir a mi\nPuto Gnomo de los cojones");
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

    public ArrayList<Enums.Tipo_Ataque> getTipoAtaques() {
        return TipoAtaque_Fisico;
    }
   
    public void addTipoAtaque_fisico(Enums.Tipo_Ataque tipoAtaque){
        this.TipoAtaque_Fisico.add(tipoAtaque);
    }
    public void addTipoAtaque_magico(Enums.Tipo_Ataque tipoAtaque){
        this.TipoAtaque_Magico.add(tipoAtaque);
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
    

    public boolean isBuscaTrampas() {
        return BuscaTrampas;
    }
    public void setBuscaTrampas(boolean buscaTrampas) {
        BuscaTrampas = buscaTrampas;
    }
    public ArrayList<Enums.Tipo_Ataque> getTipoAtaque_Fisico() {
        return TipoAtaque_Fisico;
    }
    public void setTipoAtaque_Fisico(ArrayList<Enums.Tipo_Ataque> tipoAtaque_Fisico) {
        TipoAtaque_Fisico = tipoAtaque_Fisico;
    }
    public ArrayList<Enums.Tipo_Ataque> getTipoAtaque_Magico() {
        return TipoAtaque_Magico;
    }
    public void setTipoAtaque_Magico(ArrayList<Enums.Tipo_Ataque> tipoAtaque_Magico) {
        TipoAtaque_Magico = tipoAtaque_Magico;
    }
    public int getCantidadAtaques(boolean fisico){
        if(fisico){
            return TipoAtaque_Fisico.size();
        }
        return TipoAtaque_Magico.size();
    }
    public Enemigo elegirEnemigo(ArrayList<Enemigo> horda,Scanner input){
        if(horda.size()==1){
            return horda.get(0);
        }
        System.out.println("¿A quién quieres zurrale bien zurrao?:0-"+(horda.size()-1));
        int objetivo=-1;
        do{
            try{
                objetivo = input.nextInt();
            }catch(Exception e){
                System.out.println("Ya estamos tocando los cojones otra vez.\nDeja de beber coño ya y pon el número bien");
                System.out.println("¿A quién quieres zurrale bien zurrao?:0-"+(horda.size()-1));
            }
            input.nextLine();
        }while(objetivo<0 || objetivo>(horda.size()-1));
        
        return horda.get(objetivo);
    }
    public int getModificador() {
        return Modificador;
    }
    public void setModificador(int modificador) {
        Modificador = modificador;
    }
    public void aumentarModificador(int modificador){
        Modificador+=modificador;
    }
    public int getModificador_toda_la_sala() {
        return Modificador_toda_la_sala;
    }
    public void setModificador_toda_la_sala(int modificador) {
        Modificador_toda_la_sala = modificador;
    }
    public void aumentarModificador_toda_la_sala(int modificador){
        Modificador_toda_la_sala+=modificador;
    }
    public void ataque_fisico(Scanner input, int nivelMundo, ArrayList<Enemigo> horda) {
        //Este método es común a todos los personajes. Sirve para calcular el ataque físico base
        Danno danno = new Danno();
        int ataque =atacar(input, nivelMundo,horda);
        danno.setCantidad(ataque);
        if(getTipoAtaque_Fisico().size()==1){
          danno.setTipo(getTipoAtaque_Fisico().get(0));
        }
        else{
            boolean pasa=false;
            int tipo =-1;
            System.out.println("Elige el tipo de daño");
            for(int i=0;i<getTipoAtaque_Fisico().size();i++){
                System.out.println(i+") "+getTipoAtaque_Fisico().get(i));
                }
            //Revisar el bucle para evitar un error si no es un int en el System.in
            do{
                try{
                    tipo=input.nextInt();
                    pasa=true;
                }catch(Exception e){
                    System.out.println("¿Alma de Hokague, no sabes meter un puto número tal y como aparece en la lista?");
                   
                }
                input.nextLine();
            }while((tipo<0||tipo>=getTipoAtaque_Fisico().size())||!pasa);
           
            danno.setTipo(getTipoAtaque_Fisico().get(tipo));
        };
        Enemigo enemigo=elegirEnemigo(horda, input);
        enemigo.recibirDanno(danno);
    }
    public abstract void quitarbeneficios();//este método lo tiene que implementar cada clase para quitarse las aptitudes
    //activadas durante el combate y que deban quitarse al finalizar el combate como el cambiaformas del druida.
    public boolean isJugador_inicial() {
        return jugador_inicial;
    }
    public void setJugador_inicial(boolean jugador_inicial) {
        this.jugador_inicial = jugador_inicial;
    }
    public abstract void fase_limpieza(int nivelMundo);
    protected abstract void Ritual_Brujo(int nivelMundo, Grupo aventureros, Scanner input);
    
}
