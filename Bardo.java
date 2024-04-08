import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;




public class Bardo extends Jugador{

    private HashMap<Integer,String> Musica_de_Bardo;
    private HashMap<Integer,Integer> Infundir_Valor; //tabla que controla los valores de las aptitudes especiales
    private HashMap<Integer,Integer> TablaAtaque;
    private boolean Conocimiento_de_bardo,Portento_Musical;
    private HashMap<Integer,Cantar> Cantar;
  
    
    
 
  

    public Bardo (Scanner input){
        iniciarNombre(input);
        setIsAtaqueMagico(true);
        setBuscaTrampas(false);
        setNR(2);
        setHajugado(false);
        setClase(Enums.Tipo_Clase.Bardo);

        setSalvaciones(new ArrayList<Enums.Tipo_Salvacion>());
        addSalvaciones(Enums.Tipo_Salvacion.Reflejos);
        addSalvaciones(Enums.Tipo_Salvacion.Voluntad);
        setTipoAtaque_Fisico(new ArrayList<Enums.Tipo_Ataque>());
        addTipoAtaque_fisico(Enums.Tipo_Ataque.Perforante);
        setTablaAtaque(iniciarAtaqueBase());
        iniciarInfundir_Valor();
        iniciarMusica_de_Bardo();
        iniciarCantares();
        
        Conocimiento_de_bardo=true;
        Portento_Musical=false;
        
        
        
                      
        
    }

    private HashMap<Integer,Integer> iniciarAtaqueBase(){
        TablaAtaque = new HashMap<Integer,Integer>();
        TablaAtaque.put(1,4);
        TablaAtaque.put(2,4);
        TablaAtaque.put(3,4);
        TablaAtaque.put(4,5);
        TablaAtaque.put(5,5);
        TablaAtaque.put(6,5);
        TablaAtaque.put(7,6);
        TablaAtaque.put(8,6);
        TablaAtaque.put(9,6);
        TablaAtaque.put(10,7);
        TablaAtaque.put(11,7);
        TablaAtaque.put(12,7);
        TablaAtaque.put(13,8);
        TablaAtaque.put(14,8);
        TablaAtaque.put(15,8);
        return TablaAtaque;
    } 
    
    private void iniciarInfundir_Valor(){
        Infundir_Valor = new HashMap<>();
        Infundir_Valor.put(1,1);
        Infundir_Valor.put(2,1);
        Infundir_Valor.put(3,1);
        Infundir_Valor.put(4,1);
        Infundir_Valor.put(5,2);
        Infundir_Valor.put(6,2);
        Infundir_Valor.put(7,2);
        Infundir_Valor.put(8,2);
        Infundir_Valor.put(9,3);
        Infundir_Valor.put(10,3);
        Infundir_Valor.put(11,3);
        Infundir_Valor.put(12,3);
        Infundir_Valor.put(13,4);
        Infundir_Valor.put(14,4);
        Infundir_Valor.put(15,4);
    } 
    private void iniciarMusica_de_Bardo(){
        Musica_de_Bardo=new HashMap<>();
    
        Musica_de_Bardo.put(1,"[1Chp] Todo el grupo gana Salvación elegida");
        Musica_de_Bardo.put(2,"[1Chp] Todo el grupo gana Salvación FOR");
        Musica_de_Bardo.put(3,"[1Chp] Todo el grupo gana Salvación REF / FOR");
        Musica_de_Bardo.put(4,"[1Chp] Todo el grupo gana Salvación REF / FOR");
        Musica_de_Bardo.put(5,"[1Chp] Todo el grupo gana Salvación VOL / FOR / REF");
        Musica_de_Bardo.put(6,"[1Chp] Todo el grupo gana Salvación VOL / FOR / REF");
        Musica_de_Bardo.put(7,"[1Chp] Todo el grupo gana Salvación VOL / FOR / REF");
        Musica_de_Bardo.put(8,"[1Chp] Todo el grupo gana Salvación VOL / FOR / REF");
        Musica_de_Bardo.put(9,"[1Chp] Todo el grupo gana Salvación VOL / FOR / REF");
        Musica_de_Bardo.put(10,"[1Chp] Todo el grupo gana Salvación VOL / FOR / REF");
        Musica_de_Bardo.put(11,"[1Chp] Todo el grupo gana Salvación VOL / FOR / REF");
        Musica_de_Bardo.put(12,"[1Chp] Todo el grupo gana Salvación VOL / FOR / REF");
        Musica_de_Bardo.put(13,"[1Chp] Todo el grupo gana Salvación VOL / FOR / REF");
        Musica_de_Bardo.put(14,"[1Chp] Todo el grupo gana Salvación VOL / FOR / REF");
        Musica_de_Bardo.put(15,"[1Chp] Todo el grupo gana Salvación VOL / FOR / REF");
    
    }
    public void iniciarCantares(){
        Cantar=new HashMap<>();
        
        Cantar.put(5,new Cantar("[1Chp] Da +10 de ataque a un jugador y +5 a los jugadores adyacentes",10));
        Cantar.put(10,new Cantar("[1Chp] Da +20 de ataque a un jugador y +10 a los jugadores adyacentes",20));
        Cantar.put(15,new Cantar("[1Chp] Da +30 de ataque a un jugador y +15 a los jugadores adyacentes",30));
        
    }



