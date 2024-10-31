package br.com.fiap.view.investimentos;

import br.com.fiap.dao.InvestimentosDao;
import br.com.fiap.model.Investimentos;

import java.sql.SQLException;
import java.util.List;

public class GetAllInvestimentos {
    public static void main(String[] args) {
        try {
            InvestimentosDao dao = new InvestimentosDao();
            List<Investimentos> investimentos = dao.getAll();
            for (Investimentos investimento : investimentos) {
                System.out.println("Id do investimento: " + investimento.getCd_investimentos() + " " + "Descrição Investimento: " + investimento.getDs_investimentos() + ", R$ " + investimento.getQt_valor_investido() + "," + "Data do investimento: " + investimento.getDt_investimentos() + "," + "Data Retirada do investimento: " +  investimento.getDt_retirada_investimentos());
            }
            dao.fecharConexao();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
}