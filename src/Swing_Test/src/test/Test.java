package Swing_Test.src.test;


import Swing_Test.src.view.CalculatorWindow;

import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        CalculatorWindow.setDefaultLookAndFeelDecorated(true);
        CalculatorWindow calculatorWindow = new CalculatorWindow("简易计算器");
        calculatorWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculatorWindow.setContentPane(calculatorWindow.getPane());
        calculatorWindow.setLocationRelativeTo(null);
        calculatorWindow.setVisible(true);
        calculatorWindow.pack();
    }
}
