/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Windows;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Carlos J
 */
public class Registro extends javax.swing.JFrame {

    private JSONObject jsonUsuario = null;
    private JSONArray usuarios=null;
    /**
     * Creates new form Registro
     */
    public Registro() {
        initComponents();
        setLocationRelativeTo(null);
        this.setResizable(false);
        
        ImageIcon img = new ImageIcon(getClass().getResource("/com/Imagenes/logo.png"));
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(lblLogo.getWidth(),lblLogo.getHeight(),Image.SCALE_DEFAULT));
        lblLogo.setIcon(icono);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        labelMetric5 = new org.edisoncor.gui.label.LabelMetric();
        txtUsuario = new org.edisoncor.gui.textField.TextFieldRoundIcon();
        labelMetric6 = new org.edisoncor.gui.label.LabelMetric();
        labelMetric2 = new org.edisoncor.gui.label.LabelMetric();
        txtPassword = new org.edisoncor.gui.passwordField.PasswordFieldRoundImage();
        labelMetric7 = new org.edisoncor.gui.label.LabelMetric();
        txtPasswordConfrim = new org.edisoncor.gui.passwordField.PasswordFieldRoundImage();
        lblLogo = new javax.swing.JLabel();
        buttonRound1 = new org.edisoncor.gui.button.ButtonRound();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro");

        labelMetric5.setText("Usuario");
        labelMetric5.setFont(new java.awt.Font("Consolas", 1, 30)); // NOI18N

        txtUsuario.setFont(new java.awt.Font("Dialog", 0, 30)); // NOI18N

        labelMetric6.setText("Contraseña");
        labelMetric6.setFont(new java.awt.Font("Consolas", 1, 30)); // NOI18N

        labelMetric2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMetric2.setText("Registro");
        labelMetric2.setFont(new java.awt.Font("Consolas", 1, 48)); // NOI18N

        txtPassword.setFont(new java.awt.Font("Dialog", 0, 30)); // NOI18N

        labelMetric7.setText("Confirmar Contraseña");
        labelMetric7.setFont(new java.awt.Font("Consolas", 1, 30)); // NOI18N

