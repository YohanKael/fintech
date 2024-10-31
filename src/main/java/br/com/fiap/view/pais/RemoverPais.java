package br.com.fiap.view.pais;

import br.com.fiap.dao.PaisDao;
import br.com.fiap.exception.EntidadeNaoEncontradaException;
import java.sql.SQLException;

public class RemoverPais {
    public static void main(String[] args) {
        try {
            PaisDao dao = new PaisDao();
            dao.remover(1);
            dao.fecharConexao();
            System.out.println("País removido com sucesso!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Nao foi possivel remover o país, id nao encontrado");
        }

    }
}
