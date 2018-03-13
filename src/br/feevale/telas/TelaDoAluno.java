package br.feevale.telas;

public class TelaDoAluno extends BaseTelaSwing {

    public TelaDoAluno() {
        super("Manutenção de Alunos");

        addField(2, 1, "Matricula", 2);
        addField(2, 4, "Nome", 5);
        addField(3, 1, "Teste", 12);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TelaDoAluno();
    }
}
