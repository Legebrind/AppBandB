import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Grupo {
    private List<Jugador> jugadores;
    private HashMap<Integer,String> ListaClases;
    
    public Grupo(){
        jugadores = new ArrayList<>();
        ListaClases =new HashMap<>();
        crearlistadoClases();
        numeroJugadores();
    }

    public void agregarJugador(int a) {
        Jugador jugador;
        Scanner sc =new Scanner(System.in);
        System.out.println("Jugador nº"+a+ "¿Que clase quieres jugar?\n");
        System.out.println(ListaClases);
        System.out.println("\n");
        int clase =sc.nextInt();
        while(clase> ListaClases.size() || clase<0){
            System.out.println("No te pases de listo elige tu clase introduciendo un número entre 0 y "+ListaClases.size());
            System.out.println("Jugador nº"+a+ "¿Que clase quieres jugar?\n");
            System.out.println(ListaClases);
            System.out.println("\n");
            clase =sc.nextInt();
        }
        sc.close();
        switch (clase) {
            case 0:
                jugador= new Barbaro();
                break;
        
            default:
                break;
        }
        this.jugadores.add(a,jugador);
    }

    public void eliminarJugador(Jugador jugador) {
        jugadores.remove(jugador);
    }

    public int obtenerCantidadJugadores() {
        return jugadores.size();
    }

    public void mostrarInformacionEquipo() {
        System.out.println("Jugadores en el equipo:");
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.getNombre());
        }
    }

    // Otros métodos según tus necesidades
    public void numeroJugadores(){
    Scanner sc=new Scanner(System.in);
    System.out.println("¿Cuantos son los cabestros que van darlo todo por nada mas que diversión inmunda?");
    int njugadores =sc.nextInt();
    for(int i=0;i<njugadores;i++){
        agregarJugador(i);
    }

  }

  public void crearlistadoClases(){
    this.ListaClases.put(0,"Barbaro");

  }
}

    }
}
