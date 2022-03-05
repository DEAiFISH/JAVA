package MyStar;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JFrame;

public class MyStar {

    public static void main(String[] args) {
        JFrame frame = new JFrame("满天星");
        MyStarPanel panel = new MyStarPanel();
        frame.add(panel);
        Thread t = new Thread(panel);
        t.start();
        frame.setSize(500, 800);
        frame.setVisible(true);
        frame.setLocationRelativeTo((Component)null);
        frame.setDefaultCloseOperation(3);
        frame.setBackground(Color.BLACK);
    }
}

