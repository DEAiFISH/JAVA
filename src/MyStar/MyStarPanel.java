package MyStar;

import java.awt.*;
import java.awt.image.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MyStarPanel extends JPanel implements Runnable {
    int[] xx = new int[100];
    int[] yy = new int[100];
    BufferedImage image;
    int[] fonts = new int[100];

    public MyStarPanel() {
        for(int i = 0; i < 100; ++i) {
            this.xx[i] = (int)(Math.random() * 500);
            this.yy[i] = (int)(Math.random() * 800);
        }

        try {
            this.image = ImageIO.read(MyStarPanel.class.getResource("IMG_2472.JPG"));
        } catch (IOException var2) {
            var2.printStackTrace();
        }

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(this.image, 0, 0, 500, 800, (ImageObserver)null);
        g.setColor(Color.WHITE);

        for(int i = 0; i < 100; ++i) {
            Font ft = new Font("微软雅黑", 1, this.fonts[i]);
            g.setFont(ft);
            g.drawString("*", this.xx[i], this.yy[i]);
        }

    }

    @Override
    public void run() {
        while(true) {
            for(int i = 0; i < 100; ++i) {
                this.yy[i]++;
                if (this.yy[i] > 600) {
                    this.yy[i] = 0;
                }

                if (this.yy[i] > 0 && this.yy[i] < 150) {
                    this.fonts[i] = 18;
                } else if (this.yy[i] > 150 && this.yy[i] < 500) {
                    this.fonts[i] = 22;
                } else {
                    this.fonts[i] = 32;
                }
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException var2) {
                var2.printStackTrace();
            }

            this.repaint();
        }
    }
}

