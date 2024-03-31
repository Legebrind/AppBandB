import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;




public class Bardo extends Jugador{

    private HashMap<Integer,String> Musica_de_Bardo,Cantares;
    private HashMap<Integer,Integer> Infundir_Valor; //tabla que controla los valores de las aptitudes especiales
    private HashMap<Integer,Integer> TablaAtaque;
    private boolean Conocimiento_de_bardo,Portento_Musical;
    
    
    
 
  

    public Bardo (Scanner input){
        setIsAtaqueMagico(true);
        
        setNR(2);
        setHajugado(false);
        setClase(Enums.Tipo_Clase.Bardo);
        setSalvaciones(new ArrayList<Enums.Tipo_Salvacion>());
        addSalvaciones(Enums.Tipo_Salvacion.Reflejos);
        addSalvaciones(Enums.Tipo_Salvacion.Voluntad);
        setTipoAtaque_Fisico(new ArrayList<Enums.Tipo_Ataque>());
        addTipoAtaque_fisico(Enums.Tipo_Ataque.Perforante);
        setTablaAtaque(iniciarAtaqueBase());
        iniciarInfundir_Valor();
        iniciarMusica_de_Bardo();
        iniciarCantares();
        
        Conocimiento_de_bardo=true;
        Portento_Musical=false;
        
        
        
                      
        
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
    
    private void iniciarInfundir_Valor(){
        Infundir_Valor = new HashMap<>();
        Infundir_Valor.put(1,1);
        Infundir_Valor.put(2,1);
        Infundir_Valor.put(3,1);
        Infundir_Valor.put(4,1);
        Infundir_Valor.put(5,2);
        Infundir_Valor.put(6,2);
        Infundir_Valor.put(7,2);
        Infundir_Valor.put(8,2);
        Infundir_Valor.put(9,3);
        Infundir_Valor.put(10,3);
        Infundir_Valor.put(11,3);
        Infundir_Valor.put(12,3);
        Infundir_Valor.put(13,4);
        Infundir_Valor.put(14,4);
        Infundir_Valor.put(15,4);
    } 
    private void iniciarMusica_de_Bardo(){
        Musica_de_Bardo=new HashMap<>();
    
        Musica_de_Bardo.put(1,"[1Chp] Todo el grupo gana Salvación FOR");
        Musica_de_Bardo.put(2,"[1Chp] Todo el grupo gana Salvación FOR");
        Musica_de_Bardo.put(3,"[1Chp] Todo el grupo gana Salvación REF / FOR");
        Musica_de_Bardo.put(4,"[1Chp] Todo el grupo gana Salvación REF / FOR");
        Musica_de_Bardo.put(5,"[1Chp] Todo el grupo gana Salvación VOL / FOR / REF");
        Musica_de_Bardo.put(6,"[1Chp] Todo el grupo gana Salvación VOL / FOR / REF");
        Musica_de_Bardo.put(7,"[1Chp] Todo el grupo gana Salvación VOL / FOR / REF");
        Musica_de_Bardo.put(8,"[1Chp] Todo el grupo gana Salvación VOL / FOR / REF");
        Musica_de_Bardo.put(9,"[1Chp] Todo el grupo gana Salvación VOL / FOR / REF");
        Musica_de_Bardo.put(10,"[1Chp] Todo el grupo gana Salvación VOL / FOR / REF");
        Musica_de_Bardo.put(11,"[1Chp] Todo el grupo gana Salvación VOL / FOR / REF");
        Musica_de_Bardo.put(12,"[1Chp] Todo el grupo gana Salvación VOL / FOR / REF");
        Musica_de_Bardo.put(13,"[1Chp] Todo el grupo gana Salvación VOL / FOR / REF");
        Musica_de_Bardo.put(14,"[1Chp] Todo el grupo gana Salvación VOL / FOR / REF");
        Musica_de_Bardo.put(15,"[1Chp] Todo el grupo gana Salvación VOL / FOR / REF");
    
    }
    public void iniciarCantares(){
        Cantares=new HashMap<>();
        Cantares.put(5,"[1Chp] Da +10 de ataque a un jugador y +5 a los jugadores adyacentes");
        Cantares.put(10,"[1Chp] Da +20 de ataque a un jugador y +10 a los jugadores adyacentes");
        Cantares.put(15,"[1Chp] Da +30 de ataque a un jugador y +15 a los jugadores adyacentes");
        
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

    public boolean isPortento_Musical() {
        return Portento_Musical;
    }

    public void setPortento_Musical(boolean portento_Musical) {
        Portento_Musical = portento_Musical;
    }
    public boolean isConocimiento_de_bardo() {
        return Conocimiento_de_bardo;
    }

}