package jeu;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import javax.swing.JOptionPane;

public class ScoreManager {
    private List<Player> scores;

    public ScoreManager() {
        scores = new ArrayList<>();
        loadScores("../../resources/scores.txt");
    }

    public boolean isTopScore(Player player) {
        if (scores.size() < 10) {
            return true;
        }
        // Vérifier si le score du joueur est supérieur au dixième meilleur score
        return player.getScore() > scores.get(9).getScore();
    }

    public void addScore(Player player) {
        scores.add(player);
        scores.sort(Comparator.comparingInt(Player::getScore).reversed());
        if (scores.size() > 10) {
            scores.remove(10);  // Garder uniquement les 10 meilleurs scores
        }
    }

    public void saveScores(String fileName) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName))) {
            for (Player player : scores) {
                writer.write(player.getName() + " : " + player.getScore());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        // Get all scores
    public List<Player> getScores() {
        return scores;
    }

    public void showScores() {
        StringBuilder scoreList = new StringBuilder("Meilleurs Scores :\n");
        for (Player player : scores) {
            scoreList.append(player.getName()).append(" : ").append(player.getScore()).append("\n");
        }
        JOptionPane.showMessageDialog(null, scoreList.toString());
    }

    private void loadScores(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            for (String line : lines) {
                String[] parts = line.split(" : ");
                if (parts.length == 2) {
                    scores.add(new Player(parts[0], Integer.parseInt(parts[1])));
                }
            }
            scores.sort(Comparator.comparingInt(Player::getScore).reversed());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
