
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Logica {
    private Random Aleatorio;
    public Logica(){
        this.Aleatorio = new Random();
    }

    public int lanza_1D6(){
        return this.Aleatorio.nextInt(1,7);
    } 
    public void trampa(int NivelDungeon){
        if (lanza_1D6()==1){
            System.out.println("¡¡¡¡¡TRAMPA!!!!!");
            System.out.println("El daño de la trampa es: "+ NivelDungeon + " VAS" );
            System.out.println("Dolor de la trampa: 1 ficha de dolor por VAS ingerido");
        }
        else {System.out.println("No hay trampa, por esta vez ¬¬ ");}

    }

//Métodos para gestionar el turno, abarca desde secuencia1 hasta secuencia 4
public void buscarTrampas(ArrayList<Jugador> aventureros, MesaDestino mesa,Scanner input,int NivelMundo){

    //1ºMirar si hay trampa
    for (Jugador buscadortrampas : aventureros) {
        if(buscadortrampas.isBuscaTrampas()){
            System.out.println(buscadortrampas.getNombre());
        }
        System.out.println("¿Quién de los nombrados se sacrifica por el equipo y busca trampas\n Si nadie tiene huevos a buscar una trampa escribir nadie, panda de pijosprogre");
        String jugador=input.nextLine();
        input.nextLine();
        while (jugador!="nadie"|| aventureros.contains(jugador)) {
            System.out.println("Venga no me toquéis los huevos que no tengo todo el día, escribir el nombre del héroe o el de nadie");
            jugador=input.nextLine();
            input.nextLine();            
        }
        switch (jugador) {
            case "nadie":
                System.out.println("Panda de desgraciaos cobardes y borrachos mediocres\n Pues ahora toca comprobar si hay trampa y hace ¡¡¡¡booooom!!!!");
                trampa(NivelMundo);
                break;
        
            default:
                System.out.println("Ole tú coño moreno"+jugador+",bébete ese UBE bueno para evitar la trampa");
                break;
        }    
        }
    
 

  
    

}

public Enemigo patearPuerta(MesaDestino Mesaprincipal,boolean isBoss,int NivelMundo){
       //2ºPatear la puerta
       Enemigo enemigo;
       System.out.println("¡Pateas la puerta! (Como diría nuestro Miguelañez 'Con dos cojones y un palo')");
       if(isBoss){
        enemigo=Mesaprincipal.getBoss(NivelMundo);
        System.out.println("Veamos que tenemos aquí\n\n");
        System.out.println(enemigo.getNombre());
        System.out.print(enemigo.getDescripcion());
        System.out.println("Interesante....Veamos la putada\n\n");
        System.out.print(enemigo.getPutada());
       }
       else{
        enemigo=Mesaprincipal.getEnemigo(NivelMundo);
        System.out.println("Veamos que tenemos aquí\n\n");
        System.out.println(enemigo.getNombre());
        System.out.print(enemigo.getDescripcion());
        System.out.println("Interesante....Veamos la putada\n\n");
        System.out.print(enemigo.getPutada());
       }
    return enemigo;
       
}
public void combatir (Enemigo enemigo, Grupo aventureros, Scanner input,int NivelMundo,Descripcion_Combate Descripciones){
    //3º Combatir
    String respuesta;
        while(enemigo.getPG_enemigo()>0){
            //fase de ataques magicos
          for (Jugador aventurero: aventureros.getJugadores()) {
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
          for (Jugador aventurero: aventureros.getJugadores()) {
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

public void limpieza(){
        //4º Limpieza.
        //Mostrar los jugadores que pueden curar, sus costes de curación
        //Si es boss indicar el botín
}



//Establecer jefe de grupo

public void jefeDeGrupo(Grupo aventureros, int NivelMundo, Scanner input){
    if (NivelMundo==1){
        System.out.println("Los aventureros están en la taberna decidiendo quién será el jefe de grupo y brindando por el éxito en la peligrosa gesta.");
        System.out.println("SIN MEDIAR PALABRA y mirando a los ojos de los compañeros, todos brindan solemnemente un UBE (como mínimo)");
        System.out.println("Aquellos que lo desean pueden beber un VASO en vez de un UBE.");
        System.out.println("Los personajes que beban el VASO serán considerados Pretendientes y entre ellos estará el futuro Jefe de Grupo.");
        System.out.println("En caso de que un sólo jugador beba un VASO, este será el Jefe de Grupo.\n      En caso de que ningún jugador beba un VASO, no habrá Jefe de Grupo y todas las Cartas de Tesoro serán retiradas del Juego (“no jefes no comiercio”).\n      El Jugador Inicial de la primera Sala será el jugador de mayor edad.\n      En caso de que varios jugadores beban un VASO, cada uno de los pretendientes al título deberán lanzar un breve discurso de 30 segundos empezando por el jugador de más edad.\n\nUna vez han acabado de hablar, los No Pretendientes votarán a quien desean tener como Jefe de Grupo.\n\n    Votación: A la de tres, todos señalan a quien desean. El jugador que tenga más compañeros señalándole, será el elegido.");
        System.out.println("Muy bien ¿Que jugador será el ávaro MasterLuuuter");
        aventureros.mostrarInformacionEquipo();
        int i=input.nextInt();
        input.nextLine();
        while (i<0 || i>aventureros.getJugadoresMax()) {
            System.out.println("Joder macho, no ha empezao el juego y ya vais to turcios\nPon el puto número bien entre 0 y"+aventureros.getJugadoresMax());
            i=input.nextInt();
            
        }
        aventureros.getJugador(i).setJefe(true);
        System.out.println("Ole tú, Ole tú, y dice si soy yo, no voy a ser yo  "+aventureros.getJugador(i).getNombre());

    }
    else{
        System.out.println("Los aventureros están en el suelo, reventaicos, decidiendo quién será el jefe de grupo y brindando por el éxito en la peligrosa gesta.");
        System.out.println("SIN MEDIAR PALABRA y mirando a los ojos de los compañeros, todos brindan solemnemente un UBE (como mínimo)");
        System.out.println("Aquellos que lo desean pueden beber un VASO en vez de un UBE.");
        System.out.println("Los personajes que beban el VASO serán considerados Pretendientes y entre ellos estará el futuro Jefe de Grupo.");
        System.out.println("En caso de que un sólo jugador beba un VASO, este será el Jefe de Grupo.\n      En caso de que ningún jugador beba un VASO, no habrá Jefe de Grupo y todas las Cartas de Tesoro serán retiradas del Juego (“no jefes no comiercio”).\n      El Jugador Inicial de la primera Sala será el jugador de mayor edad.\n      En caso de que varios jugadores beban un VASO, cada uno de los pretendientes al título deberán lanzar un breve discurso de 30 segundos empezando por el jugador de más edad.\n\nUna vez han acabado de hablar, los No Pretendientes votarán a quien desean tener como Jefe de Grupo.\n\n    Votación: A la de tres, todos señalan a quien desean. El jugador que tenga más compañeros señalándole, será el elegido.");
        System.out.println("Muy bien ¿Que jugador será el ávaro MasterLuuuter");
        System.out.print("Si el hasta entonces Jefe de Grupo (JF previo) toma un VASO, continúa siéndolo.\n     Si el JF previo no ha bebido un VASO pueden suceder dos cosas:\n    1. Varios jugadores han bebido el VASO: Votación\n      2. Ningún jugador ha bebido el VASO: Desaparecen los Tesoros hasta que vuelva a haber\nEste nuevo jefe de grupo no cambia el orden de Jugador Incial.");
        aventureros.mostrarInformacionEquipo();
        int i=input.nextInt();
        input.nextLine();
        while (i<0 || i>aventureros.getJugadoresMax()) {
            System.out.println("Joder macho, ya vais to turcios\nPon el puto número bien entre 0 y"+aventureros.getJugadoresMax());
            i=input.nextInt();
            
        }
        aventureros.getJugador(i).setJefe(true);
        System.out.println("Ole tú, Ole tú, y dice si soy yo, no voy a ser yo  "+aventureros.getJugador(i).getNombre());

    }
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
    
    


