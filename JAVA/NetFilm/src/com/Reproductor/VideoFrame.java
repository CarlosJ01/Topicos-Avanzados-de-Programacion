package com.Reproductor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.net.URL;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author link
 */
public class VideoFrame extends JFrame {

    private final JFXPanel jfxPanel = new JFXPanel();
    private WebEngine engine;
    
    private final JPanel panel = new JPanel(new BorderLayout());

    private final JButton btnBack = new JButton("Back");
    
    private String videoUrl;

    public VideoFrame(String videoUrl) {
        super();
        this.videoUrl = videoUrl;
        initComponents();
        setLocationRelativeTo(this);
        this.setResizable(false);
    }

    private void initComponents() {
        createScene();

        btnBack.addActionListener((ActionEvent e) -> {
            this.videoUrl="";
            this.jfxPanel.setScene(null);
            this.dispose();
        });

        JPanel topBar = new JPanel(new BorderLayout(5, 0));
        topBar.setBorder(BorderFactory.createEmptyBorder(3, 5, 3, 5));
        topBar.add(btnBack, BorderLayout.WEST);

        panel.add(topBar, BorderLayout.NORTH);
        panel.add(jfxPanel, BorderLayout.CENTER);

        getContentPane().add(panel);

        setPreferredSize(new Dimension(800, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }
    
    private void createScene() {
        Platform.runLater(() -> {
            initFX(jfxPanel);
        });
    }
    
    private void initFX(JFXPanel fxPanel) {
        Scene scene = newScene();
        fxPanel.setScene(scene);
    }
    
    private Scene newScene() {
        Group root = new Group();
        Scene scene = new Scene(root, Color.ALICEBLUE);

        try {
            URL url = new URL(videoUrl);
            
            Media media = new Media(url.toURI().toString());
            javafx.scene.media.MediaPlayer mediaPlayer = new javafx.scene.media.MediaPlayer(media);
            mediaPlayer.setAutoPlay(true);
            MediaControl mediaControl = new MediaControl(mediaPlayer);
            scene.setRoot(mediaControl);
            scene.getStylesheets().add(VideoFX.class.getResource("mediaplayer.css").toExternalForm());
        } catch(Exception e) {
            e.printStackTrace();
        }

        return scene;
    }
    
}
