package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Created by krish_000 on 4/11/2016.
 */
public class GuiShower extends JPanel {
    public static void main(String[] args){

    }

    public void paintComponent(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(200, 200, 100, 100);
        g.setColor(Color.ORANGE);
        g.fillOval(200, 200, 100, 100);
    }
}
