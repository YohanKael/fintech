package br.com.fiap.view.cidades;
import br.com.fiap.dao.CidadesDao;
import br.com.fiap.model.Cidades;

import java.sql.SQLException;
import java.util.List;

public class GetAllCidades {
    public static void main(String[] args) {
        try {
            CidadesDao dao = new CidadesDao();
            List<Cidades> cidades = dao.getAllBairros();
            for (Cidades cidade : cidades) {
                System.out.println("Id da cidade: " + cidade.getIdCidade() + "," + " Nome da cidade: " + cidade.getNmCidade());
            }
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
}
