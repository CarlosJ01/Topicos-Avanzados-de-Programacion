/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Windows;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.edisoncor.gui.util.Avatar;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Carlos J
 */
public class Busqueda extends javax.swing.JFrame {

    private JSONObject perfil = null;
    private JSONArray favoritas = null;
    private int idUsuario = -1;
    private JSONArray peliculas=null;
    private String busqueda ="";
    
    /**
     * Creates new form Busqueda
     */
    public Busqueda() {
        initComponents();
    }
    
    public Busqueda(JSONObject per,JSONArray favo,int idUsuario,String Busqueda) {
        initComponents();
        setLocationRelativeTo(this);
        this.setResizable(false);
        
        this.perfil=per;
        this.favoritas=favo;
        this.idUsuario=idUsuario;
        this.busqueda=Busqueda;
        
        System.out.println(busqueda+Busqueda);
        
        this.peliculas=sacarPeliculas();
        
        graficas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel2 = new org.edisoncor.gui.panel.Panel();
        panel1 = new org.edisoncor.gui.panel.Panel();
        lblLogo = new javax.swing.JLabel();
        lblGeneros1 = new org.edisoncor.gui.label.LabelMetric();
        pnlAvtPelis = new org.edisoncor.gui.panel.PanelAvatarChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblGeneros1.setText("Busqueda");
        lblGeneros1.setFont(new java.awt.Font("Consolas", 1, 48)); // NOI18N

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 341, Short.MAX_VALUE)
                .addComponent(lblGeneros1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(149, 149, 149))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblGeneros1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlAvtPelis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlAvtPelisMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlAvtPelis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlAvtPelis, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnlAvtPelisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlAvtPelisMouseClicked
        if(evt.getClickCount() >= 2 && !evt.isConsumed()) {
            evt.consume();
            try {
                String selec = pnlAvtPelis.getSelectedtitulo();
                for (int i = 0; i < peliculas.size(); i++) {
                    JSONObject peli = (JSONObject) peliculas.get(i);
                    String encontra = peli.get("titulo").toString();
                    if (encontra.equals(selec)) {
                        new Pelicula(peli,perfil,favoritas,idUsuario).setVisible(true);
                        this.dispose();
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Error al iniciar pelicula");
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_pnlAvtPelisMouseClicked

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
            java.util.logging.Logger.getLogger(Busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Busqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Busqueda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.label.LabelMetric lblGeneros1;
    private javax.swing.JLabel lblLogo;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.panel.Panel panel2;
    private org.edisoncor.gui.panel.PanelAvatarChooser pnlAvtPelis;
    // End of variables declaration//GEN-END:variables

    private JSONArray sacarPeliculas() {
        String url ="http://localhost:8080/NetFilmWS/recursos/servicio/busqueda/"+busqueda;
        System.out.println(url);
        Client cliente = ClientBuilder.newClient();
        WebTarget objetivo = cliente.target(url);
        String respuesta = objetivo.request(MediaType.APPLICATION_JSON).get(String.class);
        
        JSONArray lista = null;
                
        try {
            JSONParser jParser = new JSONParser();
            lista = (JSONArray) jParser.parse(respuesta);
        } catch (Exception e) {
            System.out.println("Error al sacar favoritas");
            System.out.println(e);
        }
        
        return lista;
    }
    
     private void graficas() {
        ImageIcon img = new ImageIcon(getClass().getResource("/com/Imagenes/logo.png"));
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(lblLogo.getWidth(),lblLogo.getHeight(),Image.SCALE_DEFAULT));
        lblLogo.setIcon(icono);
        
        
        if(peliculas.size()>=2){
            //Cambiar Avatars
            ArrayList<Avatar> avatares = new ArrayList<>();
            for (int i = 0; i < peliculas.size();i++) {
                try {
                    JSONObject peli =(JSONObject)peliculas.get(i);
                    String id = peli.get("id").toString();
                    String titulo = peli.get("titulo").toString();
                    String cadenaImg = peli.get("icono").toString();
                    byte [] byteImg = Base64.getDecoder().decode(cadenaImg);

                    InputStream in = new ByteArrayInputStream(byteImg);
                    Avatar anng = new Avatar(id, titulo, ImageIO.read(in));

                    avatares.add(anng);

                } catch (Exception e) {
                    System.out.println("Error al agregar avatares");
                    System.out.println(e);
                }
            }
            pnlAvtPelis.setAvatars(avatares);
        }else{
            ArrayList<Avatar> avatares = new ArrayList<>();
            try {
                JSONObject peli =(JSONObject)peliculas.get(0);
                String id = peli.get("id").toString();
                String titulo = peli.get("titulo").toString();
                String cadenaImg = peli.get("icono").toString();
                byte [] byteImg = Base64.getDecoder().decode(cadenaImg);

                InputStream in = new ByteArrayInputStream(byteImg);
                Avatar roku = new Avatar(id, titulo, ImageIO.read(in));
                
                avatares.add(roku);
                avatares.add(roku);
                
            } catch (Exception e) {
                System.out.println("Error al agregar avatares");
                System.out.println(e);
            }
            pnlAvtPelis.setAvatars(avatares);
        }
    }
}
