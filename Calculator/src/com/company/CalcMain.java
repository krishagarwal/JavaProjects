package com.company;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import java.awt.Container;


public class CalcMain {

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");

        JFrame theGUI = new JFrame();
        theGUI.setTitle("Calc");
        theGUI.setSize(200, 385);
        theGUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        theGUI.setResizable(true);
        theGUI.setIconImage(new ImageIcon(CalcMain.class.getResource("calculator.png")).getImage());

        Container pane = theGUI.getContentPane();
        JPanel myPanel = new CalcPanel();
        pane.add(myPanel);

        theGUI.setVisible(true);

    }
}