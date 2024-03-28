import java.util.HashMap;
//Clase tipo HashMap que alberga los tipos de salvaciones
//1.Fortaleza
//2.Reflejos
//3.Voluntad

public class Salvacion{
private HashMap<Integer, String> Salvaciones;

public Salvacion(){
    Salvaciones.put(1,"Fortaleza");
    Salvaciones.put(2,"Reflejos");
    Salvaciones.put(3,"Voluntad");

}
public String getSalvacion(int a){

    return this.Salvaciones.get(a);
}
}