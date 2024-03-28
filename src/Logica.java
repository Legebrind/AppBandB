
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class Logica {
    private Random Aleatorio;
    public Logica(){
        Random Aleatorio = new Random();
    }

   public int tirarDado(){
        return Aleatorio.nextInt(1,7);

   } 
   public void trampa(int NivelDungeon){
    if (tirarDado()==1){
        System.out.println("¡¡¡¡¡TRAMPA!!!!!");
        System.out.println("El daño de la trampa es: "+ NivelDungeon + " VAS" );
        System.out.println("Dolor de la trampa: 1 ficha de dolor por VAS ingerido");

    }
    else {System.out.println("No hay trampa, por esta vez");}

   }


public void secuencia(Jugador Jp, MesaDestino Mesa){
    int aux=0;
Scanner sc=new Scanner(System.in);
    System.out.println("¿"+Jp.getNombre()+",estas preparado?");
    String a=sc.nextLine();
    while(a!="si" || a!="SI" && aux<=5){
        if(a=="no" || a=="No"||a=="NO"){
            System.out.println("Pues si tu no quieres seguir jugando yo tampoco");
            //Mesa.FinDelJuego();
        }
        System.out.println("No entiendo nada de lo que dices");
        System.out.println("¡DI SI O NO!");
    }

    System.out.println(Jp.getNombre()+" te diriges a la mesa del destino para enfrentarte a ");
    sc.close();

}

public void leer_Txt(String txt){

   
            try {
                File archivo = new File(txt);
                Scanner scanner = new Scanner(archivo);
    
                while (scanner.hasNextLine()) {
                    String linea = scanner.nextLine();
                    System.out.println(linea);
                }
    
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    
    


