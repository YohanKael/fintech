package br.com.fiap.view.lucros;

import br.com.fiap.dao.LucrosDao;
import br.com.fiap.exception.EntidadeNaoEncontradaException;
import br.com.fiap.model.Lucros;

import java.sql.SQLException;

public class AtualizarLucro {
    public static void main(String[] args) {
        try {
            LucrosDao dao = new LucrosDao();
            Lucros lucro = dao.pesquisar(1);
            lucro.setDsLucro("lucro com Transporte");
            lucro.setQtValorLucro(5000);
            dao.atualizar(lucro);
            dao.fecharConexao();
            System.out.println("Lucro Atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Nao foi possivel realizar a atualição dos dados");
        }
    }
}
