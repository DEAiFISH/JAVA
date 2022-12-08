package Swing_Test.src.view;


import Swing_Test.src.controller.MyMouseAdapter;

import javax.swing.*;

public class CalculatorWindow extends JFrame {
    private MyMouseAdapter listener;
    private JTextField output;
    private JTextField input;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton button4;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton button8;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton button12;
    private JButton cButton;
    private JButton a0Button;
    private JButton button15;
    private JButton button16;
    private JPanel pane;


    public CalculatorWindow() {
        listener = new MyMouseAdapter(this);
        a1Button.addMouseListener(listener);
        a2Button.addMouseListener(listener);
        a3Button.addMouseListener(listener);
        button4.addMouseListener(listener);
        a4Button.addMouseListener(listener);
        a5Button.addMouseListener(listener);
        a6Button.addMouseListener(listener);
        button8.addMouseListener(listener);
        a7Button.addMouseListener(listener);
        a8Button.addMouseListener(listener);
        a9Button.addMouseListener(listener);
        button12.addMouseListener(listener);
        cButton.addMouseListener(listener);
        a0Button.addMouseListener(listener);
        button15.addMouseListener(listener);
        button16.addMouseListener(listener);
    }

    public CalculatorWindow(String name) {
        this();
        this.setName(name);
    }

    public JTextField getOutput() {
        return output;
    }

    public JTextField getInput() {
        return input;
    }

    public JPanel getPane() {
        return pane;
    }

}
