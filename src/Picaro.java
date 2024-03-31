//Para poder determinar los PG de la clase es necesario
//crear una clase TablaPG en la mesa y llamar al metodo
//Picaro.iniciarPG("TablaPG.getPg(Nivel_de_Mundo,NR)")
//Hay que implementar bomba de humo
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



public class Picaro extends Jugador {
    private HashMap<Integer,String> Sentido_Trampas;
    private HashMap<Integer,Integer> Furtivo; //tabla que controla los valores de las aptitudes especiales
    private HashMap<Integer,Integer> TablaAtaque;
    private boolean BuscaTrampas;
    
    
    

    public Picaro (Scanner input){
        setIsAtaqueMagico(false);
        setNR(2);
        setHajugado(false);
        setClase(Enums.Tipo_Clase.Picaro);
        setTablaAtaque(new HashMap<Integer,Integer>());
        Furtivo = new HashMap<>();
        Sentido_Trampas = new HashMap<>();
        setSalvaciones(new ArrayList<Enums.Tipo_Salvacion>());
        addSalvaciones(Enums.Tipo_Salvacion.Reflejos);
        setTipoAtaque_Fisico(new ArrayList<Enums.Tipo_Ataque>());
        addTipoAtaque_fisico(Enums.Tipo_Ataque.Cortante);
        addTipoAtaque_fisico(Enums.Tipo_Ataque.Perforante);
        setTablaAtaque(iniciarAtaqueBase());
        iniciarFurtivo();
        iniciarSentido_Trampas();
                      
        
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
    
    private void iniciarFurtivo(){
        Furtivo=new HashMap<>();
        this.Furtivo.put(1,4);
        this.Furtivo.put(2,4);
        this.Furtivo.put(3,4);
        this.Furtivo.put(4,5);
        this.Furtivo.put(5,10);
        this.Furtivo.put(6,10);
        this.Furtivo.put(7,12);
        this.Furtivo.put(8,12);
        this.Furtivo.put(9,18);
        this.Furtivo.put(10,21);
        this.Furtivo.put(11,21);
        this.Furtivo.put(12,21);
        this.Furtivo.put(13,32);
        this.Furtivo.put(14,32);
        this.Furtivo.put(15,32);
    } 
    private void iniciarSentido_Trampas(){
    //Modificar como clase Furtivo;
    this.Sentido_Trampas.put(1,"Sentido trampas 1");
    this.Sentido_Trampas.put(2,"Sentido trampas 1");
    this.Sentido_Trampas.put(3,"Sentido trampas 1");
    this.Sentido_Trampas.put(4,"Sentido trampas 2");
    this.Sentido_Trampas.put(5,"Sentido trampas 2");
    this.Sentido_Trampas.put(6,"Sentido trampas 2");
    this.Sentido_Trampas.put(7,"Sentido trampas 3");
    this.Sentido_Trampas.put(8,"Sentido trampas 3");
    this.Sentido_Trampas.put(9,"Sentido trampas 3");
    this.Sentido_Trampas.put(10,"Sentido trampas 4");
    this.Sentido_Trampas.put(11,"Sentido trampas 4");
    this.Sentido_Trampas.put(12,"Sentido trampas 4");
    this.Sentido_Trampas.put(13,"Sentido trampas 5");
    this.Sentido_Trampas.put(14,"Sentido trampas 5");
    this.Sentido_Trampas.put(15,"Sentido trampas 5");
    }
    public Furtivo getFurtivo(int nivelMundo){

        return Furtivo.get(nivelMundo);
    }
    public String getSentido_Trampas(int a){

        return this.Sentido_Trampas.get(a);
    }



    public int getAtaqueBase(int NivelMundo) {
        return this.TablaAtaque.get(NivelMundo);
    }
    public int atacar(Scanner input,int nivelMundo){
        String utilizarFurtivo="z";
   
        Furtivo Furtivo=getFurtivo(nivelMundo);
        int danoBase=getAtaqueBase(nivelMundo);
        //Preguntas
         while(utilizarFurtivo!="s" && utilizarFurtivo!="n"){
            System.out.println("¿Quieres usar Furtivo?: "+danoBase+Furtivo.getDescripcion()+"(s/n)");
            utilizarFurtivo=input.nextLine();
            input.nextLine();
        }
        switch (utilizarFurtivo) {
            case "s":
                System.out.println("Bebes 1 UBE y 1 chupito");
                System.out.println("Con toda tu rabia golpeas brutalmente las partes íntimas del enemigo\nHaciendo un total de "+(danoBase*Furtivo.getMultiplicador()+" daño"));
            return danoBase*Furtivo.getMultiplicador();        
        
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

    public boolean isBuscaTrampas() {
        return BuscaTrampas;
    }

    public void setBuscaTrampas(boolean buscaTrampas) {
        BuscaTrampas = buscaTrampas;
    }

}