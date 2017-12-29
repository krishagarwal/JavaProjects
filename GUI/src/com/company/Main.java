package com.company;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{

    public static void main(String[] args) {
        Main m = new Main();
    }

    public Main(){
        super("JFrame");
        setSize(400, 400);
        setLocation(0,0);
        setBackground(Color.GREEN);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(true);
        GuiShower g = new GuiShower();
        setContentPane(g);
        setVisible(true);
    }
}
