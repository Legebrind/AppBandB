import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;




public class Druida extends Jugador{

    private HashMap<Integer,String> Sanacion,BuenasBayas,Restablecimiento;

    private HashMap<Integer,Integer> CurarHeridas; //tabla que controla los valores de las aptitudes especiales
    private HashMap<Integer,Integer> TablaAtaque;
    private HashMap<Integer,Integer> CambiaFormas;
    private boolean isCambiaFormas,isCompaSalvaje;
    


        public Druida (Scanner input){
        setIsAtaqueMagico(false);
        iniciarNombre(input);
        setBuscaTrampas(false);
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
        iniciarBuenasBayas();
        iniciarCambiaFormas();
        isCambiaFormas=false;
        isCompaSalvaje=false;
        
       
        
        
        
                      
        
    }

    private void iniciarCambiaFormas() {
        
        
            CambiaFormas = new HashMap<Integer,Integer>();
            CambiaFormas.put(5,9);
            CambiaFormas.put(6,9);
            CambiaFormas.put(7,10);
            CambiaFormas.put(8,10);
            CambiaFormas.put(9,12);
            CambiaFormas.put(10,13);
            CambiaFormas.put(11,13);
            CambiaFormas.put(12,13);
            CambiaFormas.put(13,16);
            CambiaFormas.put(14,16);
            CambiaFormas.put(15,16);
            
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
    public int atacar(Scanner input,int nivelMundo,ArrayList<Enemigo>horda){
        String respuesta="z";
        int CompaSalvaje=2;
        //Se comprueba si tiene activao el compañero animal y se le pregunta si quiere activarlo
        if(!isCompaSalvaje){
            System.out.println("[1Chp] pa que venga un amigo muy especial a pegar contigo\n¿Te lo tomas?(S/N)");
            do{   
                try{
                    respuesta=input.nextLine();

                }catch(Exception e){
                    System.out.println("¡¡¡¡Di si o nó!!!!!Alma de Hokague");
                    input.nextLine();
                } //comprobar
            }while (respuesta.toLowerCase()!="s"&&respuesta.toLowerCase()!="n");
            if(respuesta=="s"){
                setCompaSalvaje(true); //Se activa el compañero animal y se reinicia la variable respuesta
                respuesta="z";
            }
        }
       //Si tiene compañero animal se le pregunta si quiere que ataque y se le añade el modificador del compañero al ataque
        if(isCompaSalvaje){
            System.out.println("¿Quieres que tu amigo salvaje le saque los ojos al malo? (S/N)");
            do{
                try{
                    respuesta=input.nextLine();

                }catch(Exception e){
                    System.out.println("¡¡¡¡Di si o nó!!!!!Alma de Hokague");
                    input.nextLine();
                } //comprobar
            }while (respuesta.toLowerCase()!="s"&&respuesta.toLowerCase()!="n");
        
            if(respuesta=="s"){
                if(nivelMundo>=4&&nivelMundo<7){
                    CompaSalvaje=4;
                }
                if(nivelMundo>=7&&nivelMundo<10){
                    CompaSalvaje=6;
                }
                if(nivelMundo>=10&&nivelMundo<13){
                    CompaSalvaje=8;
                }
                if(nivelMundo>=13){
                    CompaSalvaje=10;
                }
                aumentarModificador(CompaSalvaje);
            }
        }
        //A partir de este nivel puede transformarse
        if(nivelMundo>=4){
            //Si está transformado se aplica el daño directamente
            if(isCambiaFormas()){
            return CambiaFormas.get(nivelMundo)+getModificador()+getModificador_toda_la_sala();
            }
            //Si no está transformado se le pregunta si quiere transformarse
            System.out.println("¿Estás cómodo con esa piel? ¿No prefieres cambiarte ;)? [1UBE y pega como una lagartija grande]\n(S/N)");
            do{

                try{
                    respuesta=input.nextLine();

                }catch(Exception e){
                    System.out.println("¡¡¡¡Di si o nó!!!!!Alma de Hokague");
                    input.nextLine();
                } //comprobar
            }while (respuesta.toLowerCase()!="s"&&respuesta.toLowerCase()!="n");
            if(respuesta=="s"){
                setCambiaFormas(true);
                return CambiaFormas.get(nivelMundo)+getModificador()+getModificador_toda_la_sala();
            }
            
        }
        return getAtaqueBase(nivelMundo)+getModificador()+getModificador_toda_la_sala();
    }

            
    public void ataque_magico(Scanner input, int nivelMundo, ArrayList<Enemigo> horda,ArrayList<Modificador> modificadores, Grupo aventureros) {
        int respuesta = -1;
        System.out.println("¿Que ataque mágico quires hacer jipi (si, he dicho jipi)");
        if(nivelMundo<3){return;}
        if(nivelMundo>=3 && nivelMundo<8){
            System.out.println("Bien, te tomas [1UBE] y le espolvoreas un poco de serrín para que gane 1 de dureza");
        }
        
        if(nivelMundo>=8&&nivelMundo<=13){
            System.out.println("0: [1 UBE] Piel robliza de calidad(2(3 si eres de nivel 12) de dureza a un jugador)");
            System.out.println("1: [1 Chp] Tormenta fina (20 Daño a todos los enemigos)");
            do{
                try{
                    respuesta =input.nextInt();
                }catch(Exception e){
                System.out.println("¿Alma de Hokague, no sabes meter un puto número tal y como aparece en la lista?");
                input.nextLine();
                }
            }while((respuesta<0 || respuesta>1));
            switch (respuesta) {
                case 0:
                System.out.println("Bien, te tomas [1UBE] y le espolvoreas un poco de serrín de calidad para que gane 2 de dureza");
                    break;
                case 1:
                    Danno danno =new Danno();
                    danno.setCantidad(20);
                    danno.setTipo(Enums.Tipo_Ataque.Magia);
                    for (Enemigo x : horda) {
                        x.recibirDanno(danno);
                    }
                    break;
            }
        }
        if(nivelMundo>13){
            System.out.println("0: [1 UBE] Piel robliza de calidad(3 de dureza a un jugador)");
            System.out.println("1: [1 Chp] Tormenta fina (30 Daño a todos los enemigos)");
            do{
                try{
                    respuesta =input.nextInt();
                }catch(Exception e){
                System.out.println("¿Alma de Hokague, no sabes meter un puto número tal y como aparece en la lista?");
                input.nextLine();
                }
            }while((respuesta<0 || respuesta>1));
            switch (respuesta) {
                case 0:
                System.out.println("Bien, te tomas [1UBE] y le espolvoreas serrín de calidad y en cantidad para que gane 3 de dureza");
                    break;
                case 1:
                    Danno danno =new Danno();
                    danno.setCantidad(30);
                    danno.setTipo(Enums.Tipo_Ataque.Magia);
                    for (Enemigo x : horda) {
                        x.recibirDanno(danno);
                    }
                    break;
            }
        }


    }
                 
                

    

    public HashMap<Integer, String> getSanacion() {
        return Sanacion;
    }

    public void setSanacion(HashMap<Integer, String> sanacion) {
        Sanacion = sanacion;
    }

    public HashMap<Integer, String> getBuenasBayas() {
        return BuenasBayas;
    }

    public void setBuenasBayas(HashMap<Integer, String> buenasBayas) {
        BuenasBayas = buenasBayas;
    }

    public HashMap<Integer, String> getRestablecimiento() {
        return Restablecimiento;
    }

    public void setRestablecimiento(HashMap<Integer, String> restablecimiento) {
        Restablecimiento = restablecimiento;
    }

    public HashMap<Integer, Integer> getCurarHeridas() {
        return CurarHeridas;
    }

    public void setCurarHeridas(HashMap<Integer, Integer> curarHeridas) {
        CurarHeridas = curarHeridas;
    }

    public HashMap<Integer, Integer> getTablaAtaque() {
        return TablaAtaque;
    }

    public void setTablaAtaque(HashMap<Integer, Integer> tablaAtaque) {
        TablaAtaque = tablaAtaque;
    }

    public HashMap<Integer, Integer> getCambiaFormas() {
        return CambiaFormas;
    }

    public void setCambiaFormas(HashMap<Integer, Integer> cambiaFormas) {
        CambiaFormas = cambiaFormas;
    }

    public boolean isCambiaFormas() {
        return isCambiaFormas;
    }

    public void setCambiaFormas(boolean isCambiaFormas) {
        this.isCambiaFormas = isCambiaFormas;
    }  

    public boolean isCompaSalvaje() {
        return isCompaSalvaje;
    }

    public void setCompaSalvaje(boolean isCompaSalvaje) {
        this.isCompaSalvaje = isCompaSalvaje;
    }


    public void quitarbeneficios() {
        
       isCambiaFormas=false;
       isCompaSalvaje=false;
        
    }
   

}