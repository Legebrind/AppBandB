import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;




public class Chaman extends Jugador{

    private HashMap<Integer,String> Sanacion,Curacion,Restablecimiento;

    private HashMap<Integer,Integer> CurarHeridas; //tabla que controla los valores de las aptitudes especiales
    private HashMap<Integer,Integer> TablaAtaque;
    private HashMap<Integer,Ritual_Brujo> Ritual_Brujo;
    private HashMap<Integer,Maldicion_vudu> Maldicion_vudu;
    private boolean patearPuerta=true;
    private boolean despuesdePatear=true;
   
    
    //Hay que introducir Adivinaciones.
    
 
  

    public Chaman (Scanner input){
        iniciarNombre(input);
        setIsAtaqueMagico(true);
        setBuscaTrampas(false);
        setNR(1);
        setHajugado(false);
        setClase(Enums.Tipo_Clase.Chaman);
        setSalvaciones(new ArrayList<Enums.Tipo_Salvacion>());
        addSalvaciones(Enums.Tipo_Salvacion.Voluntad);
        setTipoAtaque_Fisico(new ArrayList<Enums.Tipo_Ataque>());
        addTipoAtaque_fisico(Enums.Tipo_Ataque.Perforante);
        addTipoAtaque_fisico(Enums.Tipo_Ataque.Contundente);
        setTablaAtaque(iniciarAtaqueBase());
        iniciarCurarHeridas();
        iniciarSanacion();
        iniciarCuracion();
        iniciarRitual();
        iniciarMaldicion_vudu();
        
        
        
        
        
        
                      
        
    }

    private HashMap<Integer,Integer> iniciarAtaqueBase(){
        TablaAtaque = new HashMap<Integer,Integer>();
        TablaAtaque.put(1,2);
        TablaAtaque.put(2,2);
        TablaAtaque.put(3,2);
        TablaAtaque.put(4,2);
        TablaAtaque.put(5,3);
        TablaAtaque.put(6,3);
        TablaAtaque.put(7,3);
        TablaAtaque.put(8,3);
        TablaAtaque.put(9,4);
        TablaAtaque.put(10,4);
        TablaAtaque.put(11,4);
        TablaAtaque.put(12,4);
        TablaAtaque.put(13,5);
        TablaAtaque.put(14,5);
        TablaAtaque.put(15,5);
        return TablaAtaque;
    } 
    
