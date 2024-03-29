import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class HUD {


    
    public HUD (){
        JFrame frame = new JFrame("Game Interface");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2, 2));
        HashMap<Integer, String> ImagenJugadores =new HashMap<>();
        ImagenJugadores.put(1,"Jugador1.jpg");
        ImagenJugadores.put(2,"Jugador2.jpg");
        ImagenJugadores.put(3,"Jugador3.jpg");
        ImagenJugadores.put(4,"Jugador4.jpg");
        ImagenJugadores.put(5,"Jugador5.jpg");
        ImagenJugadores.put(6,"Jugador6.jpg");
        ImagenJugadores.put(7,"Jugador7.jpg");

        // Parte Superior Izquierda
        JPanel enemyPanel = new JPanel(new GridLayout(1,2));
        enemyPanel.setBackground(Color.BLACK);
        JLabel enemyImageLabel = new JLabel(new ImageIcon("enemy.jpg"));
        JTextArea enemyDescriptionArea = new JTextArea("Descripción del enemigo...");
        enemyPanel.add(enemyImageLabel);
        enemyPanel.add(enemyDescriptionArea);

        // Parte Superior Derecha (7 jugadores)
        JPanel playersPanel = new JPanel(new GridLayout(1, 7));
        for (int i = 1; i <= 7; i++) {
            JLabel playerLabel = new JLabel(new ImageIcon(ImagenJugadores.get(i)));
            playersPanel.add(playerLabel);
        }

        // Parte Inferior Izquierda (Terminal)
        JTextArea combatLogArea = new JTextArea("Sucesos del combate...");
        combatLogArea.setBackground(Color.black);
        combatLogArea.setForeground(Color.green);
        combatLogArea.setFont(new Font("Dialog", Font.BOLD, 20));

        // Parte Inferior Derecha
        JPanel infoPanel = new JPanel(new GridLayout(2, 1));
        JLabel infoLabel = new JLabel("Información relevante");
        JTextField inputField = new JTextField();

        infoPanel.add(infoLabel);
        infoPanel.add(inputField);

        // Agregar paneles al frame
        frame.add(enemyPanel);
        frame.add(playersPanel);
        frame.add(combatLogArea);
        frame.add(infoPanel);

        frame.pack();
        frame.setVisible(true);
    }
    
    
}

