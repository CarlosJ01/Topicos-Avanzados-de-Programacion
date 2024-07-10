package com.Reproductor;

import java.io.File;
import java.net.URL;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.stage.Stage;

/**
 *
 * @author link
 */
public class VideoFX extends Application {
    
    private static final String MEDIA_URL = "http://localhost:8080/StreamingWS/webresources/streaming/video";
    // file:// + pathArchivoLocal

    @Override 
    public void start(Stage stage) {
        stage.setTitle("Media Player");
        Group root = new Group();
        Scene scene = new Scene(root,600,265);
        // create media player
        try {
            URL url = new URL(MEDIA_URL);
            
            Media media = new Media(url.toURI().toString());
            javafx.scene.media.MediaPlayer mediaPlayer = new javafx.scene.media.MediaPlayer(media);
            mediaPlayer.setAutoPlay(true);
            MediaControl mediaControl = new MediaControl(mediaPlayer);
            scene.setRoot(mediaControl);
            scene.getStylesheets().add(VideoFX.class.getResource("mediaplayer.css").toExternalForm());
            // show stage
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Application.launch("");
    }
    
}
