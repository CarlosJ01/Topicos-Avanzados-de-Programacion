/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Practica07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Carlos J
 */
public class Catalogo extends javax.swing.JFrame {

    private int opcion=0;
    private ArrayList<String> electronicos;
    private JSONArray vestimentas;
    private int ind=0;
    
    /**
     * Creates new form Catalogo
     */
    public Catalogo() {
        initComponents();
    }
    
    public Catalogo(int opc) {
        initComponents();
         setLocationRelativeTo(null);
        this.opcion=opc;
        this.electronicos=new ArrayList();
        this.vestimentas=new JSONArray();
        if (opcion==1) {
            leerElectronicos();
        } else {
            leerVestimenta();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        labelProducto = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelPrecio = new javax.swing.JLabel();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Book Antiqua", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Producto");

        labelProducto.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        labelProducto.setForeground(new java.awt.Color(51, 53, 230));
        labelProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelProducto.setText("jLabel2");

        jLabel3.setFont(new java.awt.Font("Book Antiqua", 0, 48)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Precio");

        labelPrecio.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        labelPrecio.setForeground(new java.awt.Color(188, 7, 7));
        labelPrecio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelPrecio.setText("jLabel2");

        btnAnterior.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        btnAnterior.setText("<-");
        btnAnterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAnteriorMouseClicked(evt);
            }
        });

        btnSiguiente.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        btnSiguiente.setText("->");
        btnSiguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSiguienteMouseClicked(evt);
            }
        });
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAnterior)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSiguiente)
                .addGap(14, 14, 14))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelProducto)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(labelPrecio)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelPrecio)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnterior)
                    .addComponent(btnSiguiente))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSiguienteMouseClicked
        ind++;
        mostrar();
    }//GEN-LAST:event_btnSiguienteMouseClicked

    private void btnAnteriorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnteriorMouseClicked
        ind--;
        mostrar();
    }//GEN-LAST:event_btnAnteriorMouseClicked

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSiguienteActionPerformed

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
            java.util.logging.Logger.getLogger(Catalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Catalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Catalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Catalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Catalogo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelPrecio;
    private javax.swing.JLabel labelProducto;
    // End of variables declaration//GEN-END:variables

    private void mostrar() {
        int mayor=0;
        if (opcion==1) {
            mayor=electronicos.size();
        } else {
            mayor=vestimentas.size();
        }
        if(ind == mayor){
            ind=0;
        }else{
            if(ind==-1){
                ind=4;
            }
        }
        JSONObject rgt=new JSONObject();
        if (opcion==1) {
            try {
                JSONParser parser= new JSONParser();
                rgt=(JSONObject)parser.parse(electronicos.get(ind).toString());
            } catch (ParseException ex) {
                Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            rgt= (JSONObject)vestimentas.get(ind);//Optener el objeto JSON encontrado en el indice del arreglo
        }
        labelProducto.setText(rgt.get("Producto").toString());
        labelPrecio.setText(rgt.get("Precio").toString());
    }
    
    private void leerVestimenta() {
        try {
            BufferedReader lector=new BufferedReader(new FileReader("Vestimenta.json"));
            String cadena="";
            String dato=null;
            while ((dato=lector.readLine())!=null) {                
                cadena+=dato;
            }
            lector.close();
            
            JSONParser parser = new JSONParser();
            vestimentas=(JSONArray)parser.parse(cadena);//Guardar la cadena extraida en el arrego de JSON
            mostrar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void leerElectronicos() {
        try {
            BufferedReader lector=new BufferedReader(new FileReader("Electronicos.json"));
            String cadena="";
            String dato=null;
            while ((dato=lector.readLine())!=null) {                
                electronicos.add(dato);
                System.out.println(dato);
            }
            lector.close();
            mostrar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
