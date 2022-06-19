package entities;

import exception.TrataExcecao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ListaProduto {

    Conexao connection = new Conexao();
    private static int controleMatriz = 3;
    private static int controle;
    private Produto matriz[][] = new Produto[][]{
            {new Produto(
                    1,
                    "Rtx 3070",
                    "Placa de vídeo série rtx",
                    3,
                    5000.00)},
            {new Produto(
                    2,
                    "gtx 2060",
                    "Placa de Vídeo série gtx",
                    5,
                    2500.00)},
            {new Produto(
                    3,
                    "Mouse Redragon",
                    "Mouse gamer",
                    7,
                    200.00)},
            {new Produto(
                    4,
                    "Teclado Razer",
                    "Teclado mecânico gamer",
                    2,
                    300.00)},
            {new Produto(
                    5,
                    "Monitor Tiem",
                    "Monitor QuadHD",
                    1,
                    2200.00)},
            {new Produto(
                    6,
                    "Headset Hyperx",
                    "headset gamer",
                    4,
                    250.00)},
            {new Produto(
                    7,
                    "Gabinete XC7",
                    "Gabinete gamer XC7",
                    1,
                    100.00)},
            {new Produto(
                    8,
                    "Ryzem 7 2700x",
                    "Amd Ryzem 7 2700x 8x16",
                    2,
                    1300.00)},
            {new Produto(
                    9,
                    "Msi x470",
                    "Placa mãe msi x470",
                    3,
                    1100.00)}
    };

    public void cadastraProduto() {
        String cadastraProduto = "INSERT INTO Produto (Id, Nome, Descricao, Quantidade, Preco) " +
                "values (?, ?, ?, ?, ?)";
        try (Connection conexao = connection.recuperarConexao()) {
            try(PreparedStatement ps = conexao.prepareStatement(cadastraProduto)) {
                if(controle < matriz.length) {
                    for (int i = 0; i < 3; i++) {
                        if (controle < controleMatriz) {
                            Produto[] conjunto = matriz[controle];
                            for (int indiceConjunto = 0; indiceConjunto < conjunto.length; indiceConjunto++) {
                                ps.setInt(1, conjunto[indiceConjunto].getId());
                                ps.setString(2, conjunto[indiceConjunto].getNome());
                                ps.setString(3, conjunto[indiceConjunto].getDescricao());
                                ps.setInt(4, conjunto[indiceConjunto].getQuantidade());
                                ps.setDouble(5, conjunto[indiceConjunto].getPreco());
                                ps.execute();
                                controle++;
                            }
                        }
                        controleMatriz++;
                    }
                }
                else {
                    System.out.println("Não tem mais produtos para serem cadastrados! ");
                }
            }
        }
        catch (SQLException e) {
            throw new TrataExcecao(e.getMessage());
        }
}

    public void atualizaProduto () {
        int altera = controle - 2;
        String alteraProduto = "UPDATE Produto SET Quantidade=0 WHERE Id=" + altera;
        if(controle < 3) {
            System.out.println("");
            System.out.println("******************************************");
            System.out.println("*** não tem produto para ser ALTERADO! ***");
            System.out.println("******************************************");
            System.out.println("");

        }
        else{
            try (Connection conexao = connection.recuperarConexao()) {
                PreparedStatement ps = conexao.prepareStatement(alteraProduto);
                ps.execute();
            } catch (SQLException e) {
                throw new TrataExcecao(e.getMessage());
            }
        }

    }

    public void excluiProduto () {
        int altera = controle - 1;
        String alteraProduto = "DELETE FROM Produto WHERE Id=" + altera;
        if(controle < 3) {
            System.out.println("");
            System.out.println("******************************************");
            System.out.println("*** não tem produto para ser DELETADO! ***");
            System.out.println("******************************************");
            System.out.println("");
        }
        else{
            try (Connection conexao = connection.recuperarConexao()) {
                PreparedStatement ps = conexao.prepareStatement(alteraProduto);
                ps.execute();
            } catch (SQLException e) {
                throw new TrataExcecao(e.getMessage());
            }
        }
    }

    public void mostraProdutos () {
        String alteraProduto = "SELECT * FROM Produto";
        if(controle < 3) {
            System.out.println("");
            System.out.println("**********************************************");
            System.out.println("*** não tem produtos para serem MOSTRADOS! ***");
            System.out.println("**********************************************");
            System.out.println("");
        }
        else{
            try (Connection conexao = connection.recuperarConexao()) {
                PreparedStatement ps = conexao.prepareStatement(alteraProduto);
                ps.execute();
                ResultSet rst = ps.getResultSet();
                while(rst.next()) {
                    Integer id = rst.getInt("Id");
                    String nome = rst.getString("Nome");
                    String descricao = rst.getString("Descricao");
                    Integer quantidade = rst.getInt("Quantidade");
                    Double preco = rst.getDouble("Preco");
                    System.out.println("----------------------------------------");
                    System.out.println("ID: " + id);
                    System.out.println("NOME: " + nome);
                    System.out.println("DESCRIÇÃO: " + descricao);
                    System.out.println("QUANTIDADE: " + quantidade);
                    System.out.println("PREÇO: " + preco);
                    System.out.println("----------------------------------------");
                }
            } catch (SQLException e) {
                throw new TrataExcecao(e.getMessage());
            }
        }
    }
}
