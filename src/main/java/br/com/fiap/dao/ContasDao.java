package br.com.fiap.dao;

import br.com.fiap.exception.EntidadeNaoEncontradaException;
import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Conta;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContasDao {
    private Connection conexao;

    public ContasDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void cadastrar(Conta conta) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO tb_contas (id_conta, saldo, dt_criacao_conta, dt_encerramento_conta) VALUES (seq_conta.nextval, ?, ?, ?)");
        stm.setFloat(1, conta.getSaldo());
        stm.setDate(2, java.sql.Date.valueOf(conta.getDt_criacao_conta()));
        stm.setDate(3, java.sql.Date.valueOf(conta.getDt_encerramento_conta()));
        stm.executeUpdate();
    }


    private Conta parseConta(ResultSet result) throws SQLException {
        int cd_conta = result.getInt("id_conta");
        LocalDate dt_criacao_conta = result.getDate("dt_criacao_conta").toLocalDate();
        LocalDate dt_encerramento_conta = result.getDate("dt_encerramento_conta").toLocalDate();
        float saldo = result.getFloat("saldo");
        return new Conta(cd_conta, saldo, dt_criacao_conta, dt_encerramento_conta);
    }


    public Conta pesquisar(int codigo) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM tb_contas where id_conta = ?");
        stm.setLong(1, codigo);
        ResultSet result = stm.executeQuery();
        if (!result.next())
            throw new EntidadeNaoEncontradaException("Conta não encontrada");
        return parseConta(result);
    }


    public List<Conta> getAllContas() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM tb_contas");
        ResultSet result = stm.executeQuery();
        List<Conta> lista = new ArrayList<>();
        while (result.next()) {
            lista.add(parseConta(result));
        }
        return lista;
    }

    public void atualizar(Conta conta) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = conexao.prepareStatement("UPDATE tb_contas SET saldo = ?, dt_criacao_conta = ?, dt_encerramento_conta = ? where id_conta = ?");
        stm.setFloat(1, conta.getSaldo());
        stm.setDate(2, java.sql.Date.valueOf(conta.getDt_criacao_conta()));
        stm.setDate(3, java.sql.Date.valueOf(conta.getDt_encerramento_conta()));
        stm.setInt(4, conta.getId_conta());
        stm.executeUpdate();
    }

    public void remover(int codigo) throws SQLException, EntidadeNaoEncontradaException {
        PreparedStatement stm = conexao.prepareStatement("DELETE from tb_contas where id_conta = ?");
        stm.setLong(1, codigo);
        int linha = stm.executeUpdate();
        if (linha == 0)
            throw new EntidadeNaoEncontradaException("Conta não encontrada para ser removida");
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }
}
