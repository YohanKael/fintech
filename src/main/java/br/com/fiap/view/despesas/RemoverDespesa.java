package br.com.fiap.view.despesas;
import br.com.fiap.dao.DespesasDao;
import br.com.fiap.exception.EntidadeNaoEncontradaException;
import java.sql.SQLException;

public class RemoverDespesa {
    public static void main(String[] args) {
        try {
            DespesasDao dao = new DespesasDao();
            dao.remover(1);
            dao.fecharConexao();
            System.out.println("Despesa Removida com sucesso!");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Não foi possivel realizar a remoção, despesa nao encontrada");

        }
    }

}
