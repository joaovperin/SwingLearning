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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Descrição da classe.
 */
public class Semaforo extends JFrame implements Runnable {

    private static final int ALERT_SIZE = 200;

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
    }

    @Override
    public void run() {
        buildWindow();
        startSemaphore();
    }

    private void buildWindow() {
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(bounds);
        setVisible(true);

        int row = 0;

        this.red = new Alerta(1, row++, Color.red);
        this.yellow = new Alerta(1, row++, Color.yellow);
        this.green = new Alerta(1, row++, Color.green);
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
        final int off = 55;
        g.setColor(a.color());
        g.fillRect(a.x * ALERT_SIZE, a.y * ALERT_SIZE + off, ALERT_SIZE, ALERT_SIZE);
    }

    private class Alerta {

        public final int x;
        public final int y;
        private final Color c;

        public int alpha = 255;

        public Alerta(int x, int y, Color color) {
            this.x = x;
            this.y = y;
            this.c = color;
        }

        public Color color() {
            return new Color(c.getRed(), c.getGreen(), c.getBlue(), alpha);
        }

        public void changeState() {
            if (this.alpha == 255) {
                this.alpha = 120;
            } else {
                this.alpha = 255;
            }
        }

        public void bright() {
            this.alpha = 255;
        }

        public void fade() {
            this.alpha = 120;
        }
    }

}
