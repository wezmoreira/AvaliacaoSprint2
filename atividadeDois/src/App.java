import entities.Filme;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        Scanner sc = new Scanner(System.in);
        Filme filme = new Filme();
        int opcao;

        do {
            System.out.println("[1] - Filtrar filmes.");
            System.out.println("[0] - Sair.");
            System.out.println("********************************");
            System.out.println("");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1: {
                    filme.filtraFilmes();
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

