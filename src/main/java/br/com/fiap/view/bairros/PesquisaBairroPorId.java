package br.com.fiap.view.bairros;
import br.com.fiap.dao.BairrosDao;
import br.com.fiap.exception.EntidadeNaoEncontradaException;
import br.com.fiap.model.Bairros;

import java.sql.SQLException;

public class PesquisaBairroPorId {
    public static void main(String[] args) {
        try {
            BairrosDao dao = new BairrosDao();
            Bairros bairro = dao.pesquisar(2);
            System.out.println("Id do Bairro: " + bairro.getIdBairro() + "," + " Descrição do Bairro: " + bairro.getDsBairro());
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Codigo não existe na tabela de Bairros");
        }
    }
}
