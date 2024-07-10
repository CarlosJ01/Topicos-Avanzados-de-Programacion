
package com.libro;

import java.util.List;
import javax.swing.SwingWorker;


public class Capitulo2 extends javax.swing.JFrame {

  
    public Capitulo2() {
        initComponents();
        setLocationRelativeTo(this);
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        panelImage2 = new org.edisoncor.gui.panel.PanelImage();
        atras = new javax.swing.JLabel();
        volteo1 = new javax.swing.JLabel();

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/p6/images/cambioPag8.jpg"))); // NOI18N

        atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/p6/images/volteoPagina.png"))); // NOI18N
        atras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        atras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                atrasMouseClicked(evt);
            }
        });

        volteo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/p6/images/volteoPagina.png"))); // NOI18N
        volteo1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        volteo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                volteo1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelImage2Layout = new javax.swing.GroupLayout(panelImage2);
        panelImage2.setLayout(panelImage2Layout);
        panelImage2Layout.setHorizontalGroup(
            panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(atras, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(443, Short.MAX_VALUE))
            .addGroup(panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage2Layout.createSequentialGroup()
                    .addContainerGap(431, Short.MAX_VALUE)
                    .addComponent(volteo1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)))
        );
        panelImage2Layout.setVerticalGroup(
            panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage2Layout.createSequentialGroup()
                .addGap(0, 580, Short.MAX_VALUE)
                .addComponent(atras, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage2Layout.createSequentialGroup()
                    .addContainerGap(564, Short.MAX_VALUE)
                    .addComponent(volteo1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(16, 16, 16)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelImage2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelImage2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atrasMouseClicked
        new Paginas(this,1).execute();
    }//GEN-LAST:event_atrasMouseClicked

    private void volteo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volteo1MouseClicked
        new Paginas(this,3).execute();
    }//GEN-LAST:event_volteo1MouseClicked


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
            java.util.logging.Logger.getLogger(Capitulo2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Capitulo2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Capitulo2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Capitulo2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Capitulo2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel atras;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private org.edisoncor.gui.panel.PanelImage panelImage2;
    private javax.swing.JLabel volteo1;
    // End of variables declaration//GEN-END:variables
 
    class Paginas extends SwingWorker{
      private Capitulo2 libro;
      private int paguina;

        public Paginas(Capitulo2 libro,int paguina) {
            this.libro = libro;
            this.paguina=paguina;
        }
      

        @Override
        protected Object doInBackground() throws Exception {
            for (int i = 1; i <= 5; i++) {
                this.publish("" + i);
                Thread.sleep(150);
            }
            return "";
        }

        @Override
        protected void done() {
            super.done(); //
            libro.hide();
            abrir();
        }

        @Override
        protected void process(List chunks) {
            super.process(chunks); 
            volteo1.setVisible(false);
            atras.setVisible(false);
            String pag= chunks.get(0).toString();
            int p = Integer.parseInt(pag);
            panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/p6/images/volteoPagFinal"+ p +".png")));
            panelImage1.updateUI();
        }
        
        protected void abrir(){
            switch (paguina) {
                case 0:
                        new Indice().setVisible(true);
                    break;
                case 1:
                        new Capitulo1().setVisible(true);
                    break;
                 case 2:
                        new Capitulo2().setVisible(true);
                    break;
                case 3:
                        new Capitulo3().setVisible(true);
                    break;
                case 4:
                        new Capitulo4().setVisible(true);
                    break;
                case 5:
                        new Capitulo5().setVisible(true);
                    break;
                default:
                    throw new AssertionError();
            }
        }
        
  }
}
