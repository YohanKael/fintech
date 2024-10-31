package br.com.fiap.view.lucros;
import br.com.fiap.dao.LucrosDao;
import br.com.fiap.exception.EntidadeNaoEncontradaException;

import java.sql.SQLException;

public class RemoverLuro {
    public static void main(String[] args) {
        try {
            LucrosDao dao = new LucrosDao();
            dao.remover(1);
            dao.fecharConexao();
            System.out.println("Lucro Removida com sucesso!");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Não foi possivel realizar a remoção, lucro não encontrado");
        }
    }
}
