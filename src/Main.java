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
        boolean Juego = true;
        NivelMundo = 1;
        
        //Se carga el mazo de enemigos a través del "enemigos.txt"
        Mesaprincipal.ListaEnemigos();
        //Borra una vez finalizada la programación
        Mesaprincipal.imprimirEnemigos(); //este método es solo para comprobar que todo ha ido bien
        pantalla = new HUD();

        Grupo Aventureros = new Grupo(input);
        Aventureros.mostrarInformacionEquipo();//Borra una vez finalizada la programación
        
        for(int i=1;i<16;i++){
            NivelMundo=i;
            for(int j=1;j<5;j++){
                if(j==4){
                    combatir(Mesaprincipal.getBoss(NivelMundo));
                }
                    combatir(Mesaprincipal.getEnemigo(NivelMundo));

            }
        }
 
        //Esta linea debe ir al final del programa
        System.out.println("Cerrando programa");
        input.close();
    }



    

    public static void combatir(Enemigo enemigo){
        String respuesta;
        while(enemigo.getPG_enemigo()>0){
            //fase de ataques magicos
          for (Jugador aventurero: Aventureros.getJugadores()) {
            if(aventurero.isIsAtaqueMagico() && !aventurero.isHajugado() && enemigo.getPG_enemigo()>0){
                
                System.out.println(aventurero.getNombre() +"¿Quieres usar tu ataque mágico? (S/N)");
                respuesta=input.nextLine();
                input.nextLine();
                while(respuesta.toLowerCase()!="s" && respuesta.toLowerCase()!="n"){
                    System.out.println("Di s o n ¡¡¡Pijo en dioh!!!");
                    respuesta=input.nextLine();
                    input.nextLine();
                }//Aquí se produce un ataque
                if(respuesta.toLowerCase()=="s"){
                    enemigo.setPG_enemigo(enemigo.getPG_enemigo()-aventurero.ataqueMagico(NivelMundo));//Pasar HaJugado a false
                    aventurero.setHajugado(true);
                }
                    
                
            }
            
          }
          //fase de ataque normal
          for (Jugador aventurero: Aventureros.getJugadores()) {
            if(!aventurero.isHajugado() && enemigo.getPG_enemigo()>0){
                
                System.out.println(aventurero.getNombre() +"¿Quieres atacar? (S/N)");
                respuesta=input.nextLine();
                input.nextLine();
                while(respuesta.toLowerCase()!="s" && respuesta.toLowerCase()!="n"){
                    System.out.println("Di s o n ¡¡¡Pijo en dioh!!!");
                    respuesta=input.nextLine();
                    input.nextLine();
                }//Aquí se produce un ataque
                if(respuesta.toLowerCase()=="s"){
                    enemigo.setPG_enemigo(enemigo.getPG_enemigo()-aventurero.atacar(input,NivelMundo));//Pasar HaJugado a false
                    aventurero.setHajugado(true);
                }
                //Si decide no atacar consume turno.
                else{aventurero.setHajugado(true);}
                }
                //Ya han atacado todos.  
          
        
            }
            //Ahora ataca el enemigo
            if(enemigo.getPG_enemigo()>0){
                enemigo.getAtaque(Descripciones);
            }
        }
        System.out.println("Pin pan muerto\n Cawen dioh que no os morís\n Curaos pedazo de pus tumurosa");


    }
    

}

    
    

