package br.feevale.telas;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaExemplo extends JFrame {

    public TelaExemplo() {

        setTitle("Programa Exemplo - Prog III - FEEVALE");

        setBounds(100, 50, 600, 350);

        setLayout(null);

        JLabel lb = new JLabel();
        lb.setText("Programação III - FEEVALE");
        lb.setBounds(100, 30, 300, 30);
        getContentPane().add(lb);

        lb.setForeground(Color.RED);
        lb.setBackground(Color.GRAY);
        lb.setOpaque(true);
        lb.setHorizontalAlignment(JLabel.CENTER);

        JTextField tf = new JTextField();
        tf.setBounds(50, 100, 230, 23);
        getContentPane().add(tf);

        JComboBox<String> times = new JComboBox<>();
        times.addItem("Internacional");
        times.addItem("Novo Hamburgo");
        times.addItem("Flumiense");
        times.addItem("São Paulo");
        times.addItem("Goianiense");
        times.addItem("Lituano");
        times.addItem("Chapecoense");
        times.setBounds(50, 140, 180, 23);
        getContentPane().add(times);

        JButton botao = new JButton("Confirma");
        botao.setBounds(50, 180, 180, 25);
        getContentPane().add(botao);

        setVisible(true);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {

        System.out.println("Hello World");
        new TelaExemplo();
    }
}
