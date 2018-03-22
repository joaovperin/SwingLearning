package br.feevale.telas;

import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Formatter;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public abstract class BaseTelaSwing extends JFrame implements Runnable {

    protected static final String DESC_INFO = "Informação";

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
    @SuppressWarnings("OverridableMethodCallInConstructor")
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
        return addButton(nrLinha, nrColuna, texto, largura, null);
    }

    protected final JButton addButton(int nrLinha, int nrColuna, String texto, int largura, ActionListener al) {

        int posColuna = getCoordenadaX(nrColuna);
        int posLinha = getCoordenadaY(nrLinha);

        JButton component = new JButton(texto);
        if (al != null) {
            component.addActionListener(al);
        }
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

    protected final JFormattedTextField addNumberField(int nrLinha, int nrColuna, String texto, int largura) {

        int posColuna = getCoordenadaX(nrColuna);
        int posLinha = getCoordenadaY(nrLinha);

        JLabel lb = new JLabel(texto);
        lb.setBounds(posColuna, posLinha, largura * getLarguraColuna(), 20);
        getContentPane().add(lb);

        JFormattedTextField component = new JFormattedTextField(NumberFormat.getCurrencyInstance());
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
        int posLinha = getCoordenadaY(nrLinha, ALTURA_LINHA * 3 / 5);

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

    protected final void addRadioButtons(JRadioButton... radios) {
        addRadioButtons(this, radios);
    }

    protected final void addRadioButtons(JFrame parent, JRadioButton... radios) {
        addRadioButtons(parent, new ButtonGroup(), radios);
    }

    protected final void addRadioButtons(JFrame parent, ButtonGroup group, JRadioButton... radios) {
        for (JRadioButton r : radios) {
            group.add(r);
            parent.add(r);
        }
        if (parent != this) {
            getContentPane().add(parent);
        }
    }

    protected final JRadioButton createRadioButton(int nrLinha, int nrColuna, String texto) {
        return createRadioButton(nrLinha, nrColuna, texto, false);
    }

    protected final JRadioButton createRadioButton(int nrLinha, int nrColuna, String texto, boolean selected) {

        int posColuna = getCoordenadaX(nrColuna);
        int posLinha = getCoordenadaY(nrLinha, ALTURA_LINHA * 3 / 5);

        JRadioButton component = new JRadioButton(texto);
        component.setBounds(posColuna, posLinha, 2 * getLarguraColuna(), 15);
        component.setToolTipText(texto);

        component.setSelected(selected);

        return component;
    }

    protected final JTextArea addTextArea(int nrLinha, int nrColuna, String texto, int largura) {
        return addTextArea(nrLinha, nrColuna, texto, largura, 25);
    }

    protected final JTextArea addTextArea(int nrLinha, int nrColuna, String texto, int largura, int altura) {

        int posColuna = getCoordenadaX(nrColuna);
        int posLinha = getCoordenadaY(nrLinha);

        JLabel lb = new JLabel(texto);
        lb.setBounds(posColuna, posLinha, largura * getLarguraColuna(), altura * getAlturaLinha());
        getContentPane().add(lb);

        posLinha += getAlturaLinha();

        JTextArea component = new JTextArea();
        component.setBounds(posColuna, posLinha + 20, largura * getLarguraColuna(), altura * getAlturaLinha());
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

    private int getAlturaLinha() {
        return ALTURA_LINHA;
    }

}
