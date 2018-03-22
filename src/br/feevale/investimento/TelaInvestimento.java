/*
 * SwingLearning
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.feevale.investimento;

import br.feevale.telas.*;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Tela de Investimentos
 *
 */
public class TelaInvestimento extends BaseTelaSwing {

    private JTextField tempoInvestimento;
    private JTextField juros;
    private JTextField valorInicial;

    public TelaInvestimento(String titulo) {
        super(titulo);
    }

    @Override
    protected void createWindow() {
        int i = 2, j = 5;
        juros = addField(i++, j, "Taxa de juros mensal", 3);
        valorInicial = addField(i++, j, "Valor Inicial aplicado", 3);
        tempoInvestimento = addField(i++, j, "Tempo de invesmento", 3);

        i = 7;
        j = 1;
        addButton(i, j, "Calcular investimento", 3, (ev) -> {
            try {
                String msg = String.format("Seu investimento rendeu %.2f reais!", calculaInvestimento());
                JOptionPane.showMessageDialog(null, msg, DESC_INFO, JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                String msg = "Conteúdo inválido nos campos numéricos! Favor digitar novamente.";
                JOptionPane.showMessageDialog(null, msg, DESC_INFO, JOptionPane.ERROR_MESSAGE);
            }
        });
        j += 4;
        addButton(i, j, "Limpar campos", 3, (ActionEvent ev) -> {
            String msg = "Deseja mesmo limpar?";
            int showConfirmDialog = JOptionPane.showConfirmDialog(null, msg, DESC_INFO, JOptionPane.OK_CANCEL_OPTION);
            if (showConfirmDialog == JOptionPane.OK_OPTION) {
                clearFields(juros, valorInicial, tempoInvestimento);
            } else {
                System.out.println("nao");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new TelaInvestimento("Teste RadioButton"));
    }

    private void clearFields(JTextField... fields) {
        for (JTextField f : fields) {
            if (f != null) {
                f.setText("");
            }
        }
    }

    private float calculaInvestimento() throws Exception {
        try {
            float inicial = Float.valueOf(valorInicial.getText());
            float percentual = Float.valueOf(juros.getText());
            int tempo = Integer.valueOf(tempoInvestimento.getText());
            // Returns 
            return inicial + calculaJurosComposto(inicial, percentual, tempo);
        } catch (NumberFormatException e) {
            throw new Exception();
        }
    }

    public float calculaJurosComposto(float valorInicial, float jurosMensal, int tempoInvestido) {
        if (tempoInvestido <= 0) {
            return 0;
        }
        if (tempoInvestido == 1) {
            return valorInicial * (jurosMensal / 100);
        }
        return valorInicial * (jurosMensal / 100)
                + calculaJurosComposto(valorInicial + valorInicial * (jurosMensal / 100),
                        jurosMensal,
                        tempoInvestido - 1);
    }

}
