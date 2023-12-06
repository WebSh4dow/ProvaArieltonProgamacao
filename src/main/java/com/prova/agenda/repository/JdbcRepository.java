package com.prova.agenda.repository;

public interface JdbcRepository {

    void abrirConexao();

    void fecharConexao();

    void criarDatabaseAgenda();

    void criarTabelaContato();
}
