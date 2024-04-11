//Para poder determinar los PG de la clase es necesario
//crear una clase TablaPG en la mesa y llamar al metodo
//Guerrero.iniciarPG("TablaPG.getPg(Nivel_de_Mundo,NR)")
//Hay que establecer la clase de prestigio
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



public class Guerrero extends Jugador {
    private HashMap<Integer,Integer> Ataque_Poderoso,Ataque_Poderoso_mejorado;
   
    private HashMap<Integer,Integer> TablaAtaque;
    private boolean EstiloAtaque_Poderoso,Acorazado;

    public Guerrero (Scanner input){
        iniciarNombre(input);
        setIsAtaqueMagico(false);
        setBuscaTrampas(false);
        setNR(2);
        setHajugado(false);
        setClase(Enums.Tipo_Clase.Guerrero);
        setTablaAtaque(new HashMap<Integer,Integer>());
        
        setSalvaciones(new ArrayList<Enums.Tipo_Salvacion>());
        addSalvaciones(Enums.Tipo_Salvacion.Fortaleza);
        setTipoAtaque_Fisico(new ArrayList<Enums.Tipo_Ataque>());
        addTipoAtaque_fisico(Enums.Tipo_Ataque.Cortante);
        setTablaAtaque(iniciarAtaqueBase());
        iniciarAtaque_Poderoso();
        Acorazado=false;
        EstiloAtaque_Poderoso=false;
        
                      
        
    }

    private HashMap<Integer,Integer> iniciarAtaqueBase(){
        TablaAtaque = new HashMap<Integer,Integer>();
        TablaAtaque.put(1,6);
        TablaAtaque.put(2,7);
        TablaAtaque.put(3,8);
        TablaAtaque.put(4,8);
        TablaAtaque.put(5,9);
        TablaAtaque.put(6,10);
        TablaAtaque.put(7,11);
        TablaAtaque.put(8,11);
        TablaAtaque.put(9,12);
        TablaAtaque.put(10,13);
        TablaAtaque.put(11,14);
        TablaAtaque.put(12,14);
        TablaAtaque.put(13,15);
        TablaAtaque.put(14,16);
        TablaAtaque.put(15,17);
        return TablaAtaque;
    } 
    
    
    

  private void iniciarAtaque_Poderoso(){
    Ataque_Poderoso = new HashMap<>();
    
    //Este bonificador solo se aplica cuando bebe un UBE, añade esta cantidad al ataque base
    Ataque_Poderoso.put(1,3);
    Ataque_Poderoso.put(2,3);
    Ataque_Poderoso.put(3,3);
    Ataque_Poderoso.put(4,3);
    Ataque_Poderoso.put(5,4);
    Ataque_Poderoso.put(6,4);
    Ataque_Poderoso.put(7,4);
    Ataque_Poderoso.put(8,4);
    Ataque_Poderoso.put(9,5);
    Ataque_Poderoso.put(10,5);
    Ataque_Poderoso.put(11,5);
    Ataque_Poderoso.put(12,5);
    Ataque_Poderoso.put(13,6);
    Ataque_Poderoso.put(14,6);
    Ataque_Poderoso.put(15,6);

  }
  private void iniciarAtaque_Poderoso_mejorado(){
    Ataque_Poderoso_mejorado = new HashMap<>();
 
    //Este bonificador solo se aplica cuando bebe un UBE, añade esta cantidad al ataque base
   
    Ataque_Poderoso_mejorado.put(6,6);
    Ataque_Poderoso_mejorado.put(7,7);
    Ataque_Poderoso_mejorado.put(8,8);
    Ataque_Poderoso_mejorado.put(9,10);
    Ataque_Poderoso_mejorado.put(10,11);
    Ataque_Poderoso_mejorado.put(11,12);
    Ataque_Poderoso_mejorado.put(12,13);
    Ataque_Poderoso_mejorado.put(13,15);
    Ataque_Poderoso_mejorado.put(14,16);
    Ataque_Poderoso_mejorado.put(15,17);

  }
    
   

    public int getAtaqueBase(int NivelMundo) {
        return this.TablaAtaque.get(NivelMundo);
    }
    public int atacar(Scanner input,int nivelMundo,ArrayList<Enemigo>horda){
        int respuesta=-1;
        boolean atqpoderoso=false;
        System.out.println("¿Quieres darle al enemigo pa que la sienta en el pecho? \n1)Si\n2)No");
            do{
                try{
                    respuesta=input.nextInt();

                }catch(Exception e){
                    System.out.println("¡¡¡¡Di 1 o 2!!!!!Alma de Hokague");
                    input.nextInt();
                } //comprobar
            }while (respuesta!=1 && respuesta!=2);
        if(respuesta==1){
            atqpoderoso=true;
            
            respuesta=-1;}
        respuesta=-1;
        if(nivelMundo>=6 && (Acorazado==false&&EstiloAtaque_Poderoso==false)){
            System.out.println("Muy bien machote, ahora tienes que elegir pa los restos si pegar chuki de Cieza(1)\ncomo un armadillo(2) con una falsa sensación de protección");
            do{
                try{
                    respuesta=input.nextInt();

                }catch(Exception e){
                    System.out.println("¡¡¡¡Di 1 o 2!!!!!Alma de Hokague");
                    input.nextInt();
                } //comprobar
            }while (respuesta!=1 && respuesta!=2);
            if(respuesta==2){
                Acorazado=true;
            }
            else{ 
                iniciarAtaque_Poderoso_mejorado();
                EstiloAtaque_Poderoso=true;
            }
        }
        if(Acorazado){
            if(atqpoderoso){
                aumentarModificador(Ataque_Poderoso.get(nivelMundo));
            }
        }
        if(atqpoderoso){
            aumentarModificador(EstiloAtaque_Poderoso?Ataque_Poderoso_mejorado.get(nivelMundo):Ataque_Poderoso.get(nivelMundo));
           
        }
        return getAtaqueBase(nivelMundo)+getModificador()+getModificador_toda_la_sala();
    }
    public void ataque_magico(Scanner input, int nivelMundo, ArrayList<Enemigo> horda,
            ArrayList<Modificador> modificadores, Grupo aventureros) {
        return;
    }
    public void quitarbeneficios() {
       
    }

    @Override
    public void fase_limpieza(int nivelMundo) {
      return;
    }

    @Override
    protected void Ritual_Brujo(int nivelMundo, Grupo aventureros, Scanner input) {
      return;
    }
}
