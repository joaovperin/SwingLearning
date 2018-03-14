/*
 * SwingLearning
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.feevale.telas;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;
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
public class TelaCheckExemplo extends BaseTelaSwing implements ItemListener {

    public TelaCheckExemplo(String titulo) {
        super(titulo);
    }

    @Override
    protected void createWindow() {

        int i = 1, j = 1;
        addCheckbox(i++, j, "Algo", KeyEvent.VK_A).addItemListener(this);
        addCheckbox(i++, j, "Bem", KeyEvent.VK_B, true).addItemListener(this);
        addCheckbox(i++, j, "Comum", KeyEvent.VK_C).addItemListener(this);
        addCheckbox(i++, j, "De", KeyEvent.VK_D).addItemListener(this);
        addCheckbox(i++, j, "Se", KeyEvent.VK_S).addItemListener(this);
        addCheckbox(i++, j, "Ver", KeyEvent.VK_V).addItemListener(this);

        i = 1;
        j = 3;
        addCheckbox(i++, j, "Basta", KeyEvent.VK_B).addItemListener(this);
        addCheckbox(i++, j, "XXXX", KeyEvent.VK_X).addItemListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        //
        Object source = e.getItemSelectable();


        if (e.getStateChange() == ItemEvent.DESELECTED) {
            System.out.println("DESELECTED " + ((JCheckBox) source).getText());
        }
        //        //...
        //        updatePicture();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new TelaCheckExemplo("Teste Checkbox"));
    }

}
