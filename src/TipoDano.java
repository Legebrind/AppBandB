//Clase tipo HashMap que alberga los tipos de daño
//1.Cortante
//2.Perforante
//3.Contundente
import java.util.HashMap;
public class TipoDano {

    private HashMap <Integer, String> TiposDano;

    public TipoDano(){
        TiposDano=new HashMap<>();
        this.TiposDano.put(1,"Cortante");
        this.TiposDano.put(2,"Perforante");
        this.TiposDano.put(3,"Contundente");
    }

    public void eliminarTipo(int a){
        this.TiposDano.put(a,"");

    }
    public String getTp_Dano(int a){

        return this.TiposDano.get(a);
    }
    public void anadirTipo(int a, String b){
        this.TiposDano.put(a,b);
    }

}