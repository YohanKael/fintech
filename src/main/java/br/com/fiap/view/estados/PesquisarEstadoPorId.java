package br.com.fiap.view.estados;

import br.com.fiap.dao.EstadosDao;
import br.com.fiap.exception.EntidadeNaoEncontradaException;
import br.com.fiap.model.Estados;

import java.sql.SQLException;

public class PesquisarEstadoPorId {
    public static void main(String[] args) {
        try{
            EstadosDao dao = new EstadosDao();
            Estados estado = dao.pesquisar(1);
            System.out.println("Id do Estado: " + estado.getIdEstado() + "," + " Nome do Estado: " + estado.getNmEstado());
            dao.fecharConexao();

        } catch (SQLException e){
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEncontradaException e){
            System.err.println("Id não existe na tabela de Estados");
        }
    }
}
