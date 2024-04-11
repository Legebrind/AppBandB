import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;




public class Paladin extends Jugador{

    private HashMap<Integer,String> Restablecimiento;
    private HashMap<Integer,Integer>Tabla_MD;
    private int Contador_MD;
    private HashMap<Integer,Integer> Imposicion_Manos; //tabla que controla los valores de las aptitudes especiales
    private HashMap<Integer,Integer> TablaAtaque,Expulsar_NM;
    


    public Paladin (Scanner input){
        setIsAtaqueMagico(false);
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
        iniciarExpulsar_NM();
        iniciarTabla_MD();
         
    }
   

    private void iniciarExpulsar_NM() {
            Expulsar_NM = new HashMap<Integer,Integer>();
            Expulsar_NM.put(4,10);
            Expulsar_NM.put(5,10);
            Expulsar_NM.put(6,10);
            Expulsar_NM.put(7,10);
            Expulsar_NM.put(8,20);
            Expulsar_NM.put(9,20);
            Expulsar_NM.put(10,20);
            Expulsar_NM.put(11,20);
            Expulsar_NM.put(12,30);
            Expulsar_NM.put(13,30);
            Expulsar_NM.put(14,30);
            Expulsar_NM.put(15,30);
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
    public void iniciarTabla_MD(){
        Tabla_MD = new HashMap<Integer,Integer>();
        Tabla_MD.put(1,4);
        Tabla_MD.put(2,4);
        Tabla_MD.put(3,5);
        Tabla_MD.put(4,5);
        Tabla_MD.put(5,5);
        Tabla_MD.put(6,5);
        Tabla_MD.put(7,6);
        Tabla_MD.put(8,6);
        Tabla_MD.put(9,6);
        Tabla_MD.put(10,6);
        Tabla_MD.put(11,7);
        Tabla_MD.put(12,7);
        Tabla_MD.put(13,7);
        Tabla_MD.put(14,7);
        Tabla_MD.put(15,8);
        

    }


    public int getAtaqueBase(int NivelMundo) {
        return this.TablaAtaque.get(NivelMundo);
    }
    public int atacar(Scanner input,int nivelMundo,ArrayList<Enemigo>horda){
       
        int respuesta=-1;
        if(Tabla_MD.get(nivelMundo)>getContador_MD()){
            for (Enemigo enemigo : horda) {
                for (String x : enemigo.getCaracteristicas()) {
                    if(x=="Demonio"){
                        System.out.println(enemigo.getNombre()+"es un demonio, lo que quiere decir que\n");
                        System.out.println("hay un demonio con vida y puedes castigarle ¿Castigamos? \n0)=Si\n1)=No");
                        do{
                            try{
                                respuesta =input.nextInt();
                            }catch(Exception e){//comprobar que no afecte respuesta del if anterior
                            System.out.println("¿Alma de Hokague, no sabes meter un puto número tal y como aparece en la lista?");
                            }
                            input.nextLine();
                        }while((respuesta<0|| respuesta>1));
                        if(respuesta==0){
                            aumentarModificador((nivelMundo/2)+1);
                            setContador_MD(getContador_MD()+1);
                            return getAtaqueBase(nivelMundo)+getModificador()+getModificador_toda_la_sala();
                        }
                    }
                }
            }
        }
        return getAtaqueBase(nivelMundo)+getModificador()+getModificador_toda_la_sala();
    }
        
    public int getContador_MD() {
        return Contador_MD;
    }

    public void setContador_MD(int contador_MD) {
        Contador_MD = contador_MD;
    }
    public void expulsar_NM(ArrayList<Enemigo> horda, int nivelMundo){
        if(nivelMundo>=4){
            Danno danno =new Danno();
            danno.setCantidad(Expulsar_NM.get(nivelMundo));
            danno.setTipo(Enums.Tipo_Ataque.Expulsar);
            for (Enemigo enemigo : horda) {
                enemigo.recibirDanno(danno);
            }
        }
    }

 
    public void ataque_magico(Scanner input, int nivelMundo, ArrayList<Enemigo> horda,
            ArrayList<Modificador> modificadores, Grupo aventureros) {
       System.out.println("Muy bien señorito, expulsas muy bien");
       expulsar_NM(horda, nivelMundo);
    }

  
    public void quitarbeneficios() {
        setContador_MD(0);
    }
    public HashMap<Integer, Integer> getTabla_MD() {
        return Tabla_MD;
    }

    public void setTabla_MD(HashMap<Integer, Integer> tabla_MD) {
        Tabla_MD = tabla_MD;
    }

    @Override
    public void fase_limpieza(int nivelMundo) {
        if(nivelMundo==3){
            setIsAtaqueMagico(true);
        }
        System.out.println("\n"+getNombre()+"\n\t"+Imposicion_Manos.get(nivelMundo)+"\n\t"+Restablecimiento.get(nivelMundo)); 
    }

    @Override
    protected void Ritual_Brujo(int nivelMundo, Grupo aventureros, Scanner input) {
      return;
    }


}
