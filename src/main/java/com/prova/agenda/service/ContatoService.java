package com.prova.agenda.service;

import com.prova.agenda.model.Contato;
import com.prova.agenda.repository.ContatoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoService implements ContatoRepository {

    private JdbcService jdbcService;

    private static final Logger logger = LoggerFactory.getLogger(JdbcService.class);

    public ContatoService(JdbcService jdbcService) {
        this.jdbcService = jdbcService;
    }

    @Override
    public boolean adicionarContato(Contato contato) {
        boolean contatoAdicionado = false;
        jdbcService.abrirConexao();
        try {
            String sql = "INSERT INTO contato (nome, telefone, endereco, email) VALUES (?, ?, ?, ?);";
            PreparedStatement statement = jdbcService.getConexaoJDBC().prepareStatement(sql);
            statement.setString(1, contato.getNome());
            statement.setString(2, contato.getTelefone());
            statement.setString(3, contato.getEndereco());
            statement.setString(4, contato.getEmail());
            statement.executeUpdate();
            contatoAdicionado = true;
            logger.error("[Loggando no metodo de adicionar, contato salvo de id]: ", contato.getId());
        } catch (SQLException e) {
            logger.error("[Loggando no metodo de adicionar contatos erro]: ", e);
        }
        jdbcService.fecharConexao();
        return contatoAdicionado;
    }

    @Override
    public List<Contato> obterListaContatosPelaConsulta(ResultSet resultado) throws SQLException {
        List<Contato> contatos = new ArrayList<>();
        while (resultado.next()) {
            int id = resultado.getInt("id");
            String nome = resultado.getString("nome");
            String telefone = resultado.getString("telefone");
            String email = resultado.getString("email");
            String endereco = resultado.getString("endereco");
            contatos.add(new Contato(id, nome, telefone, email, endereco));
        }
        return contatos;
    }

    @Override
    public List<Contato> consutarTodosContatos() {
        List<Contato> contatos = null;
        jdbcService.abrirConexao();
        try {
            String sql = "SELECT * FROM contato;";
            PreparedStatement declaracao = jdbcService.getConexaoJDBC().prepareStatement(sql);
            contatos = obterListaContatosPelaConsulta(declaracao.executeQuery());
        } catch (SQLException e) {
            logger.error("[Loggando no metodo de adicionar consutarTodosContatos erro]: ", e);
        }
        jdbcService.fecharConexao();
        return contatos;
    }

    @Override
    public List<Contato> consutarContatosFiltrados(String nome) {
        List<Contato> contatos = null;
        jdbcService.abrirConexao();
        try {
            String sql = "SELECT * FROM contato WHERE nome LIKE '%" + nome + "%';";
            PreparedStatement declaracao = jdbcService.getConexaoJDBC().prepareStatement(sql);
            contatos = obterListaContatosPelaConsulta(declaracao.executeQuery());
        } catch (SQLException e) {
            logger.error("[Loggando no metodo de adicionar consutarContatosFiltrados erro]: ", e);
        }
        jdbcService.fecharConexao();
        return contatos;
    }

    @Override
    public boolean editarContato(Contato contato) {
        boolean atualizado = false;
        jdbcService.abrirConexao();
        try {
            String sql = "UPDATE contato SET nome = ?, telefone = ?, email = ?, endereco = ? WHERE id = ?;";
            PreparedStatement preparedStatement = jdbcService.getConexaoJDBC().prepareStatement(sql);
            preparedStatement.setString(1, contato.getNome());
            preparedStatement.setString(2, contato.getTelefone());
            preparedStatement.setString(3, contato.getEmail());
            preparedStatement.setString(4, contato.getEndereco());
            preparedStatement.setInt(5, contato.getId());
            preparedStatement.executeUpdate();
            atualizado = true;
        } catch (SQLException e) {
            logger.error("[Loggando no metodo de adicionar editarContato erro]: ", e);
        }
        jdbcService.fecharConexao();
        return atualizado;
    }

    @Override
    public boolean deletarContato(int id) {
        boolean removido = false;
        jdbcService.abrirConexao();
        try {
            String sql = "DELETE FROM contato WHERE id = ?;";
            PreparedStatement declaracao = jdbcService.getConexaoJDBC().prepareStatement(sql);
            declaracao.setInt(1, id);
            declaracao.executeUpdate();
            removido = true;
        } catch (SQLException e) {
            logger.error("[Loggando no metodo de adicionar deletarContato erro]: ", e);
        }
        jdbcService.fecharConexao();
        return removido;
    }


}
