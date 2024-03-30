import java.util.ArrayList;
import java.util.Scanner;
/* Hay que usar este comentario para elimar todas las línes de código que sean de test
                   
                        Borra una vez finalizada la programación
*/
public class Main {
    
    //Campos
    private static boolean Juego; 
    private static int NivelMundo;
    private static Logica Reglas;
    private static MesaDestino Mesaprincipal;
    private static Grupo Aventureros;
    private static HUD pantalla;
    private static Scanner input = new Scanner(System.in);
    private static Descripcion_Combate Descripciones;
    
    public static void main(String[] args) {
        
        //Clase que contiene todos los métodos para el cálculo y las reglas
        Logica Reglas = new Logica();  
       
       //Clase donde se guarda el grupo, los enemigos y los tesoros. Debería controlar el orden del juego.
        MesaDestino Mesaprincipal = new MesaDestino(); 
        
        Reglas.leer_Txt("Portada.txt");
        Juego = true;
        NivelMundo = 1;
        
        //Se carga el mazo de enemigos a través del "enemigos.txt"
        Mesaprincipal.ListaEnemigos();
         
        for (Enemigo enemigo: Mesaprincipal.getListaEnemigos()) {
            System.out.print(enemigo.getNombre());
            System.out.print(enemigo.getNivel());
            System.out.print(enemigo.getDescripcion_Enemigo());
        }
               
        pantalla = new HUD();

        Grupo Aventureros = new Grupo(input);
        //Establecer el Jefe de grupo inicial
        Reglas.jefeDeGrupo(Aventureros,1,input);
        for(int NivelMundo=1;NivelMundo<16;NivelMundo++){
            if(NivelMundo%5==0){
                Reglas.jefeDeGrupo(Aventureros,NivelMundo,input);//En los niveles 5/10/15 se elige nuevo Jefe de grupo
            }

            for(int sala=1;sala<5;sala++){
                Reglas.buscarTrampas(Aventureros.getJugadores(), Mesaprincipal, input, NivelMundo); //1_Secuencia de busqueda de trampas
                boolean isBoss=sala==4;
                Enemigo enemigo=Reglas.patearPuerta(Mesaprincipal,isBoss,NivelMundo);//2_Secuencia, crea un boss, se lee la putada y se combate.
                Reglas.combatir(enemigo,Aventureros,input,NivelMundo,Descripciones);//3_Secuencia, el combate.
                Reglas.limpieza();//4_Limpieza;
                              
            }

        }
            
        
 
        //Esta linea debe ir al final del programa
        System.out.println("Cerrando programa");
        input.close();
    }
}


    
    

