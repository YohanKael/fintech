package br.com.fiap.view.telefones;
import br.com.fiap.dao.TelefonesDao;
import br.com.fiap.model.Telefones;
import java.sql.SQLException;
import java.util.List;

public class GetAllTelefones {

    public static void main(String[] args) {
        try {
            TelefonesDao dao = new TelefonesDao();
            List<Telefones> telefones = dao.GetAllTelefones();
            for (Telefones telefone : telefones) {
                System.out.println("Id telefone:" + telefone.getIdTelefone() + " Telefone Completo: " + telefone.getNrCodigoPais() + " " + telefone.getNrDdd() + " " + telefone.getNrTelefone());
            }
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
}
