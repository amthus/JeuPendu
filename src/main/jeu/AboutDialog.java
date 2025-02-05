package jeu;
import javax.swing.*;

public class AboutDialog extends JDialog {
    public AboutDialog(JFrame parent) {
        super(parent, "À propos", true);
        setSize(300, 200);
        setLocationRelativeTo(parent);

        JTextArea textArea = new JTextArea("Jeu du Pendu - Version 1.0\nDéveloppé par [Votre Nom]\nBonne chance !");
        textArea.setEditable(false);
        add(new JScrollPane(textArea));

        setVisible(true);
    }
}
