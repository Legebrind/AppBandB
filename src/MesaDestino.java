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
    public ArrayList<Enemigo> getListaEnemigos(){
        return this.ListaEnemigos;

    }
    public ArrayList<Objeto> getListaTesoro() {
        return ListaTesoro;
    }
    public void setListaTesoro(ArrayList<Objeto> listaTesoro) {
        ListaTesoro = listaTesoro;
    }

  //Se obtiene un enemigo en función del nivel de Dungeon,y lo elimina de la listaEnemigos.
    public Enemigo getEnemigo(int NivelMundo){
        List<Enemigo> auxList = this.ListaEnemigos.stream()
        .filter(x->x.getNivel()==NivelMundo)
        .collect(Collectors.toList());
      int aux = Aleatorio.nextInt(0,(auxList.size())); // Corrección aquí
      Enemigo enemigo=auxList.get(aux);
      this.ListaEnemigos.remove(enemigo);
      return enemigo;


    }
    public Enemigo getBoss(int NivelMundo){
        Enemigo enemigo =getEnemigo(NivelMundo);
        int nAptitudes;
        Aleatorio = new Random();
        switch (NivelMundo) {
            case 1:
            case 2:
            case 3:
            case 4:
                 nAptitudes=0;             
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
        for(int i=0;i<nAptitudes;i++){
            
            enemigo.setCaracterBoss(Aleatorio.nextInt(0,Enums.Tipo_Aptitud_Boss.values().length));
            
        }

      return enemigo;


    }
    public void ListaEnemigos(){

        try (BufferedReader reader = new BufferedReader(new FileReader("enemigos.txt"))) {
            StringBuilder contenido = new StringBuilder();
            String linea;
            while ((linea = reader.readLine()) != null) {
                contenido.append(linea).append("\n"); // Agrega el salto de línea
            }
            // Ahora 'contenido' contiene todo el párrafo. Puedes procesarlo según tus necesidades.
            String[] partes = contenido.toString().split("/");

            // Asegúrate de que haya al menos 10 campos en el párrafo antes de intentar acceder a ellos
            for (int i = 0; i < partes.length; i += 10) {
                if (i + 9 < partes.length) {
                    ArrayList<String> caracteristicas =new ArrayList<>();
                    String nombre = partes[i];
                    int nivel = Integer.parseInt(partes[i + 1]);
                    int ataque = Integer.parseInt(partes[i + 2]);
                    int vida = Integer.parseInt(partes[i + 3]);
                    String putada = partes[i + 4];
                    caracteristicas.add(partes[i + 5]);
                    caracteristicas.add(partes[i + 6]);
                    String reglaCombate = partes[i + 7];
                    int nEne = Integer.parseInt(partes[i + 8]);
                    String descEnemi = partes[i + 9];
                    // Crea instancias de Enemigo con estos datos
                    
                    
                    Enemigo enemigo = new Enemigo(nombre, nivel, ataque, vida, putada, reglaCombate, nEne, descEnemi, caracteristicas);
                    ListaEnemigos.add(enemigo);
                } 
               // else {System.err.println("Error en el párrafo: " + contenido.toString());}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
}