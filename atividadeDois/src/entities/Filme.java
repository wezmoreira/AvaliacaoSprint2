package entities;

import exception.TrataExcecao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class Filme {
    private int id;
    private String nome;
    private String descricao;
    private Date Ano;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getAno() {
        return Ano;
    }

    Conexao connection = new Conexao();

    public void filtraFilmes(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a quantidade de filmes que voce quer filtrar: ");
        int quantidade = sc.nextInt();
        System.out.println("Digite o número da pagina que você quer acessar: ");
        int numeroPagina = sc.nextInt();

        listaFilme(numeroPagina, quantidade);
    }

    public void listaFilme(int numeroPagina, int quantidadeFilmes){
        int limite = 10;
        int offset = (numeroPagina * limite) - limite;
        String listaFilme = "SELECT * FROM Filmes LIMIT " + quantidadeFilmes + " OFFSET "+ offset;

        try (Connection conexao = connection.recuperarConexao()) {
            PreparedStatement ps = conexao.prepareStatement(listaFilme);
            ps.execute();
            ResultSet rst = ps.getResultSet();
            while(rst.next()) {
                Integer id = rst.getInt("Id");
                String nome = rst.getString("Nome");
                String descricao = rst.getString("Descricao");
                Date ano = rst.getDate("Ano");
                System.out.println("----------------------------------------");
                System.out.println("ID: " + id);
                System.out.println("NOME: " + nome);
                System.out.println("DESCRIÇÃO: " + descricao);
                System.out.println("ANO: " + ano);
                System.out.println("----------------------------------------");
            }
        } catch (SQLException e) {
            throw new TrataExcecao(e.getMessage());
        }
    }
}

