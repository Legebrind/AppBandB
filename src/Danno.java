public class Danno {
    
    private int cantidad;
    private Enums.Tipo_Ataque tipo;

    public Danno(int cantidad, Enums.Tipo_Ataque tipo) {
        this.cantidad = cantidad;
        this.tipo = tipo;
    }
    public Danno(){
        
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Enums.Tipo_Ataque getTipo() {
        return tipo;
    }

    public void setTipo(Enums.Tipo_Ataque tipo) {
        this.tipo = tipo;
    }

    

   
}
