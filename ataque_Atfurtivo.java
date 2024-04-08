import java.util.HashMap;

public class ataque_Atfurtivo {
    private HashMap<Integer,Integer> Atfurtivo;

    public ataque_Atfurtivo(){
        Atfurtivo = new HashMap<>();

    }

    public int atfurtivo (int nivelMundo,int modificador){

        this.Atfurtivo.put(1,4);
        this.Atfurtivo.put(2,4);
        this.Atfurtivo.put(3,4);
        this.Atfurtivo.put(4,5);
        this.Atfurtivo.put(5,10);
        this.Atfurtivo.put(6,10);
        this.Atfurtivo.put(7,12);
        this.Atfurtivo.put(8,12);
        this.Atfurtivo.put(9,18);
        this.Atfurtivo.put(10,21);
        this.Atfurtivo.put(11,21);
        this.Atfurtivo.put(12,21);
        this.Atfurtivo.put(13,32);
        this.Atfurtivo.put(14,32);
        this.Atfurtivo.put(15,32);

        return Atfurtivo.get(nivelMundo)+modificador;
    }
    
}
