import java.sql.*;

public class ClienteDAOImpl implements ClienteDAO{
    @Override
    public Connection connect(String urlConexao) {
        try {
            return DriverManager.getConnection(urlConexao);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createTable(String urlConexao) {
        try {
            String create = "CREATE TABLE IF NOT EXISTS cliente ( id INTEGER NOT NULL PRIMARY KEY," +
                    "nome VARCHAR(255) NOT NULL," +
                    "idade INTEGER NOT NULL," +
                    "rg VARCHAR(255) NOT NULL," +
                    "cpf VARCHAR(255) NOT NULL);";
            PreparedStatement preparedStatement = connect(urlConexao).prepareStatement(create);
            preparedStatement.execute();

            preparedStatement.close();
            connect(urlConexao).close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(String url_conexao, Cliente cliente) {
        try{
            String insert = "INSERT INTO cliente(id, nome, idade, rg, cpf) VALUES(?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connect(url_conexao).prepareStatement(insert);
            preparedStatement.setInt(1, cliente.getId());
            preparedStatement.setString(2, cliente.getNome());
            preparedStatement.setInt(3, cliente.getIdade());
            preparedStatement.setString(4, cliente.getRg());
            preparedStatement.setString(5, cliente.getCpf());

            preparedStatement.execute();
            preparedStatement.close();
            connect(url_conexao).close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void selectAll(String urlConexao) {
        String select = "SELECT * FROM cliente";

        try {
            PreparedStatement preparedStatement = connect(urlConexao).prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                System.out.printf("id %d nome %s idade %d cpf %s rg %s",
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getInt("idade"),
                        resultSet.getString("cpf"),
                        resultSet.getString("rg"));
            }

            resultSet.close();
            preparedStatement.close();
            connect(urlConexao).close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(String urlConexao, int id, String name, Integer idade) {
        String updateCliente = "UPDATE cliente SET nome = ?, + idade = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connect(urlConexao).prepareStatement(updateCliente);
        ){
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, idade);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String urlConexao, int id) {
        String deleteCliente = "DELETE FROM cliente WHERE id = ?";
        try(PreparedStatement preparedStatement = connect(urlConexao).prepareStatement(deleteCliente)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
