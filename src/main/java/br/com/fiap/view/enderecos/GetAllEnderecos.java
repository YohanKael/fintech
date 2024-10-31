package br.com.fiap.view.enderecos;
import br.com.fiap.dao.EnderecosDao;
import br.com.fiap.model.Enderecos;
import java.sql.SQLException;
import java.util.List;

public class GetAllEnderecos {
    public static void main(String[] args) {
        try {
            EnderecosDao dao = new EnderecosDao();
            List<Enderecos> enderecos = dao.getAllEnderecos();
            for (Enderecos endereco : enderecos) {
                System.out.println("Id do endereço:" + endereco.getIdEndereco() + "," + " Numero do CEP:" + endereco.getNumeroCep() + "," + "Numero da rua:" + endereco.getNumeroResidencia() + "," + "Nome Da Rua: " +  endereco.getNomeRua());
                System.out.println("Complemento do endereço:"  + endereco.getComplementoEndereco());
            }
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
}
