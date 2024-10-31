package br.com.fiap.view.pais;

import br.com.fiap.dao.PaisDao;
import br.com.fiap.model.Paises;

import java.sql.SQLException;

public class CadastrarPais {
    public static void main(String[] args) {
        try{
            PaisDao dao = new PaisDao();

            Paises pais = new Paises("Brasil");
            Paises pais2 = new Paises("EUA");
            Paises pais3 = new Paises("Austrália");
            Paises pais4 = new Paises("Espanha");
            Paises pais5 = new Paises("Argentina");

            dao.cadastrar(pais);
            dao.cadastrar(pais2);
            dao.cadastrar(pais3);
            dao.cadastrar(pais4);
            dao.cadastrar(pais5);
            dao.fecharConexao();
            System.out.println("Pais Adicionado  com sucesso!!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
