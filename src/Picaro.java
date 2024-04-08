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
    private boolean Ha_bebido;
    
    public Picaro (Scanner input){
        iniciarNombre(input);
        setIsAtaqueMagico(false);
        setBuscaTrampas(true);
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



    public int getAtaqueBase(int NivelMundo) {
        return this.TablaAtaque.get(NivelMundo);
    }

  

    @Override
    public int atacar(Scanner input, int nivelMundo, ArrayList<Enemigo> horda) {
       return getAtaqueBase(nivelMundo)+getModificador()+getModificador_toda_la_sala();
    }

    
    public void ataque_magico(Scanner input, int nivelMundo, ArrayList<Enemigo> horda,
            ArrayList<Modificador> modificadores, Grupo aventureros) {
      return;
    }

    @Override
    public void quitarbeneficios() {
       return;
    }

    @Override
    public void fase_limpieza(int nivelMundo) {
    return;  
    }
    public boolean isHa_bebido() {
        return Ha_bebido;
    }

    public void setHa_bebido(boolean ha_bebido) {
        Ha_bebido = ha_bebido;
    }

    @Override
    protected void Ritual_Brujo(int nivelMundo, Grupo aventureros, Scanner input) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Ritual_Brujo'");
    }

}
