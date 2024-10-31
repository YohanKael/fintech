package br.com.fiap.dao;

import br.com.fiap.exception.EntidadeNaoEncontradaException;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Cidades;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CidadesDao {
    private Connection conexao;

    public CidadesDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void cadastrar(Cidades cidade) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO tb_cidades (id_cidade, nm_cidade) VALUES (seq_cidade.nextval, ?)");
        stm.setString(1, cidade.getNmCidade());
        stm.executeUpdate();
    }


    private Cidades parseCidade(ResultSet result) throws SQLException {
        int idCidade = result.getInt("id_cidade");
        String nmCidade = result.getString("nm_cidade");
        return new Cidades(idCidade, nmCidade);
    }


    public Cidades pesquisar(int codigo) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM tb_cidades where id_cidade = ?");
        stm.setLong(1, codigo);
        ResultSet result = stm.executeQuery();
        if (!result.next())
            throw new EntidadeNaoEncontradaException("Cidade não encontrado");
        return parseCidade(result);
    }


    public List<Cidades> getAllBairros() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM tb_cidades");
        ResultSet result = stm.executeQuery();
        List<Cidades> lista = new ArrayList<>();
        while (result.next()) {
            lista.add(parseCidade(result));
        }
        return lista;
    }

    public void atualizar(Cidades cidade) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = conexao.prepareStatement("UPDATE tb_cidades SET nm_cidade = ? where id_cidade = ?");
        stm.setString(1, cidade.getNmCidade());
        stm.setInt(2, cidade.getIdCidade());
        stm.executeUpdate();
    }

    public void remover(int codigo) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = conexao.prepareStatement("DELETE from tb_cidades where id_cidade = ?");
        stm.setLong(1, codigo);
        int linha = stm.executeUpdate();
        if (linha == 0)
            throw new EntidadeNaoEncontradaException("Cidade não encontrada para ser removido");
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }
}
