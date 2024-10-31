package br.com.fiap.view.enderecos;

import br.com.fiap.dao.EnderecosDao;
import br.com.fiap.exception.EntidadeNaoEncontradaException;

import java.sql.SQLException;

public class RemoverEndereco {
    public static void main(String[] args){
        try {
            EnderecosDao dao = new EnderecosDao();
            dao.remover(30);
            dao.fecharConexao();
            System.out.println("Endereco Removido com sucesso!");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Não foi possivel realizar a remoção, endereço nao encontrado");
        }
    }
}
