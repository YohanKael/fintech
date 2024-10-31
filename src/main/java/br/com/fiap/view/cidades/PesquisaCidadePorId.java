package br.com.fiap.view.cidades;
import br.com.fiap.dao.CidadesDao;
import br.com.fiap.exception.EntidadeNaoEncontradaException;
import br.com.fiap.model.Cidades;

import java.sql.SQLException;

public class PesquisaCidadePorId {
    public static void main(String[] args) {
        try {
            CidadesDao dao = new CidadesDao();
            Cidades cidade = dao.pesquisar(2);
            System.out.println("Id da Cidade: " + cidade.getIdCidade() + "," + " Nome da Cidade: " + cidade.getNmCidade());
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Id não existe na tabela de Cidades");
        }
    }
}
