/*
 * SwingLearning
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.feevale.perin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Descrição da classe.
 */
public class Semaforo extends JFrame implements Runnable {

    public static int w = 80;
    public static int h = 80;

    /** Window Size */
    private final Rectangle bounds;

    private Alerta red;
    private Alerta yellow;
    private Alerta green;

    public Semaforo() {
        super("Semaforo");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();

        int wMargin = (int) width / 6;
        int hMargin = (int) height / 6;

        System.out.printf("** Assuming resolution of %d/%d\n", (int) width, (int) height);

        this.bounds = new Rectangle(wMargin, hMargin, (int) width - 2 * wMargin, (int) height - 2 * hMargin);
        updateSize();
    }

    @Override
    public void run() {
        buildWindow();
        startSemaphore();
        new Thread(() -> {
            runBlablabla();
        }).start();
    }

    private void buildWindow() {
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(bounds);
        setVisible(true);

        float row = 2.9f;
        float col = 4.5f;

        this.red = new Alerta(col, row++, Color.red);
        this.yellow = new Alerta(col, row++, Color.yellow);
        this.green = new Alerta(col, row++, Color.green);
    }

    private void startSemaphore() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {

            }

            @Override
            public void keyPressed(KeyEvent k) {
                switch (k.getKeyChar()) {
                    case '1':
                        green.changeState();
                        break;
                    case '2':
                        yellow.changeState();
                        break;
                    case '3':
                        red.changeState();
                        break;
                    default:
                        break;
                }
                repaint();
            }

            @Override
            public void keyReleased(KeyEvent ke) {

            }
        });

        addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent ce) {
                updateSize();
            }

            @Override
            public void componentMoved(ComponentEvent ce) {
            }

            @Override
            public void componentShown(ComponentEvent ce) {
            }

            @Override
            public void componentHidden(ComponentEvent ce) {
            }

        });
    }

    public final void updateSize() {
        Dimension size = getSize();
        w = (int) (size.getWidth() / 10);
        h = (int) (size.getHeight() / 10);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        paintAlert(g, red);
        paintAlert(g, yellow);
        paintAlert(g, green);
    }

    /**
     * Main entry point
     *
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Semaforo());
    }

    private void paintAlert(Graphics g, Alerta a) {
//        final int off = getHeight() / 15;
        final int off = 5;
        g.setColor(a.color());
        g.fillRect((int) (a.x() * w), (int) (a.y() * h + off * a.y()), w, h);
    }

    private class Alerta {

        private final float x;
        private final float y;
        private final Color c;

        private int alpha = 255;

        public Alerta(float x, float y, Color color) {
            this.x = x;
            this.y = y;
            this.c = color;
        }

        public float x() {
            return x;
        }

        public float y() {
            return y;
        }

        public Color color() {
            return new Color(c.getRed(), c.getGreen(), c.getBlue(), alpha);
        }

        public void dark() {
            this.alpha = 120;
        }

        public void light() {
            this.alpha = 255;
        }

        public void changeState() {
            if (this.alpha == 255) {
                dark();
            } else {
                light();
            }
        }

    }

    public void runBlablabla() {

        Alerta current = green;
        Alerta next = yellow;
        int time = 3;

        while (true) {

            try {
                if (current == green) {
                    time = 5;
                    next = yellow;
                } else if (current == yellow) {
                    time = 2;
                    next = red;
                } else if (current == red) {
                    time = 5;
                    next = green;
                }

                green.dark();
                yellow.dark();
                red.dark();

                current.light();
                repaint();
                Thread.sleep(time * 1000);
                current = next;

            } catch (InterruptedException ex) {

            }
        }

    }

}
