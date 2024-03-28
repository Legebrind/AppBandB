public class Main {
    
    //Campos
    private boolean Juego; 
    private int Nivel_de_Mundo;
    private Logica Reglas;
    private MesaDestino Mesaprincipal;
    private Grupo Aventureros;
  
    
    public static void main(String[] args) {
        Logica Reglas = new Logica();
        MesaDestino Mesaprincipal = new MesaDestino();
        
        Reglas.leer_Txt("Portada.txt");
        boolean Juego=true;
        int Nivel_de_Mundo=1;
        Reglas = new Logica();
        Mesaprincipal = new MesaDestino();
        Mesaprincipal.ListaEnemigos();
        Mesaprincipal.imprimirEnemigos();
        Grupo Aventureros =new Grupo();

        
    }

    
    }

