

public class Enemigo {

    private String Nombre;
    private int Ataque,Nivel,PG_enemigo;
    
   

    public Enemigo(String Nombre,int Nivel,int Ataque,int PG_enemigo){
      this.Nombre=Nombre;
      this.Nivel=Nivel;
      this.Ataque=Ataque;
      this.PG_enemigo=PG_enemigo;
    }
    public void setPG_enemigo(int PG) {
        this.PG_enemigo = PG;
    }
    
   
    public String getNombre() {
        return this.Nombre;
    }
     
    public void getAtaque() {
        System.out.println("El"+ Nombre +"ataca con todo lo gordo haciendo "+Ataque +"de daño");
        
    }

    public int getPG_enemigo() {
        return this.PG_enemigo;
    }
 
    public int getNivel() {
        return this.Nivel;
    }

    
    }



