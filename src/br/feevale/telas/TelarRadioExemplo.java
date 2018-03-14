/*
 * SwingLearning
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.feevale.telas;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.SwingUtilities;

/**
 * Descrição da classe.
 *
 * Checkbox Example.
 * https://docs.oracle.com/javase/tutorial/uiswing/examples/components/CheckBoxDemoProject/src/components/CheckBoxDemo.java
 * https://docs.oracle.com/javase/tutorial/uiswing/examples/components/index.html#CheckBoxDemo
 * https://docs.oracle.com/javase/tutorial/uiswing/components/button.html#radiobutton
 * https://docs.oracle.com/javase/tutorial/uiswing/components/button.html
 *
 */
public class TelarRadioExemplo extends BaseTelaSwing implements ItemListener {

    public TelarRadioExemplo(String titulo) {
        super(titulo);
    }

    @Override
    protected void createWindow() {
        int i = 1, j = 1;
        addRadioButtons(this,
                createRadioButton(i++, j, "Algo"),
                createRadioButton(i++, j, "Bem"));

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new TelarRadioExemplo("Teste RadioButton"));
    }

}
