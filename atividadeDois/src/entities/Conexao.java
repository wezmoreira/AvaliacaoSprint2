package entities;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import exception.TrataExcecao;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Conexao {
    public DataSource dataSource;

    public Conexao() {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setJdbcUrl("jdbc:mysql://localhost/avaliacao?useTimezone=true&serverTimezone=UTC");
        cpds.setUser("root");
        cpds.setPassword("rodrigo321");
        cpds.setMaxPoolSize(5);

        this.dataSource = cpds;
    }

    public Connection recuperarConexao() {
        try{
            return this.dataSource.getConnection();
        }
        catch (SQLException e){
            throw new TrataExcecao("TEVE UMA EXCEÇÃO" + e.getMessage());
        }
    }
}
