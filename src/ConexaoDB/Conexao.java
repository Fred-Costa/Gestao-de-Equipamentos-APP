package ConexaoDB;

import java.sql.*;

public class Conexao {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/LREC-db";
    private static final String USER = "root";
    private static final String PASS = "LrecDB-1234";

    public static Connection getConnection() {

        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException erro) {
            throw new RuntimeException("Erro na conexão: " + erro);
        }
    }

    public static void closeConnection(Connection conn) {

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException erro) {
            throw new RuntimeException("Erro no fecho da conexão: " + erro);
        }
    }

}