    private void iniciarCurarHeridas(){
        CurarHeridas = new HashMap<>();
        CurarHeridas.put(1,2);
        CurarHeridas.put(2,2);
        CurarHeridas.put(3,2);
        CurarHeridas.put(4,2);
        CurarHeridas.put(5,5);
        CurarHeridas.put(6,5);
        CurarHeridas.put(7,5);
        CurarHeridas.put(8,5);
        CurarHeridas.put(9,8);
        CurarHeridas.put(10,8);
        CurarHeridas.put(11,8);
        CurarHeridas.put(12,8);
        CurarHeridas.put(13,11);
        CurarHeridas.put(14,11);
        CurarHeridas.put(15,11);
    } 
    private void iniciarSanacion(){
        Sanacion=new HashMap<>();
    
        Sanacion.put(1,"[1UBE] Suprime estados negativos por valor de 1");
        Sanacion.put(2,"[1UBE] Suprime estados negativos por valor de 1");
        Sanacion.put(3,"[1UBE] Suprime estados negativos por valor de 1");
        Sanacion.put(4,"[1UBE] Suprime estados negativos por valor de 1");
        Sanacion.put(5,"[1UBE] Suprime estados negativos por valor de 2");
        Sanacion.put(6,"[1UBE] Suprime estados negativos por valor de 2");
        Sanacion.put(7,"[1UBE] Suprime estados negativos por valor de 2");
        Sanacion.put(8,"[1UBE] Suprime estados negativos por valor de 2");
        Sanacion.put(9,"[1UBE] Suprime estados negativos por valor de 3");
        Sanacion.put(10,"[1UBE] Suprime estados negativos por valor de 3");
        Sanacion.put(11,"[1UBE] Suprime estados negativos por valor de 3");
        Sanacion.put(12,"[1UBE] Suprime estados negativos por valor de 3");
        Sanacion.put(13,"[1UBE] Suprime estados negativos por valor de 4");
        Sanacion.put(14,"[1UBE] Suprime estados negativos por valor de 4");
        Sanacion.put(15,"[1UBE] Suprime estados negativos por valor de 4");
    }
    public void iniciarCuracion(){
        Curacion=new HashMap<>();
        Curacion.put(1,"[1Chp] Invocas comida, una rica e insuficiente Bolsa de Snacks");
        Curacion.put(2,"[1Chp] Invocas comida, una rica e insuficiente Bolsa de Snacks");
        Curacion.put(3,"[1Chp] Invocas comida, una rica e insuficiente Bolsa de Snacks");
        Curacion.put(4,"[1Chp] Invocas comida, una rica e insuficiente Bolsa de Snacks");
        Curacion.put(5,"[1Chp] Invocas comida, una rica e insuficiente Bolsa de Snacks");
        Curacion.put(6,"[1Chp] Invocas comida, un rico y necesario Medio Sandwich por persona");
        Curacion.put(7,"[1Chp] Invocas comida, un rico y necesario Medio Sandwich por persona");
        Curacion.put(8,"[1Chp] Invocas comida, un rico y necesario Medio Sandwich por persona");
        Curacion.put(9,"[1Chp] Invocas comida, un rico y necesario Medio Sandwich por persona");
        Curacion.put(10,"[1Chp] Invocas comida, un rico y necesario Medio Sandwich por persona");
        Curacion.put(11,"[1Chp] Ole tú y tus huevos morenos que invocas comida suprema; Hamburguesa, Kebab, Pizza, Pincho de tortilla / jugador");
        Curacion.put(12,"[1Chp] Ole tú y tus huevos morenos que invocas comida suprema; Hamburguesa, Kebab, Pizza, Pincho de tortilla / jugador");
        Curacion.put(13,"[1Chp] Ole tú y tus huevos morenos que invocas comida suprema; Hamburguesa, Kebab, Pizza, Pincho de tortilla / jugador");
        Curacion.put(14,"[1Chp] Ole tú y tus huevos morenos que invocas comida suprema; Hamburguesa, Kebab, Pizza, Pincho de tortilla / jugador");
        Curacion.put(15,"[1Chp] Ole tú y tus huevos morenos que invocas comida suprema; Hamburguesa, Kebab, Pizza, Pincho de tortilla / jugador");

    }

    public HashMap<Integer, String> getRestablecimiento() {
        return Restablecimiento;
    }

    public void iniciarRestablecimiento() {
        
        Restablecimiento = new HashMap<Integer, String>();
       
        Restablecimiento.put(2,"[1UBE] Permite a un Jugador ir al baño");
        Restablecimiento.put(3,"[1UBE] Permite a un Jugador ir al baño");
        Restablecimiento.put(4,"[1UBE] Permite a un Jugador ir al baño");
        Restablecimiento.put(5,"[1UBE] Permite a un Jugador ir al baño");
        Restablecimiento.put(6,"[1UBE] Permite a un Jugador ir al baño");
        Restablecimiento.put(7,"[1UBE] Permite a dos Jugadores ir al baño");
        Restablecimiento.put(8,"[1UBE] Permite a dos Jugadores ir al baño");
        Restablecimiento.put(9,"[1UBE] Permite a dos Jugadores ir al baño");
        Restablecimiento.put(10,"[1UBE] Permite a dos Jugadores ir al baño");
        Restablecimiento.put(11,"[1UBE] Permite a dos Jugadores ir al baño");
        Restablecimiento.put(12,"[1UBE] Permite a tres Jugadores ir al baño");
        Restablecimiento.put(13,"[1UBE] Permite a tres Jugadores ir al baño");
        Restablecimiento.put(14,"[1UBE] Permite a tres Jugadores ir al baño");
        Restablecimiento.put(15,"[1UBE] Permite a tres Jugadores ir al baño");
    }



    public int getAtaqueBase(int NivelMundo) {
        return this.TablaAtaque.get(NivelMundo);
    }
    public int atacar(Scanner input,int nivelMundo,ArrayList<Enemigo>horda){
        int danoBase=getAtaqueBase(nivelMundo)+getModificador()+getModificador_toda_la_sala();
        System.out.println("Bebes 1 UBE");
            return danoBase;
        }
    
    public int ataqueMagico(int nivelMundo){
        return 0;
    }

  
 
