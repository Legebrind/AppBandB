import java.util.ArrayList;
import java.util.Random;
//Clase de Enemigo. Define el nombre, ataque, nivel y puntos de golpe. Ademas tiene un arraylist Enums para 
//el tipo de Aptitud del boss.
//También tiene dos campos para la putada y descripcion
public class Enemigo {

    private String Nombre,Ataque;
    private int Nivel,PG_enemigo;
    private String Putada,Regla_de_Combate,Descripcion_Enemigo;
    private Integer nEnemigos;
    private Random Aleatorio;
    private ArrayList<String> Caracteristicas;
   
    public Enemigo(String Nombre,int Nivel,String Ataque,int PG_enemigo,String Putada, String Descp,int nEne,String descp_Enemigo,ArrayList<String> caracterisitcas){
      this.Nombre=Nombre;
      this.Nivel=Nivel;
      this.Ataque=Ataque;
      this.PG_enemigo=PG_enemigo;
      this.Putada=Putada;
      this.Regla_de_Combate=Descp;
      this.nEnemigos=nEne;
      this.Descripcion_Enemigo=descp_Enemigo;
      this.Caracteristicas=caracterisitcas;
     
      
    }
    public Enemigo(){
        
    }
    public void setPG_enemigo(int PG) {
        this.PG_enemigo = PG;
    }
    
    public ArrayList<String> getCaracteristicas() {
        return Caracteristicas;
    }
    public void setCaracteristica(String caracteristica) {
        this.Caracteristicas.add(caracteristica);
    }
    public String getNombre() {
        return this.Nombre;
    }
     
    public void getAtaque(Descripcion_Combate Descripciones) {
        System.out.println(Descripciones.getDescripcion_del_Ataque() + " y hace "+Ataque +" de daño");
        
    }

    public int getPG_enemigo() {
        return this.PG_enemigo;
    }
 
    public int getNivel() {
        return this.Nivel;
    }


    public String getPutada() {
        return Putada;
    }
    public void setPutada(String putada) {
        Putada = putada;
    }
    public String getDescripcion() {
        return Regla_de_Combate;
    }
    public void setDescripcion(String descripcion) {
        Regla_de_Combate = descripcion;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getAtaque() {
        return Ataque;
    }
    public void setAtaque(String ataque) {
        Ataque = ataque;
    }
    public void setNivel(int nivel) {
        Nivel = nivel;
    }
    public int getnEnemigos() {
        return nEnemigos;
    }
    public void setnEnemigos(int nEnemigos) {
        this.nEnemigos = nEnemigos;
    }
    public String getDescripcion_Enemigo() {
        return Descripcion_Enemigo;
    }
    public void setDescripcion_Enemigo(String descripcion_Enemigo) {
        Descripcion_Enemigo = descripcion_Enemigo;
    }

   

    public void recibirDanno(Danno danno){
        if(this.Caracteristicas.contains("Ninguna")){
            this.PG_enemigo-=danno.getCantidad();
            System.out.println("Le haces to esto "+danno.getCantidad()+" de daño");
            return;
        }
        if((this.Caracteristicas.contains("No Muerto")) && danno.getTipo()==Enums.Tipo_Ataque.Expulsar){
            this.PG_enemigo-=danno.getCantidad();
            System.out.println("Le haces to esto "+danno.getCantidad()+" de daño");
            return;
        }
        if((this.Caracteristicas.contains("No Muerto")||this.Caracteristicas.contains("Inmune a Crítico")) && danno.getTipo()==Enums.Tipo_Ataque.Furtivo){
            danno.setCantidad(0);
            System.out.println("Le haces to esto "+danno.getCantidad()+" de daño");
        }
        if((this.Caracteristicas.contains("Volador")) && danno.getTipo()!=Enums.Tipo_Ataque.Adistancia && danno.getTipo()!=Enums.Tipo_Ataque.Magia){

            danno.setCantidad(danno.getCantidad()/2);
            System.out.println("Le haces to esto "+danno.getCantidad()+" de daño");
        }
        if((this.Caracteristicas.contains("Invisible"))){
            Aleatorio= new Random();
            if(Aleatorio.nextInt(0,2)==0){
                danno.setCantidad(0);
                System.out.println("Le haces to esto "+danno.getCantidad()+" de daño");
            }

        }
        this.PG_enemigo-=danno.getCantidad();
                
    }

}


    
    




