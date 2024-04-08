public class Modificador {
    
    private int Cantidad;


    private Enums.Tipo_Clase TipoClase;



    public Modificador(){
        
    }
    public Enums.Tipo_Clase getTipoClase() {
        return TipoClase;
    }

    public void setTipoClase(Enums.Tipo_Clase tipoClase) {
        TipoClase = tipoClase;
    }
    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }
}
