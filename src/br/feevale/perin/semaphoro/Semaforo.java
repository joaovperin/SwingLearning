/*
 * SwingLearning
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.feevale.perin.semaphoro;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
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

    private String ad = null;

    public Alerta getRed() {
        return red;
    }

    public Alerta getYellow() {
        return yellow;
    }

    public Alerta getGreen() {
        return green;
    }

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
        addKeyListener(new AbstractKeyListener() {

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
        });

        addComponentListener(new AbstractComponentListener() {
            @Override
            public void componentResized(ComponentEvent ce) {
                updateSize();
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

        float w10 = getWidth() / 10;
        int pX = (int) (getWidth() / 2 - w10 / 2);

        if (this.ad != null) {
            g.drawString(this.ad, pX, 50);
        }

    }

    public void swapAd(String ad) {
        this.ad = ad;
        repaint();
        SwingUtilities.invokeLater(() -> {
            try {
                Thread.sleep(2000);
                this.ad = null;
                repaint();
            } catch (InterruptedException ex) {

            }
        });
    }

    private void paintAlert(Graphics g, Alerta a) {
        final int off = 5;
        g.setColor(a.color());
        g.fillRect((int) (a.x() * w), (int) (a.y() * h + off * a.y()), w, h);
    }

}
