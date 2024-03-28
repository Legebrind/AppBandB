import java.util.HashMap;
//Clase tipo HashMap que alberga los tipos de salvaciones
//1.Fortaleza
//2.Reflejos
//3.Voluntad

public class Salvacion{
private HashMap<Integer, String> Salvaciones;

public Salvacion(){
    Salvaciones=new HashMap<>();
    Salvaciones.put(1,"Fortaleza");
    Salvaciones.put(2,"Reflejos");
    Salvaciones.put(3,"Voluntad");

}
public String getSalvacion(int a){

    return this.Salvaciones.get(a);
}
public void eliminarSalvacion(int a){
    this.Salvaciones.put(a,"");

}
public void annadirSalvacion(int a, String b){
    this.Salvaciones.put(a,b);
}
}