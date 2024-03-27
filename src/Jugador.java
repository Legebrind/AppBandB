//Clase Jugador, es abstracta junto con la clase Clases, ambas definen la clase final que elegirá el jugador
//quedando definidos todos los campos y métodos para acceder a ellos.

public abstract class Jugador {
    private String Nombre;//Nombre del jugador
    private Boolean Jefe,Debilitado,Envenenado,Perdida_de_Nivel;
    private int FD;
    
    protected void setNombre(String Nom){
        this.Nombre=Nom;
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
    protected Boolean getJefe(){
        return this.Jefe;
        }
    



}