package jeu;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;
import javax.swing.*;

public class HangmanGame extends JFrame implements ActionListener {
    private List<String> words;
    private String wordToGuess;
    private StringBuilder hiddenWord;
    private int attemptsLeft = 7;
    private JLabel hiddenWordLabel;
    private JLabel attemptsLabel;
    private JTextField guessTextField;
    private JButton guessButton;
    private JLabel imageLabel;
    private Player currentPlayer;
    private ScoreManager scoreManager;
    private int correctGuesses = -1; 
    private JFrame frame;

    public HangmanGame() {
        this.frame = frame;  

        // Configuration de la fenêtre principale
        setTitle("Jeu du Pendu");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());

        // Initialisation des composants
        scoreManager = new ScoreManager();
        loadWordsFromFile("../../resources/dictionnaire.txt");

        hiddenWordLabel = new JLabel("", SwingConstants.CENTER);
        hiddenWordLabel.setFont(new Font("Arial", Font.BOLD, 24));

        attemptsLabel = new JLabel("Tentatives restantes : " + attemptsLeft, SwingConstants.CENTER);
        guessTextField = new JTextField(10);
        guessButton = new JButton("Deviner");

        guessButton.addActionListener(this);
        guessTextField.addActionListener(this);

        imageLabel = new JLabel();
        updateHangmanImage(); // Charger l'image initiale

        // Panel du haut
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2, 1));
        topPanel.add(hiddenWordLabel);
        topPanel.add(attemptsLabel);

        // Panel du bas
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(guessTextField);
        bottomPanel.add(guessButton);

        add(topPanel, BorderLayout.NORTH);
        add(imageLabel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Initialiser le jeu
        initializeGame();

        // Ajout du menu
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Fichier");
        JMenuItem viewScoresMenuItem = new JMenuItem("Voir les scores");
        viewScoresMenuItem.addActionListener(e -> showScores());
        fileMenu.add(viewScoresMenuItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Méthode pour démarrer le jeu
    public void play() {
        initializeGame();
        setVisible(true);
    }

    // Méthode pour charger les mots depuis un fichier
    private void loadWordsFromFile(String filename) {
        try {
            words = Files.readAllLines(Paths.get(filename));
            if (words.isEmpty()) {
                throw new IOException("Le fichier est vide !");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erreur : Impossible de charger les mots.\n" + e.getMessage(),
                    "Erreur", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    // Initialisation du jeu
    private void initializeGame() {
    // Demander le nom du joueur
    String playerName;
    while (true) {
        playerName = JOptionPane.showInputDialog(null, 
            "Veuillez entrer votre nom pour commencer le jeu.\n\n⚠️", 
            JOptionPane.WARNING_MESSAGE);

        if (playerName == null) {
        frame.dispose();  // Ferme la fenêtre actuelle 
        // Créez une nouvelle instance de la page d'accueil
        new MainPage();  
        return; 
        }

        playerName = playerName.trim();

        if (playerName.isEmpty()) {
            JOptionPane.showMessageDialog(null, 
                "Le nom ne peut pas être vide. Essayez encore.", 
                "Erreur", 
                JOptionPane.ERROR_MESSAGE);
        } else if (!playerName.matches("[a-zA-Zà-öø-ÿÀ-ÖØ-ß\\s]+")) {
            JOptionPane.showMessageDialog(null, 
                "Le nom ne doit contenir que des lettres et des espaces. Essayez encore.", 
                "Erreur", 
                JOptionPane.ERROR_MESSAGE);
        } else {
            break;  // Nom valide, sortir de la boucle
        }
    }

    currentPlayer = new Player(playerName);  // Nom nettoyé et validé


        
        Random rand = new Random();
        wordToGuess = words.get(rand.nextInt(words.size())).toLowerCase();
        hiddenWord = new StringBuilder("_".repeat(wordToGuess.length()));
        hiddenWordLabel.setText(hiddenWord.toString());

        attemptsLeft = 7;
        updateHangmanImage();
        attemptsLabel.setText("Tentatives restantes : " + attemptsLeft);
    }

    // Mise à jour du mot caché après une tentative
    private void updateHiddenWord(char guess) {
        boolean found = false;

        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guess && hiddenWord.charAt(i) == '_') {
                hiddenWord.setCharAt(i, guess);
                found = true;
            }
        }

        hiddenWordLabel.setText(hiddenWord.toString());

        if (found) {
            correctGuesses++; // On passe à l’image suivante
        } else {
            attemptsLeft--; // Perte d'un essai en cas d'erreur
        }

        attemptsLabel.setText("Tentatives restantes : " + attemptsLeft);
        updateHangmanImage();

        // Fin du jeu en cas de victoire ou de défaite
        if (hiddenWord.toString().equals(wordToGuess)) {
            endGame("Félicitations ! Vous avez gagné !", "victory.png");
        } else if (attemptsLeft <= 0) {
            endGame("Dommage, vous avez perdu ! Le mot était : " + wordToGuess, "pendu-6.png");
        }
    }

    // Mise à jour de l'image en fonction du nombre d'essais restants
    private void updateHangmanImage() {
        String imagePath = "../../resources/images/pendu-" + (7 - attemptsLeft) + ".png";
        imageLabel.setIcon(new ImageIcon(imagePath));
    }

    // Méthode pour calculer le score en fonction des erreurs
    private int calculateScore() {
        int errors = 6 - attemptsLeft; // Nombre d'erreurs commises
        switch (errors) {
            case 0: return 100;  // Aucun erreur
            case 1: return 50;
            case 2: return 35;
            case 3: return 25;
            case 4: return 15;
            case 5: return 10;
            case 6: return 5;
            default: return 0;
        }
    }

    // Fin du jeu, affichage du message et gestion des scores
    private void endGame(String message, String finalImage) {
        guessTextField.setEnabled(false);
        guessButton.setEnabled(false);
        imageLabel.setIcon(new ImageIcon(finalImage));
        JOptionPane.showMessageDialog(this, message, "Fin du jeu", JOptionPane.INFORMATION_MESSAGE);
        currentPlayer.setScore(calculateScore());

        // Enregistrement du score si nécessaire
        if (scoreManager.isTopScore(currentPlayer)) {
            scoreManager.addScore(currentPlayer);
            scoreManager.saveScores("../../resources/scores.txt");
        }

        // Réinitialisation du jeu
        initializeGame();
        guessTextField.setEnabled(true);
        guessButton.setEnabled(true);
        guessTextField.requestFocus();
    }

    // Affichage des scores
    private void showScores() {
        StringBuilder scoreList = new StringBuilder("Scores :\n");
        for (Player player : scoreManager.getScores()) {
            scoreList.append(player.getName()).append(" : ").append(player.getScore()).append("\n");
        }
        JOptionPane.showMessageDialog(this, scoreList.toString(), "Scores", JOptionPane.INFORMATION_MESSAGE);
    }

    // Gestion des événements lorsque le joueur soumet une tentative
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == guessButton || e.getSource() == guessTextField) {
            String guessText = guessTextField.getText().toLowerCase();
            if (guessText.length() > 0) {
                char guess = guessText.charAt(0);
                updateHiddenWord(guess);
                guessTextField.setText("");
            }
        }
    }

    // Lancement du jeu
    public static void main(String[] args) {
        SwingUtilities.invokeLater(HangmanGame::new);
    }
}
