package br.com.fiap.view.enderecos;
import br.com.fiap.dao.EnderecosDao;
import br.com.fiap.exception.EntidadeNaoEncontradaException;
import br.com.fiap.model.Enderecos;

import java.sql.SQLException;

public class AtualizacaoEndereco {
    public static void main(String[] args) {
        try {
            EnderecosDao dao = new EnderecosDao();
            Enderecos endereco = dao.pesquisar(35);
            endereco.setNomeRua("alamedas das orquideas");
            endereco.setNumeroCep("58790-910");
            endereco.setComplementoEndereco("Casa branca e azul");
            dao.atualizar(endereco);
            dao.fecharConexao();
            System.out.println("Endereco Atualizado Com Sucesso!!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Não foi possivel realizar a atualização dos dados, endereço não encontrado");
        }
    }
}
