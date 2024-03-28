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
        numeroJugadores();
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
        System.out.println("¿Cuantos son los cabestros que van darlo todo por nada mas que diversión inmunda?");
        int njugadores=0;
        try (Scanner input = new Scanner(System.in)) {
            njugadores =input.nextInt();
            input.nextLine();
            // Código para leer datos...
        } // El recurso se cerrará automáticamente aquíScanner sc=new Scanner(System.in);
    
    
    for(int i=0;i<njugadores;i++){
        String clase;
        Scanner input = new Scanner(System.in);
        System.out.println("Jugador nº"+(i+1)+ "¿Que clase quieres jugar?\n");
        System.out.println(ListaClases);
        clase=input.nextLine();
        input.close();     
        
       
        
                
        while(ListaClases.containsValue(clase)==false){
            System.out.println("No te pases de listo elige tu clase escribiéndola tal y como aparece "+ListaClases.size());
            System.out.println("Jugador nº"+i+1+ "¿Que clase quieres jugar?\n");
            System.out.println(ListaClases);
            System.out.println("\n");
            try(Scanner sc =new Scanner(System.in)){
                clase =sc.nextLine();
            };
        }
        
        switch (clase) {
            case "Barbaro":
                Barbaro jugador= new Barbaro();
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