//Para poder determinar los PG de la clase es necesario
//crear una clase TablaPG en la mesa y llamar al metodo
//Explorador.iniciarPG("TablaPG.getPg(Nivel_de_Mundo,NR)")

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



public class Explorador extends Jugador {
    private HashMap<Integer,Integer> Arco;
    private HashMap<Integer,Integer> Dos_Armas; //tabla que controla los valores de las aptitudes especiales
    private HashMap<Integer,Integer> TablaAtaque;
    private boolean EstiloArco,Ataque_doble;

    public Explorador (Scanner input){
        iniciarNombre(input);
        setIsAtaqueMagico(false);
        setBuscaTrampas(false);
        setNR(2);
        setHajugado(false);
        setClase(Enums.Tipo_Clase.Explorador);
        setTablaAtaque(new HashMap<Integer,Integer>());
        
        setSalvaciones(new ArrayList<Enums.Tipo_Salvacion>());
        addSalvaciones(Enums.Tipo_Salvacion.Fortaleza);
        addSalvaciones(Enums.Tipo_Salvacion.Reflejos);
        setTipoAtaque_Fisico(new ArrayList<Enums.Tipo_Ataque>());
        addTipoAtaque_fisico(Enums.Tipo_Ataque.Cortante);
        setTablaAtaque(iniciarAtaqueBase());
        iniciarArco();
        EstiloArco=false;
        Ataque_doble=false;
        
                      
        
    }

    private HashMap<Integer,Integer> iniciarAtaqueBase(){
        TablaAtaque = new HashMap<Integer,Integer>();
        TablaAtaque.put(1,6);
        TablaAtaque.put(2,6);
        TablaAtaque.put(3,7);
        TablaAtaque.put(4,7);
        TablaAtaque.put(5,8);
        TablaAtaque.put(6,8);
        TablaAtaque.put(7,9);
        TablaAtaque.put(8,9);
        TablaAtaque.put(9,10);
        TablaAtaque.put(10,10);
        TablaAtaque.put(11,11);
        TablaAtaque.put(12,11);
        TablaAtaque.put(13,12);
        TablaAtaque.put(14,12);
        TablaAtaque.put(15,13);
        return TablaAtaque;
    } 
    
    
    private void iniciarDos_Armas(){
    //Modificar como clase Furia;
    Dos_Armas = new HashMap<>();
    Dos_Armas.put(2,3);
    Dos_Armas.put(3,4);
    Dos_Armas.put(4,4);
    Dos_Armas.put(5,5);
    Dos_Armas.put(6,6);
    Dos_Armas.put(7,7);
    Dos_Armas.put(8,7);
    Dos_Armas.put(9,8);
    Dos_Armas.put(10,9);
    Dos_Armas.put(11,10);
    Dos_Armas.put(12,10);
    Dos_Armas.put(13,11);
    Dos_Armas.put(14,12);
    Dos_Armas.put(15,13);
  }

  private void iniciarArco(){
    Arco = new HashMap<>();
    addTipoAtaque_fisico(Enums.Tipo_Ataque.Adistancia);
    //Este bonificador solo se aplica cuando es contra BOSS
    //El resto de combates el daño es el daño base, con característica de Adistancia y Perforante

    Arco.put(3,3);
    Arco.put(4,4);
    Arco.put(5,5);
    Arco.put(6,6);
    Arco.put(7,7);
    Arco.put(8,8);
    Arco.put(9,9);
    Arco.put(10,10);
    Arco.put(11,11);
    Arco.put(12,12);
    Arco.put(13,13);
    Arco.put(14,14);
    Arco.put(15,15);

  }
    
   

    public int getAtaqueBase(int NivelMundo) {
        return this.TablaAtaque.get(NivelMundo);
    }
    public int atacar(Scanner input,int nivelMundo,ArrayList<Enemigo>horda){
        int respuesta=-1;
               
        if(nivelMundo>=2){
            if(Ataque_doble==false&&EstiloArco==false){
                System.out.println("Muy bien machote, ahora tienes que elegir pa los restos si pegar con dos armas(1)\ncomo un guerrero o con arco(2) como un jipi");
                do{
                    try{
                        respuesta=input.nextInt();
    
                    }catch(Exception e){
                        System.out.println("¡¡¡¡Di 1 o 2!!!!!Alma de Hokague");
                        input.nextInt();
                    } //comprobar
                }while (respuesta!=1 && respuesta!=2);
    
                if(respuesta==2){
                    EstiloArco=true;addTipoAtaque_fisico(Enums.Tipo_Ataque.Adistancia);addTipoAtaque_fisico(Enums.Tipo_Ataque.Perforante);
                }
                EstiloArco=false;
            }
            if(EstiloArco){
                return getAtaqueBase(nivelMundo);
            }
            System.out.println("Te tomas [1UBE] y pegas dos veces haciendo un poquito menos de daño\n Sinceramente te compensa\n1)Si\n2)no");
            do{
                try{
                    respuesta=input.nextInt();

                }catch(Exception e){
                    System.out.println("¡¡¡¡Di 1 o 2!!!!!Alma de Hokague");
                    input.nextInt();
                } //comprobar
            }while (respuesta!=1 && respuesta!=2);
            if(respuesta==1){
                return Dos_Armas.get(nivelMundo)*2;
            }
            return getAtaqueBase(nivelMundo);

            }
        return getAtaqueBase(nivelMundo);
    }
       
       
       
            
        
    
   

 

    public void ataque_magico(Scanner input, int nivelMundo, ArrayList<Enemigo> horda,
            ArrayList<Modificador> modificadores, Grupo aventureros) {
       
        return;
    }


    public void quitarbeneficios() {
       
       return;
    }
    public boolean isAtaque_doble() {
        return Ataque_doble;
    }

    public void setAtaque_doble(boolean Ataque_doble) {
        Ataque_doble = Ataque_doble;
    }
}