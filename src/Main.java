
import java.util.Scanner;
/* Hay que usar este comentario para elimar todas las línes de código que sean de test
                   
                        Borra una vez finalizada la programación
*/
public class Main {
    
    //Campos
    
    
    
    
   
    private static Scanner input = new Scanner(System.in);
    
    
    public static void main(String[] args) {
        
        //Clase que contiene todos los métodos para el cálculo y las reglas
        Logica Reglas = new Logica();  
       
       //Clase donde se guarda el grupo, los enemigos y los tesoros. Debería controlar el orden del juego.
        MesaDestino Mesaprincipal = new MesaDestino(); 
        
        Reglas.leer_Txt("Portada.txt");
        Descripcion_Combate descripciones_Combate = new Descripcion_Combate();
        
        
        //Se carga el mazo de enemigos a través del "enemigos.txt"
        Mesaprincipal.ListaEnemigos();
         //Bucle comentado, para eliminar una vez terminado el programa. Se usa para comprobar que la carga de enemigos a través del txt es correcta.
        /*for (Enemigo enemigo: Mesaprincipal.getListaEnemigos()) {
            System.out.print(enemigo.getNombre());
            System.out.print(enemigo.getPG_enemigo());
            System.out.print(enemigo.getAtaque());
            System.out.print(enemigo.getNivel());
            System.out.print(enemigo.getDescripcion_Enemigo());
        }*/
               
        //pantalla = new HUD();

        Grupo Aventureros = new Grupo(input);
        //Establecer el Jefe de grupo inicial
        Reglas.jefeDeGrupo(Aventureros,1,input);

        //Este es el bucle que gestiona todo el juego. El juego va desde el nivel 1 hasta el nivel 15. Cada nivel se compone de 
        //4 salas. La salas de 1 a 3 son normales, la sala 4 es contra un Boss. Una vez matado al boss se repiten las salas pero de nivel 2...
        for(int NivelMundo=1;NivelMundo<16;NivelMundo++){
            if(NivelMundo%5==0){
                Reglas.jefeDeGrupo(Aventureros,NivelMundo,input);//En los niveles 5/10/15 se elige nuevo Jefe de grupo
            }

            for(int sala=1;sala<5;sala++){
               
                Reglas.buscarTrampas(Aventureros, Mesaprincipal, input, NivelMundo); //1_Secuencia de busqueda de trampas
                Enemigo enemigo=Reglas.patearPuerta(Aventureros,Mesaprincipal,NivelMundo,input);//2_Secuencia, crea un boss, se lee la putada y se combate.
                Reglas.combatir(enemigo,Aventureros,input,NivelMundo,descripciones_Combate,Mesaprincipal);//3_Secuencia, el combate.
                Reglas.limpieza(Aventureros,NivelMundo);//4_Limpieza, esta fase es para curarse. Como el programa no lleva las heridas de los pj imprimirá por pantalla
                //cada personaje con la habilidad de curar, el coste de la habilidad y su efecto. Preguntará a los jugadores que indiquen cuando estén listos para ir a la siguiente sala.
                              
            }

        }
            
        
 
        //Esta linea debe ir al final del programa
        System.out.println("Cerrando programa");
        input.close();
    }


}


    
  

