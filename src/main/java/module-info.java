module com.prova.agenda.agendaarieltonprova {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.slf4j;
    requires java.sql;
    requires javafx.base;
    requires javafx.graphics;


    opens com.prova.agenda to javafx.fxml;
    opens com.prova.agenda.controller to javafx.fxml;
    opens com.prova.agenda.model to javafx.base;
    exports com.prova.agenda;


}