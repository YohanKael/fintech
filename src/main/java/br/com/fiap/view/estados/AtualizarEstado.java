package br.com.fiap.view.estados;

import br.com.fiap.dao.EstadosDao;
import br.com.fiap.exception.EntidadeNaoEncontradaException;
import br.com.fiap.model.Estados;

import java.sql.SQLException;

public class AtualizarEstado {
    public static void main(String[] args) {
        try {
            EstadosDao dao = new EstadosDao();
            Estados estado = dao.pesquisar(1);
            estado.setNmEstado("Santa Catarina");
            dao.atualizar(estado);
            dao.fecharConexao();


            System.out.println("Estado atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Não foi possivel realizar a atualização dos dados, Cidade não encontrado");
        }
    }
}
