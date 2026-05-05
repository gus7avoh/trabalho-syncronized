package com.appcadastro.labthreadsswing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaBanco extends JPanel {

    private JButton btnBuscar;
    private JButton btnOi;
    private JTextArea txtLog;
    private JScrollPane jScrollPane1;

    public TelaBanco() {
        initComponents();
    }

    private void initComponents() {

        btnBuscar   = new JButton("BUSCAR NO BD");
        btnOi       = new JButton("Testar Interface");
        txtLog      = new JTextArea();
        jScrollPane1 = new JScrollPane(txtLog);

        txtLog.setColumns(20);
        txtLog.setRows(5);
        txtLog.setEditable(false);
        txtLog.setFont(new Font("Monospaced", Font.PLAIN, 13));

        btnOi.addActionListener(this::btnOiActionPerformed);
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1)
                .addGroup(GroupLayout.Alignment.TRAILING,
                    layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOi)
                        .addComponent(btnBuscar)
                )
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnOi)
                        .addComponent(btnBuscar)
                )
        );
    }

    private void btnOiActionPerformed(ActionEvent evt) {
        txtLog.append("Interface funcionando!\n");
    }

    private void btnBuscarActionPerformed(ActionEvent evt) {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

                btnBuscar.setEnabled(false);

                txtLog.append("Buscando...\n");

                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    System.out.println("Erro na busca: " + e.getMessage());
                }

                txtLog.append("Busca finalizada!\n\n");
                btnBuscar.setEnabled(true);
            }
        });

        t.start();
    }
}
