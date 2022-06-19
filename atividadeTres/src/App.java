import entities.Tratamento;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        Scanner sc = new Scanner(System.in);
        Tratamento tratamento = new Tratamento();
        int opcao;

        do {
            System.out.println("[1] - Para digitar sua frase.");
            System.out.println("[0] - Sair.");
            System.out.println("********************************");
            System.out.println("");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1: {
                    tratamento.entraDados();
                    System.out.println("==========================================");
                    break;
                }

                case 0: {
                    opcao = 0;
                }
            }
        }while (opcao != 0);
    }
}

