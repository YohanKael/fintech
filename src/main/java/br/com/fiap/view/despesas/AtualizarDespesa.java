package br.com.fiap.view.despesas;
import br.com.fiap.dao.DespesasDao;
import br.com.fiap.exception.EntidadeNaoEncontradaException;
import br.com.fiap.model.Despesas;

import java.sql.SQLException;


public class AtualizarDespesa {
    public static void main(String[] args) {
        try{
            DespesasDao dao = new DespesasDao();
            Despesas despesa = dao.pesquisar(1);
            despesa.setDsDespesa("Despesa cartao de credito");
            despesa.setQtValorDespesa(5000);
            dao.atualizar(despesa);
            dao.fecharConexao();
            System.out.println("Despesa Atualizada com sucesso!");
        } catch (SQLException e){
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Nao foi possivel realizar a atualização dos dados");
        }
    }
}
