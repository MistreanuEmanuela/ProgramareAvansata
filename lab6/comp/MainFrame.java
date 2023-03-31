package org.example;
import javax.swing.*;

import static java.awt.BorderLayout.*;

public class MainFrame extends JFrame {
        ConfigPanel configPanel;
        ControlPanel controlPanel;
        DrawingPanel canvas;

        public MainFrame() {
            super("My Drawing Application");
            init();
        }

        private void init() {
            setDefaultCloseOperation(EXIT_ON_CLOSE);

            canvas = new DrawingPanel(this);
            controlPanel= new ControlPanel(this);
            configPanel=new ConfigPanel(this);


            add(canvas, CENTER); //this is BorderLayout.CENTER
            add(controlPanel,SOUTH);
            add(configPanel, NORTH);


        }
    }

