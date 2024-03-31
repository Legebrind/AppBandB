public class Cantar {
    private String Descripcion;
    private int Modificador;
    public Cantar(String Descripcion, int Modificador)
    {
        this.Descripcion=Descripcion;
        this.Modificador=Modificador;
    }

    public String getDescripcion(){

        return Descripcion;
    }
    public int getModificador(){

        return Modificador;
    }


}