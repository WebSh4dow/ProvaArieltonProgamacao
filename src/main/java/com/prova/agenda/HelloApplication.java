package com.prova.agenda;

import com.prova.agenda.service.ContatoService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;

public class HelloApplication extends Application {

    private static Stage principal;

    public static void setPrincipal(Stage stage) {
        principal = stage;
    }

    public static Stage getPrincipal() {
        return principal;
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Agenda Telefônica");
        stage.setResizable(false);
        setPrincipal(stage);

        Parent root = FXMLLoader.load(getClass().getResource("/principal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}