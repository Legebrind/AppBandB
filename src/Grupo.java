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
    public Jugador getJugador(int a){
        return jugadores.get(a);
    }

    public void mostrarInformacionEquipo() {
        System.out.println("Jugadores en el equipo:");
        int i=0;
        for (Jugador jugador : jugadores) {
            System.out.println(i+") "+jugador.getNombre());
            i++;
        }
    }

    // Método que solo se invoca una vez para crear el grupo de jugadores y sus clases
    public void setJugador(Scanner input){
        int clase;
        int j=0;
        int njugadores;
        //j es para el bucle que muestra las clases de pj.
        System.out.println("¿Cuantos son los cabestros que van darlo todo por nada mas que diversión inmunda?");
        njugadores = input.nextInt();
        input.nextLine();
        for (int i = 1; i <= njugadores; i++) {
            
        
            System.out.println("Jugador nº"+i+ "¿Que clase quieres jugar?\n");
            for (Enums.Tipo_Clase s : Enums.Tipo_Clase.values()) {
                System.out.println(j+")"+s);
                j++;
            }
            clase = input.nextInt();
            input.nextLine();

            while(clase>j || clase<0){
                System.out.println("No te pases de listo elige tu clase con el número tal y como aparece ");
                System.out.println("Jugador nº"+i+ " ¿Que clase quieres jugar?\n");
                clase = input.nextInt();
                input.nextLine();
            }

            switch (clase) {
                case 0:
                    this.jugadores.add(i-1,new Barbaro(input));
                    break;
                
                case 1:
                    this.jugadores.add(i-1,new Bardo(input));
                    break;
                case 2:
                    this.jugadores.add(i-1,new Chaman(input));
                    break;
                case 3:
                    this.jugadores.add(i-1,new Clerigo(input));
                    break;
                case 4:
                    this.jugadores.add(i-1,new Druida(input));
                    break;
                case 5:
                    this.jugadores.add(i-1,new Explorador(input));
                    break;
                case 6:
                    this.jugadores.add(i-1,new Guerrero(input));
                    break;
                case 7:
                    this.jugadores.add(i-1,new Hechicero(input));
                    break;
                case 8:
                    this.jugadores.add(i-1,new Paladin(input));
                    break;
                case 9:
                    this.jugadores.add(i-1,new Picaro(input));
                    break;
                case 10:
                    this.jugadores.add(i-1,new Sanador(input));
                    break;
               
            }
            j=0;
        }
    
    }


}
  

