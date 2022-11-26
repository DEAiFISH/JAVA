import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class 计算器 {

    private JPanel 计算器;
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

    public 计算器() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = e.getActionCommand();
                if ("<-".equals(str)) {
                    str = res.getText();
                    int len = str.length();
                    if (len > 4) {
                        res.setText(str.substring(0, str.length() - 1));
                    }
                } else if ("=".equals(str)) {
                    str = res.getText().substring(4);
                    Stack<Character> stack = new Stack<>();
                    float sum = 0;
                    for (int i = 0; i < str.length(); i++) {
                        Character ch = str.charAt(i);
                        if (ch.equals('*') || ch.equals('/')) {
                            i++;
                            float x = str.charAt(i) - '0';
                            float y = stack.pop() - '0';
                            if (ch.equals('*')) {
                                sum += x * y;
                            } else {
                                sum += x / y;
                            }
                        } else {
                            stack.push(ch);
                        }
                    }
                    while (!stack.isEmpty()) {
                        int x = stack.pop() - '0';
                        char c = '+';
                        if (!stack.isEmpty()) {
                            c = stack.pop();
                        }
                        switch (c) {
                            case '+':
                                sum += x;
                                break;
                            case '-':
                                sum -= x;
                        }
                    }

                    res.setText(res.getText() + "= " + sum);

                } else {
                    res.setText(res.getText() + str);
                }
            }
        };
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

    public static void main(String[] args) {
        JFrame frame = new JFrame("计算器");
        frame.setContentPane(new 计算器().计算器);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
