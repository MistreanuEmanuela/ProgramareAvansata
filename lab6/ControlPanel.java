package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static java.awt.BorderLayout.CENTER;

public class ControlPanel extends JPanel {
        final MainFrame frame;
        JButton exitBtn = new JButton("Exit");
        JButton loadBtn = new JButton("Load");
        JButton saveBtn = new JButton("Save");
        JButton resetBtn = new JButton("Reset");
        public ControlPanel(MainFrame frame) {
            this.frame = frame; init();
        }
        private void init() {
            exitBtn.addActionListener(this::exitGame);
            saveBtn.addActionListener(this::saveGame);
            loadBtn.addActionListener(this::loadGame);
            resetBtn.addActionListener(this::resetGame);
            add(exitBtn);
            add(saveBtn);
            add(loadBtn);
            add(resetBtn);
        }
        private void exitGame(ActionEvent e) {
            frame.dispose();
        }
        private void resetGame(ActionEvent e) {

        }
        private void loadGame(ActionEvent e) {
         frame.canvas.createBoard();

        }
        private void saveGame(ActionEvent e) {
            frame.dispose();
        }
    }

