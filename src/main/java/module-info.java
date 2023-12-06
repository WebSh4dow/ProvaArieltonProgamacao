module com.prova.agenda.agendaarieltonprova {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.slf4j;
    requires java.sql;
    requires mysql.connector.java;

    opens com.prova.agenda to javafx.fxml;
    exports com.prova.agenda;
}