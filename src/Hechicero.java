//Para poder determinar los PG de la clase es necesario
//crear una clase TablaPG en la mesa y llamar al metodo
//Hechicero.iniciarPG("TablaPG.getPg(Nivel_de_Mundo,NR)")
//Faltan las aptitudes especiales
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



public class Hechicero extends Jugador {
    private HashMap<Integer,Integer> Energia_Arcana;
   
    private HashMap<Integer,Integer> TablaAtaque;
    private boolean Canalizacion;
    
    
    
    public Hechicero (Scanner input){
        iniciarNombre(input);
        setIsAtaqueMagico(true);
        setBuscaTrampas(false);
        setNR(1);
        setHajugado(false);
        setClase(Enums.Tipo_Clase.Hechicero);
        setTablaAtaque(new HashMap<Integer,Integer>());
        
        setSalvaciones(new ArrayList<Enums.Tipo_Salvacion>());
        addSalvaciones(Enums.Tipo_Salvacion.Voluntad);
        setTipoAtaque_Fisico(new ArrayList<Enums.Tipo_Ataque>());
        addTipoAtaque_fisico(Enums.Tipo_Ataque.Contundente);
        setTablaAtaque(iniciarAtaqueBase());
        Energia_Arcana();
        Canalizacion=false;
                      
        
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
    
    
    

  private void Energia_Arcana(){
    Energia_Arcana = new HashMap<>();
    addTipoAtaque_fisico(Enums.Tipo_Ataque.Adistancia);
    //Este bonificador solo se aplica cuando bebe un UBE, añade esta cantidad al ataque base
    Energia_Arcana.put(1,10);
    Energia_Arcana.put(2,10);
    Energia_Arcana.put(3,10);
    Energia_Arcana.put(4,20);
    Energia_Arcana.put(5,20);
    Energia_Arcana.put(6,20);
    Energia_Arcana.put(7,30);
    Energia_Arcana.put(8,30);
    Energia_Arcana.put(9,30);
    Energia_Arcana.put(10,40);
    Energia_Arcana.put(11,40);
    Energia_Arcana.put(12,40);
    Energia_Arcana.put(13,50);
    Energia_Arcana.put(14,50);
    Energia_Arcana.put(15,50);

  }
    
   

    public int getAtaqueBase(int NivelMundo) {
        return this.TablaAtaque.get(NivelMundo);
    }
    public int atacar(Scanner input,int nivelMundo,ArrayList<Enemigo>horda){
        return getAtaqueBase(nivelMundo)+getModificador()+getModificador_toda_la_sala();
    }
    public void ataque_magico(Scanner input, int nivelMundo, ArrayList<Enemigo> horda,ArrayList<Modificador> modificadores, Grupo aventureros) {
                int respuesta = -1;

                if(nivelMundo<3){
                    System.out.println("¿Que ataque mágico quires hacer Hechicerdo?");
                    System.out.println("0: Energía arcana [1 Chp, y le enchufas con un cable pelao trifásico]");
                    System.out.println("1:  Purgar invisibilidad [1UBE Otorgas luz a esta sala para pegar agusto]");
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
                            Danno danno =new Danno();
                            danno.setCantidad(Energia_Arcana.get(nivelMundo));
                            danno.setTipo(Enums.Tipo_Ataque.Magia);
                            if(horda.size()==1){
                                horda.getFirst().recibirDanno(danno);
                                return;
                            }
                            else{
                                System.out.println("¿A que enemigo le vas a enchufar?");
                                for(int i=0;i<=horda.size();i++){
                                    System.out.println(i+") "+horda.get(i).getNombre());
                                }
                                do{
                                    try{
                                        respuesta =input.nextInt();
                                    }catch(Exception e){//comprobar que no afecte respuesta del if anterior
                                    System.out.println("¿Alma de Hokague, no sabes meter un puto número tal y como aparece en la lista?");
                                    input.nextLine();
                                    }
                                }while((respuesta<0|| respuesta>horda.size()));
                                horda.get(respuesta).recibirDanno(danno);
                                return;
                            }

                        case 1:
                             //Comprobar si Invisible se aplica al array características del enemigo
                             for (Enemigo enemigo : horda) {
                                for (String x : enemigo.getCaracteristicas()) {
                                    if(x=="Invisible"){x="Ninguna";}
                                }    
                            }
                            break;
                    }
                }
                
                System.out.println("¿Que ataque mágico quires hacer Hechicerdo?");
                System.out.println("0: Energía arcana [1 Chp, y le enchufas con un cable pelao trifásico]");
                System.out.println("1:  Purgar invisibilidad [1UBE Otorgas luz a esta sala para pegar agusto]");
                System.out.println("2: Daño en area [1 Chp+1UBE, y le enchufas con un cable pelao trifásico a unos cuantos]");
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
                        Danno danno =new Danno();
                        danno.setCantidad(Energia_Arcana.get(nivelMundo));
                        danno.setTipo(Enums.Tipo_Ataque.Magia);
                        if(horda.size()==1){
                            horda.getFirst().recibirDanno(danno);
                            return;
                        }
                        else{
                            System.out.println("¿A que enemigo le vas a enchufar?");
                            for(int i=0;i<=horda.size();i++){
                                System.out.println(i+") "+horda.get(i).getNombre());
                            }
                            do{
                                try{
                                    respuesta =input.nextInt();
                                }catch(Exception e){//comprobar que no afecte respuesta del if anterior
                                System.out.println("¿Alma de Hokague, no sabes meter un puto número tal y como aparece en la lista?");
                                input.nextLine();
                                }
                            }while((respuesta<0|| respuesta>horda.size()));
                            horda.get(respuesta).recibirDanno(danno);
                            return;
                        }
                        

                    case 1:
                     //Comprobar si Invisible se aplica al array características del enemigo
                        for (Enemigo enemigo : horda) {
                            for (String x : enemigo.getCaracteristicas()) {
                                if(x=="Invisible"){x="Ninguna";}
                            }    
                        }
                        break;
                    case 2:
                        Danno danno1 =new Danno();
                        danno1.setCantidad(Energia_Arcana.get(nivelMundo));
                        danno1.setTipo(Enums.Tipo_Ataque.Magia);
                        if(horda.size()==1){
                            horda.getFirst().recibirDanno(danno1);
                            return;
                        }
                        else{
                            System.out.println("¿A que enemigo le vas a enchufar?");
                            HashMap<Integer,Boolean> chivato =new HashMap<>();
                            int j=0;
                            int danno_en_area=0;
                            if(nivelMundo<7){danno_en_area=1;}
                            if(nivelMundo>=7&&nivelMundo<11){danno_en_area=2;}
                            if(nivelMundo>=11&&nivelMundo<15){danno_en_area=3;}
                            if(nivelMundo==15){danno_en_area=4;}
                            for(int c=1;c<=danno_en_area;c++){
                                for(int i=0;i<=horda.size();i++){
                                    System.out.println(i+") "+horda.get(i).getNombre());
                                }
                                do{
                                    try{
                                        respuesta =input.nextInt();
                                    }catch(Exception e){//comprobar que no afecte respuesta del if anterior
                                    System.out.println("¿Alma de Hokague, no sabes meter un puto número tal y como aparece en la lista?");
                                    input.nextLine();
                                    }
                                }while((respuesta<0|| respuesta>horda.size()));
                                horda.get(respuesta).recibirDanno(danno1);
                                while(chivato.containsKey(respuesta)){
                                    System.out.println("No seas listo, a este bicho ya le has atizao con el cable pelao");
                                    do{
                                        try{
                                            respuesta =input.nextInt();
                                        }catch(Exception e){//comprobar que no afecte respuesta del if anterior
                                        System.out.println("¿Alma de Hokague, no sabes meter un puto número tal y como aparece en la lista?");
                                        input.nextLine();
                                        }
                                    }while((respuesta<0|| respuesta>horda.size()));
                                }
                                chivato.put(j,true);
                                j++;
                                horda.get(respuesta).recibirDanno(danno1);
                            }
                        }
                        return;
                }
    }
                
    

    public void quitarbeneficios() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'quitarbeneficios'");
    }

    public HashMap<Integer, Integer> getEnergia_Arcana() {
        return Energia_Arcana;
    }

    public void setEnergia_Arcana(HashMap<Integer, Integer> energia_Arcana) {
        Energia_Arcana = energia_Arcana;
    }

    public HashMap<Integer, Integer> getTablaAtaque() {
        return TablaAtaque;
    }

    public void setTablaAtaque(HashMap<Integer, Integer> tablaAtaque) {
        TablaAtaque = tablaAtaque;
    }

    public boolean isCanalizacion() {
        return Canalizacion;
    }

    public void setCanalizacion(boolean canalizacion) {
        Canalizacion = canalizacion;
    }
}