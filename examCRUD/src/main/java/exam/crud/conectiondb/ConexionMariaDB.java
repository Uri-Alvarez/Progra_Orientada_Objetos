package exam.crud.conectiondb;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMariaDB {

    private static final String URL = "jdbc:mariadb://localhost:3306/exam";
    private static final String USER = "uri";
    private static final String PASSWORD = "123";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a MariaDB!");
        } catch (SQLException e) {
            System.out.println("Error al conectar a MariaDB");
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        getConnection();
    }
}
