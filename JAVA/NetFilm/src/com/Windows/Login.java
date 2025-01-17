/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Windows;

import com.bulenkov.darcula.DarculaLaf;
import com.sun.glass.events.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


/**
 *
 * @author Carlos J
 */
public class Login extends javax.swing.JFrame {

    JSONObject usuario = null;
    
    /**
     * Creates new form Inicio
     */
    public Login() {
        initComponents();
        setLocationRelativeTo(null);
        this.setResizable(false);
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
        panelTranslucido1 = new org.edisoncor.gui.panel.PanelTranslucido();
        labelMetric2 = new org.edisoncor.gui.label.LabelMetric();
        txtUsuario = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        labelMetric5 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric6 = new org.edisoncor.gui.label.LabelMetric();
        buttonRound1 = new org.edisoncor.gui.button.ButtonRound();
        labelMetric7 = new org.edisoncor.gui.label.LabelMetric();
        txtPassword = new org.edisoncor.gui.passwordField.PasswordFieldRoundImage();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio");

        panel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Imagenes/Fondo01.jpg"))); // NOI18N

        labelMetric2.setText("Iniciar Sesion");
        labelMetric2.setFont(new java.awt.Font("Consolas", 1, 48)); // NOI18N

        txtUsuario.setFont(new java.awt.Font("Dialog", 0, 30)); // NOI18N

        labelMetric5.setText("Usuario");
        labelMetric5.setFont(new java.awt.Font("Consolas", 1, 30)); // NOI18N

        labelMetric6.setText("Contraseña");
        labelMetric6.setFont(new java.awt.Font("Consolas", 1, 30)); // NOI18N

        buttonRound1.setBackground(new java.awt.Color(153, 0, 0));
        buttonRound1.setText("Inicio");
        buttonRound1.setFont(new java.awt.Font("Consolas", 1, 25)); // NOI18N
        buttonRound1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonRound1MouseClicked(evt);
            }
        });

        labelMetric7.setText("Crear una Cuenta");
        labelMetric7.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        labelMetric7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelMetric7MouseClicked(evt);
            }
        });

        txtPassword.setFont(new java.awt.Font("Dialog", 0, 30)); // NOI18N
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panelTranslucido1Layout = new javax.swing.GroupLayout(panelTranslucido1);
        panelTranslucido1.setLayout(panelTranslucido1Layout);
        panelTranslucido1Layout.setHorizontalGroup(
            panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTranslucido1Layout.createSequentialGroup()
                .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTranslucido1Layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(labelMetric2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTranslucido1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelMetric6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMetric5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(151, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTranslucido1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelMetric7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(355, 355, 355))
        );
        panelTranslucido1Layout.setVerticalGroup(
            panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTranslucido1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(labelMetric2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMetric5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelMetric6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(buttonRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelMetric7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(panelTranslucido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(panelTranslucido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
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

    private void buttonRound1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonRound1MouseClicked
        String usr = txtUsuario.getText();
        String pass = txtPassword.getText();
        
        String url ="http://localhost:8080/NetFilmWS/recursos/servicio/acceder";
        try {
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(url);
            Response response = target.queryParam("usuario",usr).queryParam("contrasenia",pass).request().method("POST");
            String respuesta = response.readEntity(String.class);

            System.out.println(respuesta);
            int numero = Integer.parseInt(respuesta);
            
            if(numero<=0){
                JOptionPane.showMessageDialog(null,"Usuario o Contraseña Incorrectas","Error",JOptionPane.ERROR_MESSAGE);
            }else{
                usuario = extraerUsuario();
                new Perfiles(Integer.parseInt(usuario.get("id").toString())).setVisible(true);
                this.dispose();
            }
        } catch (Exception e) {
            System.out.println("Error al acceder");
            System.out.println(e);
        }
    }//GEN-LAST:event_buttonRound1MouseClicked

    private void labelMetric7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMetric7MouseClicked
        if(evt.getClickCount() >= 2) {
            new Registro().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_labelMetric7MouseClicked

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.buttonRound1MouseClicked(null);
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Material Design look and feel */
        try {
            UIManager.setLookAndFeel(new DarculaLaf());
        } catch (Exception e) {
            System.out.println("Error al abrir");
            System.out.println(e);
            System.exit(1);
        }

        /*  Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonRound buttonRound1;
    private org.edisoncor.gui.label.LabelMetric labelMetric2;
    private org.edisoncor.gui.label.LabelMetric labelMetric5;
    private org.edisoncor.gui.label.LabelMetric labelMetric6;
    private org.edisoncor.gui.label.LabelMetric labelMetric7;
    private org.edisoncor.gui.panel.Panel panel2;
    private org.edisoncor.gui.panel.PanelTranslucido panelTranslucido1;
    private org.edisoncor.gui.passwordField.PasswordFieldRoundImage txtPassword;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtUsuario;
    // End of variables declaration//GEN-END:variables
    
    private JSONObject extraerUsuario() {
        String url = "http://localhost:8080/NetFilmWS/recursos/servicio/usuario";
        JSONObject json = new JSONObject();
        HttpURLConnection connection = null;
        try {
            //Conectar
            UriBuilder builder = UriBuilder.fromPath(url).queryParam("usr",txtUsuario.getText());
            URI uri = builder.build();
            
            connection = (HttpURLConnection) uri.toURL().openConnection();
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            
            // Get Response	
            InputStream is = connection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            String respuesta = "";
            while( (line=br.readLine()) != null ) {
                respuesta += line;
            }
            
            // Disconnect
            br.close();
            connection.disconnect();
            
            System.out.println(respuesta);
            
            if(!respuesta.isEmpty()) {
                JSONParser parser = new JSONParser();
                json =(JSONObject)parser.parse(respuesta);
            }
        } catch (Exception e) {
            System.out.println("Error al extraer el usuario");
            System.out.println(e);
        }
        return json;
    }
}
