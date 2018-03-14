package br.feevale.telas;

import javax.swing.SwingUtilities;

public class TelaFuncionarios extends BaseTelaSwing {

    public TelaFuncionarios() {
        super("Funcionários");
    }

    @Override
    protected void createWindow() {
        addField(2, 2, "Código", 2);
        addField(3, 2, "Nome", 10);
        addField(4, 2, "Endereço", 10);

        addButton(7, 10, "Cancelar", 2);
        addButton(7, 8, "Salvar", 2);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new TelaFuncionarios());
    }

}
