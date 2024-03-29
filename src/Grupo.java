import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Grupo {
    private List<Jugador> jugadores;
    private HashMap<Integer,String> ListaClases;
    
    public Grupo(Scanner input){
        jugadores = new ArrayList<Jugador>();
        ListaClases =new HashMap<Integer, String>();
        crearlistadoClases();
        setJugador(input);
        
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

    // Método que solo se invoca una vez para crear el grupo de jugadores y sus clases
    public void setJugador(Scanner input){
        int clase=99;
        System.out.println("¿Cuantos son los cabestros que van darlo todo por nada mas que diversión inmunda?");
        int njugadores = 0;
        njugadores = input.nextInt();
        input.nextLine();
        for (int i = 0; i < njugadores; i++) {
            
        
        System.out.println("Jugador nº"+(i+1)+ "¿Que clase quieres jugar?\n");
        System.out.println(ListaClases+"\n");
        clase = input.nextInt();
        input.nextLine();

        while(ListaClases.containsKey(clase)==false){
            System.out.println("No te pases de listo elige tu clase escribiéndola tal y como aparece "+ListaClases.size());
            System.out.println("Jugador nº"+i+1+ " ¿Que clase quieres jugar?\n");
            System.out.println(ListaClases);
            System.out.println("\n");
            clase = input.nextInt();
            input.nextLine();
        }

        switch (clase) {
            case 0:
                Barbaro jugador= new Barbaro(input);
                this.jugadores.add(i,jugador);
                break;
        
            default:
                break;
        }
    }
    
    }
    
  

  public void crearlistadoClases(){
    this.ListaClases.put(0,"Barbaro");

  }
}