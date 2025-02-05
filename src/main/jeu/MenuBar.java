package jeu;
import jeu.HangmanGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar {
    public MenuBar(HangmanGame game) {
        JMenu fileMenu = new JMenu("Fichier");
        JMenuItem newGameItem = new JMenuItem("Nouveau Jeu");
        JMenuItem scoresItem = new JMenuItem("Scores");
        JMenuItem rulesItem = new JMenuItem("Règles");

        newGameItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.play();
            }
        });

        scoresItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Afficher les scores
            }
        });

        rulesItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Afficher les règles
            }
        });

        fileMenu.add(newGameItem);
        fileMenu.add(scoresItem);
        fileMenu.add(rulesItem);
        this.add(fileMenu);

        JMenu aboutMenu = new JMenu("À propos");
        JMenuItem aboutItem = new JMenuItem("À propos");
        aboutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Afficher la fenêtre "À propos"
            }
        });
        aboutMenu.add(aboutItem);
        this.add(aboutMenu);
    }
}