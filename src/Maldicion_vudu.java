public class Maldicion_vudu {
    
    private String Descripcion;
    private int Modificador,Danno;

    public Maldicion_vudu(String descripcion, int modificador,int danno)
    {
        this.Descripcion=descripcion;
        this.Modificador=modificador;
        this.Danno=danno;
    }

    public String getDescripcion(){
        return Descripcion;
    }
    public int getModificador(){
        return Modificador;
    }
    public int getDanno() {
        return Danno;
    }

}
