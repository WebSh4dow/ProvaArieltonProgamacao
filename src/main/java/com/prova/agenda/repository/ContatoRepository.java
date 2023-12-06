package com.prova.agenda.repository;

import com.prova.agenda.model.Contato;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ContatoRepository {
    boolean adicionarContato(Contato contato);
    List<Contato> obterListaContatosPelaConsulta(ResultSet resultSet) throws SQLException;

    List<Contato> consutarTodosContatos();

    List<Contato> consutarContatosFiltrados(String nome);

    boolean editarContato(Contato contato);

    boolean deletarContato(int id);
}
