package Swing_Test.src.controller;

import Swing_Test.src.model.Calculator;
import Swing_Test.src.view.CalculatorWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyMouseAdapter extends MouseAdapter {
    private CalculatorWindow window;
    private Calculator calculator;

    public MyMouseAdapter() {
    }

    public MyMouseAdapter(CalculatorWindow window) {
        this.window = window;
        this.calculator = new Calculator();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String str = ((JButton) e.getSource()).getText();
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            window.getInput().setText(window.getInput().getText() + str);
        } else if ("+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str)) {
            window.getInput().setText(window.getInput().getText() + " " + str + " ");
        } else if ("=".equals(str)) {
            window.getOutput().setText(calculator.calculate(window.getInput().getText()));
        } else {
            window.getOutput().setText("");
            window.getInput().setText("");
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        ((JButton) e.getSource()).setBackground(Color.YELLOW);
    }

    @Override
    public void mouseExited(MouseEvent e) {

        ((JButton) e.getSource()).setBackground(Color.BLACK);
    }
}
