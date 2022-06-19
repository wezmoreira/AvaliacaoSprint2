package exception;

public class TrataExcecao extends RuntimeException{

    public TrataExcecao(String msg){
        super("Ocorreu um erro ao tentar a conexão: " + msg);
    }
}
