import java.util.ArrayList;
//Clase de Enemigo. Define el nombre, ataque, nivel y puntos de golpe. Ademas tiene un arraylist Enums para 
//el tipo de Aptitud del boss.
//También tiene dos campos para la putada y descripcion
public class Enemigo {

    private String Nombre;
    private int Ataque,Nivel,PG_enemigo;
    private ArrayList<Enums> Tipo_Aptitud_Boss; 
    private String Putada,Regla_de_Combate,Descripcion_Enemigo,Caracteristica1,Caracteristica2;

    private Integer nEnemigos;
   



    public Enemigo(String Nombre,int Nivel,int Ataque,int PG_enemigo,String Putada, String Descp,int nEne,String descp_Enemigo,String caracterisitca1,String caracteristica2){
      this.Nombre=Nombre;
      this.Nivel=Nivel;
      this.Ataque=Ataque;
      this.PG_enemigo=PG_enemigo;
      this.Putada=Putada;
      this.Regla_de_Combate=Descp;
      this.nEnemigos=nEne;
      this.Descripcion_Enemigo=descp_Enemigo;
      this.Caracteristica1=caracterisitca1;
      this.Caracteristica2 =caracteristica2;
    }
    public void setPG_enemigo(int PG) {
        this.PG_enemigo = PG;
    }
    
   
    public String getNombre() {
        return this.Nombre;
    }
     
    public void getAtaque(Descripcion_Combate Descripciones) {
        System.out.println(Descripciones.getDescripcion_del_Ataque() + " y hace"+Ataque +"de daño");
        
    }

    public int getPG_enemigo() {
        return this.PG_enemigo;
    }
 
    public int getNivel() {
        return this.Nivel;
    }

    public ArrayList<Enums> getTipo_Aptitud_Boss() {
        return Tipo_Aptitud_Boss;
    }

    public void setTipo_Aptitud_Boss(ArrayList<Enums> tipo_Aptitud_Boss) {
        Tipo_Aptitud_Boss = tipo_Aptitud_Boss;
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
    public int getAtaque() {
        return Ataque;
    }
    public void setAtaque(int ataque) {
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

    public String getCaracteristica2() {
        return Caracteristica2;
    }
    public void setCaracteristica2(String caracteristica2) {
        Caracteristica2 = caracteristica2;
    }
    public String getCaracteristica1() {
        return Caracteristica1;
    }
    public void setCaracteristica1(String caracteristica1) {
        Caracteristica1 = caracteristica1;
    }
    
    }



