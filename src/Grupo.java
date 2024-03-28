import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Grupo {
    private List<Jugador> jugadores;
    private HashMap<Integer,String> ListaClases;
    
    public Grupo(){
        jugadores = new ArrayList<Jugador>();
        ListaClases =new HashMap<Integer, String>();
        crearlistadoClases();
        
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
    public void setJugador(int i){
        int clase=99;
        
        System.out.println("Jugador nº"+(i+1)+ "¿Que clase quieres jugar?\n");
        System.out.println(ListaClases+"\n");
        Scanner input =new Scanner(System.in);
        input.nextLine();
        input.remove();
        
        clase = input.nextInt();
        
                    
        while(ListaClases.containsKey(clase)==false){
            System.out.println("No te pases de listo elige tu clase escribiéndola tal y como aparece "+ListaClases.size());
            System.out.println("Jugador nº"+i+1+ "¿Que clase quieres jugar?\n");
            System.out.println(ListaClases);
            System.out.println("\n");
            clase = input.nextInt();
            }
        
        
        switch (clase) {
            case 0:
                Barbaro jugador= new Barbaro();
                this.jugadores.add(i,jugador);
                break;
        
            default:
                break;
        }
    
    }
    
  

  public void crearlistadoClases(){
    this.ListaClases.put(0,"Barbaro");

  }
}