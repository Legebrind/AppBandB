//Clase tipo HashMap que alberga los tipos de daño
//1.Cortante
//2.Perforante
//3.Contundente
import java.util.HashMap;
public class TipoDano {

    private HashMap <Integer, String> TiposDano;

    public TipoDano(){
        this.TiposDano.put(1,"Cortante");
        this.TiposDano.put(2,"Perforante");
        this.TiposDano.put(3,"Contundente");
    }

    public String getTp_Dano(int a){

        return this.TiposDano.get(a);
    }

}