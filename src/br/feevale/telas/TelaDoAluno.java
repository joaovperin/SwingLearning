package br.feevale.telas;

import javax.swing.SwingUtilities;

public class TelaDoAluno extends BaseTelaSwing {

    public TelaDoAluno() {
        super("Manutenção de Alunos");
    }

    @Override
    protected void createWindow() {
        addField(2, 1, "Matricula", 2);
        addField(2, 4, "Nome", 5);
        addField(3, 1, "Teste", 12);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new TelaDoAluno());
    }
}
