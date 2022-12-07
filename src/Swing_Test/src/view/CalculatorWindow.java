package view;

import listener.Monitor;

import javax.swing.*;

public class CalculatorWindow {

    private JPanel panel;
    private JButton add;
    private JButton a1Button;
    private JButton a7Button;
    private JButton a4Button;
    private JButton a2Button;
    private JButton a5Button;
    private JButton a8Button;
    private JButton a0Button;
    private JButton a3Button;
    private JButton a6Button;
    private JButton a9Button;
    private JButton button11;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JTextField res;
    private JTextField put;

    public CalculatorWindow() {
        Monitor listener = new Monitor();
        add.addActionListener(listener);
        a1Button.addActionListener(listener);
        a7Button.addActionListener(listener);
        a4Button.addActionListener(listener);
        a2Button.addActionListener(listener);
        a5Button.addActionListener(listener);
        a8Button.addActionListener(listener);
        a0Button.addActionListener(listener);
        a3Button.addActionListener(listener);
        a6Button.addActionListener(listener);
        a9Button.addActionListener(listener);
        button11.addActionListener(listener);
        button1.addActionListener(listener);
        button2.addActionListener(listener);
        button3.addActionListener(listener);
        button4.addActionListener(listener);
    }

    public JTextField getRes() {
        return res;
    }

    public JTextField getPut() {
        return put;
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("简易计算器");
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setContentPane(new CalculatorWindow().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.pack();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
