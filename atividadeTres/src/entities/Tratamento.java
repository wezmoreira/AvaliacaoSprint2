package entities;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tratamento {

    private final String caraFeliz = ":-)";
    private final String caraTriste = ":-(";

    public void entraDados(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite aqui sua frase: ");
        String entrada = sc.nextLine();

        realizaTratamento(entrada);
    }

    public void realizaTratamento(String msg) {
        String caraFeliz = ":-)";
        String caraTriste = ":-(";

        Pattern cF = Pattern.compile(caraFeliz, Pattern.LITERAL);
        Pattern cT = Pattern.compile(caraTriste, Pattern.LITERAL);

        Matcher contaFeliz = cF.matcher(msg);
        Matcher contaTriste = cT.matcher(msg);


        int feliz = 0;
        while (contaFeliz.find()) {
            feliz++;
        }

        int triste = 0;
        while (contaTriste.find()) {
            triste++;
        }
        exibeMensagem(feliz, triste);
    }

    public void exibeMensagem(int feliz, int triste){
        if (feliz > triste) {
            System.out.println("");
            System.out.println("Divertido!");
            System.out.println("");
        }
        if (feliz < triste) {
            System.out.println("");
            System.out.println("Chateado!");
            System.out.println("");
        }
        if (feliz == triste) {
            System.out.println("");
            System.out.println("Neutro!");
            System.out.println("");
        }
    }


}
