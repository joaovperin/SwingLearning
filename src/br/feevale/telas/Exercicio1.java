/*
 * SwingLearning
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.feevale.telas;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
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
public class Exercicio1 extends BaseTelaSwing implements ItemListener {

    public Exercicio1(String titulo) {
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

        i = 3;
        j = 3;
        addRadioButtons(this,
                createRadioButton(i++, j, "Sim"),
                createRadioButton(i++, j, "Não"));

        i = 3;
        j = 5;
        addTextArea(i, j, "Digite seus dados", 6, 2);

        i = 1;
        j = 5;
        addField(i++, j, "Nome", 3);
        addField(i++, j, "Sobrenome", 3);
        i = 1;
        j = 9;
        addField(i++, j, "Oie", 3);
        addField(i++, j, "Tchauo", 3);

        i = 7;
        j = 1;
        addButton(i, j, "TOUCHÉ", 3).addActionListener((e) -> JOptionPane.showMessageDialog(null, "Atenção", "EU sou bonito :D", JOptionPane.OK_OPTION));
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Object item = e.getItem();
        System.out.println("CLIQUEI NA CHECKBOX " + e.getSource());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Exercicio1("Teste RadioButton"));
    }

}
