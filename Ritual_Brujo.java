public class Ritual_Brujo {
    private String Descripcion;
    private int Modificador;
    public Ritual_Brujo(String Descripcion, int Modificador)
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