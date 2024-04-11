import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;




public class Clerigo extends Jugador{

    private HashMap<Integer,String> Sanacion,Curacion,Restablecimiento;

    private HashMap<Integer,Integer> CurarHeridas; //tabla que controla los valores de las aptitudes especiales
    private HashMap<Integer,Integer> TablaAtaque,Expulsar_NM;
    


    public Clerigo (Scanner input){
        setIsAtaqueMagico(true);
        iniciarNombre(input);
        setBuscaTrampas(false);
        setNR(3);
        setHajugado(false);
        setClase(Enums.Tipo_Clase.Clerigo);
        setSalvaciones(new ArrayList<Enums.Tipo_Salvacion>());
        addSalvaciones(Enums.Tipo_Salvacion.Voluntad);
        addSalvaciones(Enums.Tipo_Salvacion.Fortaleza);
        setTipoAtaque_Fisico(new ArrayList<Enums.Tipo_Ataque>());
        addTipoAtaque_fisico(Enums.Tipo_Ataque.Contundente);
        setTablaAtaque(iniciarAtaqueBase());
        iniciarCurarHeridas();
        iniciarSanacion();
        iniciarCuracion();
        iniciarExpulsar_NM();
        iniciarRestablecimiento();
    }

    private void iniciarExpulsar_NM() {
            Expulsar_NM = new HashMap<Integer,Integer>();
            Expulsar_NM.put(1,10);
            Expulsar_NM.put(2,10);
            Expulsar_NM.put(3,15);
            Expulsar_NM.put(4,15);
            Expulsar_NM.put(5,20);
            Expulsar_NM.put(6,20);
            Expulsar_NM.put(7,25);
            Expulsar_NM.put(8,25);
            Expulsar_NM.put(9,30);
            Expulsar_NM.put(10,30);
            Expulsar_NM.put(11,35);
            Expulsar_NM.put(12,35);
            Expulsar_NM.put(13,40);
            Expulsar_NM.put(14,40);
            Expulsar_NM.put(15,45);
    } 
    

    private HashMap<Integer,Integer> iniciarAtaqueBase(){
        TablaAtaque = new HashMap<Integer,Integer>();
        TablaAtaque.put(1,4);
        TablaAtaque.put(2,4);
        TablaAtaque.put(3,4);
        TablaAtaque.put(4,5);
        TablaAtaque.put(5,5);
        TablaAtaque.put(6,5);
        TablaAtaque.put(7,6);
        TablaAtaque.put(8,6);
        TablaAtaque.put(9,6);
        TablaAtaque.put(10,7);
        TablaAtaque.put(11,7);
        TablaAtaque.put(12,7);
        TablaAtaque.put(13,8);
        TablaAtaque.put(14,8);
        TablaAtaque.put(15,8);
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
        Sanacion.put(2,"[1UBE] Suprime estados negativos por valor de 1");
        Sanacion.put(3,"[1UBE] Suprime estados negativos por valor de 1");
        Sanacion.put(4,"[1UBE] Suprime estados negativos por valor de 1");
        Sanacion.put(5,"[1UBE] Suprime estados negativos por valor de 2");
        Sanacion.put(6,"[1UBE] Suprime estados negativos por valor de 2");
        Sanacion.put(7,"[1UBE] Suprime estados negativos por valor de 2");
        Sanacion.put(8,"[1UBE] Suprime estados negativos por valor de 2");
        Sanacion.put(9,"[1UBE] Suprime estados negativos por valor de 2");
        Sanacion.put(10,"[1UBE] Suprime estados negativos por valor de 3");
        Sanacion.put(11,"[1UBE] Suprime estados negativos por valor de 3");
        Sanacion.put(12,"[1UBE] Suprime estados negativos por valor de 3");
        Sanacion.put(13,"[1UBE] Suprime estados negativos por valor de 3");
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
        Curacion.put(6,"[1Chp] Invocas comida, una rica e insuficiente Bolsa de Snacks");
        Curacion.put(7,"[1Chp] Invocas comida, una rica e insuficiente Bolsa de Snacks");
        Curacion.put(8,"[1Chp] Invocas comida, un rico y necesario Medio Sandwich por persona");
        Curacion.put(9,"[1Chp] Invocas comida, un rico y necesario Medio Sandwich por persona");
        Curacion.put(10,"[1Chp] Invocas comida, un rico y necesario Medio Sandwich por persona");
        Curacion.put(11,"[1Chp] Invocas comida, un rico y necesario Medio Sandwich por persona");
        Curacion.put(12,"[1Chp] Invocas comida, un rico y necesario Medio Sandwich por persona");
        Curacion.put(13,"[1Chp] Invocas comida, un rico y necesario Medio Sandwich por persona");
        Curacion.put(14,"[1Chp] Invocas comida, un rico y necesario Medio Sandwich por persona");
        Curacion.put(15,"[1Chp] Ole tú y tus huevos morenos que invocas comida suprema; Hamburguesa, Kebab, Pizza, Pincho de tortilla / jugador");
    }

    public String getRestablecimiento(int nivelMundo) {
        return Restablecimiento.get(nivelMundo);
    }

