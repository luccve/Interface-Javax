package com.app;

import javax.swing.*;
import java.awt.event.*;

public class Interface {

    // Criação dos campos de entrada como variáveis de instância
    private JTextField campoAltura;
    private JTextField campoPeso;
    private JTextArea resultado;

    public Interface() {

        // Criando a janela
        JFrame janela = new JFrame("Janela de IMC");
        janela.setSize(480, 180); // Definindo o tamanho da janela
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configurando o comportamento padrão ao fechar a janela

        // Criando os campos de entrada para altura e peso
        campoAltura = new JTextField(10);
        campoPeso = new JTextField(10);
        resultado = new JTextArea();
        // Adicionando os campos de entrada na janela
        JButton botaoCalcular = new JButton("Calcular");
        JPanel painel = new JPanel();
        painel.add(new JLabel("Altura (cm): "));
        painel.add(campoAltura);
        painel.add(Box.createHorizontalStrut(15)); // Espaço entre os componentes
        painel.add(new JLabel("Peso (kg): "));
        painel.add(campoPeso);
        painel.add(botaoCalcular);
        painel.add(resultado);

        // Adicionando o painel na janela
        janela.getContentPane().add(painel);


        botaoCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Resgatando os valores dos campos de entrada
                float altura = Float.parseFloat(campoAltura.getText());
                float peso = Float.parseFloat(campoPeso.getText());

                // Realizando o cálculo do IMC
                float imc = calcularIMC(altura, peso);

                // Texto
                String msg = ClassificacaoIMC(imc);

                // Exibindo o resultado do cálculo em um componente de texto
                resultado.setText(msg);
            }
        });



        // Exibindo a janela
        janela.setVisible(true);
    }

    // Método para calcular o IMC
    private float calcularIMC(float altura, float peso) {
        System.out.println(altura);
        float newAltura = altura/100;
        return peso / (newAltura * newAltura);
    }

    private String ClassificacaoIMC(float IMC) {
        String msg = "";
        if (IMC < 18.5) {
            msg = "Seu IMC é: " + IMC + "\nVocê está abaixo do peso.";
        } else if (IMC >= 18.5 && IMC <= 24.9) {
            msg = "Seu IMC é: " + IMC + "\nVocê está com o peso normal.";
        } else if (IMC >= 25 && IMC <= 29.9) {
            msg = "Seu IMC é: " + IMC + "\nVocê está com sobrepeso.";
        } else if (IMC >= 30) {
            msg = "Seu IMC é: " + IMC + "\nVocê está com obesidade.";
        } else {
            msg = "IMC inválido.";
        }
        return msg;
    }


}