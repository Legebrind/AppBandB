import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javazoom.jl.decoder.JavaLayerException;

import javazoom.jl.player.AudioDevice;
import javazoom.jl.player.FactoryRegistry;
import javazoom.jl.player.advanced.AdvancedPlayer;
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
        "Combate1.MP3",
        "Combate2.MP3",
        "Combate3.MP3",
        "Combate4.MP3",
        "Combate5.MP3"
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
    

 
        private AdvancedPlayer player;
        private Random aleatorio;
        /**
         * Constructor for objects of class MusicFilePlayer
         */
        public Reproductor()
        {
            player = null;
            aleatorio=new Random();
        }
        
  
        /**
         * Start playing the given audio file.
         * The method returns once the playing has been started.
         * @param filename The file to be played.
         */
        public void reproducir()
    {
        try {
           
            Thread playerThread = new Thread() {
                public void run()
                {
                    try {
                        player.play(5000);
                    }
                    catch(JavaLayerException e) {
                       
                    }
                    finally {
                        killPlayer();
                    }
                }
            };
            playerThread.start();
        }
        catch (Exception ex) {
            
        }
    }
           
        
        public void stop()
        {
            killPlayer();
        }
        
        /**
         * Set up the player ready to play the given file.
         * @param filename The name of the file to play.
         */
        private void cargarArchivo(String filename)
        {
            try {
                InputStream is = getInputStream(filename);
                player = new AdvancedPlayer(is, createAudioDevice());
            }
            catch (IOException e) {
                reportProblem(filename);
                killPlayer();
            }
            catch(JavaLayerException e) {
                reportProblem(filename);
                killPlayer();
            }
        }
    
        /**
         * Return an InputStream for the given file.
         * @param filename The file to be opened.
         * @throws IOException If the file cannot be opened.
         * @return An input stream for the file.
         */
        private InputStream getInputStream(String filename)
            throws IOException
        {
            return new BufferedInputStream(
                        new FileInputStream(filename));
        }
    
        /**
         * Create an audio device.
         * @throws JavaLayerException if the device cannot be created.
         * @return An audio device.
         */
        private AudioDevice createAudioDevice()
            throws JavaLayerException
        {
            return FactoryRegistry.systemRegistry().createAudioDevice();
        }
    
        /**
         * Terminate the player, if there is one.
         */
        public void killPlayer()
        {
            synchronized(this) {
                if(player != null) {
                    player.stop();
                    player = null;
                }
            }
        }
        
        /**
         * Report a problem playing the given file.
         * @param filename The file being played.
         */
        private void reportProblem(String filename)
        {
            System.out.println("There was a problem playing: " + filename);
        }
        public void cargarPuerta()
        {   int posicion=aleatorio.nextInt(PatearPuerta.length);
            String filename=PatearPuerta[posicion];
            try {
                InputStream is = getInputStream(filename);
                player = new AdvancedPlayer(is, createAudioDevice());
            }
            catch (IOException e) {
                reportProblem(filename);
                killPlayer();
            }
            catch(JavaLayerException e) {
                reportProblem(filename);
                killPlayer();
            }
        }
        public void cargarMusica()
        {   int posicion=aleatorio.nextInt(Cancion.length);
            String filename=Cancion[posicion];
            try {
                InputStream is = getInputStream(filename);
                player = new AdvancedPlayer(is, createAudioDevice());
            }
            catch (IOException e) {
                reportProblem(filename);
                killPlayer();
            }
            catch(JavaLayerException e) {
                reportProblem(filename);
                killPlayer();
            }
        }
        public void cargarLimpieza()
        {   int posicion=aleatorio.nextInt(Limpieza.length);
            String filename=Limpieza[posicion];
            try {
                InputStream is = getInputStream(filename);
                player = new AdvancedPlayer(is, createAudioDevice());
            }
            catch (IOException e) {
                reportProblem(filename);
                killPlayer();
            }
            catch(JavaLayerException e) {
                reportProblem(filename);
                killPlayer();
            }
        }
    }