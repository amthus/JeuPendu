package jeu;
import jeu.HangmanGame;
import javax.swing.*;
import java.awt.*;

public class GameOverDialog extends JDialog {
    public GameOverDialog(JFrame parent, boolean won, String word) {
        super(parent, "Fin de la partie", true);
        setLayout(new BorderLayout());
        JLabel message = new JLabel(won ? "Félicitations! Vous avez gagné!" : "Dommage! Le mot était: " + word, SwingConstants.CENTER);
        add(message, BorderLayout.CENTER);
        JButton closeButton = new JButton("Fermer");
        closeButton.addActionListener(e -> dispose());
        add(closeButton, BorderLayout.SOUTH);
        setSize(300, 150);
        setLocationRelativeTo(parent);
    }
}