    public void ataque_magico(Scanner input, int nivelMundo, ArrayList<Enemigo> horda,
            ArrayList<Modificador> modificadores, Grupo aventureros) {
                int respuesta = -1;
                System.out.println("¿Que ataque mágico quires hacer, pequeño jublar");
                System.out.println("0:  Purgar invisibilidad[1 UBE, enciendes la linterna para ver al enemigo mucho mejor]");
                System.out.println("1:  Ritual de batalla [1UBE por pj y te restriegas con ellos, pa suberles el ataque,ya tu sabeh]");
                
                
                if(nivelMundo>=6){
                    System.out.println("2 Maldición vudú [1 Chp fresquito, le bajas daño y le quitas vida al estilo vudú]");
                    do{
                        try{
                            respuesta =input.nextInt();
                        }catch(Exception e){
                        System.out.println("¿Alma de Hokague, no sabes meter un puto número tal y como aparece en la lista?");
                        input.nextLine();
                        }
                    }while((respuesta<0|| respuesta>2));
                    switch (respuesta) {
                        case 0:
                            //Comprobar si Invisible se aplica al array características del enemigo
                            for (Enemigo enemigo : horda) {
                                for (String x : enemigo.getCaracteristicas()) {
                                    if(x=="Invisible"){x="Ninguna";}
                                }    
                            }
                            break;
                        case 1:
                        Ritual_Brujo(nivelMundo, aventureros, input);
                        break;
                        case 2:
                        maldicion_vudu(input, nivelMundo, horda);
                        break;
                        
                    }

                }
                else{
                    do{
                        try{
                            respuesta =input.nextInt();
                        }catch(Exception e){
                        System.out.println("¿Alma de Hokague, no sabes meter un puto número tal y como aparece en la lista?");
                        input.nextLine();
                        }
                    }while((respuesta<0|| respuesta>1));
                    switch (respuesta) {
                        case 0:
                            //Comprobar si Invisible se aplica al array características del enemigo
                            for (Enemigo enemigo : horda) {
                                for (String x : enemigo.getCaracteristicas()) {
                                    if(x=="Invisible"){x="Ninguna";}
                                }    
                            }
                            break;
                        case 1:
                        Ritual_Brujo(nivelMundo, aventureros, input);
                        break;
                    }
                }
    }  

