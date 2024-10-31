package br.com.fiap.view.contas;
import br.com.fiap.dao.ContasDao;
import br.com.fiap.exception.EntidadeNaoEncontradaException;
import br.com.fiap.model.Conta;
import java.sql.SQLException;

public class PesquisarContaPorId {
    public static void main(String[] args) {
        try {
            ContasDao dao = new ContasDao();
            Conta conta = dao.pesquisar(1);
            System.out.println("Id da Conta:" + conta.getId_conta() + "," + " Saldo da conta: " + conta.getSaldo() + "," + " Data de crianção da conta: " + conta.getDt_criacao_conta() + "," + " Data encerramento da conta: " + conta.getDt_encerramento_conta());
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Codigo não existe na tabela de contas");
        }
    }
}
