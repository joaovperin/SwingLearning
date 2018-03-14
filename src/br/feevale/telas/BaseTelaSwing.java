package br.feevale.telas;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public abstract class BaseTelaSwing extends JFrame implements Runnable {

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
        createWindow();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * Método para ser sobrescrito p/ criar a janela
     */
    protected abstract void createWindow();

    /**
     * Roda a aplicação - Torna visível
     */
    @Override
    public final void run() {
        setVisible(true);
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

        JButton component = new JButton(texto);
        component.setBounds(posColuna, posLinha, largura * getLarguraColuna(), 38);
        getContentPane().add(component);

        return component;
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

        JTextField component = new JTextField();
        component.setBounds(posColuna, posLinha + 20, largura * getLarguraColuna(), 23);
        getContentPane().add(component);

        return component;
    }

    protected final JCheckBox addCheckbox(int nrLinha, int nrColuna, String texto) {
        return addCheckbox(nrLinha, nrColuna, texto, null);
    }

    protected final JCheckBox addCheckbox(int nrLinha, int nrColuna, String texto, Integer key) {
        return addCheckbox(nrLinha, nrColuna, texto, key, false);
    }

    protected final JCheckBox addCheckbox(int nrLinha, int nrColuna, String texto, Integer key, boolean selected) {

        int posColuna = getCoordenadaX(nrColuna);
        int posLinha = getCoordenadaY(nrLinha, ALTURA_LINHA *3/5);

        JCheckBox component = new JCheckBox(texto);
        component.setBounds(posColuna, posLinha, 2 * getLarguraColuna(), 15);
        component.setToolTipText(texto);
        if (key != null) {
            component.setMnemonic(key);
        }
        component.setSelected(selected);
        getContentPane().add(component);

        return component;
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
    protected final JTextArea addTextArea(int nrLinha, int nrColuna, String texto, int largura) {

        int posColuna = getCoordenadaX(nrColuna);
        int posLinha = getCoordenadaY(nrLinha);

        JLabel lb = new JLabel(texto);
        lb.setBounds(posColuna, posLinha, largura * getLarguraColuna(), 20);
        getContentPane().add(lb);

        JTextArea component = new JTextArea();
        component.setBounds(posColuna, posLinha + 20, largura * getLarguraColuna(), 23);
        getContentPane().add(component);

        return component;
    }

    private int getCoordenadaY(int nrLinha) {
        return getCoordenadaY(nrLinha, ALTURA_LINHA);
    }

    private int getCoordenadaY(int nrLinha, int alturaLinha) {
        return (MARGEM / 2) + alturaLinha * (nrLinha - 1);
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