    public int getAtaqueBase(int NivelMundo) {
        return this.TablaAtaque.get(NivelMundo);
    }
 
    
    public void ataqueInfundirValor(int nivelMundo,  Grupo aventureros){

        for (Jugador jugador : aventureros.getJugadores()) {
            jugador.setModificador(Infundir_Valor.get(nivelMundo)+jugador.getModificador());
        }
        System.out.println("Ese bardo bueno que infunde valor a sus compañeros soplandoles en la nuca");

    } 

    public void ataqueCantar(int nivelMundo,  Grupo aventureros, Scanner input){

        System.out.println("¿Quién será el agraciado que reciba tu canción y salpique tu tonalidad a sus compañeros adyacentes?");
        aventureros.mostrarInformacionEquipo();
        int respuesta=-1;
        var cantar = Cantar.get(5);
        if(nivelMundo>9 && nivelMundo<15){cantar=Cantar.get(10); }
        if(nivelMundo>=15){cantar=Cantar.get(15);}
        do{
            try{
                respuesta =input.nextInt();
            }catch(Exception e){
            System.out.println("¿Alma de Hokague, no sabes meter un puto número tal y como aparece en la lista?");
            input.nextLine();
            }
        }while (respuesta<0||respuesta>aventureros.getJugadoresMax()-1); //Comprobar la condición
        
        if (respuesta==0){
            aventureros.getJugador(respuesta).aumentarModificador(cantar.getModificador());
            aventureros.getJugador(respuesta+1).aumentarModificador(cantar.getModificador()/2);
            aventureros.getJugador(aventureros.getJugadoresMax()-1).aumentarModificador(cantar.getModificador()/2);
            return;
        }
        if (respuesta==aventureros.getJugadoresMax()-1){
            aventureros.getJugador(respuesta-1).aumentarModificador(cantar.getModificador());
            aventureros.getJugador(0).aumentarModificador(cantar.getModificador()/2);
            aventureros.getJugador(respuesta).aumentarModificador(cantar.getModificador());
            return;
        }
            aventureros.getJugador(respuesta-1).aumentarModificador(cantar.getModificador());
            aventureros.getJugador(respuesta+1).aumentarModificador(cantar.getModificador()/2);
            aventureros.getJugador(respuesta).aumentarModificador(cantar.getModificador());

        
    }

    
    public int atacar (Scanner input, int nivelMundo,ArrayList<Enemigo>horda){
        
       return getAtaqueBase(nivelMundo)+getModificador()+getModificador_toda_la_sala();


    }
    
    public void ataque_magico(Scanner input, int nivelMundo, ArrayList<Enemigo> horda,ArrayList<Modificador> modificadores,Grupo aventureros) {
        System.out.println("¿Que ataque mágico quires hacer, pequeño jublar");
        System.out.println("0:  "+Infundir_Valor.get(nivelMundo));
        
        System.out.println("1:  [1 Chp] y toca tu música bardote machote");
        if (nivelMundo>4){
            System.out.println("2:  "+Cantar.get(nivelMundo));
        }

        int respuesta =input.nextInt();
        input.nextLine();
        while (!(respuesta == 0 || respuesta == 1) && !(nivelMundo > 4 && respuesta == 2)) {//posible error XD
            System.out.println("Joder macho no das ni una, no puedes escribir ni un puto número bien");
            System.out.println("¿Que ataque mágico quires hacer, pequeño jublar");
            System.out.println("0:  "+Infundir_Valor.get(nivelMundo));
            
            System.out.println("1:  [1 Chp] y toca tu música bardote machote");
            if (nivelMundo>4){
                System.out.println("2:  "+Cantar.get(nivelMundo));
            }
            respuesta=input.nextInt();
            input.nextLine();
        }
        if(respuesta==2){

            ataqueCantar(nivelMundo, aventureros, input);

        }
        if(respuesta==0){
            ataqueInfundirValor(nivelMundo, aventureros);
        }
        if(respuesta==1){System.out.println("Ole ese chupito bueno, asi si.");}
    }


   

    public boolean isPortento_Musical() {
        return Portento_Musical;
    }

    public void setPortento_Musical(boolean portento_Musical) {
        Portento_Musical = portento_Musical;
    }
    public boolean isConocimiento_de_bardo() {
        return Conocimiento_de_bardo;
    }

    @Override
    public void quitarbeneficios() {
       
    }

    public HashMap<Integer, String> getMusica_de_Bardo() {
        return Musica_de_Bardo;
    }

    public void setMusica_de_Bardo(HashMap<Integer, String> musica_de_Bardo) {
        Musica_de_Bardo = musica_de_Bardo;
    }

    public HashMap<Integer, Integer> getInfundir_Valor() {
        return Infundir_Valor;
    }

    public void setInfundir_Valor(HashMap<Integer, Integer> infundir_Valor) {
        Infundir_Valor = infundir_Valor;
    }

    public HashMap<Integer, Integer> getTablaAtaque() {
        return TablaAtaque;
    }

    public void setTablaAtaque(HashMap<Integer, Integer> tablaAtaque) {
        TablaAtaque = tablaAtaque;
    }

    public void setConocimiento_de_bardo(boolean conocimiento_de_bardo) {
        Conocimiento_de_bardo = conocimiento_de_bardo;
    }

    public HashMap<Integer, Cantar> getCantar() {
        return Cantar;
    }

    public void setCantar(HashMap<Integer, Cantar> cantar) {
        Cantar = cantar;
    }

 

}