    public void iniciarRestablecimiento() {
        
        Restablecimiento = new HashMap<Integer, String>();
       
        Restablecimiento.put(2,"[1UBE] Permite a un Jugador ir al baño");
        Restablecimiento.put(3,"[1UBE] Permite a un Jugador ir al baño");
        Restablecimiento.put(4,"[1UBE] Permite a un Jugador ir al baño");
        Restablecimiento.put(5,"[1UBE] Permite a un Jugador ir al baño");
        Restablecimiento.put(6,"[1UBE] Permite a dos Jugadores ir al baño");
        Restablecimiento.put(7,"[1UBE] Permite a dos Jugadores ir al baño");
        Restablecimiento.put(8,"[1UBE] Permite a dos Jugadores ir al baño");
        Restablecimiento.put(9,"[1UBE] Permite a dos Jugadores ir al baño");
        Restablecimiento.put(10,"[1UBE] Permite a tres Jugadores ir al baño");
        Restablecimiento.put(11,"[1UBE] Permite a tres Jugadores ir al baño");
        Restablecimiento.put(12,"[1UBE] Permite a tres Jugadores ir al baño");
        Restablecimiento.put(13,"[1UBE] Permite a tres Jugadores ir al baño");
        Restablecimiento.put(14,"[1UBE] Permite a cuatro Jugadores ir al baño");
        Restablecimiento.put(15,"[1UBE] Permite a cuatro Jugadores ir al baño");
    }



    public int getAtaqueBase(int NivelMundo) {
        return this.TablaAtaque.get(NivelMundo);
    }
    


    public int atacar (Scanner input,int nivelMundo,ArrayList<Enemigo>horda){
        return getAtaqueBase(nivelMundo)+getModificador()+getModificador_toda_la_sala();
        }


    
    public void ataque_magico(Scanner input, int nivelMundo, ArrayList<Enemigo> horda,
            ArrayList<Modificador> modificadores, Grupo aventureros) {
        
        int respuesta = -1;

                if(nivelMundo>=2 && nivelMundo<4){
                    System.out.println("¿Que ataque mágico quires hacer cura con porra");
                    System.out.println("0: Expulsar No Muertos [1 Chp, Enciendes las luces del garito y vas echando a los NM]");
                    System.out.println("1:  Fuerza de toro [1UBE Otorgas a un jugador un bonificador de ataque]");
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
                            expulsar_NM(horda, nivelMundo);
                            break;
                        case 1:
                            fuerza_de_Toro(aventureros, input,nivelMundo);
                            break;
                    }
                }
                
                if(nivelMundo>=4){
                    System.out.println("2: Protección, otorgas a un jugador dureza");
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
                            expulsar_NM(horda, nivelMundo);
                            break;
                        case 1:
                            fuerza_de_Toro(aventureros, input,nivelMundo);
                            break;
                        case 2:
                        if(nivelMundo<9){
                            System.out.println("Pones to duro a un jugador y obtiene dureza 1");
                        }
                        if(nivelMundo>=9 && nivelMundo<14){
                            System.out.println("Te esfuerzas mucho mas que antes y pones to duro a un jugador que obtiene dureza 2");
                        }
                        if(nivelMundo>=14){
                            System.out.println("Virgen santa, ahora si que pones durísimo a un jugador con dureza 3");
                        }
                        break;
                        
                    }

                }
                else{
                    expulsar_NM(horda, nivelMundo); 
                }

    }  
    public void expulsar_NM(ArrayList<Enemigo> horda, int nivelMundo){
        Danno danno =new Danno();
        danno.setCantidad(Expulsar_NM.get(nivelMundo));
        danno.setTipo(Enums.Tipo_Ataque.Expulsar);
        for (Enemigo enemigo : horda) {
            enemigo.recibirDanno(danno);
        }
    }
    public void fuerza_de_Toro(Grupo aventureros, Scanner input,int nivelMundo){
        System.out.println("¿Quién será el agraciado que reciba tu sermón motivador?");
        aventureros.mostrarInformacionEquipo();
        int respuesta=-1;
        int fuerza=4;
        if(nivelMundo>=10 && nivelMundo<14){fuerza=6;}
        if(nivelMundo>=14){fuerza=7;}
        do{
            try{
                respuesta =input.nextInt();
            }catch(Exception e){
            System.out.println("¿Alma de Hokague, no sabes meter un puto número tal y como aparece en la lista?");
            input.nextLine();
            }
        }while (respuesta<0||respuesta>aventureros.getJugadoresMax()-1); //Comprobar la condición
        
        aventureros.getJugador(respuesta).setModificador_toda_la_sala(fuerza);
        System.out.println(aventureros.getJugador(respuesta).getNombre()+"ahora tienes un +" +fuerza+ " de daño, puedes besar al clérigo para agradecerselo");
    }

    
    public void quitarbeneficios() {
    
    }

    @Override
    public void fase_limpieza(int nivelMundo) {
        System.out.println("\n"+getNombre()+"\n\t"+CurarHeridas.get(nivelMundo)+"\n\t"+Sanacion.get(nivelMundo)+"\n\t"+Curacion.get(nivelMundo)+"\n\t"+Restablecimiento.get(nivelMundo)); 
    }

    @Override
    protected void Ritual_Brujo(int nivelMundo, Grupo aventureros, Scanner input) {
     return;
    }
 
   

}
