public class ArmaMagica_mas_2 extends Objeto {

    private int At;

    public ArmaMagica_mas_2(){

        //super.Objeto("Arma_Mágica_+_2",1, "Es una espada mágica llameante, especial para BBQ");
        setNombre("Arma_Mágica_+_2");
        setNivel(1);
        setDescripcion("Es una espada mágica llameante, especial para BBQ");
        At=2;
    }

   public int getDanno(){
    return this.At;
   }
    }
    

