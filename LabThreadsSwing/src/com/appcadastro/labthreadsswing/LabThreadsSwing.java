package com.appcadastro.labthreadsswing;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class LabThreadsSwing {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Banco - Lab Threads");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new TelaBanco());
            frame.pack();
            frame.setSize(500, 350);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}