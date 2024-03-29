import java.util.ArrayList;

import java.util.Scanner;

public class Grupo {
    private ArrayList<Jugador> jugadores;
    
    
    public Grupo(Scanner input){
        jugadores = new ArrayList<Jugador>();
        setJugador(input);
        
    }

      public int getJugadoresMax() {
        return jugadores.size();
    }

    public ArrayList<Jugador> getJugadores(){
        return this.jugadores;
    }

    public void mostrarInformacionEquipo() {
        System.out.println("Jugadores en el equipo:");
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.getNombre());
        }
    }

    // Método que solo se invoca una vez para crear el grupo de jugadores y sus clases
    public void setJugador(Scanner input){
        int clase;
        System.out.println("¿Cuantos son los cabestros que van darlo todo por nada mas que diversión inmunda?");
        int njugadores;
        njugadores = input.nextInt();
        input.nextLine();
        for (int i = 0; i < njugadores; i++) {
            
        
            System.out.println("Jugador nº"+(i+1)+ "¿Que clase quieres jugar?\n");
            for (Enums.Tipo_Clase s : Enums.Tipo_Clase.values()) {
                System.out.println(i+")"+s);
            }
            clase = input.nextInt();
            input.nextLine();

            while(clase>i || clase<=0){
                System.out.println("No te pases de listo elige tu clase con el número tal y como aparece ");
                System.out.println("Jugador nº"+i+1+ " ¿Que clase quieres jugar?\n");
                clase = input.nextInt();
                input.nextLine();
            }

            switch (clase-1) {
                case 0:
                    Barbaro jugador= new Barbaro(input);
                    this.jugadores.add(i,jugador);
                    break;
            
                default:
                break;
            }
        }
    
    }
    
  

}