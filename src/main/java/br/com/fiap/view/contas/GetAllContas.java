package br.com.fiap.view.contas;
import br.com.fiap.dao.ContasDao;
import br.com.fiap.model.Conta;
import java.sql.SQLException;
import java.util.List;

public class GetAllContas {
    public static void main(String[] args) {
        try {
            ContasDao dao = new ContasDao();
            List<Conta> contas = dao.getAllContas();
            for (Conta conta : contas) {
                System.out.println("Id da Conta:" + conta.getId_conta() + "," + " Saldo da conta: " + conta.getSaldo() + "," + " Data de crianção da conta: " + conta.getDt_criacao_conta() + "," + " Data encerramento da conta: " + conta.getDt_encerramento_conta());
            }
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
}
