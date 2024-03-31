import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;




public class Paladin extends Jugador{

    private HashMap<Integer,String> Sanacion,Curacion,Restablecimiento;

    private HashMap<Integer,Integer> Imposicion_Manos; //tabla que controla los valores de las aptitudes especiales
    private HashMap<Integer,Integer> TablaAtaque,Expulsar_NM;
    private boolean PurgarInvisibilidad;//Hay que ver como establecer esta habilidad
    
    //Hay que introducir fuerza de toro y proteccion.
    
 
  

    public Paladin (Scanner input){
        setIsAtaqueMagico(true);
        iniciarNombre(input);
        setBuscaTrampas(false);
        setNR(3);
        setHajugado(false);
        setClase(Enums.Tipo_Clase.Paladin);
        setSalvaciones(new ArrayList<Enums.Tipo_Salvacion>());
        addSalvaciones(Enums.Tipo_Salvacion.Voluntad);
        addSalvaciones(Enums.Tipo_Salvacion.Fortaleza);
        setTipoAtaque_Fisico(new ArrayList<Enums.Tipo_Ataque>());
        addTipoAtaque_fisico(Enums.Tipo_Ataque.Contundente);
        setTablaAtaque(iniciarAtaqueBase());
        iniciarImposicion_Manos();
        iniciarSanacion();
        iniciarCuracion();
        iniciarExpulsar_NM();
        
        
        PurgarInvisibilidad=true;
        
        
        
                      
        
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
    
    private void iniciarImposicion_Manos(){
        Imposicion_Manos = new HashMap<>();
        
        
        Imposicion_Manos.put(3,2);
        Imposicion_Manos.put(4,2);
        Imposicion_Manos.put(5,3);
        Imposicion_Manos.put(6,3);
        Imposicion_Manos.put(7,4);
        Imposicion_Manos.put(8,4);
        Imposicion_Manos.put(9,5);
        Imposicion_Manos.put(10,5);
        Imposicion_Manos.put(11,6);
        Imposicion_Manos.put(12,6);
        Imposicion_Manos.put(13,7);
        Imposicion_Manos.put(14,7);
        Imposicion_Manos.put(15,8);
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
        Restablecimiento.put(6,"[1UBE] Permite a un Jugador ir al baño");
        Restablecimiento.put(7,"[1UBE] Permite a un Jugador ir al baño");
        Restablecimiento.put(8,"[1UBE] Permite a un Jugador ir al baño");
        Restablecimiento.put(9,"[1UBE] Permite a un Jugador ir al baño");
        Restablecimiento.put(10,"[1UBE] Permite a un Jugador ir al baño");
        Restablecimiento.put(11,"[1UBE] Permite a un Jugador ir al baño");
        Restablecimiento.put(12,"[1UBE] Permite a un Jugador ir al baño");
        Restablecimiento.put(13,"[1UBE] Permite a un Jugador ir al baño");
        Restablecimiento.put(14,"[1UBE] Permite a un Jugador ir al baño");
        Restablecimiento.put(15,"[1UBE] Permite a un Jugador ir al baño");
    }



    public int getAtaqueBase(int NivelMundo) {
        return this.TablaAtaque.get(NivelMundo);
    }
    public int atacar(Scanner input,int nivelMundo){
        
        int danoBase=getAtaqueBase(nivelMundo);
        //Preguntas
    
        System.out.println("Te rajas por no beber un chupito y golpeas sin usar todo tu potencial\nHaces "+danoBase+" de daño (paupérrimo)");
        System.out.println("Bebes 1 UBE");
            return danoBase;
            
        }
    
    public int ataqueMagico(int nivelMundo){
        return 0;
    }

    @Override
    public Danno ataque_fisico(Scanner input, int nivelMundo, ArrayList<Enemigo> horda) {
        Danno danno = new Danno();
        System.out.println(getNombre()+"es hora de hacer cosas de esas de bardo");
        int ataque =atacar(input, nivelMundo);
        danno.setCantidad(ataque);
        if(getTipoAtaque_Fisico().size()==1){
          danno.setTipo(getTipoAtaque_Fisico().get(0));
        }
        else{
            System.out.println("¿Que tipo de ataque quieres usar?");
            for (int i=0; i<=getTipoAtaque_Fisico().size();i++) {
                    System.out.println(i+")"+getTipoAtaque_Fisico().get(i));
                }
            ataque =input.nextInt();
            input.nextLine();
            while (ataque<0 || ataque>getTipoAtaque_Fisico().size()) {
                System.out.println("No me toques los cojones y pon el número bien, que no es tan difícil pijo en dioh");
                ataque=input.nextInt();
                input.nextLine();
            }
            danno.setTipo(getTipoAtaque_Fisico().get(ataque));

        };
        return danno;
    }
    @Override
    public Danno ataque_magico(Scanner input, int nivelMundo, ArrayList<Enemigo> horda) {
        // TODO Auto-generated method stub
        return null;
    }  

 
   

}