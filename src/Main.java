import java.util.Scanner;
/* Hay que usar este comentario para elimar todas las línes de código que sean de test
                   
                        Borra una vez finalizada la programación
*/
public class Main {
    
    //Campos
    private boolean Juego; 
    private int Nivel_de_Mundo;
    private Logica Reglas;
    private MesaDestino Mesaprincipal;
    private Grupo Aventureros;
    private static HUD pantalla;
    private static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        //Clase que contiene todos los métodos para el cálculo y las reglas
        Logica Reglas = new Logica();  
       
       //Clase donde se guarda el grupo, los enemigos y los tesoros. Debería controlar el orden del juego.
        MesaDestino Mesaprincipal = new MesaDestino(); 
        
        Reglas.leer_Txt("Portada.txt");
        boolean Juego = true;
        int Nivel_de_Mundo = 1;
        
        //Se carga el mazo de enemigos a través del "enemigos.txt"
        Mesaprincipal.ListaEnemigos();
        //Borra una vez finalizada la programación
        Mesaprincipal.imprimirEnemigos(); //este método es solo para comprobar que todo ha ido bien
        pantalla = new HUD();

        Grupo Aventureros = new Grupo(input);
        Aventureros.mostrarInformacionEquipo();//Borra una vez finalizada la programación

 
        //Esta linea debe ir al final del programa
        System.out.println("Cerrando programa");
        input.close();
    }
}

    
    

