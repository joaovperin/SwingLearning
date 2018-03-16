/*
 * SwingLearning
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.feevale.perin.semaphoro;

import java.util.concurrent.Callable;

/**
 * Descrição da classe.
 */
public class ControleSemaforo implements Runnable {

    private final Alerta green;
    private final Alerta yellow;
    private final Alerta red;

    private Callable repaint = () -> null;
    private Callable genAd = () -> null;

    public ControleSemaforo(Alerta green, Alerta yellow, Alerta red) {
        this.green = green;
        this.yellow = yellow;
        this.red = red;
    }

    public void setRepaint(Callable repaint) {
        this.repaint = repaint;
    }

    public void setGenAd(Callable genAd) {
        this.genAd = genAd;
    }

    @Override
    public final void run() {
        Alerta current = green;
        Alerta next = yellow;
        int time = 3;
        int adCounter = 0;

        while (true) {

            try {

                if (++adCounter >= 3) {
                    System.out.println("oi");
                    generateAd();
                    adCounter = 0;
                }

                if (current == green) {
                    time = 4;
                    next = yellow;
                } else if (current == yellow) {
                    time = 2;
                    next = red;
                } else if (current == red) {
                    time = 4;
                    next = green;
                }

                green.dark();
                yellow.dark();
                red.dark();

                current.light();

                repaintWindow();

                Thread.sleep(time * 800);
                current = next;

            } catch (InterruptedException ex) {

            }
        }
    }

    private void repaintWindow() {
        try {
            repaint.call();
        } catch (Exception ex) {
        }
    }

    private void generateAd() {
        try {
            genAd.call();
        } catch (Exception ex) {
        }
    }

}
