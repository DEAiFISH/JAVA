package listener;

import controller.Calculator;
import view.CalculatorWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Monitor implements ActionListener {
    private CalculatorWindow window = new CalculatorWindow();
    private Calculator calculator = new Calculator();
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        if ("C".equals(str)) {
            window.getRes().setText("");
            window.getPut().setText("");
        } else if ("=".equals(str)) {
            try {

                String input = window.getRes().getText();
                String strX = "";
                String strY = "";
                char sign = '`';
                int index = 0;
                while (Character.isDigit(input.charAt(index))) {
                    strX += input.charAt(index++);
                }
                sign = input.charAt(index++);
                while (index < input.length()) {
                    strY += input.charAt(index++);
                }
                switch (sign) {
                    case '+':
                        window.getPut().setText("" + calculator.add(Double.parseDouble(strX), Double.parseDouble(strY)));
                        break;
                    case '-':
                        window.getPut().setText("" + calculator.del(Double.parseDouble(strX), Double.parseDouble(strY)));
                        break;
                    case '*':
                        window.getPut().setText("" + calculator.mul(Double.parseDouble(strX), Double.parseDouble(strY)));
                        break;
                    case '/':
                        window.getPut().setText("" + calculator.div(Double.parseDouble(strX), Double.parseDouble(strY)));
                        break;
                }
            } catch (RuntimeException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(),"提示",JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            window.getRes().setText(window.getRes().getText() + str);
        }
    }
}
