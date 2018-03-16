/*
 * SwingLearning
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.feevale.perin.semaphoro;

import java.awt.Color;

/**
 * Descrição da classe.
 */
public class Alerta {

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
