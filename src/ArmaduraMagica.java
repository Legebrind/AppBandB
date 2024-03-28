
public class ArmaduraMagica extends Objeto{
    private int Dureza;
    public ArmaduraMagica(){
    setNombre("Armadura_Magica_Dureza_1");
    setNivel(1);
    setDescripcion("Es un cubo de basura, que aparece mágicamente cuando te atacan para protegerte");    Dureza=1;
}
public int getDureza(){
    return this.Dureza;
}
}