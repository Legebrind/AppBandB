//Para poder determinar los PG de la clase es necesario
//crear una clase TablaPG en la mesa y llamar al metodo
//Barbaro.setPG("TablaPG.getPg(Nivel_de_Mundo,NR)")

import java.util.ArrayList;
import java.util.HashMap;

public class Barbaro extends Clases{

    private HashMap<Integer,String> Furia,Sentido_Trampas;//tabla que controla los valores de las aptitudes especiales
    private ArrayList<String> Aptitudes; //Se guardan los titulos de las aptitudes especiales
    
    public Barbaro (){
        setNombre();
        setAtaqueBase();
        setFuria();
        setSentido_Trampas();
        setNR(3);
        setTipoDano("Cortante");
        setSalvacion("Fortaleza");
        setAtaque(TablaAtaque.get(1));
        setAptitudes(1);
        EquipoInicial();
        setDebilitado(false);
        setEnvenedado(false);
        setPerdida_de_Nivel(false);
       
        
    }

    private void setAtaqueBase(){
        this.TablaAtaque.put(1,6);
        this.TablaAtaque.put(2,6);
        this.TablaAtaque.put(3,7);
        this.TablaAtaque.put(4,7);
        this.TablaAtaque.put(5,8);
        this.TablaAtaque.put(6,8);
        this.TablaAtaque.put(7,9);
        this.TablaAtaque.put(8,9);
        this.TablaAtaque.put(9,10);
        this.TablaAtaque.put(10,10);
        this.TablaAtaque.put(11,11);
        this.TablaAtaque.put(12,11);
        this.TablaAtaque.put(13,12);
        this.TablaAtaque.put(14,12);
        this.TablaAtaque.put(15,13);

    } 
 
    private void setFuria(){
        this.Furia.put(1,"Furia x2");
        this.Furia.put(2,"Furia x2");
        this.Furia.put(3,"Furia x2");
        this.Furia.put(4,"Furia x2");
        this.Furia.put(5,"Furia x2");
        this.Furia.put(6,"Furia x3");
        this.Furia.put(7,"Furia x3");
        this.Furia.put(8,"Furia x3");
        this.Furia.put(9,"Furia x3");
        this.Furia.put(10,"Furia x3");
        this.Furia.put(11,"Furia x4");
        this.Furia.put(12,"Furia x4");
        this.Furia.put(13,"Furia x4");
        this.Furia.put(14,"Furia x4");
        this.Furia.put(15,"Furia x4");
    } 
private void setSentido_Trampas(){

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
public String getFuria(int a){

    return this.Furia.get(a);
}
public String getSentido_Trampas(int a){

    return this.Sentido_Trampas.get(a);
}
public void setAptitudes(int nivel){
 this.Aptitudes.add(0,this.Furia.get(nivel));
 this.Aptitudes.add(1,this.Sentido_Trampas.get(nivel)); 
 if(nivel==6){
    this.Aptitudes.add(2,"Reflejos_Rapidos");
 }
 
}

public ArrayList<String> getAptitudes(){

    return this.Aptitudes;
}


public int getAtaqueBase(int NivelMundo) {
   return this.TablaAtaque.get(NivelMundo);
}




}