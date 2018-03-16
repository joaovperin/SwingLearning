/*
 * SwingLearning
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.feevale.perin;

import br.feevale.perin.semaphoro.AdvertisementGenerator;
import br.feevale.perin.semaphoro.ControleSemaforo;
import br.feevale.perin.semaphoro.Semaforo;
import java.util.concurrent.Callable;
import javax.swing.SwingUtilities;

/**
 * Descrição da classe.
 */
public class SemaphoroMain implements Runnable {

    /**
     * Main entry point
     *
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new SemaphoroMain());
    }

    @Override
    public void run() {

        Semaforo semaforo = new Semaforo();
        semaforo.run();

        ControleSemaforo cs = new ControleSemaforo(semaforo.getGreen(), semaforo.getYellow(), semaforo.getRed());
        cs.setRepaint((Callable) () -> {
            semaforo.repaint();
            return null;
        });
        cs.setGenAd((Callable) () -> {
            semaforo.swapAd(AdvertisementGenerator.randomAd());
            return null;
        });
        new Thread(cs).start();
    }

}