        txtPasswordConfrim.setFont(new java.awt.Font("Dialog", 0, 30)); // NOI18N
        txtPasswordConfrim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordConfrimKeyPressed(evt);
            }
        });

        buttonRound1.setBackground(new java.awt.Color(153, 0, 0));
        buttonRound1.setText("Registrar");
        buttonRound1.setFont(new java.awt.Font("Consolas", 1, 25)); // NOI18N
        buttonRound1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonRound1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelMetric7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelMetric6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelMetric5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtPasswordConfrim, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelMetric2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(buttonRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelMetric2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelMetric5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelMetric6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelMetric7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPasswordConfrim, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(buttonRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRound1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonRound1MouseClicked
        if(acepta()){
            registrar();
            siguiente();
        }
    }//GEN-LAST:event_buttonRound1MouseClicked

    private void txtPasswordConfrimKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordConfrimKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.buttonRound1MouseClicked(null);
        }
    }//GEN-LAST:event_txtPasswordConfrimKeyPressed

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
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonRound buttonRound1;
    private org.edisoncor.gui.label.LabelMetric labelMetric2;
    private org.edisoncor.gui.label.LabelMetric labelMetric5;
    private org.edisoncor.gui.label.LabelMetric labelMetric6;
    private org.edisoncor.gui.label.LabelMetric labelMetric7;
    private javax.swing.JLabel lblLogo;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.passwordField.PasswordFieldRoundImage txtPassword;
    private org.edisoncor.gui.passwordField.PasswordFieldRoundImage txtPasswordConfrim;
    private org.edisoncor.gui.textField.TextFieldRoundIcon txtUsuario;
    // End of variables declaration//GEN-END:variables

    private boolean acepta() {
        boolean acep = true;
        usuarios = obtenerUsuarios();
        
        //Si estan vacios los campos
        if (txtUsuario.getText().isEmpty() && txtPassword.getText().isEmpty() && txtPasswordConfrim.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Todos los Campos son Obligatorios","Error",JOptionPane.ERROR_MESSAGE);
            acep=false;
        }else{
            //Si las contraseñas son iguales
            if (!(txtPassword.getText().equals(txtPasswordConfrim.getText()))) {
                JOptionPane.showMessageDialog(null,"Las contraseñas no Coinciden","Error",JOptionPane.ERROR_MESSAGE);
                acep=false;
            } else {
                for (int i = 0; i<usuarios.size();i++) {
                    JSONObject usr = (JSONObject)usuarios.get(i);
                    if(usr.get("usuario").toString().equals(txtUsuario.getText())){
                        JOptionPane.showMessageDialog(null,"El usuario ya Existe\nPorfavor eliga otro nombre","Error",JOptionPane.ERROR_MESSAGE);
                        acep=false;
                        break;
                    }
                }
            }
        }
        return acep;
    }

    private void registrar() {
        JSONObject json = new JSONObject();
        json.put("usuario",txtUsuario.getText());
        json.put("contrasenia",txtPassword.getText());
        
        String url = "http://localhost:8080/NetFilmWS/recursos/servicio/ingresarUsuario";
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        
        Form form = new Form();
        form.param("nuevo",json.toJSONString());
        
        Response response = target.request(MediaType.TEXT_PLAIN).put(Entity.form(form));
        boolean siono1 = Boolean.parseBoolean(response.toString());
        boolean siono2 = registrarDatos();
        if(!siono1 && siono2){
            JOptionPane.showMessageDialog(null, "Nuevo Usuario Registrado", "Notificacion", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"No se puede Registrar nuevo Usuario\nIntente en otro momento","Error",JOptionPane.ERROR_MESSAGE);               
        }
    }

    private JSONArray obtenerUsuarios() {
        String url ="http://localhost:8080/NetFilmWS/recursos/servicio/usuarios";
        
        Client cliente = ClientBuilder.newClient();
        WebTarget objetivo = cliente.target(url);
        String respuesta = objetivo.request(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println(respuesta);
        
        JSONParser parser = new JSONParser();
        JSONArray lista = new JSONArray();
        try {
            lista=(JSONArray)parser.parse(respuesta);
        } catch (ParseException e) {
           System.out.println("Error al leer los usuarios");
           System.out.println(e);
        }
        
        return lista;
    }

    private boolean registrarDatos() {
        String url = "http://localhost:8080/NetFilmWS/recursos/servicio/ingresarDatosUsuario";
        try {
            jsonUsuario = extraerUsuario();
            
            File file = new File(getClass().getResource("/com/Imagenes/Icono00.png").getPath().replaceAll("%20"," "));
            Path path = Paths.get(file.getAbsolutePath());
            byte [] byteImg = Files.readAllBytes(path);
            String imgBase64 = Base64.getEncoder().encodeToString(byteImg);
            System.out.println(imgBase64);

            JSONObject datos = new JSONObject();
            datos.put("edad",18);
            datos.put("idioma","Español");
            
            JSONObject jsonDatos = new JSONObject();
            jsonDatos.put("nombre",txtUsuario.getText());
            jsonDatos.put("datos",datos.toJSONString());
            jsonDatos.put("imagen",imgBase64);
            
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(url);
        
            Form form = new Form();
            form.param("usuario",jsonUsuario.toJSONString());
            form.param("datos",jsonDatos.toJSONString());
            Response response = target.request(MediaType.TEXT_PLAIN).put(Entity.form(form));
            
            System.out.println(response);
            
        } catch (Exception e) {
            System.out.println("Error al registra datos");
            System.out.println(e);
            return false;
        }
        return true;
    }

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

    private void siguiente() {
        String url ="http://localhost:8080/NetFilmWS/recursos/servicio/acceder";
        try {
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(url);
            Response response = target.queryParam("usuario",txtUsuario.getText()).queryParam("contrasenia",txtPassword.getText()).request().method("POST");
            String respuesta = response.readEntity(String.class);

            System.out.println(respuesta);
            int numero = Integer.parseInt(respuesta);
            
            if(numero>=0){
                new Perfiles(Integer.parseInt(jsonUsuario.get("id").toString())).setVisible(true);
                this.dispose();
            }
        } catch (Exception e) {
            System.out.println("Error al pasar al siguiente");
            System.out.println(e);
        }
    }
}
