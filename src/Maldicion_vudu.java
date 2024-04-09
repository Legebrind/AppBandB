public class Maldicion_vudu {
    
    private String Descripcion,Modificador;
    private int Danno;

    public Maldicion_vudu(String descripcion, String modificador,int danno)
    {
        this.Descripcion=descripcion;
        this.Modificador=modificador;
        this.Danno=danno;
    }

    public String getDescripcion(){
        return Descripcion;
    }
    public String getModificador(){
        return Modificador;
    }
    public int getDanno() {
        return Danno;
    }

}
