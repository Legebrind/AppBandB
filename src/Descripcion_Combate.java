import java.util.Random;

public class Descripcion_Combate {
     private static final String[] Descripciones = {
        "El enemigo golpea con brutalidad produciendo profundas heridas a nuestro héroe.",
        "Este bichejo se te ha comido una horeja, mas vale que hagas algo",
        "El enemigo contraataca con fiereza",
        "Dios santo has visto eso, te acaba de escupir en un ojo",
        "El enemigo se tambalea, pero aún sigue en pie, mostrando su resistencia",
        "El enemigo retrocede momentáneamente, evaluando su siguiente movimiento.",
        "El monstruo entona una canción inspiradora, y te mete colleja",
        "El enemigo se encoleriza y carga con ferocidad.",
        "Carga con brutalidad al grito de CHUPA Y MAMA QUE SE DERRAMA",
        "El inteligente monstruo te suerta una retaila inclusiva democráticamente, lo que te despista",
        "El enemigo se mueve con agilidad, buscando una apertura",
        "Nuestro pícaro se desliza detrás del enemigo, buscando un punto débil, pero",
        "El enemigo nos maldice, 'Malditus sus genes heteropatriarcales'",
        "El monstruo se enfurece al comprobar que vuestro grupo no es paritario",
        "El enemigo os provoca con insultos y amenazas, juraría que es de esos que tiene muchos primos, y.",
        "El enemigo canaliza energía oscura en su espada 'ya tu sahbeh' y te la mete produciendo",
        "El enemigo os desafía con una risa, muy parecida a la de leticia Savater cuando habla de salchichas",
        "El enemigo os ataca con un martillo de democrático",
        "El enemigo os ataca desde la mas absoluta verdad inclusiva",
        "El enemigo os ataca, parece que el pícaro le ha robado y está muy cabreado",
        "El enemigo os ataca con dulzura pasando la mano por vuestras caras",
        "El biche os ataca y os dice 'Esto es pa que lo disfrutes'",
        "El biche os ataca llenándole de orgullo y satisfacción por todo lo que váis a beber",
        "El monstrue dice que esto es vuestro"


    };

    private Random random;

    public Descripcion_Combate() {
        random = new Random();
    }

    public String getDescripcion_del_Ataque() {
        int index = random.nextInt(Descripciones.length);
        return Descripciones [index];
    }
}
