import java.util.ArrayList;
import java.util.random.RandomGenerator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MesaDestino implements RandomGenerator {

    private ArrayList<Enemigo> ListaEnemigos;
    private ArrayList<Objeto> ListaTesoro;
    private int NivelDungeon;
    private boolean Juego=True;
    public MesaDestino(){


    }
    public void FinDelJuego(){
        this.Juego=False;

    }
    public Enemigo getEnemigo(){
        List<Enemigo> auxList = ListaEnemigos.stream()
        .filter(x->x.getNivel(NivelDungeon))
        .collect(Collectors.toList());
        int aux= nextInt (0,auxList.size());

    }
  
    
}
