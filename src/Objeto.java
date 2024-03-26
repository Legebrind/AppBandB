public class Objeto{
    //Campos:
    private String Nombre;
    private int Nivel;
    private String[] Descripcion;
    //Constructor:
    public Objeto(){
    }
    public Objeto(String Nombre, int Nivel, String[] Descripcion){
        this.Nombre=Nombre;
        this.Nivel=Nivel;
        this.Descripcion=Descripcion;
     }

//Métodos:
public void setNombre(String Nombre){
    this.Nombre=Nombre;

}
public void setNivel(int Nivel){
    this.Nivel=Nivel;

}
public void setDescripcion(String[] Descripcion){
this.Descripcion=Descripcion;
}
public String getNombre(){
    return this.Nombre;

}
public int getNivel(){
    return this.Nivel;

}
public String[] getDescripcion(){
    return this.Descripcion;

}
}
