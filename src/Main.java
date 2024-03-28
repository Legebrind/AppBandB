import java.util.Scanner;

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
        Logica Reglas = new Logica();
        MesaDestino Mesaprincipal = new MesaDestino();
        Reglas.leer_Txt("Portada.txt");
        boolean Juego = true;
        int Nivel_de_Mundo = 1;
        Reglas = new Logica();
        Mesaprincipal = new MesaDestino();
        Mesaprincipal.ListaEnemigos();
        Mesaprincipal.imprimirEnemigos();
        pantalla = new HUD();

        Grupo Aventureros = new Grupo();

        System.out.println("¿Cuantos son los cabestros que van darlo todo por nada mas que diversión inmunda?");
        int njugadores = 0;
        njugadores = input.nextInt();
        input.nextLine();
        for (int i = 0; i < njugadores; i++) {
            Aventureros.setJugador(i, input);
        }
        //Esta linea debe ir al final del programa
        System.out.println("Cerrando programa");
        input.close();
    }
}

    
    

