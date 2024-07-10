package com.Reproductor;

/**
 *
 * @author link
 */
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


public class WebViewSample {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Swing and JavaFX");
        frame.setSize(1000, 1000);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout(0, 0));
        frame.getContentPane().add(panel, BorderLayout.CENTER);

        final JFXPanel jfxPanel = new JFXPanel();
        panel.add(jfxPanel);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFx(jfxPanel);
            }
       });
    }

    private static void initFx(JFXPanel fxPanel) {
        Stage stage = new Stage();
        stage.setTitle("Web View");
        Scene scene = new Scene(new Browser(), 1000, 1000, Color.web("#666970"));
        stage.setScene(scene);
        fxPanel.setScene(scene);
    }
    
    static class Browser extends Region {

    final WebView browser = new WebView();
    final WebEngine webEngine = browser.getEngine();

    public Browser() {
        // load the home page
        webEngine.load("http://www.google.com");

        //add components
        getChildren().add(browser);
    }

    @Override
    protected void layoutChildren() {
        double w = getWidth();
        double h = getHeight();
        layoutInArea(browser,0,0,w,h,0,HPos.CENTER,VPos.CENTER);
    }

}

}