    public void iniciarRitual(){
        Ritual_Brujo=new HashMap<>();
        Ritual_Brujo.put(1,new Ritual_Brujo("[1UBE x PJ]: Otorga +1 al ataque durante el próximo encuentro",1));
        Ritual_Brujo.put(2,new Ritual_Brujo("[1UBE x PJ]: Otorga +1 al ataque durante el próximo encuentro",1));
        Ritual_Brujo.put(3,new Ritual_Brujo("[1UBE x PJ]: Otorga +2 al ataque durante el próximo encuentro",2));
        Ritual_Brujo.put(4,new Ritual_Brujo("[1UBE x PJ]: Otorga +2 al ataque durante el próximo encuentro",2));
        Ritual_Brujo.put(5,new Ritual_Brujo("[1UBE x PJ]: Otorga +3 al ataque durante el próximo encuentro",3));
        Ritual_Brujo.put(6,new Ritual_Brujo("[1UBE x PJ]: Otorga +3 al ataque durante el próximo encuentro",3));
        Ritual_Brujo.put(7,new Ritual_Brujo("[1UBE x PJ]: Otorga +4 al ataque durante el próximo encuentro",4));
        Ritual_Brujo.put(8,new Ritual_Brujo("[1UBE x PJ]: Otorga +4 al ataque durante el próximo encuentro",4));
        Ritual_Brujo.put(9,new Ritual_Brujo("[1UBE x PJ]: Otorga +5 al ataque durante el próximo encuentro",5));
        Ritual_Brujo.put(10,new Ritual_Brujo("[1UBE x PJ]: Otorga +5 al ataque durante el próximo encuentro",5));
        Ritual_Brujo.put(11,new Ritual_Brujo("[1UBE x PJ]: Otorga +6 al ataque durante el próximo encuentro",6));
        Ritual_Brujo.put(12,new Ritual_Brujo("[1UBE x PJ]: Otorga +6 al ataque durante el próximo encuentro",6));
        Ritual_Brujo.put(13,new Ritual_Brujo("[1UBE x PJ]: Otorga +7 al ataque durante el próximo encuentro",7));
        Ritual_Brujo.put(14,new Ritual_Brujo("[1UBE x PJ]: Otorga +7 al ataque durante el próximo encuentro",7));
        Ritual_Brujo.put(15,new Ritual_Brujo("[1UBE x PJ]: Otorga +8 al ataque durante el próximo encuentro",8));
    }
    public void Ritual_Brujo(int nivelMundo,  Grupo aventureros, Scanner input){
        System.out.println("¿Cuantos UBES vas a beber antes de frotar tu aceite ritualítico a tus compañeros fornidos");
        int njugadores=-1;
        do{
            try{
                njugadores =input.nextInt();
                
            }catch(Exception e){
                System.out.println("¿Alma de Hokague, no sabes meter un puto número tal y como aparece en la lista?");
                input.nextLine();
            }
        }while((njugadores<=0||njugadores>aventureros.getJugadoresMax()));
        System.out.println("¿Quién será el agraciado que reciba tus aceites ritualiticos?");
        aventureros.mostrarInformacionEquipo();
        while (njugadores!=0) {
            int respuesta=0;
            do{
                try{
                    respuesta =input.nextInt();
                }catch(Exception e){
                System.out.println("¿Alma de Hokague, no sabes meter un puto número tal y como aparece en la lista?");
                input.nextLine();
                }
            }while((respuesta<0||respuesta>aventureros.getJugadoresMax()));
            
            njugadores--;
            aventureros.getJugador(respuesta).setModificador_toda_la_sala(Ritual_Brujo.get(nivelMundo).getModificador());
        }
        
        
    }
    public void iniciarMaldicion_vudu(){
        Maldicion_vudu =new HashMap<>();
        Maldicion_vudu.put(6,new Maldicion_vudu("-1 Ataque & 10 Daño a un monstruo",-1,10));
        Maldicion_vudu.put(7,new Maldicion_vudu("-1 Ataque & 10 Daño a un monstruo",-1,10));
        Maldicion_vudu.put(8,new Maldicion_vudu("-1 Ataque & 10 Daño a un monstruo",-1,10));
        Maldicion_vudu.put(9,new Maldicion_vudu("-1 Ataque & 10 Daño a un monstruo",-1,10));
        Maldicion_vudu.put(10,new Maldicion_vudu("-2 Ataque & 20 Daño a un monstruo",-2,20));
        Maldicion_vudu.put(11,new Maldicion_vudu("-2 Ataque & 20 Daño a un monstruo",-2,20));
        Maldicion_vudu.put(12,new Maldicion_vudu("-2 Ataque & 20 Daño a un monstruo",-2,20));
        Maldicion_vudu.put(13,new Maldicion_vudu("-2 Ataque & 20 Daño a un monstruo",-2,20));
        Maldicion_vudu.put(14,new Maldicion_vudu("-3 Ataque & 30 Daño a un monstruo",-3,30));
        Maldicion_vudu.put(15,new Maldicion_vudu("-3 Ataque & 30 Daño a un monstruo",-3,30));
       

    }
    
    public void maldicion_vudu(Scanner input, int nivelMundo, ArrayList<Enemigo> horda){
        System.out.println("Elige al enemigo que quieres maldecir con tu mirada sesi,zalamera y sobre todo vizca");
        for(int i=0;i<=horda.size();i++){
            System.out.println(i+")  "+horda.get(i).getNombre());
        }
        int respuesta=0;
            do{
                try{
                    respuesta =input.nextInt();
                }catch(Exception e){
                System.out.println("¿Alma de Hokague, no sabes meter un puto número tal y como aparece en la lista?");
                input.nextLine();
                }
            }while((respuesta<0||respuesta>horda.size()));
            //Modifica el ataque del enemigo
            horda.get(respuesta).setAtaque(horda.get(respuesta).getAtaque() - Maldicion_vudu.get(nivelMundo).getModificador());
            //Hace daño al enemigo
            Danno danno= new Danno();
            danno.setCantidad(Maldicion_vudu.get(nivelMundo).getDanno());
            danno.setTipo(Enums.Tipo_Ataque.Magia);
            horda.get(respuesta).recibirDanno(danno);

    }

    @Override
    public void quitarbeneficios() {
       
    }
}