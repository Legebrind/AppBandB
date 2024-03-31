//Para poder determinar los PG de la clase es necesario
//crear una clase TablaPG en la mesa y llamar al metodo
//Hechicero.iniciarPG("TablaPG.getPg(Nivel_de_Mundo,NR)")
//Faltan las aptitudes especiales
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



public class Hechicero extends Jugador {
    private HashMap<Integer,Integer> Energia_Arcana;
   
    private HashMap<Integer,Integer> TablaAtaque;
    private boolean EstiloEnergia_Arcana;
    
    
    
    public Hechicero (Scanner input){
        iniciarNombre(input);
        setIsAtaqueMagico(true);
        setBuscaTrampas(false);
        setNR(1);
        setHajugado(false);
        setClase(Enums.Tipo_Clase.Hechicero);
        setTablaAtaque(new HashMap<Integer,Integer>());
        
        setSalvaciones(new ArrayList<Enums.Tipo_Salvacion>());
        addSalvaciones(Enums.Tipo_Salvacion.Voluntad);
        setTipoAtaque_Fisico(new ArrayList<Enums.Tipo_Ataque>());
        addTipoAtaque_fisico(Enums.Tipo_Ataque.Contundente);
        setTablaAtaque(iniciarAtaqueBase());
        iniciarDos_Armas();
        Energia_Arcana();
        
                      
        
    }

    private HashMap<Integer,Integer> iniciarAtaqueBase(){
        TablaAtaque = new HashMap<Integer,Integer>();
        TablaAtaque.put(1,2);
        TablaAtaque.put(2,2);
        TablaAtaque.put(3,2);
        TablaAtaque.put(4,2);
        TablaAtaque.put(5,3);
        TablaAtaque.put(6,3);
        TablaAtaque.put(7,3);
        TablaAtaque.put(8,3);
        TablaAtaque.put(9,4);
        TablaAtaque.put(10,4);
        TablaAtaque.put(11,4);
        TablaAtaque.put(12,4);
        TablaAtaque.put(13,5);
        TablaAtaque.put(14,5);
        TablaAtaque.put(15,5);
        return TablaAtaque;
    } 
    
    
    

  private void Energia_Arcana(){
    Energia_Arcana = new HashMap<>();
    addTipoAtaque_fisico(Enums.Tipo_Ataque.Adistancia);
    //Este bonificador solo se aplica cuando bebe un UBE, añade esta cantidad al ataque base
    Energia_Arcana.put(1,10);
    Energia_Arcana.put(2,10);
    Energia_Arcana.put(3,10);
    Energia_Arcana.put(4,20);
    Energia_Arcana.put(5,20);
    Energia_Arcana.put(6,20);
    Energia_Arcana.put(7,30);
    Energia_Arcana.put(8,30);
    Energia_Arcana.put(9,30);
    Energia_Arcana.put(10,40);
    Energia_Arcana.put(11,40);
    Energia_Arcana.put(12,40);
    Energia_Arcana.put(13,50);
    Energia_Arcana.put(14,50);
    Energia_Arcana.put(15,50);

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