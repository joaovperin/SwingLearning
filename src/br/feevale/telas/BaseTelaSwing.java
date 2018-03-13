package br.feevale.telas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public abstract class BaseTelaSwing extends JFrame {

    public static final int ALTURA_LINHA = 43;
    public static final int NRO_COLUNAS = 12;
    public static final int MARGEM = 40;

    /**
     * Largura da coluna
     */
    private Integer larguraColuna;

    /**
     * Construtor
     *
     * @param titulo
     */
    public BaseTelaSwing(String titulo) {
        setTitle("FEEVALE - " + titulo);
        setLayout(null);
        setBounds(100, 100, 650, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * Adiciona um botão
     *
     * @param nrLinha
     * @param nrColuna
     * @param texto
     * @param largura
     * @return JButton
     */
    protected final JButton addButton(int nrLinha, int nrColuna, String texto, int largura) {

        int posColuna = getCoordenadaX(nrColuna);
        int posLinha = getCoordenadaY(nrLinha);

        JButton bt = new JButton(texto);
        bt.setBounds(posColuna, posLinha, largura * getLarguraColuna(), 38);
        getContentPane().add(bt);

        return bt;
    }

    /**
     * Adiciona um campo de texto
     *
     * @param nrLinha
     * @param nrColuna
     * @param texto
     * @param largura
     * @return JTextField
     */
    protected final JTextField addField(int nrLinha, int nrColuna, String texto, int largura) {

        int posColuna = getCoordenadaX(nrColuna);
        int posLinha = getCoordenadaY(nrLinha);

        JLabel lb = new JLabel(texto);
        lb.setBounds(posColuna, posLinha, largura * getLarguraColuna(), 20);
        getContentPane().add(lb);

        JTextField tf = new JTextField();
        tf.setBounds(posColuna, posLinha + 20, largura * getLarguraColuna(), 23);
        getContentPane().add(tf);

        return tf;
    }

    private int getCoordenadaY(int nrLinha) {
        return (MARGEM / 2) + ALTURA_LINHA * (nrLinha - 1);
    }

    private int getCoordenadaX(int nrColuna) {
        return (MARGEM / 2) + (nrColuna - 1) * getLarguraColuna();
    }

    private int getLarguraColuna() {
        if (larguraColuna == null) {
            larguraColuna = getWidth();
            larguraColuna -= MARGEM + 18;
            larguraColuna /= NRO_COLUNAS;
        }
        return larguraColuna;
    }

}
