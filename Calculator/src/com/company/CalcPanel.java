package com.company;

import java.math.BigDecimal;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CalcPanel extends JPanel implements ActionListener {
    private String num1 = "";
    private String num2 = "";
    private String operator = "";
    private boolean usingFirst = true;
    private BigDecimal total = BigDecimal.ZERO;
    private final JTextField display;
    private final JButton b1;
    private final JButton b2;
    private final JButton b3;
    private final JButton b4;
    private final JButton b5;
    private final JButton b6;
    private final JButton b7;
    private final JButton b8;
    private final JButton b9;
    private final JButton b0;
    private final JButton bDec;
    private final JButton bClear;
    private final JButton bEquals;
    private final JButton bPlus;
    private final JButton bMinus;
    private final JButton bMultiply;
    private final JButton bDivide;
    private final JButton bColor;

    CalcPanel() {
        setLayout(null);

        setBackground(new Color(198, 27, 11));


        display = new JTextField();

        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        b0 = new JButton("0");
        bDec = new JButton(".");
        bClear = new JButton("C");
        bEquals = new JButton("=");
        bPlus = new JButton("+");
        bMinus = new JButton("-");
        bMultiply = new JButton("*");
        bDivide = new JButton("/");
        bColor = new JButton(new ImageIcon(getClass().getResource("palette.png")));

        display.setBorder(null);
        b1.setOpaque(false);
        b2.setOpaque(false);
        b3.setOpaque(false);
        b4.setOpaque(false);
        b5.setOpaque(false);
        b6.setOpaque(false);
        b7.setOpaque(false);
        b8.setOpaque(false);
        b9.setOpaque(false);
        b0.setOpaque(false);
        bDec.setOpaque(false);
        bClear.setOpaque(false);
        bEquals.setOpaque(false);
        bPlus.setOpaque(false);
        bMinus.setOpaque(false);
        bMultiply.setOpaque(false);
        bDivide.setOpaque(false);
        bColor.setOpaque(false);

        b1.setBorder(null);
        b2.setBorder(null);
        b3.setBorder(null);
        b4.setBorder(null);
        b5.setBorder(null);
        b6.setBorder(null);
        b7.setBorder(null);
        b8.setBorder(null);
        b9.setBorder(null);
        b0.setBorder(null);
        bDec.setBorder(null);
        bClear.setBorder(null);
        bEquals.setBorder(null);
        bPlus.setBorder(null);
        bMinus.setBorder(null);
        bMultiply.setBorder(null);
        bDivide.setBorder(null);
        bColor.setBorder(null);

        Color test = new Color(0xFFFFFF - getBackground().getRGB());
        Color foreground = (test.getRed() * 0.2126 + test.getGreen() * 0.7152 + test.getBlue() * 0.0772) < 128 ? Color.BLACK : Color.WHITE;
        b1.setForeground(foreground);
        b2.setForeground(foreground);
        b3.setForeground(foreground);
        b4.setForeground(foreground);
        b5.setForeground(foreground);
        b6.setForeground(foreground);
        b7.setForeground(foreground);
        b8.setForeground(foreground);
        b9.setForeground(foreground);
        b0.setForeground(foreground);
        bDec.setForeground(foreground);
        bClear.setForeground(foreground);
        bEquals.setForeground(foreground);
        bPlus.setForeground(foreground);
        bMinus.setForeground(foreground);
        bMultiply.setForeground(foreground);
        bDivide.setForeground(foreground);


        Font f = new Font("Bodoni MT", Font.BOLD, 19);

        b1.setFont(f);
        b2.setFont(f);
        b3.setFont(f);
        b4.setFont(f);
        b5.setFont(f);
        b6.setFont(f);
        b7.setFont(f);
        b8.setFont(f);
        b9.setFont(f);
        b0.setFont(f);
        bDec.setFont(f);
        bClear.setFont(f);
        bEquals.setFont(f);
        bPlus.setFont(f);
        bMinus.setFont(f);
        bMultiply.setFont(f);
        bDivide.setFont(f);

        b0.setToolTipText("'0'");
        b1.setToolTipText("'1'");
        b2.setToolTipText("'2'");
        b3.setToolTipText("'3'");
        b4.setToolTipText("'4'");
        b5.setToolTipText("'5'");
        b6.setToolTipText("'6'");
        b7.setToolTipText("'7'");
        b8.setToolTipText("'8'");
        b9.setToolTipText("'9'");
        bDec.setToolTipText("'.'");
        bPlus.setToolTipText("'+', SHIFT + '='");
        bMinus.setToolTipText("'-'");
        bDivide.setToolTipText("'/'");
        bMultiply.setToolTipText("'*'");
        bEquals.setToolTipText("'=', ENTER");
        bClear.setToolTipText("'c'");
        bColor.setToolTipText("Choose calculator color");

        display.setBounds(0, 0, 200, 80);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setMargin(new Insets(20, 20, 20, 20));
        display.setFont(new Font("Bodoni MT", Font.BOLD, 20));
        display.setEditable(false);
        display.setBackground(Color.WHITE);

        b1.setBounds(0, 230, 50, 50);
        b2.setBounds(50, 230, 50, 50);
        b3.setBounds(100, 230, 50, 50);
        bPlus.setBounds(150, 230, 50, 50);
        bMinus.setBounds(150, 180, 50, 50);
        bMultiply.setBounds(150, 130, 50, 50);
        bDivide.setBounds(150, 80, 50, 50);

        b4.setBounds(0, 180, 50, 50);
        b5.setBounds(50, 180, 50, 50);
        b6.setBounds(100, 180, 50, 50);

        b7.setBounds(0, 130, 50, 50);
        b8.setBounds(50, 130, 50, 50);
        b9.setBounds(100, 130, 50, 50);

        b0.setBounds(0, 280, 50, 50);
        bDec.setBounds(50, 280, 50, 50);
        bClear.setBounds(100, 280, 50, 50);
        bEquals.setBounds(150, 280, 50, 50);
        bColor.setBounds(0, 0, 30, 30);

        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(b9);
        add(b0);
        add(bDec);
        add(display);
        add(bClear);
        add(bEquals);
        add(bPlus);
        add(bMinus);
        add(bMultiply);
        add(bDivide);
        display.add(bColor);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b0.addActionListener(this);
        bEquals.addActionListener(this);
        bPlus.addActionListener(this);
        bMinus.addActionListener(this);
        bMultiply.addActionListener(this);
        bDivide.addActionListener(this);
        bClear.addActionListener(this);
        bDec.addActionListener(this);
        bColor.addActionListener(this);


        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int heightSections = (int) (getSize().getHeight() / 6);
                int widthSections = (int) (getSize().getWidth() / 4);
                display.setBounds(0, 0, widthSections * 4 + 10, heightSections);

                bDivide.setBounds(widthSections * 3, heightSections, widthSections, heightSections);

                b7.setBounds(0, heightSections * 2, widthSections, heightSections);
                b8.setBounds(widthSections, b7.getY(), widthSections, heightSections);
                b9.setBounds(widthSections * 2, b7.getY(), widthSections, heightSections);
                bMultiply.setBounds(widthSections * 3, b7.getY(), widthSections, heightSections);

                b4.setBounds(0, heightSections * 3, widthSections, heightSections);
                b5.setBounds(widthSections, b4.getY(), widthSections, heightSections);
                b6.setBounds(widthSections * 2, b4.getY(), widthSections, heightSections);
                bMinus.setBounds(widthSections * 3, b4.getY(), widthSections, heightSections);

                b1.setBounds(0, heightSections * 4, widthSections, heightSections);
                b2.setBounds(widthSections, b1.getY(), widthSections, heightSections);
                b3.setBounds(widthSections * 2, b1.getY(), widthSections, heightSections);
                bPlus.setBounds(widthSections * 3, b1.getY(), widthSections, heightSections);

                b0.setBounds(0, heightSections * 5, widthSections, heightSections);
                bDec.setBounds(widthSections, b0.getY(), widthSections, heightSections);
                bClear.setBounds(widthSections * 2, b0.getY(), widthSections, heightSections);
                bEquals.setBounds(widthSections * 3, b0.getY(), widthSections, heightSections);

                Font f = new Font("Bodoni MT", Font.BOLD, (int) (0.38 * heightSections));
                b1.setFont(f);
                b2.setFont(f);
                b3.setFont(f);
                b4.setFont(f);
                b5.setFont(f);
                b6.setFont(f);
                b7.setFont(f);
                b8.setFont(f);
                b9.setFont(f);
                b0.setFont(f);
                bDec.setFont(f);
                bClear.setFont(f);
                bEquals.setFont(f);
                bPlus.setFont(f);
                bMinus.setFont(f);
                bMultiply.setFont(f);
                bDivide.setFont(f);
                display.setFont(new Font("Bodoni MT", Font.BOLD, (int) (0.38 * heightSections * (20 / 19))));

                repaint();


            }
        });

        MouseListener ml = new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                ((JButton) e.getSource()).setBorder(new LineBorder(b1.getForeground()));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ((JButton) e.getSource()).setBorder(null);
            }
        };

        b1.addMouseListener(ml);
        b2.addMouseListener(ml);
        b3.addMouseListener(ml);
        b4.addMouseListener(ml);
        b5.addMouseListener(ml);
        b6.addMouseListener(ml);
        b7.addMouseListener(ml);
        b8.addMouseListener(ml);
        b9.addMouseListener(ml);
        b0.addMouseListener(ml);
        bDec.addMouseListener(ml);
        bEquals.addMouseListener(ml);
        bClear.addMouseListener(ml);
        bPlus.addMouseListener(ml);
        bMinus.addMouseListener(ml);
        bMultiply.addMouseListener(ml);
        bDivide.addMouseListener(ml);


        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(key -> {

            if (key.getID() == KeyEvent.KEY_PRESSED) {
                switch (key.getKeyCode()) {
                    case 155:
                    case KeyEvent.VK_0:
                        b0.doClick();
                        break;
                    case 35:
                    case KeyEvent.VK_1:
                        b1.doClick();
                        break;
                    case 40:
                    case KeyEvent.VK_2:
                        b2.doClick();
                        break;
                    case 34:
                    case KeyEvent.VK_3:
                        b3.doClick();
                        break;
                    case 37:
                    case KeyEvent.VK_4:
                        b4.doClick();
                        break;
                    case 12:
                    case KeyEvent.VK_5:
                        b5.doClick();
                        break;
                    case 39:
                    case KeyEvent.VK_6:
                        b6.doClick();
                        break;
                    case 36:
                    case KeyEvent.VK_7:
                        b7.doClick();
                        break;
                    case 38:
                    case KeyEvent.VK_8:
                        b8.doClick();
                        break;
                    case 33:
                    case KeyEvent.VK_9:
                        b9.doClick();
                        break;
                    case 127:
                    case 46:
                    case KeyEvent.VK_DECIMAL:
                        bDec.doClick();
                        break;
                    case KeyEvent.VK_DIVIDE:
                        bDivide.doClick();
                        break;
                    case KeyEvent.VK_MULTIPLY:
                        bMultiply.doClick();
                        break;
                    case 107:
                        bPlus.doClick();
                        break;
                    case 109:
                    case '-':
                        bMinus.doClick();
                        break;
                    case KeyEvent.VK_EQUALS:
                        if (key.isShiftDown()) {
                            bPlus.doClick();
                            break;
                        }
                    case KeyEvent.VK_ENTER:
                        bEquals.doClick();
                        break;
                    case KeyEvent.VK_C:
                        bClear.doClick();
                        break;
                }
            }

            return false;

        });
    }

    public strictfp void actionPerformed(ActionEvent e) {

        if (e.getSource() == bColor) {

            Color test;

            try {
                JColorChooser colorChooser = new JColorChooser();

                colorChooser.setColor(getBackground());

                for (AbstractColorChooserPanel p : colorChooser.getChooserPanels()) {
                    if (p.getDisplayName().matches("RGB|HSV|HSL")) {
                        Container c = ((Container) p.getComponent(0));
                        c.remove(3);
                        c.remove(7);
                        c.remove(11);
                    } else if (p.getDisplayName().equals("CMYK")) {
                        Container c = ((Container) p.getComponent(0));
                        c.remove(4);
                        c.remove(9);
                        c.remove(8);
                    }
                }

                JDialog dialog = JColorChooser.createDialog(this, "Choose Calculator Color", true, colorChooser, null, null);
                dialog.setVisible(true);

                Color newColor = ((JColorChooser) (dialog.getContentPane().getComponent(0))).getColor();

//                Color newColor = new Color(newColor1.getRGB());

                setBackground(newColor);

                test = new Color(0xFFFFFF - newColor.getRGB());
            } catch (NullPointerException npe) {
                test = new Color(0xffffff - getBackground().getRGB());
            }

            Color foreground = (test.getRed() * 0.2126 + test.getGreen() * 0.7152 + test.getBlue() * 0.0772) < 128 ? Color.BLACK : Color.WHITE;

            b1.setForeground(foreground);
            b2.setForeground(foreground);
            b3.setForeground(foreground);
            b4.setForeground(foreground);
            b5.setForeground(foreground);
            b6.setForeground(foreground);
            b7.setForeground(foreground);
            b8.setForeground(foreground);
            b9.setForeground(foreground);
            b0.setForeground(foreground);
            bDec.setForeground(foreground);
            bClear.setForeground(foreground);
            bEquals.setForeground(foreground);
            bPlus.setForeground(foreground);
            bMinus.setForeground(foreground);
            bMultiply.setForeground(foreground);
            bDivide.setForeground(foreground);

            return;
        }

        String s = e.getActionCommand();
        if (s.equals("1") || s.equals("2") || s.equals("3") || s.equals("4") ||
                s.equals("5") || s.equals("6") || s.equals("7") || s.equals("8") ||
                s.equals("9") || s.equals("0")) {
            if (usingFirst) {
                num1 += s;
                display.setText(num1 + "     ");
            } else {
                num2 += s;
                display.setText(num2 + "     ");
            }
            return;
        }

        if (s.equals(".")) {
            if (usingFirst && !num1.contains(".")) {
                num1 += s;
                display.setText(num1 + "     ");
            } else if (!num2.isEmpty() && !num2.contains(".")) {
                num2 += s;
                display.setText(num2 + "     ");
            }
            return;
        }

        if (s.equals("+") || s.equals("*") || s.equals("/")) {

            if (!num2.isEmpty() && !operator.isEmpty()) {
                bEquals.doClick();
                operator = s;
                usingFirst = false;
            } else if (operator.isEmpty()) {
                usingFirst = false;
                operator = s;
            }
            return;
        }

        if (s.equals("-")) {

            if (!num2.isEmpty() && !operator.isEmpty()) {
                bEquals.doClick();
                operator = s;
                usingFirst = false;
            } else if (display.getText().startsWith(" = ") && operator.isEmpty()) {
                usingFirst = false;
                operator = s;
            } else if (num1.isEmpty() && !display.getText().startsWith(" = ")) {
                num1 += "-";
                display.setText(num1 + "     ");
            } else if (!usingFirst && num2.isEmpty()) {
                num2 += "-";
                display.setText(num2 + "     ");
            } else {
                usingFirst = false;
                operator = s;
            }
            return;
        }

        if (s.equals("=")) {
            try {
                switch (operator) {
                    case "+":
                        if (!num1.isEmpty()) {
                            total = BigDecimal.valueOf(Double.parseDouble(num1)).add(BigDecimal.valueOf(Double.parseDouble(num2)));
                        } else {
                            total = total.add(BigDecimal.valueOf(Double.parseDouble(num2)));
                        }
                        break;
                    case "-":
                        if (!num1.isEmpty()) {
                            total = BigDecimal.valueOf(Double.parseDouble(num1)).subtract(BigDecimal.valueOf(Double.parseDouble(num2)));

                        } else {
                            total = total.subtract(BigDecimal.valueOf(Double.parseDouble(num2)));
                        }
                        break;
                    case "*":
                        if (!num1.isEmpty()) {
                            total = BigDecimal.valueOf(Double.parseDouble(num1)).multiply(BigDecimal.valueOf(Double.parseDouble(num2)));
                        } else {
                            total = total.multiply(BigDecimal.valueOf(Double.parseDouble(num2)));
                        }
                        break;
                    case "/":
                        if (Double.parseDouble(num2) == 0) {
                            total = null;
                        } else if (!num1.isEmpty()) {
                            total = BigDecimal.valueOf(Double.parseDouble(num1)).divide(BigDecimal.valueOf(Double.parseDouble(num2)), BigDecimal.ROUND_HALF_EVEN);
                        } else {
                            total = total.divide(BigDecimal.valueOf(Double.parseDouble(num2)), BigDecimal.ROUND_HALF_EVEN);
                        }
                        break;
                    default:
                        if (!num1.isEmpty()) {
                            total = BigDecimal.valueOf(Double.parseDouble(num1));
                        } else if (!num2.isEmpty()) {
                            total = BigDecimal.valueOf(Double.parseDouble(num2));
                        } else {
                            total = BigDecimal.ZERO;
                        }
                }

                display.setText(" = " + (total != null ? total.toPlainString() : "Infinity") + "     ");
            } catch (Exception exc) {
                display.setText("Error     ");
            }

            usingFirst = true;

            num1 = "";
            num2 = "";
            operator = "";
            return;
        }

        if (s.equals("C")) {
            display.setText("");
            usingFirst = true;
            num1 = "";
            num2 = "";
            total = BigDecimal.ZERO;
        }

    }

}