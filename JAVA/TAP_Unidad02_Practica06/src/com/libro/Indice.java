
package com.libro;

import java.util.List;
import javax.swing.SwingWorker;

public class Indice extends javax.swing.JFrame  {


    public Indice() {
        initComponents();
        setLocationRelativeTo(this);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        volteo = new javax.swing.JLabel();
        Capitulo1 = new javax.swing.JLabel();
        Capitulo2 = new javax.swing.JLabel();
        Capitulo3 = new javax.swing.JLabel();
        Capitulo4 = new javax.swing.JLabel();
        Capitulo5 = new javax.swing.JLabel();
        atras = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(550, 635));
        setType(java.awt.Window.Type.UTILITY);

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/p6/images/cambioPag6.png"))); // NOI18N

        volteo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/p6/images/volteoPagina.png"))); // NOI18N
        volteo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        volteo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                volteoMouseClicked(evt);
            }
        });

        Capitulo1.setBackground(new java.awt.Color(255, 255, 255));
        Capitulo1.setFont(new java.awt.Font("sansserif", 0, 8)); // NOI18N
        Capitulo1.setForeground(new java.awt.Color(255, 255, 255));
        Capitulo1.setText("                                                                                                                   _");
        Capitulo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Capitulo1MouseClicked(evt);
            }
        });

        Capitulo2.setBackground(new java.awt.Color(255, 255, 255));
        Capitulo2.setFont(new java.awt.Font("sansserif", 0, 8)); // NOI18N
        Capitulo2.setForeground(new java.awt.Color(255, 255, 255));
        Capitulo2.setText("                                                                                                                   _");
        Capitulo2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Capitulo2MouseClicked(evt);
            }
        });

        Capitulo3.setBackground(new java.awt.Color(255, 255, 255));
        Capitulo3.setFont(new java.awt.Font("sansserif", 0, 8)); // NOI18N
        Capitulo3.setForeground(new java.awt.Color(255, 255, 255));
        Capitulo3.setText("                                                                                                                   _");
        Capitulo3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Capitulo3MouseClicked(evt);
            }
        });

        Capitulo4.setBackground(new java.awt.Color(255, 255, 255));
        Capitulo4.setFont(new java.awt.Font("sansserif", 0, 8)); // NOI18N
        Capitulo4.setForeground(new java.awt.Color(255, 255, 255));
        Capitulo4.setText("                                                                                                                   _");
        Capitulo4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Capitulo4MouseClicked(evt);
            }
        });

        Capitulo5.setBackground(new java.awt.Color(255, 255, 255));
        Capitulo5.setFont(new java.awt.Font("sansserif", 0, 8)); // NOI18N
        Capitulo5.setForeground(new java.awt.Color(255, 255, 255));
        Capitulo5.setText("                                                                                                                   _");
        Capitulo5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Capitulo5MouseClicked(evt);
            }
        });

        atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/p6/images/volteoPagina.png"))); // NOI18N
        atras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        atras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                atrasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(atras, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(volteo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(panelImage1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelImage1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(Capitulo5, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Capitulo4, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Capitulo3, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Capitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Capitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(Capitulo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Capitulo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Capitulo3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Capitulo4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Capitulo5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 393, Short.MAX_VALUE)
                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(volteo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(atras, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volteoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volteoMouseClicked
       new PaginasIndice(this,1).execute();
    }//GEN-LAST:event_volteoMouseClicked

    private void Capitulo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Capitulo1MouseClicked
        volteoMouseClicked(evt);
    }//GEN-LAST:event_Capitulo1MouseClicked

    private void Capitulo2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Capitulo2MouseClicked
        new PaginasIndice(this,2).execute();
    }//GEN-LAST:event_Capitulo2MouseClicked

    private void Capitulo3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Capitulo3MouseClicked
        new PaginasIndice(this,3).execute();
    }//GEN-LAST:event_Capitulo3MouseClicked

    private void Capitulo4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Capitulo4MouseClicked
        new PaginasIndice(this,4).execute();
    }//GEN-LAST:event_Capitulo4MouseClicked

    private void Capitulo5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Capitulo5MouseClicked
        new PaginasIndice(this,5).execute();
    }//GEN-LAST:event_Capitulo5MouseClicked

    private void atrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atrasMouseClicked
        new PaginasIndice(this,0).execute();
    }//GEN-LAST:event_atrasMouseClicked

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
            java.util.logging.Logger.getLogger(Indice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Indice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Indice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Indice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Indice().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Capitulo1;
    private javax.swing.JLabel Capitulo2;
    private javax.swing.JLabel Capitulo3;
    private javax.swing.JLabel Capitulo4;
    private javax.swing.JLabel Capitulo5;
    private javax.swing.JLabel atras;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private javax.swing.JLabel volteo;
    // End of variables declaration//GEN-END:variables
  
//Siguiente paguina
    class PaginasIndice extends SwingWorker{
      private Indice libro;
      private int paguina;

        public PaginasIndice(Indice libro,int pag) {
            this.libro = libro;
            this.paguina=pag;
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
            atras.setVisible(false);
            volteo.setVisible(false);
            String pag= chunks.get(0).toString();
            int p = Integer.parseInt(pag);
            panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/p6/images/volteoPagFinal"+ p +".png")));
            panelImage1.updateUI();
        }
        
        protected void abrir(){
            switch (paguina) {
                case 0:
                        new Libro().setVisible(true);
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

