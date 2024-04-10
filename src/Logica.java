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
    public void buscarTrampas(Grupo aventureros, MesaDestino mesa,Scanner input,int NivelMundo){

        //1ºMirar si hay trampa
        //Comprueba si hay pj que puedan buscar trampa
        if(!aventureros.hayBuscador()){
            System.out.println(aventureros.getJugador_inicial().getNombre()+" te toca buscar trampa en cueros");
            trampa(NivelMundo); 
            return;
        }
        int contador=0;
        for (Jugador jugador : aventureros.getJugadores()) {
            if(jugador.isBuscaTrampas()){
                System.out.println(contador+") "+jugador.getNombre());
                contador++;
            }
            
        
        }
        System.out.println("69) Si nadie tiene huevos");
        int jugador=-1;
        System.out.println("\n¿Quién de los nombrados se sacrifica por el equipo y busca trampas?\nSi nadie tiene huevos a buscar una trampa sufreréis las consecuencias, panda de pijosprogre");
        do{
            try{
                jugador=input.nextInt();
                
            }catch(Exception e){
                System.out.println("enga no me toquéis los huevos que no tengo todo el día, escribir el nombre del héroe o el de nadie");
            }
            input.nextLine();
        }while(jugador<0 || ((jugador>contador)&&(jugador!=69)));

        switch (jugador) {
            case 69:
                System.out.println("Panda de desgraciaos cobardes y borrachos mediocres\nPues ahora toca comprobar si hay trampa y hace ¡¡¡¡booooom!!!!");
                //Hay que llamar aquí al jugador inicial
                System.out.println(aventureros.getJugador_inicial().getNombre()+" te toca buscar trampa en cueros");
                trampa(NivelMundo); //to do.
                break;
            default:
                System.out.println("Ole tú coño moreno "+aventureros.getJugador(jugador).getNombre()+", bébete ese UBE bueno para evitar la trampa");
        }    
    }
    
    public Enemigo patearPuerta(Grupo aventureros,MesaDestino Mesaprincipal,int NivelMundo,Scanner input){
       //Antes de patear se puede hacer el ritual del chaman
       for (Jugador pJugador : aventureros.getJugadores()) {
       
        if(pJugador.getClase()==Enums.Tipo_Clase.Chaman){
            System.out.println(pJugador.getNombre()+"Ritual de batalla [1UBE por pj y te restriegas con ellos, pa suberles el ataque,ya tu sabeh]\n¿Te hace?\n1)Si\n2)No");
            int respuesta=-1;
            do{
            
                try{
                    respuesta=input.nextInt();
                    
                }catch(Exception e){
                    System.out.println("enga no me toquéis los huevos que no tengo todo el día, ¡Di si o no!");
                }
                input.nextLine();
            }while(respuesta!=1 && respuesta!=2);
            if(respuesta==1){
                pJugador.Ritual_Brujo(NivelMundo,aventureros,input);
            }
            else{
                System.out.println("Vaya un Caquitas de chamán");
            }
        }
       }
       
        //2ºPatear la puerta
       Enemigo enemigo;
       System.out.println(aventureros.getJugador_inicial().getNombre()+"\n¡Pateas la puerta! (Como diría nuestro Miguelañez 'Con dos cojones y un palo')");
       
        enemigo=Mesaprincipal.getEnemigo(NivelMundo);
        System.out.println("Veamos que tenemos aquí\n\n");
        System.out.println(enemigo.getNombre());
        System.out.print(enemigo.getDescripcion());
        System.out.println("\nInteresante....Veamos la putada\n");
        System.out.print(enemigo.getPutada());
        int buscarOtroEnemigo=-1;
        for (Jugador jugador : aventureros.getJugadores()) {
            
            if(jugador.getClase()==Enums.Tipo_Clase.Picaro){
                if(NivelMundo>=3){
                    System.out.println(jugador.getNombre()+"[1Chp]: toma un chupito para volver y vuelve a sacar un nuevo encuentro ¡Suerte! ");
                    int respuesta=-1;
                    System.out.println(jugador.getNombre()+" ¿Usas bomba de humo y buscas otro combate?.\n1)Si\n2)No");
                    do{
                    
                        try{
                            respuesta=input.nextInt();
                            
                        }catch(Exception e){
                            System.out.println("enga no me toquéis los huevos que no tengo todo el día, ¡Di si o no!");
                        }
                        input.nextLine();
                    }while(respuesta!=1 && respuesta!=2);
                    if (respuesta==1) {
                        buscarOtroEnemigo=1;
                    }
                    System.out.println("Venga pues a darle palos a este");
                }
            }
                    
            if(jugador.getClase()==Enums.Tipo_Clase.Paladin||jugador.getClase()==Enums.Tipo_Clase.Sanador){
                if(enemigo.getCaracteristicas().contains("Demonio")){
                    System.out.println("Mala suerte chavales, no se si lo sabéis pero "+jugador.getNombre()+" es un puto Pala\nEl enemigo tiene ganas de frotarle la cara a un Palaca");
                return enemigo;
                }
            }
           
            if(jugador.getClase()==Enums.Tipo_Clase.Chaman){
                if(NivelMundo>=2){
                    System.out.println(jugador.getNombre()+"[1Chp]: toma un chupito para volver a sacar un nuevo encuentro ¡Suerte! ");
                    int respuesta=-1;
                    System.out.println(jugador.getNombre()+" ¿Usas adivinación y buscas otro combate?.\n1)Si\n2)No");
                    do{
                    
                        try{
                            respuesta=input.nextInt();
                            
                        }catch(Exception e){
                            System.out.println("enga no me toquéis los huevos que no tengo todo el día, ¡Di si o no!");
                        }
                        input.nextLine();
                    }while(respuesta!=1 && respuesta!=2);
                    if (respuesta==1) {
                        buscarOtroEnemigo=1;
                    }
                    System.out.println("Venga pues a darle palos a este");
                }
            }
        }
        if(buscarOtroEnemigo==1){
            System.out.println("Bien, veamos que se esconde detrás de la puerta número dos");
            enemigo=Mesaprincipal.getEnemigo(NivelMundo);
            System.out.println(enemigo.getNombre());
            System.out.print(enemigo.getDescripcion());
            System.out.println("\nInteresante....Veamos la putada\n");
            System.out.print(enemigo.getPutada());
            return enemigo;
        }
            
        return enemigo;  
            
    }
       
    
    
       

    public void combatir (Enemigo enemigo, Grupo aventureros, Scanner input,int NivelMundo,Descripcion_Combate Descripciones,MesaDestino mesaPrincipal){
        //3º Combatir
        for (Jugador jugador : aventureros.getJugadores()) {
            if(jugador.getClase()==Enums.Tipo_Clase.Explorador){
                    if(enemigo.getCaracteristicas().contains("Animal")){
                        int respuesta=-1;
                        System.out.println("[1Chp]: Evita combate contra un animal después de que este haya hecho su Putada\n"+jugador.getNombre()+" evitas el combate, si acarias al animalico donde el te diga.\n1)Si\n2)No");
                        do{
                        
                            try{
                                respuesta=input.nextInt();
                                
                            }catch(Exception e){
                                System.out.println("enga no me toquéis los huevos que no tengo todo el día, ¡Di si o no!");
                            }
                            input.nextLine();
                        }while(respuesta!=1 && respuesta!=2);
                        if (respuesta==1) {
                            System.out.println("****************");
                            System.out.println("Combate evitado");
                            System.out.println("****************");
                            mesaPrincipal.eliminar_enemigo_lista(enemigo);
                            for (Jugador aventurero: aventureros.getJugadores()){
                                aventurero.setModificador(0);//Se elimina los modificadores que duran un turno
                            }
                        }
                    System.out.println("Nunca me hubiera imaginado un explorador que rechazara esta oportunidad, vago y melindroso, muy mal");
                    }
            }
            if(jugador.getClase()==Enums.Tipo_Clase.Druida){
                if(enemigo.getCaracteristicas().contains("Animal")){
                    int respuesta=-1;
                    System.out.println("[1Chp]: Evita combate contra un animal después de que este haya hecho su Putada\n"+jugador.getNombre()+" evitas el combate, si acarias al animalico donde el te diga.\n1)Si\n2)No");
                    do{
                    
                        try{
                            respuesta=input.nextInt();
                            
                        }catch(Exception e){
                            System.out.println("enga no me toquéis los huevos que no tengo todo el día, ¡Di si o no!");
                        }
                        input.nextLine();
                    }while(respuesta!=1 && respuesta!=2);
                    if (respuesta==1) {
                        System.out.println("****************");
                        System.out.println("Combate evitado");
                        System.out.println("****************");
                        mesaPrincipal.eliminar_enemigo_lista(enemigo);
                        for (Jugador aventurero: aventureros.getJugadores()){
                            aventurero.setModificador(0);//Se elimina los modificadores que duran un turno
                        }
                        return;
                    }
                System.out.println("Encima de Druida, vago y jipioso");
                }
            }
                
        }
        //Aquí empieza el combate si no se puede evitar el combate.
        int atacan_todos=aventureros.getJugadoresMax();
        int respuesta=-1;
        ArrayList<Enemigo> horda= new ArrayList<Enemigo>();
        for(int i=0;i<enemigo.getnEnemigos();i++){
            horda.add(i,enemigo);
        }
        while(horda.size()>0){
            ArrayList<Modificador> modificadores=new ArrayList<>();
            //fase de ataques magicos
            for (Jugador aventurero: aventureros.getJugadores()) {
                respuesta=-1;
                if(aventurero.isIsAtaqueMagico() && !aventurero.isHajugado() && enemigo.getPG_enemigo()>0){
                    
                    System.out.println("\n"+aventurero.getNombre() +" ¿Quieres usar tu ataque mágico?\n1)Si\n2)No");
                    do{
                        try{
                            respuesta=input.nextInt();
                        }catch(Exception e){
                            System.out.println("Di s o n ¡¡¡Pijo en dioh!!!");
                        }
                        input.nextLine();
                    }while(respuesta!=1&&respuesta!=2);
                    //Aquí se produce un ataque
                    if(respuesta==1){
                        aventurero.ataque_magico(input, NivelMundo,horda,modificadores,aventureros);//Pasar HaJugado a false
                        aventurero.setHajugado(true);
                        aventurero.setHa_bebido(true);
                        atacan_todos--;
                    }
                }
            }
            //fase de ataque normal
            for (Jugador aventurero: aventureros.getJugadores()) {
                respuesta=-1;
                if(!aventurero.isHajugado() && enemigo.getPG_enemigo()>0){
                    
                    System.out.println("\n"+aventurero.getNombre() +" ¿Quieres atacar? \n1)Si\n2)No");
                    do{
                        try{
                            respuesta=input.nextInt();
                        }catch(Exception e){
                            System.out.println("Di s o n ¡¡¡Pijo en dioh!!!");
                        }
                        input.nextLine();
                    }while(respuesta!=1&&respuesta!=2);
                    //Aquí se produce un ataque
                    if(respuesta==1){
                        aventurero.ataque_fisico(input, NivelMundo,horda);//Pasar HaJugado a false
                        aventurero.setHa_bebido(true);
                        atacan_todos--;
                        
                    }
                    //Si decide no atacar consume turno.
                    aventurero.setHajugado(true);
                }

                
                //Ya han atacado todos.  
            }
            
            if(atacan_todos==0){
                for (Jugador pj : aventureros.getJugadores()) {
                    if(pj.getClase()==Enums.Tipo_Clase.Picaro){
                        System.out.println("Chachos, le habéis pegao bien y encima podéis hacer furtivo\n¿Se anima "+pj.getNombre()+" a tomar [1UBE]?\n1)Si,vamos a darle duro\n2)No, soy un ablanda brevas");
                        int furtivo=-1;
                        do{
                            try{
                                furtivo=input.nextInt();
                            }catch(Exception e){
                                System.out.println("El ataque furtivo es muy serio, di si o no pijoteras");
                                input.nextLine();
                            }
                        }while(furtivo!=1 && furtivo!=2);
                        if(furtivo==1){
                            ataque_Atfurtivo atfuritvo= new ataque_Atfurtivo();
                            Danno danno =new Danno();
                            danno.setCantidad(atfuritvo.atfurtivo(NivelMundo, pj.getModificador()));
                            danno.setTipo(Enums.Tipo_Ataque.Furtivo);
                            pj.elegirEnemigo(horda, input).recibirDanno(danno);                                
                        }
                    }
                }
            }
        for (Jugador aventurero: aventureros.getJugadores()){
                aventurero.setModificador(0);//Se elimina los modificadores que duran un turno
        }
                //Ahora ataca el enemigo
        if(enemigo.getPG_enemigo()>0){
                enemigo.getAtaque(Descripciones);
        }
        aventureros.reiniciarTurnoPj();
    }
    System.out.println("Pin pan muerto\nCawen dioh que no os morís\nCuraos pedazo de pus tumurosa");
    mesaPrincipal.eliminar_enemigo_lista(enemigo);
    }
    public void limpieza(Grupo aventureros,int nivelMundo){
            //4º Limpieza.
            //Hay que eliminar todas las ventajas al finalizar el combate
            //Druida:
                for (Jugador pj : aventureros.getJugadores()) {
                   pj.quitarbeneficios();
                }
            //Mostrar los jugadores que pueden curar, sus costes de curación
            for (Jugador pj : aventureros.getJugadores()) {
                pj.fase_limpieza(nivelMundo);
            }
            aventureros.set_siguiente_jugador_inicial();
            aventureros.ordenarJugadores();
    }
    //Establecer jefe de grupo
    public void jefeDeGrupo(Grupo aventureros, int NivelMundo, Scanner input){
        if (NivelMundo==1){
            System.out.println("Los aventureros están en la taberna decidiendo quién será el jefe de grupo y brindando por el éxito en la peligrosa gesta.");
            System.out.println("SIN MEDIAR PALABRA y mirando a los ojos de los compañeros, todos brindan solemnemente un UBE (como mínimo)");
            System.out.println("Aquellos que lo desean pueden beber un VASO en vez de un UBE.");
            System.out.println("Los personajes que beban el VASO serán considerados Pretendientes y entre ellos estará el futuro Jefe de Grupo.");
            System.out.println("En caso de que un sólo jugador beba un VASO, este será el Jefe de Grupo.\n      En caso de que ningún jugador beba un VASO, no habrá Jefe de Grupo y todas las Cartas de Tesoro serán retiradas del Juego (“no jefes no comiercio”).\n      El Jugador Inicial de la primera Sala será el jugador de mayor edad.\n      En caso de que varios jugadores beban un VASO, cada uno de los pretendientes al título deberán lanzar un breve discurso de 30 segundos empezando por el jugador de más edad.\n\nUna vez han acabado de hablar, los No Pretendientes votarán a quien desean tener como Jefe de Grupo.\n\n    Votación: A la de tres, todos señalan a quien desean. El jugador que tenga más compañeros señalándole, será el elegido.");
            System.out.println("Muy bien ¿Que jugador será el ávaro MasterLuuuter?\n");
            aventureros.mostrarInformacionEquipo();
            int respuesta=-1;
            do{
                try{
                    respuesta=input.nextInt();
                }catch(Exception e){
                    System.out.println("Elige a un jugador¡¡¡Pijo en dioh!!!");
                }
                input.nextLine();
            }while(respuesta<0||respuesta>aventureros.getJugadoresMax()-1);
            aventureros.getJugador(respuesta).setJefe(true);
            aventureros.getJugador(respuesta).setJugador_inicial(true);
            aventureros.ordenarJugadores();
            
            System.out.println("Ole tú, Ole tú, y dice si soy yo, no voy a ser yo  "+aventureros.getJugador_inicial().getNombre());

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
            int respuesta=-1;
            do{
                try{
                    respuesta=input.nextInt();
                }catch(Exception e){
                    System.out.println("Elige a un jugador¡¡¡Pijo en dioh!!!");
                }
                input.nextLine();
            }while(respuesta<0||respuesta>aventureros.getJugadoresMax());
            aventureros.getJugador(respuesta).setJefe(true);
            aventureros.getJugador(respuesta).setJugador_inicial(true);
            aventureros.ordenarJugadores();
            System.out.println("Ole tú, Ole tú, y dice si soy yo, no voy a ser yo  "+ aventureros.getJugador(respuesta).getNombre());

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

        
        
        


