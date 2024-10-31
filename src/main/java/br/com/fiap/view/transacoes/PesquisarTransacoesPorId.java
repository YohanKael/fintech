package br.com.fiap.view.transacoes;

import br.com.fiap.dao.TransacoesDao;
import br.com.fiap.exception.EntidadeNaoEncontradaException;
import br.com.fiap.model.Transacoes;

import java.sql.SQLException;

public class PesquisarTransacoesPorId {
    public static void main(String[] args) {
        try {
            TransacoesDao dao = new TransacoesDao();
            Transacoes transacoes = dao.pesquisar(3);
            System.out.println("Id da transação:" + transacoes.getIdTransacao() + "," + " Saldo: " + transacoes.getQtSaldo() + "," + " Valor da Transação" + transacoes.getQtValor());
            System.out.println("Saldo Total: " + "R$"  + transacoes.getQtSaldoAtualizado());
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Codigo não existe na tabela Investimento");
        }
    }
}
