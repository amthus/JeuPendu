package jeu;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainPage extends JFrame implements ActionListener {
    private JMenuBar menuBar;
    private JMenu fileMenu, aboutMenu;
    private JMenuItem newGameMenuItem, scoresMenuItem, rulesMenuItem, aboutMenuItem;

    public MainPage() {
        setTitle("Page d'Accueil - Jeu du Pendu");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Créer une police personnalisée pour le menu
        Font menuFont = new Font("Arial", Font.PLAIN, 14);

        // Initialisation du menu
        menuBar = new JMenuBar();

        // Menu Fichier
        fileMenu = new JMenu("Fichier");
        fileMenu.setFont(menuFont); 
        newGameMenuItem = new JMenuItem("Nouveau Jeu");
        scoresMenuItem = new JMenuItem("Scores");
        rulesMenuItem = new JMenuItem("Règles");

        newGameMenuItem.addActionListener(this);
        scoresMenuItem.addActionListener(this);
        rulesMenuItem.addActionListener(this);

        fileMenu.add(newGameMenuItem);
        fileMenu.add(scoresMenuItem);
        fileMenu.add(rulesMenuItem);

        // Menu À propos
        aboutMenu = new JMenu("À propos");
        aboutMenu.setFont(menuFont); 
        aboutMenuItem = new JMenuItem("À propos du jeu");
        aboutMenuItem.addActionListener(this);
        aboutMenu.add(aboutMenuItem);

        menuBar.add(fileMenu);
        menuBar.add(aboutMenu);

        setJMenuBar(menuBar);

        // Affichage de la fenêtre d'accueil
               // Affichage de la fenêtre d'accueil avec l'image
               JLabel welcomeLabel = new JLabel("Bienvenue dans le Jeu du Pendu !", SwingConstants.CENTER);
               ImageIcon imageIcon = new ImageIcon("../../resources/images/Bienvenue.png"); // Assurez-vous que le chemin est correct
       
               // Créer un JLabel pour l'image et le centrer
               JLabel imageLabel = new JLabel(imageIcon, SwingConstants.CENTER);
               add(imageLabel, BorderLayout.CENTER);  // Ajouter l'image au centre de la fenêtre
               add(welcomeLabel, BorderLayout.NORTH);  // Ajouter le texte au-dessus de l'image
       
               welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
       
               setLocationRelativeTo(null);
               setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newGameMenuItem) {
            new HangmanGame();  // Lancer une nouvelle partie
            this.dispose();     // Fermer la page d'accueil
        } else if (e.getSource() == scoresMenuItem) {
            new ScoreManager().showScores();  // Afficher les scores
        } else if (e.getSource() == rulesMenuItem) {
            showRules();  // Afficher les règles
        } else if (e.getSource() == aboutMenuItem) {
            showAbout();  // Afficher les informations sur le jeu
        }
    }

  private void showRules() {
    JOptionPane.showMessageDialog(this,
        "Le jeu du PENDU :\n\n" +
        "Vous avez 7 coups pour trouver le mot caché ! Et si vous réussissez : on recommence ! Plus vous avez trouvé de mots, plus votre score grandira ! Alors à vous de jouer !\n\n" +
        "COMPTE DES POINTS :\n\n" +
        "Mot trouvé sans erreur ...... 100Pts\n" +
        "Mot trouvé avec 1 erreur ...... 50Pts\n" +
        "Mot trouvé avec 2 erreurs : ...... 35Pts\n" +
        "Mot trouvé avec 3 erreurs ...... 25Pts\n" +
        "Mot trouvé avec 4 erreurs : ...... 15Pts\n" +
        "Mot trouvé avec 5 erreurs : ...... 10Pts\n" +
        "Mot trouvé avec 6 erreurs : ...... 5Pts\n\n" +
        "Je vous souhaite bien du plaisir....\n\n" +
        "Et si vous pensez pouvoir trouver un mot en un coup, c'est que vous pensez que le dictionnaire est petit ! " +
        "Hors, pour votre information, il comprend plus de 336 000 mots... Donc bonne chance !! ;");
}

private void showAbout() {
    JOptionPane.showMessageDialog(this,
        "À propos du jeu \"Le Pendu\" :\n\n" +
        "Le jeu du Pendu est un jeu classique où vous devez deviner un mot caché, lettre par lettre. \n" +
        "Chaque fois que vous faites une erreur, une partie d'un bonhomme est dessinée. Vous avez un nombre limité de tentatives\n " +
        "pour trouver le mot, sinon vous perdez la partie.\n");
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainPage::new);
    }
}
