import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class MesaDestino  {

    private ArrayList<Enemigo> ListaEnemigos;
    private ArrayList<Objeto> ListaTesoro;
    private Random Aleatorio;
    public MesaDestino(){
       ListaEnemigos = new ArrayList <Enemigo>();
        ListaTesoro =new ArrayList <Objeto>();
        Random Aleatorio =new Random();

    }
  //Se obtiene un enemigo en función del nivel de Dungeon,y lo elimina de la listaEnemigos.
    public Enemigo getEnemigo(int NivelMundo){
        List<Enemigo> auxList = ListaEnemigos.stream()
        .filter(x->x.getNivel()==NivelMundo)
        .collect(Collectors.toList());
      int aux = Aleatorio.nextInt(0,(auxList.size())); // Corrección aquí
      Enemigo enemigo=auxList.get(aux);
      ListaEnemigos.remove(enemigo);
      return enemigo;


    }
    public Enemigo getBoss(int NivelMundo){
        Enemigo enemigo =getEnemigo(NivelMundo);
        int nAptitudes;
        switch (NivelMundo) {
            case 1:
            case 2:
            case 3:
            case 4:
                              
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
              nAptitudes=1;
              break;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
                nAptitudes=2;
                break;
            default:
                nAptitudes=3;
                      
        }
        
      return enemigo;


    }
    public void ListaEnemigos(){

        try (BufferedReader reader = new BufferedReader(new FileReader("enemigos.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                String nombre = partes[0];
                int nivel = Integer.parseInt(partes[1]);
                int ataque = Integer.parseInt(partes[2]);
                int vida = Integer.parseInt(partes[3]);
                // Crea instancias de Enemigo con estos datos
                // Agrega los enemigos a tu colección
                Enemigo enemigo =new Enemigo(nombre,nivel,ataque,vida);
                ListaEnemigos.add(enemigo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void imprimirEnemigos(){

    for(Enemigo a:ListaEnemigos){
        System.out.println("Nombre: "+a.getNombre()+"Nivel: "+a.getNivel()+"Ataque: "+a.getAtaque()+"PG: "+a.getPG_enemigo());
    }
}
    }