package com.prova.agenda.service;

import com.prova.agenda.repository.JdbcRepository;
import java.sql.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JdbcService implements JdbcRepository {

    Connection conexaoJDBC = null;
    private final static String URL_CONEXAO = "jdbc:mysql://127.0.0.1:3306/pdv?verifyServerCertificate=false&useSSl=true";

    private final static String USUARIO = "root";

    private final static String SENHA = "root";

    private static final Logger logger = LoggerFactory.getLogger(JdbcService.class);


    @Override
    public void abrirConexao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexaoJDBC = DriverManager.getConnection(URL_CONEXAO,USUARIO,SENHA);
            logger.info("[Loggando no metodo de abrir conexão realizada com sucesso]");
        } catch (SQLException e) {
            logger.error("[Loggando no metodo de abrir conexão erro ao abrir conexão]: ", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void fecharConexao() {
        try {
            conexaoJDBC.close();
        }
        catch(SQLException e) {
            logger.error("[Loggando no metodo de abrir conexão erro ao abrir conexão]: ", e);

        }
    }

    @Override
    public void criarDatabaseAgenda() {
        try {
            this.abrirConexao();
            Statement statement = conexaoJDBC.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS agenda;";
            statement.execute(sql);

        } catch (SQLException e) {
            logger.error("[Loggando no metodo de criar tabela Agenda]: ", e);
        }
        this.fecharConexao();
    }

    @Override
    public void criarTabelaContato() {
        abrirConexao();
        try {
            String sql = "CREATE TABLE IF NOT EXISTS contato(" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "nome VARCHAR(80) NOT NULL, " +
                    "telefone VARCHAR(20) NOT NULL, " +
                    "email VARCHAR(80) NOT NULL, " +
                    "endereco VARCHAR(80) NOT NULL" +
                    ")" +
                    "ENGINE=InnoDB;";
            Statement statement = conexaoJDBC.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            logger.error("[Loggando no metodo de criar tabela Contato]: ", e);

        }
        fecharConexao();
    }

    public Connection getConexaoJDBC() {
        return conexaoJDBC;
    }

    public void setConexaoJDBC(Connection conexaoJDBC) {
        this.conexaoJDBC = conexaoJDBC;
    }

}
