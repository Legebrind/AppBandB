import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Bardo{

      private HashMap<Integer,String> Sentido_Trampas;
    private HashMap<Integer,Furia> Furia; //tabla que controla los valores de las aptitudes especiales
    private HashMap<Integer,Integer> TablaAtaque;
    
    
    
    
    public Bardo (Scanner input){
        setIsAtaqueMagico(true);
        setNR(2);
        setHajugado(false);
        setClase(Enums.Tipo_Clase.Bardo);
        setTablaAtaque(new HashMap<Integer,Integer>());
        Furia = new HashMap<>();
        Sentido_Trampas = new HashMap<>();
        setSalvaciones(new ArrayList<Enums.Tipo_Salvacion>());
        addSalvaciones(Enums.Tipo_Salvacion.Fortaleza);
        setTipoAtaque_Fisico(new ArrayList<Enums.Tipo_Ataque>());
        addTipoAtaque_fisico(Enums.Tipo_Ataque.Cortante);
        setTablaAtaque(iniciarAtaqueBase());
        iniciarFuria();
        iniciarSentido_Trampas();
                      
        
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
    
    private void iniciarFuria(){
        this.Furia.put(1,new Furia("Furia x2",2));
        this.Furia.put(2,new Furia("Furia x2",2));
        this.Furia.put(3,new Furia("Furia x2",2));
        this.Furia.put(4,new Furia("Furia x2",2));
        this.Furia.put(5,new Furia("Furia x2",2));
        this.Furia.put(6,new Furia("Furia x3",3));
        this.Furia.put(7,new Furia("Furia x3",3));
        this.Furia.put(8,new Furia("Furia x3",3));
        this.Furia.put(9,new Furia("Furia x3",3));
        this.Furia.put(10,new Furia("Furia x3",3));
        this.Furia.put(11,new Furia("Furia x4",4));
        this.Furia.put(12,new Furia("Furia x4",4));
        this.Furia.put(13,new Furia("Furia x4",4));
        this.Furia.put(14,new Furia("Furia x4",4));
        this.Furia.put(15,new Furia("Furia x4",4));
    } 
    private void iniciarSentido_Trampas(){
    //Modificar como clase Furia;
    this.Sentido_Trampas.put(1,"Sentido trampas 0");
    this.Sentido_Trampas.put(2,"Sentido trampas 1");
    this.Sentido_Trampas.put(3,"Sentido trampas 1");
    this.Sentido_Trampas.put(4,"Sentido trampas 1");
    this.Sentido_Trampas.put(5,"Sentido trampas 1");
    this.Sentido_Trampas.put(6,"Sentido trampas 2");
    this.Sentido_Trampas.put(7,"Sentido trampas 2");
    this.Sentido_Trampas.put(8,"Sentido trampas 2");
    this.Sentido_Trampas.put(9,"Sentido trampas 2");
    this.Sentido_Trampas.put(10,"Sentido trampas 3");
    this.Sentido_Trampas.put(11,"Sentido trampas 3");
    this.Sentido_Trampas.put(12,"Sentido trampas 3");
    this.Sentido_Trampas.put(13,"Sentido trampas 3");
    this.Sentido_Trampas.put(14,"Sentido trampas 4");
    this.Sentido_Trampas.put(15,"Sentido trampas 4");
    }
    public Furia getFuria(int nivelMundo){

        return Furia.get(nivelMundo);
    }
    public String getSentido_Trampas(int a){

        return this.Sentido_Trampas.get(a);
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