package br.feevale.telas;

public class TelaFuncionarios extends BaseTelaSwing {

    public TelaFuncionarios() {
        super("Funcionários");

        addField(2, 2, "Código", 2);
        addField(3, 2, "Nome", 10);
        addField(4, 2, "Endereço", 10);

        addButton(7, 10, "Cancelar", 2);
        addButton(7, 8, "Salvar", 2);

        setVisible(true);
    }

    public static void main(String[] args) {
        new TelaFuncionarios();
    }

}
