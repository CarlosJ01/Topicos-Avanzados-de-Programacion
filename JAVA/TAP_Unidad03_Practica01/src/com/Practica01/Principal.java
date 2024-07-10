/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Practica01;

import com.Modelos.Catalogo;
import com.Modelos.ManejadorBD;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos J
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        buttonConsultas = new javax.swing.JButton();
        buttonBajas = new javax.swing.JButton();
        buttonAltas = new javax.swing.JButton();
        buttonModificaciones = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        buttonConsultas.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        buttonConsultas.setText("Consultas");
        buttonConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConsultasActionPerformed(evt);
            }
        });

        buttonBajas.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        buttonBajas.setText("Bajas");
        buttonBajas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonBajasMouseClicked(evt);
            }
        });

        buttonAltas.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        buttonAltas.setText("Altas");
        buttonAltas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonAltasMouseClicked(evt);
            }
        });

        buttonModificaciones.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        buttonModificaciones.setText("Modificaciones");
        buttonModificaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonModificacionesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(buttonModificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonAltas, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonBajas, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonBajas, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAltas, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonModificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConsultasActionPerformed
        try {
            ManejadorBD manejador =  new ManejadorBD();
            ArrayList<Catalogo> productos = manejador.leerBD();
            jTextArea1.setText("Id\tProducto\n\n");
            for(Catalogo catalogo:productos){
                jTextArea1.append(catalogo.getId() + "\t" + catalogo.getProducto());
                jTextArea1.append("\n");
            }
        } catch (Exception e) {
            System.out.println("Error al leer la base de datos");
        }
    }//GEN-LAST:event_buttonConsultasActionPerformed

    private void buttonAltasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAltasMouseClicked
        String producto = JOptionPane.showInputDialog("Nombre del Producto:");
        try {
            ManejadorBD manejador = new ManejadorBD();
            int siono = manejador.agregarProducto(producto);
            if(siono>0){
                JOptionPane.showMessageDialog(null,"Agregado");
            }
            else{
                JOptionPane.showMessageDialog(null,"Fallo");
            }
        } catch (Exception e) {
            System.out.println("Error al dar de alta un producto");
        }
    }//GEN-LAST:event_buttonAltasMouseClicked

    private void buttonBajasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonBajasMouseClicked
        String producto =JOptionPane.showInputDialog("Nombre del produto: ");
        try {
            ManejadorBD manejador = new ManejadorBD();
            int siono = manejador.eliminarProducto(producto);
            if (siono>0) {
                JOptionPane.showMessageDialog(null,"Eliminado");
            } else {
                JOptionPane.showMessageDialog(null,"Fallo");
            }
        } catch (Exception e) {
            System.out.println("Error al dar de baja un producto");
        }
    }//GEN-LAST:event_buttonBajasMouseClicked

    private void buttonModificacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonModificacionesMouseClicked
       String id =JOptionPane.showInputDialog("Id del producto: ");
       String producto =JOptionPane.showInputDialog("Nuevo nombre del produto: ");
       
        try {
            ManejadorBD manejador = new ManejadorBD();
            int siono = manejador.modificarProducto(Integer.valueOf(id),producto);
            if (siono>0) {
                JOptionPane.showMessageDialog(null,"Modificado");
            } else {
                JOptionPane.showMessageDialog(null,"Fallo");
            }
        } catch (Exception e) {
            System.out.println("Error al modificar un producto");
        }
    }//GEN-LAST:event_buttonModificacionesMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAltas;
    private javax.swing.JButton buttonBajas;
    private javax.swing.JButton buttonConsultas;
    private javax.swing.JButton buttonModificaciones;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}