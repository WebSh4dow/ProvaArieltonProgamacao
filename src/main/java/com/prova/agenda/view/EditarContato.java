package com.prova.agenda.view;

import com.prova.agenda.HelloApplication;
import com.prova.agenda.controller.EditarContatoController;
import com.prova.agenda.model.Contato;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.StageStyle;

import java.io.IOException;

public class EditarContato extends Application {

    private static Stage editarContatoStage;
    private Contato contatoEdit;

    public static Stage getEditarContatoStage() {
        return editarContatoStage;
    }

    public static void setEditarContatoStage(Stage stage) {
        editarContatoStage = stage;
    }

    public Contato getContatoEdit() {
        return contatoEdit;
    }

    public void setContatoEdit(Contato contatoEdit) {
        this.contatoEdit = contatoEdit;
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.initOwner(HelloApplication.getPrincipal());
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Editar Contato");
        stage.setResizable(false);
        setEditarContatoStage(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/editar_contato.fxml"));
        Parent root = fxmlLoader.load();
        EditarContatoController controller = (EditarContatoController) fxmlLoader.getController();
        controller.preencherCampos(contatoEdit);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
