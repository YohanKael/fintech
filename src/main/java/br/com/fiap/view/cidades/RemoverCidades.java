package br.com.fiap.view.cidades;

import br.com.fiap.dao.BairrosDao;
import br.com.fiap.dao.CidadesDao;
import br.com.fiap.exception.EntidadeNaoEncontradaException;

import java.sql.SQLException;

public class RemoverCidades {
    public static void main(String[] args) {
        try {
            CidadesDao dao = new CidadesDao();
            dao.remover(1);
            dao.fecharConexao();
            System.out.println("Cidade Removida com sucesso!");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Não foi possivel realizar a remoção, cidade nao encontrado");
        }
    }
}
