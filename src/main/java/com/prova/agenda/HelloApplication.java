package com.prova.agenda;

import com.prova.agenda.repository.JdbcRepository;
import com.prova.agenda.service.ContatoService;
import com.prova.agenda.service.JdbcService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        JdbcService jdbcService = new JdbcService();
        jdbcService.criarDatabaseAgenda();
        jdbcService.criarTabelaContato();

        launch();
    }
}