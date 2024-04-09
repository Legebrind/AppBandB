import javax.sound.sampled.*;
import java.io.File;

public class Reproductor {
    private File audioFile;
    private Clip clip;
    public Reproductor() {
        
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
}
