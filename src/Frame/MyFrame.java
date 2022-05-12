package Frame;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame {
    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();
        myFrame.setLocation(50, 50);
        myFrame.setSize(400, 600);
        myFrame.setVisible(true);
        myFrame.setTitle("Text");

        myFrame.addWindowListener(new WindowAdapter() {
                                      @Override
                                      public void windowClosing(WindowEvent e) {
                                          System.exit(1);
                                      }
                                  }
        );

        myFrame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getExtendedKeyCode();
                if (key == KeyEvent.VK_ENTER) {
                    System.exit(1);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }
}
