package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {
    MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox linesCombo;
    JButton createButton;
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        dotsLabel = new JLabel( "Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));
        linesLabel=new JLabel("Line probability:");
        Double[] options={1.0, 2.0, 3.0};
        linesCombo=new JComboBox<>(options);
        createButton = new JButton("Create a new game");
        createButton.addActionListener(this::newGame);
        add(dotsLabel); //JPanel uses FlowLayout by default
        add(dotsSpinner);
        add(linesLabel);
        add(linesCombo);
        add(createButton);

    }
    public void newGame(ActionEvent e)
    {
       frame=new MainFrame();

    }
}
