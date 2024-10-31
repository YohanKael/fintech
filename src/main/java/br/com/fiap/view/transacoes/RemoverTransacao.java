package br.com.fiap.view.transacoes;
import br.com.fiap.dao.TransacoesDao;
import br.com.fiap.exception.EntidadeNaoEncontradaException;
import java.sql.SQLException;

public class RemoverTransacao {
    public static void main(String[] args) {
        try {
            TransacoesDao dao = new TransacoesDao();
            dao.remover(5);
            dao.fecharConexao();
            System.out.println("Investimento Removido com sucesso!");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Não foi possivel realizar a remoção, transação nao encontrada");

        }
    }
}
