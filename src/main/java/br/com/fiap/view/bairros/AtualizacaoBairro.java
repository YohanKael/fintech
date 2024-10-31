package br.com.fiap.view.bairros;
import br.com.fiap.dao.BairrosDao;
import br.com.fiap.exception.EntidadeNaoEncontradaException;
import br.com.fiap.model.Bairros;
import java.sql.SQLException;


public class AtualizacaoBairro {
    public static void main(String[] args) {
        try {
            BairrosDao dao = new BairrosDao();
            Bairros bairro = dao.pesquisar(1);
            bairro.setDsBairro("Jardim Europa");
            dao.atualizar(bairro);
            dao.fecharConexao();
            System.out.println("Bairro Atualizado Com Sucesso!!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e) {
            System.err.println("Não foi possivel realizar a atualização dos dados, Bairro não encontrado");
        }
    }
}
