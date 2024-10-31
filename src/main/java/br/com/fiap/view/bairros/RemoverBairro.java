package br.com.fiap.view.bairros;
import br.com.fiap.dao.BairrosDao;
import br.com.fiap.exception.EntidadeNaoEncontradaException;

import java.sql.SQLException;

public class RemoverBairro {
    public static void main(String[] args) {
        try {
            BairrosDao dao = new BairrosDao();
            dao.remover(1);
            dao.fecharConexao();
            System.out.println("Bairro Removido com sucesso!");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Não foi possivel realizar a remoção, bairro nao encontrado");
        }
    }
}
