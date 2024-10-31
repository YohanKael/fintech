package br.com.fiap.view.despesas;
import br.com.fiap.dao.DespesasDao;
import br.com.fiap.exception.EntidadeNaoEncontradaException;
import br.com.fiap.model.Despesas;

import java.sql.SQLException;

public class PesquisarDespesaPorId {
    public static void main(String[] args) {
        try {
            DespesasDao dao = new DespesasDao();
            Despesas despesa = dao.pesquisar(2);
            System.out.println("Id da despesa:" + despesa.getIdDespesa() + "," + " Descrição da despesa: " + despesa.getDsDespesa() + "," + " Valor da despesa: R$" + despesa.getQtValorDespesa() +  "," + " Data da despesa: " + despesa.getDtDespesa());
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Codigo não existe na tabela de despesas");
        }
    }
}
