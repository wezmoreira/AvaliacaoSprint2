import entities.ListaProduto;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        Scanner sc = new Scanner(System.in);
        ListaProduto lista = new ListaProduto();
        int opcao;

        do {
            System.out.println("[1] - Cadastro de produtos.");
            System.out.println("[2] - Atualizar produto.");
            System.out.println("[3] - Excluir produto.");
            System.out.println("[4] - Exibir produtos.");
            System.out.println("[0] - Sair.");
            System.out.println("********************************");
            System.out.println("");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1: {
                    lista.cadastraProduto();
                    System.out.println("==========================================");
                    break;
                }

                case 2: {
                    lista.atualizaProduto();
                    System.out.println("==========================================");
                    break;
                }

                case 3:{
                    lista.excluiProduto();
                    System.out.println("==========================================");
                    break;
                }

                case 4:{
                    lista.mostraProdutos();
                    System.out.println("==========================================");
                    break;
                }

                case 0: {
                    opcao = 0;
                }
            }
        } while (opcao != 0);
    }
}
