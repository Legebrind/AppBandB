import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;




public class Sanador extends Jugador{

    private HashMap<Integer,String> Sanacion,Curacion,Restablecimiento;
    


    private HashMap<Integer,Integer> CurarHeridas; //tabla que controla los valores de las aptitudes especiales
    private HashMap<Integer,Integer> TablaAtaque,Expulsar_NM;
    
    
    //Hay que introducir fuerza de toro y proteccion.
    
 
  

    public Sanador (Scanner input){
        setIsAtaqueMagico(false);
        iniciarNombre(input);
        setBuscaTrampas(false);
        setNR(1);
        setHajugado(false);
        setClase(Enums.Tipo_Clase.Sanador);
        setSalvaciones(new ArrayList<Enums.Tipo_Salvacion>());
        addSalvaciones(Enums.Tipo_Salvacion.Voluntad);
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
        CurarHeridas.put(4,5);
        CurarHeridas.put(5,5);
        CurarHeridas.put(6,5);
        CurarHeridas.put(7,8);
        CurarHeridas.put(8,8);
        CurarHeridas.put(9,8);
        CurarHeridas.put(10,11);
        CurarHeridas.put(11,11);
        CurarHeridas.put(12,11);
        CurarHeridas.put(13,14);
        CurarHeridas.put(14,14);
        CurarHeridas.put(15,14);
    } 
    private void iniciarSanacion(){
        Sanacion=new HashMap<>();
    
        Sanacion.put(1,"[1UBE] Suprime estados negativos por valor de 1");
        Sanacion.put(2,"[1UBE] Suprime estados negativos por valor de 1");
        Sanacion.put(3,"[1UBE] Suprime estados negativos por valor de 1");
        Sanacion.put(4,"[1UBE] Suprime estados negativos por valor de 2");
        Sanacion.put(5,"[1UBE] Suprime estados negativos por valor de 2");
        Sanacion.put(6,"[1UBE] Suprime estados negativos por valor de 2");
        Sanacion.put(7,"[1UBE] Suprime estados negativos por valor de 3");
        Sanacion.put(8,"[1UBE] Suprime estados negativos por valor de 3");
        Sanacion.put(9,"[1UBE] Suprime estados negativos por valor de 3");
        Sanacion.put(10,"[1UBE] Suprime estados negativos por valor de 4");
        Sanacion.put(11,"[1UBE] Suprime estados negativos por valor de 4");
        Sanacion.put(12,"[1UBE] Suprime estados negativos por valor de 4");
        Sanacion.put(13,"[1UBE] Suprime estados negativos por valor de 5");
        Sanacion.put(14,"[1UBE] Suprime estados negativos por valor de 5");
        Sanacion.put(15,"[1UBE] Suprime estados negativos por valor de 5");
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

 
    public int atacar(Scanner input, int nivelMundo, ArrayList<Enemigo> horda) {
       return getAtaqueBase(nivelMundo)+getModificador()+getModificador_toda_la_sala();
    }

 
    
    public void quitarbeneficios() {
      return;
    }

    @Override
    public void ataque_magico(Scanner input, int nivelMundo, ArrayList<Enemigo> horda,
            ArrayList<Modificador> modificadores, Grupo aventureros) {
                int respuesta = -1;
                if(nivelMundo<5){
                    return;
                }
                System.out.println("¿Que ataque mágico quires hacer chupapiedras homeopático");
                Danno danno =new Danno();
                if(nivelMundo<9){
                    System.out.println("Bien, con astucia y elegancia te tomas [1 Chp] y le pegas, un chorrillo homeopático tuyo, al enemigo");
                    System.out.println("¿Quién será el agraciado?");
                    for(int i=0;i<horda.size();i++){
                        System.out.println(i+")"+horda.get(i).getNombre());
                    }
                    do{
                        try{
                            respuesta=input.nextInt();
                        }catch(Exception e){
                            System.out.println("¿Alma de Hokague, no sabes meter un puto número tal y como aparece en la lista?");
                            input.nextLine();
                        }
                    }while((respuesta<0 || respuesta>horda.size()));
                    danno.setCantidad(10);
                    danno.setTipo(Enums.Tipo_Ataque.Magia);
                    if((horda.get(respuesta).getCaracteristicas().get(0)=="Demonio" || horda.get(respuesta).getCaracteristicas().get(0)=="No Muerto") ||(horda.get(respuesta).getCaracteristicas().get(1)=="Demonio" || horda.get(respuesta).getCaracteristicas().get(1)=="No Muerto")){
                        danno.setCantidad(danno.getCantidad()*2);
                    } 
                    horda.get(respuesta).recibirDanno(danno);
                }
                
                if(nivelMundo>=9 && nivelMundo<13){
                    System.out.println("Bien, con astucia y elegancia te tomas [1 Chp] y le pegas, un chorrazo homeopático tuyo, al enemigo");
                    System.out.println("¿Quién será el agraciado?");
                    for(int i=0;i<horda.size();i++){
                        System.out.println(i+")"+horda.get(i).getNombre());
                    }
                    do{
                        try{
                            respuesta=input.nextInt();
                        }catch(Exception e){
                            System.out.println("¿Alma de Hokague, no sabes meter un puto número tal y como aparece en la lista?");
                            input.nextLine();
                        }
                    }while((respuesta<0 || respuesta>horda.size()));
                    danno.setCantidad(20);
                    danno.setTipo(Enums.Tipo_Ataque.Magia);
                    if((horda.get(respuesta).getCaracteristicas().get(0)=="Demonio" || horda.get(respuesta).getCaracteristicas().get(0)=="No Muerto") ||(horda.get(respuesta).getCaracteristicas().get(1)=="Demonio" || horda.get(respuesta).getCaracteristicas().get(1)=="No Muerto")){
                        danno.setCantidad(danno.getCantidad()*2);
                    } 
                    horda.get(respuesta).recibirDanno(danno);
                }
                if(nivelMundo>13){
                    System.out.println("Bien, con astucia y elegancia te tomas [1 Chp] y le pegas un buen chorrazo homeopático tuyo, al enemigo");
                    System.out.println("¿Quién será el agraciado?");
                    for(int i=0;i<horda.size();i++){
                        System.out.println(i+")"+horda.get(i).getNombre());
                    }
                    do{
                        try{
                            respuesta=input.nextInt();
                        }catch(Exception e){
                            System.out.println("¿Alma de Hokague, no sabes meter un puto número tal y como aparece en la lista?");
                            input.nextLine();
                        }
                    }while((respuesta<0 || respuesta>horda.size()));
                    danno.setCantidad(30);
                    danno.setTipo(Enums.Tipo_Ataque.Magia);
                    if((horda.get(respuesta).getCaracteristicas().get(0)=="Demonio" || horda.get(respuesta).getCaracteristicas().get(0)=="No Muerto") ||(horda.get(respuesta).getCaracteristicas().get(1)=="Demonio" || horda.get(respuesta).getCaracteristicas().get(1)=="No Muerto")){
                        danno.setCantidad(danno.getCantidad()*2);
                    } 
                    horda.get(respuesta).recibirDanno(danno);
                }
    }

    @Override
    public void fase_limpieza(int nivelMundo) {
        if(nivelMundo==4){
            setIsAtaqueMagico(true);
        }
        var output = "\n"+getNombre()+"\n\t"+CurarHeridas.get(nivelMundo)+"\n\t"+Sanacion.get(nivelMundo)+"\n\t"+Curacion.get(nivelMundo);
        if(nivelMundo > 1){
            output += "\n\t"+Restablecimiento.get(nivelMundo);
        }
        System.out.println(output);
    }

    @Override
    protected void Ritual_Brujo(int nivelMundo, Grupo aventureros, Scanner input) {
      return;
    }
    
    


 
   

}
