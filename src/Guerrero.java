//Para poder determinar los PG de la clase es necesario
//crear una clase TablaPG en la mesa y llamar al metodo
//Guerrero.iniciarPG("TablaPG.getPg(Nivel_de_Mundo,NR)")
//Hay que establecer la clase de prestigio
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



public class Guerrero extends Jugador {
    private HashMap<Integer,Integer> Ataque_Poderoso;
   
    private HashMap<Integer,Integer> TablaAtaque;
    private boolean EstiloAtaque_Poderoso;
    
    
    
    public Guerrero (Scanner input){
        setIsAtaqueMagico(false);
        setNR(2);
        setHajugado(false);
        setClase(Enums.Tipo_Clase.Guerrero);
        setTablaAtaque(new HashMap<Integer,Integer>());
        
        setSalvaciones(new ArrayList<Enums.Tipo_Salvacion>());
        addSalvaciones(Enums.Tipo_Salvacion.Fortaleza);
        setTipoAtaque_Fisico(new ArrayList<Enums.Tipo_Ataque>());
        addTipoAtaque_fisico(Enums.Tipo_Ataque.Cortante);
        setTablaAtaque(iniciarAtaqueBase());
        iniciarDos_Armas();
        iniciarAtaque_Poderoso();
        
                      
        
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
    addTipoAtaque_fisico(Enums.Tipo_Ataque.Adistancia);
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
    
   

    public int getAtaqueBase(int NivelMundo) {
        return this.TablaAtaque.get(NivelMundo);
    }
    public int atacar(Scanner input,int nivelMundo){
        String utilizarFuria="z";
   
        Furia furia=getFuria(nivelMundo);
        int danoBase=getAtaqueBase(nivelMundo);
        //Preguntas
         while(utilizarFuria!="s" && utilizarFuria!="n"){
            System.out.println("¿Quieres usar furia?: "+danoBase+furia.getDescripcion()+"(s/n)");
            utilizarFuria=input.nextLine();
            input.nextLine();
        }
        switch (utilizarFuria) {
            case "s":
                System.out.println("Bebes 1 UBE y 1 chupito");
                System.out.println("Con toda tu rabia golpeas brutalmente las partes íntimas del enemigo\nHaciendo un total de "+(danoBase*furia.getMultiplicador()+" daño"));
            return danoBase*furia.getMultiplicador();        
        
            default:
                System.out.println("Te rajas por no beber un chupito y golpeas sin usar todo tu potencial\nHaces "+danoBase+" de daño (paupérrimo)");
                System.out.println("Bebes 1 UBE");
            return danoBase;
            
        }
    }
    public int ataqueMagico(int nivelMundo){
        return 0;
    }

    @Override
    public Danno ataque_fisico(Scanner input, int nivelMundo, ArrayList<Enemigo> horda) {
        Danno danno = new Danno();
        System.out.println(getNombre()+"es hora de hacer cosas bárbaras");
        int ataque =atacar(input, nivelMundo);
        danno.setCantidad(ataque);
        if(getTipoAtaque_Fisico().size()==1){
          danno.setTipo(getTipoAtaque_Fisico().get(0));
        }
        else{};
        return null;
    }
    @Override
    public Danno ataque_magico(Scanner input, int nivelMundo, ArrayList<Enemigo> horda) {
        // TODO Auto-generated method stub
        return null;
    }
}