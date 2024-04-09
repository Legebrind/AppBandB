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
        int clase=-1;
        int j=0;
        int njugadores=-1;
        //j es para el bucle que muestra las clases de pj.
        System.out.println("¿Cuantos son los cabestros que van darlo todo por nada mas que diversión inmunda?");
        do{

            try{
             
                njugadores=input.nextInt();
                
                if(njugadores<=0){
                    System.out.println("No metas números negativos ¿Eres fascista?");
                     
                }
            }catch(Exception e){
                System.out.println("Venga coño que no has bebido nada y ya estas tocando los cojones");
                System.out.println("Escribe el número de jugadores");
               
            }
            input.nextLine();
        }while(njugadores<=0);
      
        for (int i = 1; i <= njugadores; i++) {
        
            System.out.println("Jugador nº"+i+ "¿Que clase quieres jugar?\n");
            for (Enums.Tipo_Clase s : Enums.Tipo_Clase.values()) {
                System.out.println(j+")"+s);
                j++;
            }

            do{

                try{
                 
                    clase=input.nextInt();
                    
                    if(clase<=0){
                        System.out.println("No metas números negativos ¿Eres fascista?");
                    }
                    if(clase>j){
                        System.out.println("Esa clase todavía no está implementada, esperaté al DLC\nPuto gnomo de los cojones");
                    }
                }catch(Exception e){
                    System.out.println("No te pases de listo elige tu clase con el número tal y como aparece ");
                System.out.println("Jugador nº"+i+ " ¿Que clase quieres jugar?\n");
                   
                }
                input.nextLine();
            }while(clase<0||clase>j);

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
//Método para establecer el jugador inicial y reordenar la lista
    public void set_siguiente_jugador_inicial(){
            for (Jugador jugador : jugadores) {//Se busca quién es el jugador inicial 
                if(jugador.isJugador_inicial()){
                    jugador.setJugador_inicial(false);//una vez se encuentra, se le quita ese estado
                    int posicion=jugadores.indexOf(jugador);
                    if(posicion==jugadores.size()-1){
                        jugadores.get(0).setJugador_inicial(true);
                        return;
                    }
                    else{
                        jugadores.get(posicion+1).setJugador_inicial(true);
                    }
                }
            }
        }
    public void ordenarJugadores(){
        
        int posicion =jugadores.indexOf(getJugador_inicial());
        if(posicion==0){//si el jugador inicial es el 0 la lista está ordenada
            return;
        }
        if(posicion>0&&posicion<jugadores.size()){
            int contador=0;
            ArrayList<Jugador> lista_auxiliar=new ArrayList<>();
            for(int i=0;i<jugadores.size()-posicion;i++){
            lista_auxiliar.add(i, jugadores.get(posicion+contador));
            contador++;                                                
            }//hasta aquí la lista auxiliar está ordenada hasta el último elemento
            for(int i=0;i<posicion;i++){
                lista_auxiliar.add(contador+i, jugadores.get(i));
            }//aqui se añaden los elementos que faltaban
            jugadores.removeAll(jugadores);
            jugadores.addAll(lista_auxiliar);
            lista_auxiliar.clear();
            
        return;
        }
        if(posicion==jugadores.size()){
            ArrayList<Jugador> lista_auxiliar=new ArrayList<>();
            lista_auxiliar.add(0,jugadores.get(posicion));
            for(int i=1;i<=jugadores.size();i++){
                lista_auxiliar.add(i,jugadores.get(i-1));
            }
            this.jugadores=lista_auxiliar;
            lista_auxiliar.clear();
        }
        }
        

    
    public Jugador getJugador_inicial(){
        for (Jugador jugador : jugadores) {
            if(jugador.isJugador_inicial()){
                return jugador;
            }
        }
        return null;

    }
    public boolean getEvasion(Enemigo enemigo, Scanner input){
        int respuesta=-1;
        int contador=0;
        for (Jugador jugador : jugadores) {
            switch (jugador.getClase()) {
                case Enums.Tipo_Clase.Picaro:
                    System.out.println(jugador.getNombre()+" como buen pícaro, puede hacer bomba de humo y evadir el combate");
                    contador++;
                    break;
                case Enums.Tipo_Clase.Chaman:
                    System.out.println(jugador.getNombre()+ " como chamán puedes evitar el combate");
                    contador++;
                    break;
                case Enums.Tipo_Clase.Explorador:
                    if(enemigo.getCaracteristicas().contains("Animal")){
                        System.out.println("El enemigo es de tipo animal y por fortuna tenéis un explorador\nEl explorador, puede darle cariño al animal y mientras vosotros huir");}
                    contador++;
                        break;
                case Enums.Tipo_Clase.Paladin:
                    if(enemigo.getCaracteristicas().contains("Diablo")){
                        System.out.println("¡Qué lástimaaaaa!Este enemigo se iba a ir una vez hecha la putada\n Pero hay un palaca en grupo así que os va a frotar la cara");
                        return false;
                    }
                default:
                   
            }           
                    
        }
        if(contador!=0){
            System.out.println("¿Vais a 'evadir' (Huir como gitanos del agua)?\n1)Si\n2)No");
            do{
                try{
                    respuesta=input.nextInt();
                    
                }catch(Exception e){
                    System.out.println("Chachos, si no queréis evadir, decirlo pijo en dieh");
                    input.nextLine();
                }
            }while(respuesta<1||respuesta>2);
            if(respuesta==1){
                return true;
            }
            return false;
            }
        return false;
    }
}



