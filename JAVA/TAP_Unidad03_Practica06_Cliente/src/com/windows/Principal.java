/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.windows;

import com.reports.Reportes;
import java.awt.Color;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;
import mdlaf.MaterialLookAndFeel;
import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;
import org.edisoncor.gui.util.Avatar;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


/**
 *
 * @author Carlos J
 */
public class Principal extends javax.swing.JFrame {

    private JSONObject usuario;
    private String imgBase64;
    private byte [] byteImg;
    
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
    }
    
    public Principal(JSONObject usuario) {
        initComponents();
        this.usuario = usuario;
        
        setLocationRelativeTo(null);
        
        buttonGroup1.add(toggleHombre);
        buttonGroup1.add(toggleMujer);
        
        btnGuardar.setBackground(MaterialColors.BLACK);
        btnGuardar.setForeground(Color.WHITE);
        
        MaterialUIMovement.add(btnGuardar, MaterialColors.BLUE_GRAY_900, 5, 1000 / 30);
        
        // Cambiar Avatars
        ArrayList<Avatar> avatares = new ArrayList<>();
        
        try {
            InputStream in = getClass().getResourceAsStream("/com/p6/img/gender.png");
            Avatar reporteGeneros = new Avatar("repoGen", "Generos", ImageIO.read(in));
            avatares.add(reporteGeneros);
            
            InputStream in2 = getClass().getResourceAsStream("/com/p6/img/report.png");
            Avatar reporteCompleto = new Avatar("repoGen", "Reporte", ImageIO.read(in2));
            
            avatares.add(reporteCompleto);
            
            InputStream in3 = getClass().getResourceAsStream("/com/p6/img/age.png");
            Avatar reporteEdades = new Avatar("repoGen", "Edades", ImageIO.read(in3));
            
            avatares.add(reporteEdades);
            
            InputStream in4 = getClass().getResourceAsStream("/com/p6/img/profile.png");
            Avatar iniciarSecion = new Avatar("regresar", "Iniciar otra Secion", ImageIO.read(in4));
            
            avatares.add(iniciarSecion);
            
            panelAvatarChooser1.setAvatars(avatares);
            
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        try {
            JSONParser jParser = new JSONParser();
            JSONObject json = (JSONObject) jParser.parse(this.usuario.get("datos_personales").toString());
            
            fieldNombre.setText(json.get("nombre").toString());
            
            spinnerEdad.setValue(Integer.parseInt(json.get("edad").toString()));
            
            if(json.get("genero").toString().equals("Hombre")){
                toggleHombre.setSelected(true);
                toggleMujer.setSelected(false);
            }
            else{
                toggleHombre.setSelected(false);
                toggleMujer.setSelected(true);
            }
            
            this.imgBase64 = this.usuario.get("foto").toString();
            this.byteImg = Base64.getDecoder().decode(this.imgBase64);
            panelImage1.setIcon(new javax.swing.ImageIcon(this.byteImg));
            panelImage1.updateUI();
            
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error leer el json");
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

        jFileChooser1 = new javax.swing.JFileChooser();
        buttonGroup1 = new javax.swing.ButtonGroup();
        btnGuardar = new javax.swing.JButton();
        panelAvatarChooser1 = new org.edisoncor.gui.panel.PanelAvatarChooser();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        labelNombre = new javax.swing.JLabel();
        fieldNombre = new javax.swing.JTextField();
        toggleHombre = new javax.swing.JToggleButton();
        toggleMujer = new javax.swing.JToggleButton();
        labelEdad = new javax.swing.JLabel();
        spinnerEdad = new javax.swing.JSpinner();

        jFileChooser1.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        jFileChooser1.setApproveButtonText("Guardar");
        jFileChooser1.setDialogTitle("Guardar Reporte");
        jFileChooser1.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Principal");

        btnGuardar.setText("Guardar Perfil");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        panelAvatarChooser1.setColorPrimario(new java.awt.Color(255, 255, 255));
        panelAvatarChooser1.setColorSecundario(new java.awt.Color(204, 204, 204));
        panelAvatarChooser1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelAvatarChooser1MouseClicked(evt);
            }
        });

        panelImage1.setToolTipText("Click para elegir foto de perfil");
        panelImage1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelImage1MouseClicked(evt);
            }
        });

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

        labelNombre.setText("Nombre Completo");

        toggleHombre.setText("Hombre");

        toggleMujer.setText("Mujer");

        labelEdad.setText("Edad");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelEdad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinnerEdad))
                            .addComponent(toggleMujer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(toggleHombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelNombre)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(fieldNombre)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addComponent(panelAvatarChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(toggleHombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(toggleMujer)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(spinnerEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelEdad))))
                        .addGap(18, 18, 18)
                        .addComponent(labelNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar))
                    .addComponent(panelAvatarChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String urlWS = "http://localhost:8080/TAP_Unidad03_Practica06/res/service/datos";

        try {
            JSONObject jsonDatos = new JSONObject();
            jsonDatos.put("nombre", fieldNombre.getText());
            jsonDatos.put("genero", toggleHombre.isSelected() ? "Hombre" : "Mujer");
            jsonDatos.put("edad", spinnerEdad.getValue().toString());

            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(urlWS);

            System.out.println(imgBase64);

            Form form = new Form();
            form.param("id", usuario.get("id_usuario").toString());
            form.param("datos", jsonDatos.toJSONString());
            form.param("foto", imgBase64);

            Response response = target.request().put(Entity.form(form));
            System.out.println(response.toString());

            JOptionPane.showMessageDialog(null,"Guardado");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void panelAvatarChooser1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAvatarChooser1MouseClicked
        if(evt.getClickCount() >= 2 && !evt.isConsumed()) {
            evt.consume();
            if(panelAvatarChooser1.getSelectedtitulo().equalsIgnoreCase("Iniciar otra Secion")){
                new Login().setVisible(true);
                this.dispose();
            }else{
                jFileChooser1.setDialogTitle("Generar Reporte");
                jFileChooser1.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                if( jFileChooser1.showSaveDialog(null) == JFileChooser.APPROVE_OPTION ) {
                    String dir = jFileChooser1.getSelectedFile()+"\\"+panelAvatarChooser1.getSelectedtitulo()+".pdf";
                    jFileChooser1.setSelectedFile(new File(dir));
                    generarReporte(jFileChooser1.getSelectedFile(), panelAvatarChooser1.getSelectedtitulo());
                }
            }
        }
    }//GEN-LAST:event_panelAvatarChooser1MouseClicked

    private void panelImage1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelImage1MouseClicked
        jFileChooser1.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jFileChooser1.setCurrentDirectory(new File(""));
        if( jFileChooser1.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser1.getSelectedFile();
            System.out.println(file.getName());
            if(file.getAbsolutePath().endsWith(".png") ||
                file.getAbsolutePath().endsWith(".jpg") ||
                file.getAbsolutePath().endsWith(".jpeg") ||
                file.getAbsolutePath().endsWith(".gif") ) {
                if(file.length() <= (500 * 1024)) {
                    try {
                        panelImage1.setIcon(
                            new javax.swing.ImageIcon(file.getAbsolutePath())
                        );
                        panelImage1.updateUI();

                        Path path = Paths.get(file.getAbsolutePath());

                        byteImg = Files.readAllBytes(path);

                        imgBase64 = Base64.getEncoder().encodeToString(byteImg);
                        
                        System.out.println(byteImg);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }//GEN-LAST:event_panelImage1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Material Design look and feel */
        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel labelEdad;
    private javax.swing.JLabel labelNombre;
    private org.edisoncor.gui.panel.PanelAvatarChooser panelAvatarChooser1;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private javax.swing.JSpinner spinnerEdad;
    private javax.swing.JToggleButton toggleHombre;
    private javax.swing.JToggleButton toggleMujer;
    // End of variables declaration//GEN-END:variables
    
    private void generarReporte(File reporte, String titulo) {
        
        System.out.println(titulo);
        System.out.println(reporte.getPath());
        
        //Sacar el Json para generar el reporte
        String urlWS = "http://localhost:8080/TAP_Unidad03_Practica06/res/service/datos_reporte";
        try {
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(urlWS);

            Response response = target.request().method("POST");
            String strRespuesta = response.readEntity(String.class);
            
            JSONParser jParser = new JSONParser();
            JSONArray jArray = (JSONArray) jParser.parse(strRespuesta);
            
            Reportes pdf = new Reportes();
            
            switch (titulo) {
                case "Reporte":
                        pdf.generar(1,reporte.getPath(),jArray);
                    break;
                case "Generos":
                        pdf.generar(2,reporte.getPath(),jArray);
                    break;
                case "Edades":
                        pdf.generar(3,reporte.getPath(),jArray);
                    break;
            }
            
            JOptionPane.showMessageDialog(null,"Reporte Generado");
            
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error al generar el reporte");
        }
    }
}
