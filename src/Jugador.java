//Clase Jugador, es abstracta junto con la clase Clases, ambas definen la clase final que elegirá el jugador
//quedando definidos todos los campos y métodos para acceder a ellos.
//Jugador y Clases se pueden usar para definir enemigos.

import java.util.Scanner;

public abstract class Jugador {
    private String Nombre;//Nombre del jugador
    private boolean Jefe,Debilitado,Envenenado,Perdida_de_Nivel;
    private int FD;
    
    protected void setNombre(){
        System.out.println("Introduce tu nombre");
        String Nom;
        Scanner sc =new Scanner(System.in);
        Nom= sc.nextLine();      
        this.Nombre=Nom;
        sc.close();
        
    }
    protected void setJefe(Boolean a){
        this.Jefe=a;
    }
    protected void setDebilitado(Boolean b){
        this.Debilitado=b;
    };
    protected void setEnvenedado(Boolean b){
        this.Envenenado=b;
    };
    protected void setPerdida_de_Nivel(Boolean b){
        this.Perdida_de_Nivel=b;
    };
    protected void setFD(int a){
        this.FD=a;
    }
    protected String getNombre(){
        return this.Nombre;
    }
    protected boolean getJefe(){
        return this.Jefe;
        }
    
        protected int getFD(int a){
            return this.FD=a;
        }


}