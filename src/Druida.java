import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;




public class Druida extends Jugador{

    private HashMap<Integer,String> Sanacion,BuenasBayas,Restablecimiento;

    private HashMap<Integer,Integer> CurarHeridas; //tabla que controla los valores de las aptitudes especiales
    private HashMap<Integer,Integer> TablaAtaque;
    private HashMap<Integer,CambiaFormas> CambiaFormas;
    private boolean PurgarInvisibilidad;//Hay que ver como establecer esta habilidad
    
    //Hay que introducir fuerza de toro y proteccion.
    
 
  

    public Druida (Scanner input){
        setIsAtaqueMagico(false);
        
        setNR(2);
        setHajugado(false);
        setClase(Enums.Tipo_Clase.Druida);
        setSalvaciones(new ArrayList<Enums.Tipo_Salvacion>());
        addSalvaciones(Enums.Tipo_Salvacion.Voluntad);
        addSalvaciones(Enums.Tipo_Salvacion.Fortaleza);
        setTipoAtaque_Fisico(new ArrayList<Enums.Tipo_Ataque>());
        addTipoAtaque_fisico(Enums.Tipo_Ataque.Contundente);
        setTablaAtaque(iniciarAtaqueBase());
        iniciarCurarHeridas();
        iniciarSanacion();
        iniciarBuenasBayas();
        iniciarCambiaFormas();
        
        
        PurgarInvisibilidad=true;
        
        
        
                      
        
    }

    private void iniciarCambiaFormas() {
        
        
            CambiaFormas = new HashMap<Integer,CambiaFormas>();
            CambiaFormas.put(1,10);
            CambiaFormas.put(2,10);
            CambiaFormas.put(3,15);
            CambiaFormas.put(4,15);
            CambiaFormas.put(5,20);
            CambiaFormas.put(6,20);
            CambiaFormas.put(7,25);
            CambiaFormas.put(8,25);
            CambiaFormas.put(9,30);
            CambiaFormas.put(10,30);
            CambiaFormas.put(11,35);
            CambiaFormas.put(12,35);
            CambiaFormas.put(13,40);
            CambiaFormas.put(14,40);
            CambiaFormas.put(15,45);
            
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
        CurarHeridas.put(5,2);
        CurarHeridas.put(6,5);
        CurarHeridas.put(7,5);
        CurarHeridas.put(8,5);
        CurarHeridas.put(9,5);
        CurarHeridas.put(10,5);
        CurarHeridas.put(11,8);
        CurarHeridas.put(12,8);
        CurarHeridas.put(13,8);
        CurarHeridas.put(14,8);
        CurarHeridas.put(15,8);
    } 
   
    public void iniciarBuenasBayas(){
        BuenasBayas=new HashMap<>();
        BuenasBayas.put(1,"[1Chp] Invocas una bolsa de frutos secos, y ya, ya podrías aprender de tu amigo el clérigo");
        BuenasBayas.put(2,"[1Chp] Invocas una bolsa de frutos secos, y ya, ya podrías aprender de tu amigo el clérigo");
        BuenasBayas.put(3,"[1Chp] Invocas una bolsa de frutos secos, y ya, ya podrías aprender de tu amigo el clérigo");
        BuenasBayas.put(4,"[1Chp] Invocas una bolsa de frutos secos, y ya, ya podrías aprender de tu amigo el clérigo");
        BuenasBayas.put(5,"[1Chp] Invocas una bolsa de frutos secos, y ya, ya podrías aprender de tu amigo el clérigo");
        BuenasBayas.put(6,"[1Chp] Invocas una bolsa de frutos secos, y ya, ya podrías aprender de tu amigo el clérigo");
        BuenasBayas.put(7,"[1Chp] Invocas una bolsa de frutos secos, y ya, ya podrías aprender de tu amigo el clérigo");
        BuenasBayas.put(8,"[1Chp] Invocas una bolsa de frutos secos, y ya, ya podrías aprender de tu amigo el clérigo");
        BuenasBayas.put(9,"[1Chp] Invocas una bolsa de frutos secos, y ya, ya podrías aprender de tu amigo el clérigo");
        BuenasBayas.put(10,"[1Chp] Invocas una bolsa de frutos secos, y ya, ya podrías aprender de tu amigo el clérigo");
        BuenasBayas.put(11,"[1Chp] Invocas una bolsa de frutos secos, y ya, ya podrías aprender de tu amigo el clérigo");
        BuenasBayas.put(12,"[1Chp] Invocas una bolsa de frutos secos, y ya, ya podrías aprender de tu amigo el clérigo");
        BuenasBayas.put(13,"[1Chp] Invocas una bolsa de frutos secos, y ya, ya podrías aprender de tu amigo el clérigo");
        BuenasBayas.put(14,"[1Chp] Invocas una bolsa de frutos secos, y ya, ya podrías aprender de tu amigo el clérigo");
        BuenasBayas.put(15,"[1Chp] Invocas una bolsa de frutos secos, y ya, ya podrías aprender de tu amigo el clérigo");

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