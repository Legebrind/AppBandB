import javax.sound.sampled.*;
import java.io.File;
import java.util.Random;

public class Reproductor {
    private static final String[] PatearPuerta = {
        "PatearPuerta1.mp3",
        "PatearPuerta2.mp3",
        "PatearPuerta3.mp3",
        "PatearPuerta4.mp3",
        "PatearPuerta5.mp3",
        "PatearPuerta6.mp3",
        "PatearPuerta7.mp3",
        "PatearPuerta8.mp3",
        "PatearPuerta9.mp3",
        "PatearPuerta10.mp3"
    };
    private static final String[] Cancion = {
        "Combate1.mp3",
        "Combate2.mp3",
        "Combate3.mp3",
        "Combate4.mp3",
        "Combate5.mp3"
    };
    private static final String[] Limpieza = {
        "Limpieza1.mp3",
        "Limpieza2.mp3",
        "Limpieza3.mp3",
        "Limpieza4.mp3",
        "Limpieza5.mp3"
    };
    private static final String[] Trampa = {
        "Trampa1.mp3",
        "Trampa2.mp3",
        "Trampa3.mp3",
        "Trampa4.mp3",
        "Trampa5.mp3"
    };
    

    private File audioFile;
    private Clip clip;
    private Random aleatorio;
    public Reproductor() {
        aleatorio=new Random();
    }
    public void reproducir(String titulo){
        try {
            audioFile = new File(titulo);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void stop(){
        this.clip.stop();
    }

    public String getPuerta() {
        int index = aleatorio.nextInt(PatearPuerta.length);
        return PatearPuerta [index];
    }
    public String getCancion() {
        int index = aleatorio.nextInt(Cancion.length);
        return Cancion [index];
    }
    public String getLimpieza() {
        int index = aleatorio.nextInt(Limpieza.length);
        return Limpieza [index];
    }
}

