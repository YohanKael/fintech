package br.com.fiap.view.contas;
import br.com.fiap.dao.ContasDao;
import br.com.fiap.exception.EntidadeNaoEncontradaException;

import java.sql.SQLException;

public class RemoverConta {
    public static void main(String[] args) {
        try {
            ContasDao dao = new ContasDao();
            dao.remover(1);
            dao.fecharConexao();
            System.out.println("Conta Removida com sucesso!");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Não foi possivel realizar a remoção, conta nao encontrada");

        }
    }
}
